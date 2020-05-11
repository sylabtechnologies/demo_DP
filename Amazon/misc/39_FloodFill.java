package floodfill;
import java.util.Arrays;

class Solution
{
    private int ref[][];
    private int nrows, ncols, colorFrom, colorTo;
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        nrows = image.length;
        ncols = image[0].length;
        colorFrom = image[sr][sc];
        colorTo = newColor;

        ref = new int[nrows][];
        for (int i = 0; i < nrows; i++)
        {
            int row[] = image[i];
            ref[i] = Arrays.copyOf(row, ncols);
        }

        if (colorFrom == colorTo) return ref;
        
        helper(sr, sc);
        return ref;
    }

    private void helper(int sr, int sc)
    {
        if (sr < 0 || sr >= nrows) return;
        if (sc < 0 || sc >= ncols) return;
        
        // System.out.println("at " + sr + " " + sc);
        if (ref[sr][sc] == colorFrom)
            ref[sr][sc] = colorTo;
        else return;
        
        helper(sr-1, sc);
        helper(sr+1, sc);
        helper(sr, sc-1);
        helper(sr, sc+1);
    }
}

public class FloodFill
{
    public static void main(String[] args)
    {
        int img[][] = { {1,1,1}, {1,1,0}, {1,0,1},};
        print2D(new Solution().floodFill(img, 1, 1, 2));
    }
    
    private static void print2D(int[][] arr)
    {
        for (int[] row : arr)
            System.out.println(Arrays.toString(row));
    }    
}
