/**
 * h1; mat[r][c] for i - K <= r <= i + K, j - K <= c <= j + K, and (r, c)
 * 
 * 
 */

package matixblock;

class Solution
{
    public static int[][] matrixBlockSum(int[][] mat, int K)
    {
        int mLen = mat.length;
        int nLen = mat[0].length;
        int[][] res = new int[mLen][nLen];
        
        for (int i = 0; i < mLen; i++)
        {
            for (int j = 0; j < nLen; j++)
            {
                res[i][j] = getRegion(mat, i, j, K);
            }
        }

        return res;
    }

    private static int getRegion(int[][] mat, int i, int j, int K)
    {
        int mLen = mat.length;
        int nLen = mat[0].length;
        
        int str = Math.max(0, i - K);
        int fin = Math.min(mLen - 1, i + K);
        
        int str2 = Math.max(0, j - K);
        int fin2 = Math.min(nLen - 1, j + K);
        
        int sum = 0;
        for (int k = str; k <= fin; k++)
        {
            for (int l = str2; l <= fin2; l++)
            {
                sum += mat[k][l];
            }
        }
        
        return sum;
    }
    
    public static void printArray(int[][] nums)
    {
        for (int i = 0; i < nums.length; i++)
        {
            for (int j = 0; j < nums[0].length; j++)
                System.out.print(nums[i][j] + " ");
            System.out.println(";");
        }
    }
    
}

public class MatixBlock
{

    public static void main(String[] args)
    {
        int[][] mat = { {1, 2 ,3}, {4, 5, 6 }, {7, 8, 9} };
        
        Solution.printArray(Solution.matrixBlockSum(mat, 2));
        
    }
    
}
