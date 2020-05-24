// https://leetcode.com/contest/weekly-contest-184
package task1;
import java.util.*;

class Solution
{
    public List<String> stringMatching(String[] words)
    {
        int freqs[][] = new int[words.length][];
        int count = 0;
        for (String word : words)
            freqs[count++] = setFreq(word);

        Set<String> res = new TreeSet<>();
        for (int i = 0; i < words.length; i++)
        {
            String word = words[i];
            
            for (int j = 0; j < words.length; j++)
            {
                if (j == i) continue;
                if (words[j].length() < word.length()) continue;
                
                if (!freqMatch(freqs[i], freqs[j])) continue;
                
                if (words[j].indexOf(word) >= 0)
                    res.add(word);
            }
            
        }

        List<String> res1 = new ArrayList<>(res);
        return res1;
    }

    private int[] setFreq(String word)
    {
        int frq[] = new int[26];
        for (char c : word.toCharArray())
            frq[c - 'a']++;
        
        return frq;
    }

    private boolean freqMatch(int[] freq1, int[] freq2)
    {
        for (int i = 0; i < 26; i++)
            if (freq1[i] > freq2[i]) return false;
        
        return true;
    }
    
}

public class Task1
{
    public static void main(String[] args)
    {
        String words[] = {"mass","as","hero","superhero"};

        Solution sl = new Solution();
        System.out.println(sl.stringMatching(words));
    }
    
}
