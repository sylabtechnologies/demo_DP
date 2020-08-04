// https://leetcode.com/problems/minimum-swaps-to-arrange-a-binary-grid/

package gridswaps;
import java.util.*;

class Solution          
{
    public int minSwaps(int[][] grid)
    {
        final int n = grid.length;
        if (n == 1) return 0;

        ArrayList<RowElement> swappable = new ArrayList<>();
        for (int[] row : grid)
            swappable.add(new RowElement(row));
        
        // BUBBLE SORT
        int count = 0;
        for (int i = 0; i < swappable.size(); i++)
        {
            RowElement row = swappable.get(i);
            
            if (row.zeroes < n - 1 - i)
            {
                int j = i;
                while (j < n && swappable.get(j).zeroes < n - 1 - i)
                    j++;
                
                if (j == n) return -1;
                
                while (j > i)
                {
                    Collections.swap(swappable, j-1, j);
                    count++;
                    j--;
                }
            }
            
        }
        
        return count;
    }
    
    private static class RowElement
    {
        int[] body;
        int zeroes = 0;

        public RowElement(int[] ref)
        {
            this.body = ref;
            
            for (int i = body.length - 1; i >= 0; i--)
            {
                if (body[i] == 0)
                    zeroes++;
                else
                    break;
            }
        }

        @Override
        public String toString()
        {
            return  String.format(" %02d", zeroes) +  " : " + Arrays.toString(body);
        }
        
    }
}

public class RowSwaps
{
    public static void main(String[] args)
    {
//        int arr[][] = {{0,0,1,0,0,0,0,0,0},{1,1,0,0,0,0,0,0,0},
//            {1,1,1,1,1,0,0,0,0},{0,1,0,0,0,0,0,0,0},
//            {1,1,1,0,1,0,0,0,0},{1,0,1,0,1,0,0,0,0},
//            {0,1,1,1,0,0,0,0,0},{1,1,0,0,0,0,0,0,0},
//            {0,0,1,1,0,0,0,0,0}};
        
        int arr[][] = 
{{0,1,1,0,0,0,0,0,0,0,0,0},{0,1,0,1,1,0,0,0,0,0,0,0},{0,1,1,1,0,0,0,0,0,0,0,0},
{1,1,1,1,1,1,0,0,0,0,0,0},{1,1,1,1,0,1,1,0,0,0,0,0},{1,0,0,0,0,0,0,0,0,0,0,0},
{1,0,1,1,1,1,0,0,0,0,0,0},{1,1,0,0,0,0,0,0,0,0,0,0},{1,0,0,0,1,1,1,0,0,0,0,0},
{0,0,1,1,1,0,1,0,0,0,0,0},{1,0,0,0,0,1,1,0,0,0,0,0},{0,1,0,0,0,0,0,0,0,0,0,0}};

        System.out.println(new Solution().minSwaps(arr));
    }
    
}

/*
        int arr[][] = {{1, 0, 0, 0, 0, 0}, {0,0,0,1,0,0}, {0,0,0,1,0,0},
            {0,1,0,0,0,0}, {0,0,1,0,0,0}, {0,0,0,0,0,1} };
        int arr[][] = {{0, 0, 1},{1, 1, 0},{1, 0, 0}};
        int arr[][] = {{0,1,1,0}, {0,1,1,0}, {0,1,1,0}, {0,1,1,0}}; 

*/

