// https://leetcode.com/problems/filling-bookcase-shelves/

package bookcaseshelvesdp;

class Solution
{
    public int minHeightShelves(int[][] books, int shelf_width)
    {
        int n = books.length;
        int dp[] = new int[n];
        
        for (int i = 0; i < n; i++)
        {
            int width = 0, height = 0;
            int minHeight = Integer.MAX_VALUE;
            
            for (int j = i; j >= 0; j--)
            {
                width += books[j][0];
                height = Math.max(height, books[j][1]);
                if (width > shelf_width) break;
                
                int shelfHeight = (j == 0) ? height : dp[j-1] + height;
                minHeight = Math.min(minHeight, shelfHeight);
            }
            
            dp[i] = minHeight;
        }
        
        return dp[n - 1];
    }
}

public class BookcaseShelvesDP
{
    public static void main(String[] args)
    {
        int books[][] = {{1,1},{2,3},{2,3},{1,1},{1,1},{1,1},{1,2}};
        System.out.println(new Solution().minHeightShelves(books, 4));
    }
    
}
