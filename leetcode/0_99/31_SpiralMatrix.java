// https://leetcode.com/problems/spiral-matrix-ii/
package spiralmatrix;

public class SpiralMatrix
{
    public static void main(String[] args)
    {
        int[][] ans = generateMatrix(3);
        printMat(ans);
    }

    private static int[][] generateMatrix(int n)
    {
        if (n <= 0) return null;
        int[][] ans = new int[n][n];
        
        int startRow = 0;
        int endRow   = n;
        int startCol = 0;
        int endCol   = n;
        
        int curr = 1;
        while (curr <= n*n)
        {
            for (int i = startCol; i < endCol; i++, curr++)
                ans[startRow][i] = curr;
            
            startRow++;
            
            for (int i = startRow; i < endRow; i++, curr++)
                ans[i][endCol-1] = curr;
            
            endCol--;
            
            for (int i = endCol - 1; i >= startCol ; i--, curr++)
                ans[endRow-1][i] = curr;
            
            endRow--;
            
            for (int i = endRow - 1; i >= startRow; i--, curr++)
                ans[i][startCol] = curr;

            startCol++;
        }
        
        return ans;
    }

    private static void printMat(int[][] ans)
    {
        for (int i = 0; i < ans.length; i++)
        {
            for (int j = 0; j < ans.length; j++)
            {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println(" ");
        }
    }
    
}
