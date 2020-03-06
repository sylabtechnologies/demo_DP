/**
 * Return the number of distinct non-empty substrings of text that can be written
 * as the concatenation of some string with itself.
 * 
 * hl: find uniq chars, test repeats
 * hl2: freqMax = 26 can RabinKarp
 * hl max = count charseq hash for each substring in dp
 * then compare candidates
 * 
 * hl3: delete uniq char substr
 * hl31: RK
 */

package echosubstrings;
import java.util.*;

class Solution
{
    public int distinctEchoSubstrings(String text)
    {
        char[] carr = text.toCharArray();
        
        Set<Character> freq = new HashSet<>();
        Set<String> distinct = new HashSet<>();
        
        for (int i = 0; i < text.length(); i++)
        {
            if (freq.contains(carr[i])) continue;
            freq.add(carr[i]);
        }

        System.out.println(freq);
        
        int i = 0;
        while (i < text.length())
        {
            int start  = i;
            while (start < text.length())
            {
                if (!freq.contains(carr[start])) break;
                
                if (canCC(carr, i, start))
                {
                    distinct.add(text.substring(i, start + 1));
                    System.out.println(distinct);
                }
                
                start++;
            }
            
            i++;
        }
        
        return distinct.size();
    }    

    private boolean canCC(char[] arr, int i, int start)
    {
        int len = start - i + 1;
        if (start >= arr.length - len) return false;
        
//        System.out.println(Arrays.toString(arr));

        for (int j = 0; j < len; j++)
        {
            try {
            if (arr[i + j] != arr[ start + 1 + j])
                return false;
            } catch (Exception e)
            {
                System.out.println(i + " " + start);
            }
        }
            
        return true;
    }
}
