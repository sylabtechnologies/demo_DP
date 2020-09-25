package templarges25;
import java.util.*;

/// IF B + A > A + B THEN WE GOT BA
class Solution
{
    public String largestNumber(int[] nums)
    {
        int len = nums.length;
        if (len == 0) return "";
        
        ArrayList<String> snums = new ArrayList<>();
        int zeroC = 0;
        for (int i = 0; i < len; i++)
        {
            if (nums[i] == 0) 
            {
                zeroC++;
                continue;
            }
            
            snums.add(Integer.toString(nums[i]));
        }
        
        Collections.sort(snums, new Comparator<String>()
        {
            @Override
            public int compare(String a, String b)
            {
                return (b + a).compareTo(a + b);
            }
        });
        
        StringBuilder sb = new StringBuilder();
        for (String str : snums)
            sb.append(str);
        
        if (sb.length() == 0)
            return "0";
        else
            for (int i = 0; i < zeroC; i++)
                sb.append("0");
        
        return sb.toString();
    }
}

public class TempLargeS25
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().largestNumber(new int[] {0, 0}));
    }
}
