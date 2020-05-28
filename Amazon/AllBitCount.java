package bitcount;
import java.util.Arrays;

class Solution
{
    public int[] countBits(int num)
    {
        if (num < 0) return null;
        if (num == 0) return new int[1];
        
        int result[] = new int[num + 1];
        
        int max = 2, limit = max - 1;
        result[1] = 1;

        while (limit <= num)
        {
            int newmax = max*2;
            int newlimit = newmax - 1;
            
            for (int i = 0; i <= limit && i + max <= num; i++)
                result[i + max] = result[i] + 1;
            
            max = newmax;
            limit = newlimit;
        }

        return result;
    }
}

public class Bitcount
{
    public static void main(String[] args)
    {
        System.out.println(Arrays.toString(new Solution().countBits(5)));
    }
}

