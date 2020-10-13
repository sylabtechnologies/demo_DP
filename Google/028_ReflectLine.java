// https://leetcode.com/problems/line-reflection/

package duptree;
import java.util.*;

class Solution
{
    public boolean isReflected(int[][] points)
    {
        if (points.length == 1) return true;

        MultiMap<Integer, Integer> starmap = new MultiMap<>();
        HashSet<Point> set = new HashSet<>();
        for (int i = 0; i < points.length; i++)
        {
            int[] pt = points[i];
            Point temp = new Point(pt[0], pt[1]);
            if (set.contains(temp)) continue;
            
            starmap.put(temp.y, temp.x);
            set.add(temp);
        }
        set.clear();
        
        ArrayList<Integer> levels = starmap.getKeys(false);
        boolean fst = true;
        Double mid = null;
        for (int i = 0; i < levels.size(); i++)
        {
            int lev = levels.get(i);
            
            if (fst)
            {
                fst = false;
                mid = balance(starmap.getRow(lev));
                if (mid == null) return false;
            }
            else
            {
                if (!balance(starmap.getRow(lev)).equals(mid)) return false;
            }
        }
        
        return true;
    }

    private Double balance(ArrayList<Integer> row)
    {
        if (row.size() == 1) return new Double(row.get(0));
        Collections.sort(row);
            
        int i = 0, j = row.size() - 1;
        double mid = (row.get(i++) + row.get(j--))/ 2.0;
        if (row.size() == 2) return mid;
        
        while (i <= j)
        {
            if (i == j)
            {
                if (row.get(i) != mid) return null;
                break;
            }

            double tmp = (row.get(i++) + row.get(j--))/ 2.0;
            if (tmp != mid) return null;
        }
            
        return mid;
    }

    private static class Point implements Comparable<Point>
    {
        int x, y;

        public Point(int x, int y)
        {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }

        @Override
        public int compareTo(Point pt)
        { 
            if (pt.y == this.y)
                return Integer.compare(this.x, pt.x);
            else
                return Integer.compare(pt.y, this.y);
        }

        @Override
        public int hashCode()
        {
            return this.y * 117 + this.x;
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
            if (this.x != other.x) {
                return false;
            }
            if (this.y != other.y) {
                return false;
            }
            return true;
        }
        
        
    }
}

public class Dups
{
    public static void main(String[] args)
    {
        int pts[][] = {{-16,1}, {16,1}, {16,1}};
        System.out.println(new Solution().isReflected(pts));
    }
}
        
