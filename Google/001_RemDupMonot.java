//  https://leetcode.com/problems/remove-duplicate-letters/
import java.util.*;

class Solution
{
    // m-tonic or last char
    public String removeDuplicateLetters(String s)
    {
        if (s.isEmpty()) return new String();
        
        int freq[] = new int[26];
        Arrays.fill(freq, -1);
        for (char c : s.toCharArray())
        {
            int ix = c-'a';
            if (freq[ix] < 0)
                freq[ix] = 1;
            else
                freq[ix]++;
        }
        
        Stack<Character> res = new Stack<>();
        char frst = s.charAt(0);
        int ixx = frst-'a';
        res.push(frst);
        boolean done[] = new boolean[26];
        freq[ixx]--;
        done[ixx] = true;
        for (int i = 1; i < s.length(); i++)
        {
            char c = s.charAt(i);
            int ix1 = c - 'a';
            if (freq[ix1] == 0) continue;
            freq[ix1]--;
            
            if (done[ix1]) continue;
            
            while (!res.isEmpty())
            {
                char prev = res.peek();
                int ix2 = prev - 'a';
                if (prev > c && freq[ix2] > 0)
                {
                    res.pop();
                    done[ix2] = false;
                }
                else break;
            }

            res.push(c);
            done[ix1] = true;
            
//            System.out.println(reslt);
        }
        
        StringBuilder ret = new StringBuilder();
        for (Character c : res) ret.append(c);
        return ret.toString();
    }
}

