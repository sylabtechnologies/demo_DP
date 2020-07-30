// https://leetcode.com/problems/range-sum-query-2d-immutable/
package rangesum2d;

class NumMatrix
{
    int subSums[][];

    public NumMatrix(int[][] mat)
    {
        int len = mat[0].length;
        BinaryIndexedTree row = new BinaryIndexedTree(mat[0].length);

        subSums = new int[mat.length][];
        
        for (int i = 0; i < mat.length; i++)
        {
            int rowSum = mat[i][0];
            subSums[i] = new int[len];
            subSums[i][0] = mat[i][0];
            if (i > 0)
                subSums[i][0] += subSums[i-1][0];

            for (int j = 1; j < len; j++)
            {
                subSums[i][j] = rowSum + mat[i][j];
                rowSum += mat[i][j];
                
                if (i > 0)
                    subSums[i][j] += subSums[i-1][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2)
    {
        int bigSum = subSums[row2][col2];
        
        if (row1 > 0)
            bigSum -= subSums[row1-1][col2];
        
        if (col1 > 0)
        {
            int delta = - subSums[row2][col1 - 1];
            
            if (row1 > 0)
                delta += subSums[row1-1][col1-1];
            
            bigSum += delta;
        }
        
        return bigSum;
    }
}

public class RangeSum2d
{
    public static void main(String[] args)
    {
        int mat[][] = { {3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5},
                        {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        
        NumMatrix nm = new NumMatrix(mat);
        System.out.println(nm.sumRegion(2, 1, 4, 3));
        
    }
    
}
