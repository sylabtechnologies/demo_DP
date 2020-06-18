package surround;
import java.util.*;

class Solution
{
    private char[][] myRef;
    private int nrows, ncols;
    
    public void solve(char[][] board)
    {
        nrows = board.length;
        if (nrows == 0) return;
        
        ncols = board[0].length;
        if (ncols == 0) return;
        
        myRef = board;
        
        // dfs 1:n
        for (int i = 0; i < nrows; i++)
        {
            if (board[i][0] == 'O')
                floodfill(i, 0);

            if (board[i][ncols-1] == 'O')
                floodfill(i, ncols-1);
        }

        // dfs 2:m-1
        for (int j = 1; j < ncols-1; j++)
        {
            if (board[0][j] == 'O')
                floodfill(0, j);

            if (board[nrows-1][j] == 'O')
                floodfill(nrows-1,j);
        }
        
        for (char[] carr : board)
        {
            for (int i = 0; i < carr.length; i++)
                carr[i] = (carr[i] == 'N') ? 'O' : 'X';
        }
        
    }
    
    // dfs
    private void floodfill(int sr, int sc)
    {
        if (sr < 0 || sr >= nrows) return;
        if (sc < 0 || sc >= ncols) return;
        
        // System.out.println("at " + sr + " " + sc);
        if (myRef[sr][sc] == 'O')
            myRef[sr][sc] = 'N';
        else
            return;
        
        floodfill(sr-1, sc);
        floodfill(sr+1, sc);
        floodfill(sr, sc-1);
        floodfill(sr, sc+1);
    }

    public static void print(char[][] arr)
    {
        for (char[] ca : arr)
        {
            for (char c : ca)
                System.out.print(c);
            
            System.out.println("");
        }
    }
    
}

public class Surround
{
    public static void main(String[] args)
    {
        char arr[][] = { {'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'},
            {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        
        Solution s = new Solution();
        s.solve(arr);
        Solution.print(arr);
    }
    
}
