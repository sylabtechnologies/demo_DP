package goog37;
import java.util.Arrays;
import java.util.HashMap;

// #S = bool array (deduce total from bool array)
// https://leetcode.com/problems/can-i-win/
class Solution
{
    private HashMap<String, Boolean> memo = new HashMap<>();
    
    public boolean canIWin(int maxChoosableInteger, int desiredTotal)
    {
        if (maxChoosableInteger >= desiredTotal) return true;
        
        // see progression
        if (maxChoosableInteger * (maxChoosableInteger+1)/2 < desiredTotal)
            return false;
        
        boolean seen[] = new boolean[maxChoosableInteger + 1];
        return dfs(seen, desiredTotal, 1);
    }

    private boolean dfs(boolean[] seen, int total, int t)
    {
        String key = bool2String(seen);
        
        if (!memo.containsKey(key))
        {
            for (int i = 1; i < seen.length; i++)
            {
                if (seen[i]) continue;
                if (i >= total) return true;

                seen[i] = true;
                if (!dfs(seen, total - i, t + 1))
                {
                    memo.put(key, Boolean.TRUE);
                    seen[i] = false;
                    return true;
                }

                seen[i] = false;
            }

            memo.put(key, Boolean.FALSE);
        }
        
        return memo.get(key);
    }

    private String bool2String(boolean[] seen)
    {
        char carr[] = new char[seen.length];
        for (int i = 0; i < carr.length; i++)
            carr[i] = seen[i] ? '0' : '1';
        return new String(carr);
    }
}

public class Goog37
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().canIWin(5, 50));
    }
    
}

