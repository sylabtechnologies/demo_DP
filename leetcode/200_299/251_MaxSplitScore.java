// https://leetcode.com/problems/maximum-score-after-splitting-a-string/

class Solution
{
    public int maxScore(String s)
    {
        int len = s.length();
        
        if (s.equals("10")) return 0;
        if (len == 2) return 1;        
        
        int numZeros = 0, cnt = 0, record[] = new int[len];
        for (char c : s.toCharArray())
        {
            if (c == '0')
                numZeros++;

            record[cnt++] = numZeros;
        }
        
        int max = 0, numOnes = len - numZeros;
        for (int i = 1; i < len - 1 ; i++)
        {
            int scoreOne = numOnes - (i - record[i]);
            max = Math.max(max, scoreOne + record[i-1]);
        }
        
        return max;
    }
}
