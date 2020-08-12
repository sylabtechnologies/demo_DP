/// https://github.com/sanchit2812/InterviewBit-Solutions

package bigconc;
import java.util.*;

class Solution
{
    public ArrayList<Integer> findSubstring(String s, final List<String> words)
    {
        HashMap<String, Integer> map = new HashMap<>();
        for (String w : words)
            map.put(w, map.getOrDefault(w, 0) + 1);
        
        ArrayList<Integer> result = new ArrayList<>();
        if (s.isEmpty() || words.isEmpty()) return result;

        final int wCount = words.size();
        int wordLength = words.get(0).length();
        
        for (int i = 0; i <= s.length() - wCount * wordLength; i++)
        {
            Map<String, Integer> visited = new HashMap<>();
            
            for (int j = 0; j < wCount; j++)
            {
                int nextWord = i + j * wordLength;
                String word = s.substring(nextWord, nextWord + wordLength);
                
                if (!map.containsKey(word))
                    break;
                else
                    visited.put(word, visited.getOrDefault(word, 0) + 1);
                
                if (visited.get(word) > map.getOrDefault(word, 0)) break;
                
                if (j + 1 == wCount) result.add(i);
            }
        }
        
        return result;        
    }
}

public class BigConc
{
    public static void main(String[] args)
    {
        List<String> words = Arrays.asList("foo" ,"bar");
        System.out.println(new Solution().findSubstring("barfoothefoobarman", words));
    }
}
