package kpalindromes;

// https://leetcode.com/problems/construct-k-palindrome-strings/
/// #D odd + even count
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
        
        int evenCount = 0, oddCount = 0;
        for (int i = 0; i < 26; i++)
        {
            if (freq[i] > 0)
            {
                if (freq[i] % 2 == 0)
                    evenCount++;
                else
                    oddCount++;
                
//                char key = (char) ((char) 'a' + i);
//                System.out.println(key + " : " + freq[i]);
            }

        }
        
//        System.out.println(oddCount);
//        System.out.println(evenCount);
        
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
