package task4c;
// https://leetcode.com/problems/count-submatrices-with-all-ones/
import java.util.Arrays;

class Solution
{
    public int numSubmat(int[][] mat)
    {
        int n = mat.length;
        int m = mat[0].length;
        
        int result = 0;
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(mat[i][j] == 1)
                {
                    mat[i][j] = 1 + ((j == 0) ? 0 : mat[i][j-1]);
                
                    int max = mat[i][j];
                    for(int k = i; k >= 0; k--)
                    {
                        max = Math.min(max, mat[k][j]);
                        result += max;
                    }
                }
            }
        }
        
        return result;
    }
}


public class Task4C
{
    public static void main(String[] args)
    {
//        int mat[][] = { {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 1, 1, 0} };

        int mat[][] = { {1, 0, 1}, {1, 1, 0}, {1, 1, 0} };
        
//        int mat[][] = { {1, 0}, {1, 1} };
        System.out.println(new Solution().numSubmat(mat));
        
    }
    
}

        /*
        0 1 2 2
        0 1 2 3
        1 2 3 3
        
        */
        
        // 1 + 2 + 3 + 4 + 5 + 6
        //s6   5   4   3  

