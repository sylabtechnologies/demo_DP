// https://leetcode.com/problems/build-an-array-with-stack-operations/
package buildwstack;
import java.util.*;

class Solution
{
    List<String> result = new ArrayList<>();
    int mytarget[];
    int max = 0;
    
    public List<String> buildArray(int[] target, int n)
    {
        max = n;
        mytarget = target;
        helper(0, 1);
        return result;
    }

    private void helper(int atTarget, int curr)
    {
        if (atTarget == mytarget.length) return;
        if (curr > max) return;
        
        int aim = mytarget[atTarget];
        if (aim == curr)
        {
            result.add("Push");
            helper(atTarget + 1, curr + 1);
        }
        else
        {
            result.add("Push");
            result.add("Pop");
            helper(atTarget, curr + 1);
        }
    }
}

public class BuildwStack
{
    public static void main(String[] args)
    {
        int tarr[] = {1, 2};
        System.out.println(new Solution().buildArray(tarr, 4));
    }
}
