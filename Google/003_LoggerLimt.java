// https://leetcode.com/problems/logger-rate-limiter/
package goog1;
import java.util.*;

class Logger
{
    private final static int limit = 10;
    HashMap<String, Integer> time;
    
    public Logger()
    {
        time = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message)
    {
        Integer t = time.get(message);
        
        if (t != null && timestamp < t + limit)
            return false;

        time.put(message, timestamp);
        return true;
    }
}


public class Goog1
{
    public static void main(String[] args)
    {
//        System.out.println(new Solution().removeOuterParentheses("(()())(())(()(()))"));
    }
}
