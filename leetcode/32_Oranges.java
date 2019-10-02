// https://leetcode.com/problems/rotting-oranges/
// probably CLEAN BFS:

package oranges;
import java.util.*;

public class Oranges
{

    public static void main(String[] args)
    {
        int[][] oranges = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orangesRotting(oranges));
    }

    private static int orangesRotting(int[][] grid)
    {
        if( grid == null || grid.length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;

        // do bfs for each node 2
        Queue<int[]> bfsQueue = new LinkedList<>();
        int freshCount = 0;
        
        for(int i = 0 ; i < rows ; i++) {
            for(int j = 0 ; j < cols ; j++) {
                if(grid[i][j] == 2) {
                    bfsQueue.offer(new int[]{i , j});
                }
                else if(grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }
        
        if(freshCount == 0) return 0;
        int count = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        
        while(!bfsQueue.isEmpty())
        {
            ++count;
            int size = bfsQueue.size();
            for(int i = 0 ; i < size ; i++) {
                int[] point = bfsQueue.poll();
                for(int dir[] : dirs)
                {
                    int x = point[0] + dir[0];
                    int y = point[1] + dir[1];
                    
                    if(x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == 0 || grid[x][y] == 2)
                        continue;

                    grid[x][y] = 2;

                    bfsQueue.offer(new int[]{x , y});

                    freshCount--;
                }
            }
        }
        
        return freshCount == 0 ? count-1 : -1;        
    }
    
}
