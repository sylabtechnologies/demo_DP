// https://leetcode.com/problems/perfect-rectangle/ - see interval tree?

package perfectrectangle;

import java.util.*;

class Solution
{
    public boolean isRectangleCover(int[][] rectangles)
    {
        Set<Node> pointSet = new HashSet<>();
        Set<Rectangle> rectangleSet = new HashSet<>();
        int totalArea = 0;
        
        for(int[] arr:rectangles)
        {
            Rectangle r = new Rectangle(arr[0],arr[1],arr[2],arr[3]);
            
            if(!rectangleSet.add(r))    // check dups
                return false;
            
            totalArea += r.area();
            
            Node n1 = new Node(arr[0],arr[1]);
            Node n2 = new Node(arr[2],arr[3]);
            Node n3 = new Node(arr[0],arr[3]);
            Node n4 = new Node(arr[2],arr[1]);
         
            /// remove dups
            if(!pointSet.add(n1)) pointSet.remove(n1);
            if(!pointSet.add(n2)) pointSet.remove(n2);
            if(!pointSet.add(n3)) pointSet.remove(n3);
            if(!pointSet.add(n4)) pointSet.remove(n4);
        }
        
        // must have only 4
        
        if(pointSet.size()!= 4) return false;

        // find diagonal
        Iterator<Node> iter = pointSet.iterator();
        Node a = iter.next();
        
        while (iter.hasNext())
        {
            Node b = iter.next();
            if( b.x != a.x && b.y != a.y)
            {
                int area = Math.abs(a.x-b.x)*Math.abs(a.y-b.y);
                return totalArea == area;
            }
        }

        return false;
    }
}

class Node
{
    int x; int y;
    public Node(int x,int y) 
    {
        this.x=x; this.y=y;
    }
    @Override
    public boolean equals(Object o)
    {
        if(o==this) return true;
        if(!(o instanceof Node)) return false;
        Node n = (Node)o;
        return (x==n.x&&y==n.y);
    }
    @Override
    public int hashCode()
    {
        int ret=13;
        ret=ret*31+x;
        ret=ret*31+y;
        return ret;
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }
    
    
}

class Rectangle
{
    int x1; int y1; int x2; int y2;
    public Rectangle(int x1,int y1,int x2,int y2)
    {
        this.x1=x1; this.y1=y1;
        this.x2=x2; this.y2=y2;
    }
    @Override
    public boolean equals(Object o)
    {
        if(o==this) return true;
        if(!(o instanceof Rectangle)) return false;
        Rectangle n = (Rectangle)o;
        return (x1==n.x1&&y1==n.y1&&x2==n.x2&&y2==n.y2);
    }
    @Override
    public int hashCode()
    {
        int ret=13;
        ret=ret*31+x1;
        ret=ret*31+y1;
        ret=ret*31+x2;
        ret=ret*31+y2;
        return ret;
        //return Objects.hash(x1,x2,y1,y2);
    }

    public int area()
    {
        int a=Math.abs(x1-x2);
        int b=Math.abs(y1-y2);
        return a*b;
    }
}
