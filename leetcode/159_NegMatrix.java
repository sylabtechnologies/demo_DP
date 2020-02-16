package negmatrix;

class Solution
{
    public static int countNegatives(int[][] grid)
    {
        int m = grid.length;
        int n = grid[0].length;
        int curReach = 0;
        int res = 0;
        
        for (int i = m - 1; i >= 0; i--)
        {
            for (int j = n-1; j >= curReach; j--)
            {
                if (grid[i][j] < 0)
                {
                    res++;
                }
                else
                {
                    curReach = j;
                    break;
                }
            }
        }
        
        return res;
    }
}

public class NegMatrix
{

    public static void main(String[] args)
    {
        int[][] mat = {{1, -1}, {-1, -1}};  // {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
        System.out.println(Solution.countNegatives(mat));
      
    }
    
}
