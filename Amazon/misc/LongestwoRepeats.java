package longestworepeats;

/*
1. all substrings
2. try to memoize

FIX TO #ama#
7. STUDY https://leetcode.com/problems/longest-substring-without-repeating-characters/
W/ SLIDING WINDOW

*/

class Solution
{
    public int lengthOfLongestSubstring(String str)
    {
        int len = str.length();
        if (len <  2) return len;
        
        int max = 0;
        
        for (int i = 0; i < len; i++)
        {
            int test = check(str, i, len);
            if (test > max) max = test;
        }
        
        return max;
    }

    private int check(String str, int i, int length)
    {
        boolean busy[] = new boolean[26];
        busy[str.charAt(i) - 'a'] = true;
    
        for (int j = 1;  i + j < length; j++)
        {
            int index = str.charAt(i + j) - 'a';
            if (busy[index]) return j;
            busy[index] = true;
        }
        
        return length - i;
    }
}

public class LongestwoRepeats
{

    public static void main(String[] args)
    {
        String st = "abcabcbb";
        Solution s = new Solution();
        System.out.println(s.lengthOfLongestSubstring(st));
    }
    
}
