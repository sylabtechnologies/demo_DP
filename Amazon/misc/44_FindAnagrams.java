// https://leetcode.com/problems/find-all-anagrams-in-a-string/
package findanagrams;
import java.util.*;

class Solution
{
    public List<Integer> findAnagrams(String word, String p)
    {
        int len = p.length();
        ArrayList<Integer> res = new ArrayList<>();
        if (word.length() < len) return res;
        
        int pFreq[] = setFreq(p, 0, len);
        int currFreq[] = setFreq(word, 0, len);
        if (Arrays.equals(pFreq, currFreq)) res.add(0);
        
        for (int i = 1; i < word.length() - len + 1; i++)
        {
            char beg = word.charAt(i-1);
            char end = word.charAt(i + len - 1);
            currFreq[beg - 'a']--;
            currFreq[end - 'a']++;
            
            if (Arrays.equals(pFreq, currFreq)) res.add(i);
        }
     
        return res;
    }

    private int[] setFreq(String word, int beg, int end)
    {
        int frq[] = new int[26];
        for (int i = beg; i < end; i++)
            frq[word.charAt(i) - 'a']++;
        
        return frq;
    }
}

public class FindAnagrams
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().findAnagrams("abab", "ab"));
    }
    
}
