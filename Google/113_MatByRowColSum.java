// https://leetcode.com/problems/find-valid-matrix-given-row-and-column-sums/
// #S = greedy gables
class Solution 
{
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) 
    {
        int ret[][] = new int[rowSum.length][colSum.length];
        
        for (int i = 0; i < ret.length; i++) 
        {
            int[] row = ret[i];
            for (int j = 0; j < row.length; j++) 
            {
                int a = Math.min(rowSum[i], colSum[j]);
                row[j] = a;
                rowSum[i] -= a;
                colSum[j] -= a;
            }
        }

        return ret;
    }
}
