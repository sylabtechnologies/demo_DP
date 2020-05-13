// https://leetcode.com/problems/01-matrix/
package celldist;
import java.util.*;

class Solution
{
    private int nrows, ncols;
    private int clone[][];
    private boolean[][] filled;
    
    private static class Point
    {
        int y, x;
        public Point(int y, int x) { this.y = y; this.x = x; }
        public Point(Point p) { this.y = p.y; this.x = p.x; }

        @Override
        public String toString() { return "[" + y + ", " + x + "]"; }
    }
    
    public int[][] updateMatrix(int[][] matrix)
    {
        nrows = matrix.length;
        ncols = matrix[0].length;
        clone2D(matrix);
        
        filled = new boolean[nrows][];
        for (int i = 0; i < nrows; i++)
            filled[i] = new boolean[ncols];
        
        // find zero
        LinkedList<Point> bfs = new LinkedList<>();
        findZeros(bfs);
        if (bfs.isEmpty()) throw new IllegalArgumentException("bad args");

        while (!bfs.isEmpty())
        {
            Point next = bfs.removeFirst();
            int dist = clone[next.y][next.x];
            
            Point moves[] = { new Point(next.y - 1, next.x), new Point(next.y + 1, next.x),
                            new Point(next.y, next.x-1), new Point(next.y, next.x+1)};
            for (Point cell : moves)
            {
                if (!canDo(cell)) continue;
                if (clone[cell.y][cell.x] == 0) continue;
                
                clone[cell.y][cell.x] = dist + 1;
                bfs.add(cell);
                filled[cell.y][cell.x] = true;
            }
        }

        return clone;
    }

    private boolean canDo(Point pt)
    {
        if (pt.y < 0 || pt.y >= nrows) return false;
        if (pt.x < 0 || pt.x >= ncols) return false;
        if (filled[pt.y][pt.x]) return false;
        
        return true;
    }
    
    private void findZeros(LinkedList<Point> bfs)
    {
        for (int i = 0; i < nrows; i++)
        {
            for (int j = 0; j < ncols; j++)
            {
                if (clone[i][j] == 0)
                {
                    bfs.add(new Point(i, j));
                    filled[i][j] = true;
                }
            }
        }
    }
    
    // c2c
    private void clone2D(int[][] arr)
    {
        clone = new int[nrows][];
        
        int cnt = 0;
        for (int[] row : arr)
            clone[cnt++] = Arrays.copyOf(row, ncols);
    }    
    
    public static void print2D(int[][] arr)
    {
        for (int[] row : arr)
            System.out.println(Arrays.toString(row));
    }    
}

public class CellDist
{
    
    public static void main(String[] args)
    {
        int mat[][] = {{0,1,0}, {0,1,0},{0,1,0},{0,1,0},{0,1,0}};
        
        int ans[][] = new Solution().updateMatrix(mat);
        Solution.print2D(ans);
        
    }
    
}
