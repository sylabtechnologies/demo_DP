package rolldice;

// https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
// You have d dice, and each die has f faces numbered 1, 2, ..., f.
// Given n dice each with m faces, numbered from 1 to m
//  = do DP https://www.geeksforgeeks.org/dice-throw-dp-30/

class Solution
{
    public int numRollsToTarget(int d, int f, int t)
    {
        int[][] DPTable = new int [d + 1][t + 1];
        final long MyMOL = 1000000007;
        
        // if we have 1 dice
        for (int j = 0; j <= f && j <= t; j++)
            DPTable[1][j] = 1;

        for (int i = 2; i <= d; i++) 
            for (int j = 1; j <= t; j++) 
            {
                long num = DPTable[i][j];
                for (int k = 1; k <= f && k < j; k++) 
                    num += DPTable[i-1][j-k];
                
                while (num > MyMOL)
                    num %= MyMOL;
                
                DPTable[i][j] = (int) num;
            }
        
        return DPTable[d][t];
    }
}

public class RollDice
{
public static void main(String[] args)
    {
        Solution sol = new Solution();
        System.out.println(sol.numRollsToTarget(30, 30, 500));
    }
    
}
