package maxsumpermut;
import java.util.*;

class Solution
{
    static long MODL = 1_000_000_007;

    public int maxSumRangeQuery(int[] nums, int[][] requests)
    {
        int mylen = nums.length;
        int visited[] = new int[mylen];

        // MAKE ONE PASS!
        for (int[] req : requests)
        {
            visited[req[0]] += 1;

            if (req[1] + 1 < mylen)
                visited[req[1] + 1] -= 1;
        }
        
        for (int i = 1; i < mylen; i++)
            visited[i] += visited[i-1];
        
        Arrays.sort(nums);
        Arrays.sort(visited);
        
        long ans = 0;
        for (int i = 0; i < mylen; i++)
        {
            long add = ((long) visited[i]) * nums[i];
            add = add % MODL;
            ans = ans + add;
        }
    
        return (int) (ans % MODL);
    }
}

public class MaxSumPermut
{
    public static void main(String[] args)
    {
        
    }
    
}
