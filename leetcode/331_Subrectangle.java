// https://leetcode.com/contest/biweekly-contest-28/problems/final-prices-with-a-special-discount-in-a-shop/

class SubrectangleQueries
{
    final int mat[][];
    final int nrow, ncol;
    
    public SubrectangleQueries(int[][] rectangle)
    {
        nrow = rectangle.length;
        ncol = rectangle[0].length;
        
        mat = new int[nrow][];
        for (int i = 0; i < nrow; i++)
            mat[i] = Arrays.copyOf(rectangle[i], ncol);
    }
    
    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue)
    {
        for (int i = row1; i <= row2; i++)
        {
            for (int j = col1; j <= col2; j++)
                mat[i][j] = newValue;
        }
    }
    
    public int getValue(int row, int col)
    {
        return mat[row][col];
    }
}
