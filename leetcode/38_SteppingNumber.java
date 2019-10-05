/*

A Stepping Number is an integer such that all of its adjacent digits have an
absolute difference of exactly 1. For example, 321 is a Stepping Number
while 421 is not.

Given two integers low and high, find and return a sorted list of all
the Stepping Numbers in the range [low, high] inclusive.

*/

package steppingnumber;
import java.util.*;

/// profile mem for 0 to 1bln

class Solution
{
    public List<Integer> countSteppingNumbers(int low, int high)
    {
        TreeSet<Integer> ans = new TreeSet<>();
        
        for (int i = 0 ; i <= 9 ; i++)
        {
            dfs(low, high, i, ans); 
        }
        
        ArrayList<Integer> ans1 = new ArrayList<Integer>();
        ans1.addAll(ans);
        return ans1;
    }
    
    private static void dfs(int n, int m, int stepNum, TreeSet<Integer> answer) 
    { 
        if (stepNum <= m && stepNum >= n) answer.add(stepNum);
        
        if (stepNum == 0 || stepNum > m) return ; 
  
        int lastDigit = stepNum % 10; 
  
        int stepNumA = stepNum*10 + (lastDigit-1); 
        int stepNumB = stepNum*10 + (lastDigit+1); 
  
        if (lastDigit == 0)
            dfs(n, m, stepNumB, answer); 
        else if(lastDigit == 9) 
            dfs(n, m, stepNumA, answer); 
        else
        { 
            dfs(n, m, stepNumA, answer); 
            dfs(n, m, stepNumB, answer); 
        } 
    } 
}

public class SteppingNumber
{

    public static void main(String[] args)
    {
        Solution sol = new Solution();
        
        List<Integer> ans = sol.countSteppingNumbers(0, 21);
        System.out.println(ans);
        
    }
    
}
