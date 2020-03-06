/**
 * http://www.ardendertat.com/2011/09/20/programming-interview-questions-2-matrix-region-sum/
 * https://leetcode.com/problems/maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold/
 * ##MATRIX, PRECALC #OK: presum; binsearch;
*/

package maxsidelength;

public class Solution
{
    int[][] memoSum;
    int m;
    int n;

    private void memo(int[][] mat)
    {
        m = mat.length;
        n = mat[0].length;
        memoSum = new int[m + 1][n + 1];
        
        for (int i = 1; i <= m; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                memoSum[i][j] = memoSum[i-1][j] + memoSum[i][j-1] - memoSum[i-1][j-1] + mat[i-1][j-1];
            }
            
            // printArray(memoSum);
        }        
    }

    private boolean canFindSquare(int len, int threshold)
    {
        for (int i = len; i <= m; i++) {
            for (int j = len; j <= n; j++) {
                if (memoSum[i][j] - memoSum[i-len][j] - memoSum[i][j-len] + memoSum[i-len][j-len] <= threshold)
                    return true;
            }
        }
        
        return false;
    }
    
    
    public int maxSideLength(int[][] mat, int threshold)
    {
        memo(mat);

        int hi = Math.min(m, n);
        int lo = 0;
        
        while (lo <= hi)
        {
            int mid = (lo + hi)/2;
            
            boolean canFind = canFindSquare(mid, threshold);
            
            if (canFind)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        
        return hi;
    }    

    private static void printArray(int[][] nums)
    {
        for (int i = 0; i < nums.length; i++)
        {
            for (int j = 0; j < nums[0].length; j++)
                System.out.print(nums[i][j] + " ");
            System.out.println(";");
        }
    }
}
