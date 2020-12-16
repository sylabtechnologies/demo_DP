package goog28;
import java.util.*;

// https://leetcode.com/problems/palindrome-partitioning/
class Solution
{
    public List<List<String>> partition(String s)
    {
        List<List<String>> all = new ArrayList<>();
        bktrack(all, new ArrayList<String>(), s, 0);
        return all;
    }

    private void bktrack(List<List<String>> res, ArrayList<String> temp, String src, int start)
    {
        if (start == src.length())
        {
            res.add(new ArrayList<>(temp));
            return;
        }
        
        for (int i = start+1; i <= src.length(); i++)
        {
            String tmp = src.substring(start, i);

            if (isPalindrome(tmp))
            {
                temp.add(tmp);
                bktrack(res, temp, src, i);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String tst)
    {
        if (tst.length() == 1) return true;
        
        int i = 0, j = tst.length() - 1;
        while (i < j)
        {
            if (tst.charAt(i++) != tst.charAt(j--))
                return false;
        }

        return true;
    }
}

public class Goog28
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().partition("aab"));
    }
    
}
