// https://leetcode.com/problems/minimum-knight-moves/

package goog2;
import java.util.*;

class Solution
{
    private final static int moves[][] = 
    { {1,2}, {2,1},  {2,-1}, {1,-2},
      {-1,-2}, {-2,-1}, {-2,1}, {-1,2} };
    
    public int minKnightMoves(int finx, int finy)
    {
        Queue<Point> bfs = new LinkedList<>();
        bfs.add(new Point(0, 0, 0));
        HashSet<Point> visited = new HashSet<>();
        
        finx = Math.abs(finx);
        finy = Math.abs(finy);
        
        int xmin = -2, xmax = finx + 2,
            ymin = -2, ymax = finy + 2;
        
        while (!bfs.isEmpty())
        {
            Point pt = bfs.poll();
            if (pt.x == finx && pt.y == finy) return pt.time;

            if (visited.contains(pt))
                continue;
            else
                visited.add(pt);

            for (int[] move : moves)
            {
                if ( pt.x + move[0] < xmin || pt.x + move[0] > xmax) continue;
                if ( pt.y + move[1] < ymin || pt.y + move[1] > ymax) continue;
                
                Point next = new Point(pt.x + move[0], pt.y + move[1], pt.time + 1);
                bfs.add(next);
            }
        }

        return -1;
    }

    private static class Point
    {
        int x, y, time;
        public Point(int x, int y, int t) {this.x = x;this.y = y; time = t;}

        @Override
        public String toString() { return "(" + x + ", " + y + ')';}
        
        @Override
        public int hashCode()
        {
            int hash = 7;
            hash = 47 * hash + this.x;
            hash = 47 * hash + this.y;
            return hash;
        }

        @Override
        public boolean equals(Object obj)
        {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Point other = (Point) obj;
            
            if (this.x == other.x && this.y == other.y)
                return true;
            else
                return false;
        }
    }
}

public class Goog2
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().minKnightMoves(2, 1));
    }
    
}

