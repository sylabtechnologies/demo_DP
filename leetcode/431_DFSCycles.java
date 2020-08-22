// C2SX https://leetcode.com/problems/detect-cycles-in-2d-grid/
package bbwek1;
import java.util.*;

class Solution
{
    private char[][] myRef;
    private int nrows, ncols;    
    
    public boolean containsCycle(char[][] grid)
    {
        myRef = grid;
        nrows = grid.length;
        ncols = grid[0].length;
        
        for (int i = 0; i < nrows; i++)
        {
            for (int j = 0; j < ncols; j++)
            {
                char curr = grid[i][j];
                if (Character.isUpperCase(curr)) continue;
                
                ArrayList<Point> children = findChildren(i, j);
                if (children.size() >= 3)
                    return true;
                else if (children.size() == 2)
                {
                    Point c1 = children.get(0);
                    ArrayList<Point> c1c = findChildren(c1.y, c1.x);
                    grid[c1.y][c1.x] = '#';
                    int path = 1 + floodfill(i, j, curr);
                    boolean found = false;
                    for (Point pt : c1c)
                    {
                        if (pt.y == i && pt.x == j) continue;
                        
                        if (grid[pt.y][pt.x] == Character.toUpperCase(curr))
                        {
                            found = true;
                            break;
                        }
                    }
                    
                    grid[c1.y][c1.x] = Character.toUpperCase(curr);
                    if (path >= 4 && found) return true;
                }
                else
                    grid[i][j] = Character.toUpperCase(curr);
            }
        }

        return false;
    }
    
    private ArrayList<Point> findChildren(int i, int j)
    {
        char curr = myRef[i][j];
        int dir[][] =  {{ -1, 0},  { 1, 0}, { 0, -1}, { 0, 1}};
        
        ArrayList<Point> ans = new ArrayList<>();
        for (int[] step : dir)
        {
            int sr = i + step[0];
            if (sr < 0 || sr >= nrows) continue;
            int sc = j + step[1];
            if (sc < 0 || sc >= ncols) continue;

            if (myRef[sr][sc] == curr)
                ans.add(new Point(sr, sc));
        }
        
        return ans;
    }
    
    
    private int floodfill(int sr, int sc, char target)
    {
        if (sr < 0 || sr >= nrows) return 0;
        if (sc < 0 || sc >= ncols) return 0;
        
        char curr = myRef[sr][sc];
        if (Character.isUpperCase(curr)) return 0 ;
        
        int count = 0;
        if (curr == target)
        {
            myRef[sr][sc] = Character.toUpperCase(curr);
            count++;
        }
        else
            return 0;
        
        count += floodfill(sr-1, sc, target);
        count += floodfill(sr+1, sc, target);
        count += floodfill(sr, sc-1, target);
        count += floodfill(sr, sc+1, target);
        return count;
    }

    private static class Point
    {
        int y, x;
        public Point(int y, int x) { this.y = y; this.x = x; }
        @Override
        public String toString() { return "row " + y + ", col " + x; }
    }
}

public class TwoDcycles
{
    public static void main(String[] args)
    {
        char grid[][] = { {'c','d','a','d'}, {'a','a','a','d'},{'a','b','b','e'},{'c','c','c','e'}};                
        System.out.println(new Solution().containsCycle(grid));  
    }
    
}
