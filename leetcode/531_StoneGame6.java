package goog27;
import java.util.*;

// https://leetcode.com/problems/stone-game-vi/
// sort by a + b b/c alice scores minus bob too

class Solution
{
    public int stoneGameVI(int[] aliceValues, int[] bobValues)
    {
        int len = aliceValues.length;
        int game[][] = new int[len][2];
        for (int i = 0; i < game.length; i++)
        {
            game[i][0] = aliceValues[i];
            game[i][1] = bobValues[i];
        }
        
        Arrays.sort(game, (a,b)->Integer.compare(b[0] + b[1], a[0] + a[1]));
        
        int alice = 0, bob = 0;
        for (int i = 0; i < game.length; i++)
        {
            if (i % 2 == 0) 
                alice += game[i][0];
            else
                bob   += game[i][1];
        }
        
        return Integer.compare(alice, bob);
    }
}

public class Goog27
{
    public static void main(String[] args)
    {
        int a[] = {2,4,3};
        int b[] = {1,6,7};
        System.out.println(new Solution().stoneGameVI(a, b));
    }
}
