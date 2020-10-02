// https://leetcode.com/problems/multiply-strings/

package goog2;
import java.util.*;

class Solution
{
    public String multiply(String num1, String num2)
    {
        if (num1.equals("0") || num2.equals("0")) return "0";
        
        LinkedList<Integer> a = str2lst(num1);
        LinkedList<Integer> b = str2lst(num2);
        return productAll(a, b);
    }    

    private String productAll(LinkedList<Integer> lst1, LinkedList<Integer> lst2)
    {
        int zeros = 0;
        LinkedList<Integer> res = new LinkedList<>();
        for (int i = lst2.size() - 1; i >= 0; i--)
        {
            int n = lst2.get(i);
            LinkedList<Integer> prod = product(new LinkedList<>(lst1), n);
            for (int j = 0; j < zeros; j++)
                prod.add(0);
            zeros++;
            
            LinkedList<Integer> temp = new LinkedList<>(res);
            res = addLst(temp, prod);
        }

        return lst2str(res);
    }

    private LinkedList<Integer> product(LinkedList<Integer> lst1, final int mul)
    {
        int cur = 0;
        LinkedList<Integer> ans = new LinkedList<>();
        while (!lst1.isEmpty() || cur > 0)
        {
            int num = cur;
            if (!lst1.isEmpty()) num += lst1.removeLast()*mul;
            ans.addFirst(num % 10);
            cur = num / 10;
        }
        
        return ans;
    }

    private LinkedList<Integer> addLst(LinkedList<Integer> lst1, LinkedList<Integer> lst2)
    {
        int cur = 0;
        LinkedList<Integer> ans = new LinkedList<>();
        while (!lst1.isEmpty() || !lst2.isEmpty() || cur > 0)
        {
            int num = cur;
            if (!lst1.isEmpty()) num += lst1.removeLast();
            if (!lst2.isEmpty()) num += lst2.removeLast();
            ans.addFirst(num % 10);
            cur = num / 10;
        }
        
        return ans;
    }
    
    private LinkedList<Integer> str2lst(String str)
    {
        LinkedList<Integer> ans = new LinkedList<>();
        for (char c : str.toCharArray())
            ans.addFirst(c - '0');
        
        Collections.reverse(ans);
        return ans;
    }
    
    private String lst2str(LinkedList<Integer> lst)
    {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < lst.size(); i++)
        {
            int n = lst.get(i);
            ans.append(Integer.toString(n));
        }
        
        return ans.toString();
    }
}

public class Goog2
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().multiply("123", "456"));
    }
    
}

