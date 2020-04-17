// https://leetcode.com/problems/number-of-islands/
package islands;
import java.util.*;

class Solution
{
    int n, m;
    boolean visited[][];
    
    public int numIslands(char[][] grid)
    {
        n = grid.length; if (n == 0) return 0;
        m = grid[0].length; if (m == 0) return 0;
        visited = new boolean[n][m];

        for (int i = 0; i < grid.length; i++)
        {
            char[] cs = grid[i];
            for (int j = 0; j < cs.length; j++)
            {
                if (cs[j] == '0')
                {
                    return bfs(grid, i, j);
                }
            }
        }
        
        return 1;
    }

    private void bfsWalk(char[][] grid, int startY, int startX, char key, int dir1[][], int dir2[][])
    {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(startX, startY));
        
        while (!q.isEmpty())
        {
            Point p = q.poll();
            if (visited[p.y][p.x]) continue;;
            
            visited[p.y][p.x] = true;
            
            for (int[] dir : dir1)
            {
                Point test = new Point(p, dir, n, m);
                if (test.x >= 0)
                {
                    if (grid[test.y][test.x] == key)
                        q.offer(test);
                }
            }
            
            if (dir2 != null)
            {
                for (int[] dir : dir2)
                {
                    Point test = new Point(p, dir, n, m);
                    if (test.x >= 0)
                    {
                        if (grid[test.y][test.x] == key)
                            q.offer(test);
                    }
                }
            }
        }
    }
    
    private int bfs(char[][] grid, int startY, int startX)
    {
        int hvDirs[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; 
        int dgDirs[][] = {{-1, -1}, {-1, 1}, {1, -1}, {1, 1}}; 
        
        bfsWalk(grid, startY, startX, '0', hvDirs, dgDirs);
        
        int count = 0;
        for (int i = 0; i < grid.length; i++)
        {
            char[] cs = grid[i];
            for (int j = 0; j < cs.length; j++)
            {
                if (visited[i][j]) continue;
                
                if (cs[j] == '1')
                {
                    count++;
                    bfsWalk(grid, i, j, '1', hvDirs, null);
                }
            }
        }
        
        return count;
    }

    private static class Point
    {
        int x, y;

        public Point(int x, int y)
        {
            this.x = x;
            this.y = y;
        }

        private Point(Point p, int[] dir, int maxY, int maxX)
        {
            this.x = p.x + dir[0];
            this.y = p.y + dir[1];

            if (this.x < 0 || this.x >= maxX ) 
            {
                this.x = -1; return;
            }
            
            if (this.y < 0 || this.y >= maxY) 
            {
                this.x = -1; return;
            }
        }

        @Override
        public String toString() { return "[" + x + ", " + y + "]"; }
    }

}

public class Islands
{

    public static void main(String[] args)
    {
        char grid[][] = new char[4][];
        String test[] = { "11000", "11000", "00100", "00011"};
        // {"11110", "11010", "11000", "00000"};
        
        for (int i = 0; i < grid.length; i++)
        {
            int j = 0;
            grid[i] = new char[test[i].length()];
            for (char c : test[i].toCharArray())
                grid[i][j++] = c;
        }
        
        System.out.println(new Solution().numIslands(grid));
    }
    
}
