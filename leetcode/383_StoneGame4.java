// https://leetcode.com/problems/stone-game-iv/
package stonegame4;

class Solution
{
    public boolean winnerSquareGame(int n)
    {
        if (n == 0) return false;

        boolean answer[] = new boolean[n + 1];
        
        for (int i = 1; i <= n; i++)
        {
            int j = 1, sq = 1;
            while (sq <= i)
            {
                if (!answer[i - sq])
                {
                    answer[i] = true;
                    break;
                }
                
                j++;
                sq = j*j;
             }
        }
        
        return answer[n];
    }
}    

public class StoneGame4
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().winnerSquareGame(44));
    }
    
}
