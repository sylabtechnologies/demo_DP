package kpalindromes;

// https://leetcode.com/problems/construct-k-palindrome-strings/ #D odd count
class Solution
{
    public boolean canConstruct(String s, int k)
    {
        int freq[] = new int[26];
        char chars[]  = s.toCharArray();
        if (chars.length < k) return false;

        for (char c : chars)
        {
            int inx = c - 'a';
            freq[inx]++;
        }
        
        int oddCount = 0;
        for (int i = 0; i < 26; i++)
        {
            if (freq[i] > 0)
            {
                if (freq[i] % 2 == 1)
                    oddCount++;
            }

        }
        
        if (oddCount <= k)
            return true;
        else
            return false;
    }
}

public class KPalindromes
{

    public static void main(String[] args)
    {
        Solution sl = new Solution();
        System.out.println(sl.canConstruct("leetcode", 3));
    }
    
}
