// https://leetcode.com/problems/add-to-array-form-of-integer/

package goog2;
import java.util.*;

class Solution
{
    public List<Integer> addToArrayForm(int[] a, int K)
    {
        LinkedList<Integer> form1 = form2lst(a);
        LinkedList<Integer> form2 = int2lst(K);
        return addLst(form1, form2);
    }

    private List<Integer> addLst(LinkedList<Integer> lst1, LinkedList<Integer> lst2)
    {
        int cur = 0;
        List<Integer> ans = new LinkedList<>();
        while (!lst1.isEmpty() || !lst2.isEmpty() || cur > 0)
        {
            int num = cur;
            if (!lst1.isEmpty()) num += lst1.removeLast();
            if (!lst2.isEmpty()) num += lst2.removeLast();
            ans.add(num % 10);
            cur = num / 10;
        }
        
        Collections.reverse(ans);
        return ans;
    }
    
    private LinkedList<Integer> form2lst(int[] a)
    {
        LinkedList<Integer> ans = new LinkedList<>();
        for (int i : a) ans.add(i);
        return ans;
    }

    private LinkedList<Integer> int2lst(int num)
    {
        LinkedList<Integer> ans = new LinkedList<>();
        while (num > 0)
        {
            ans.addFirst(num % 10);
            num = num / 10;
        }
        
        return ans;
    }

}

public class Goog2
{
    public static void main(String[] args)
    {
        int arr[] = {1,2,3};
        System.out.println(new Solution().addToArrayForm(arr, 7));
    }
    
}
