package goog29;
import java.util.*;

class Solution
{
    private boolean solved;
    
    public void solveSudoku(char[][] board)
    {
        ArrayList<Point> cells = new ArrayList<>();
        for (int i = 0; i < board.length; i++)
        {
            char row[] = board[i];
            for (int j = 0; j < row.length; j++)
            {
                if (row[j] == '.')
                    cells.add(new Point(i, j));
            }
            
        }
        
        solved = false;
        bktrack(board, cells, 0);
    }

    private void bktrack(char[][] board, ArrayList<Point> cells, int start)
    {
        if (solved) return;
        if (start == cells.size())
        {
            solved = true;
            return;
        }

        Point curr = cells.get(start);
        
        for (char c = '1'; c <= '9' && !solved; c++)
        {
            board[curr.y][curr.x] = c;
            
            if (isValidSudoku(board))
            {
                bktrack(board, cells, start+1);
            }
            
            if (!solved)
                board[curr.y][curr.x] = '.';
        }
        
    }

    private boolean isValidSudoku(char[][] board)
    {
        for (int i = 0; i < board.length; i++)
        {
            char row[] = board[i];
            if (!validate(row)) return false;
        }

        for (int i = 0; i < board.length; i++)
        {
            char col[] = new char[board[0].length];
            for (int j = 0; j < board[0].length; j++)
                col[j] = board[j][i];
            if (!validate(col)) return false;
        }

        for (int sq = 0; sq <= 8; sq++)
        {
            char square[] = new char[9];
            
            int y = sq / 3, x = sq % 3, cnt = 0;
            for (int i = y*3; i < y*3 + 3; i++)
                for (int j = x*3; j < x*3 + 3; j++)
                    square[cnt++] = board[i][j];
            
            if (!validate(square)) return false;
        }
        
        return true;
    }

    private boolean validate(char[] row)
    {
        ArrayList<Integer> digs = new ArrayList<>();
        for (char c : row)
            if (c != '.') digs.add(c - '0');
        
//        System.out.println(digs);
        
        HashSet<Integer> uniq = new HashSet<>();
        for (Integer d : digs)
        {
            if (d <=0 || d > 9) return false;
            if (uniq.contains(d)) return false;
            uniq.add(d);
        }
        
        return true;
    }

    private static class Point
    {
        public final int y;
        public final int x;

        public Point(int y, int x)
        {
            this.y = y;
            this.x = x;
        }

        @Override
        public String toString() { return "(" + y + ", " + x + ')';}
        
    }
}

public class Goog29
{
    public static void main(String[] args)
    {
        char board[][] = 
        {{'5','3','.','.','7','.','.','.','.'},
         {'6','.','.','1','9','5','.','.','.'},
         {'.','9','8','.','.','.','.','6','.'},
         {'8','.','.','.','6','.','.','.','3'},
         {'4','.','.','8','.','3','.','.','1'},
         {'7','.','.','.','2','.','.','.','6'},
         {'.','6','.','.','.','.','2','8','.'},
         {'.','.','.','4','1','9','.','.','5'},
         {'.','.','.','.','8','.','.','7','9'}};
        
        Solution sl = new Solution();
        sl.solveSudoku(board);
        
        for (char[] row : board)
            System.out.println(Arrays.toString(row));
    }
}

/*

*/