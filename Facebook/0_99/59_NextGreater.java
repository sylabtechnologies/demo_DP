// https://www.interviewbit.com/problems/nextgreater/

package greater;
import java.util.*;

class Solution
{
    public int[] nextGreater(int[] arr)
    {
        int len = arr.length;
        if (len == 0) return new int[0];

        ArrayList<Pair> ans = new ArrayList<>();
        Stack<Pair> stk = new Stack<>();
        
        for (int i = 0; i < arr.length; i++)
        {
            Pair curr = new Pair(arr[i], i);
            
            while (!stk.isEmpty() && curr.val > stk.peek().val)
            {
                Pair prev = stk.pop();
                prev.val = curr.val;
                ans.add(prev);
            }
            
//            System.out.println(ans);
            stk.add(curr);
        }
        
        while (!stk.isEmpty())
        {
            Pair curr = stk.pop();
            curr.val = -1;
            ans.add(curr);
        }

        int res[] = new int[ans.size()];
        for (Pair p : ans)
            res[p.ix] = p.val;
       
        return res;
    }

    private static class Pair
    {
        int val, ix;
        public Pair(int v, int i) {val = v; ix = i;}
        @Override
        public String toString() { return val + "@ " + ix ; }
    }
}

public class NextGreater
{
    public static void main(String[] args)
    {
        int arr[] = {34, 35, 27, 42, 5, 28, 39, 20, 28};
        System.out.println(Arrays.toString(new Solution().nextGreater(arr)));
    }
}
