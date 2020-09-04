// https://leetcode.com/problems/partition-labels/ 

package partition;
import java.util.*;

class Solution
{
    public List<Integer> partitionLabels(String S)
    {
        
        // get ivals
        LinkedHashMap<Character, int[]> expanse = new LinkedHashMap<>();
        for (int i = 0; i < S.length(); i++)
        {
            Character c = S.charAt(i);
            int[] range = expanse.get(c);
            
            if (range == null)
            {
                range = new int[2];
                range[0] = i;
                range[1] = i;
                expanse.put(c, range);
            }
            else
                range[1] = i;
        }
        
        int[] temp = null;
        List<Integer> result = new ArrayList<>();
        
        // merge ivals
        for (Map.Entry<Character, int[]> entry : expanse.entrySet())
        {
            int[] curr = entry.getValue();
            if (temp == null)
                temp = curr;
            else
            {
                if (curr[0] < temp[1])
                    temp[1] = Math.max(curr[1], temp[1]);
                else
                {
                    result.add(temp[1] - temp[0] + 1);
                    temp = curr;
                }
            }
        }

        result.add(temp[1] - temp[0] + 1);

        return result;
    }
}

public class Partition
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().partitionLabels("vhaagbqkaq"));
    }
    
}
