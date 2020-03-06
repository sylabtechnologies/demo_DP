// https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
// make sliding window
// https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/discuss/516977/JavaC%2B%2BPython-Easy-and-Concise
// https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/92007/sliding-window-algorithm-template-to-solve-all-the-leetcode-substring-search-problem
// or search min index
// https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/discuss/516979/C%2B%2B-Binary-Search-Solution

package threecharsubstrings;
import java.util.*;

class Solution
{
    public int numberOfSubstrings(String s)
    {
        s = "aacaaab"; //  aaaccb acaaaabb same?
        int count[] = {0, 0, 0}, res = 0 , i = 0, n = s.length();
        for (int j = 0; j < n; ++j)
        {
            ++count[s.charAt(j) - 'a'];
            
//            System.out.println("B4: " + Arrays.toString(count));
            
            while (count[0] > 0 && count[1] > 0 && count[2] > 0)
            {
                --count[s.charAt(i++) - 'a'];
//                System.out.println(i + " - " + Arrays.toString(count));
            }
            
            res += i;
        }
        
        return res;
    }

}

public class ThreeCharSubstrings
{

    public static void main(String[] args)
    {
        Solution sol = new Solution();
        
//        System.out.println(sol.numberOfSubstrings("aabacaabbcacccbcbaaacbcaacc"));
        System.out.println(sol.numberOfSubstrings("aaacb"));
//        System.out.println(sol.numberOfSubstrings("ababbbc"));
//        System.out.println(sol.numberOfSubstrings("abcabc"));    }

    }
}
