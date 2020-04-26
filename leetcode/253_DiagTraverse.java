// https://leetcode.com/problems/diagonal-traverse-ii/

package task3;
import java.util.*;

///// reverse to i + j

class Solution
{
    public int[] findDiagonalOrder(List<List<Integer>> nums)
    {
        MultiMap<Integer, Integer> map = new MultiMap<>();
        int m = nums.size(), total = 0, maxkey = 0;
        for (int i = m - 1; i >= 0; i--)
        {
            List<Integer> row = nums.get(i);
            int len = row.size(); total += len;
            for (int j = 0; j < len; j++)
            {
                int key = i + j;
                map.put(key, row.get(j));
                maxkey = Math.max(maxkey, key);
            }
        }
        
        System.out.println(map);

        int result[] = new int[total], cnt = 0;
        for (int slice = 0; slice <= maxkey; slice++)
        {
            List<Integer> row = map.getRow(slice);
            for (Integer elem : row)
                result[cnt++] = elem;
        }

        return result;
    }
}

public class Task3
{
    public static void main(String[] args)
    {
        int nn[][] = {{1,2,3,4,5},{6,7},{8},{9,10,11},{12,13,14,15,16}};
//        int nn[][] = {{1,2,3}, {4,5,6}, {7,8,9}};
//        int nn[][] = {{6}, {8}, {6,1,6,16}};

        List<List<Integer>> nums = new ArrayList<>();
        int prev = 0;
        for (int[] row : nn)
        {
            List<Integer> nrow = new ArrayList<>();
            for (int n : row)
                nrow.add(n);
            nums.add(nrow);
        }
        
        System.out.println(nums);
        
        int ans[] = new Solution().findDiagonalOrder(nums);
        System.out.println(Arrays.toString(ans));
        
    }
    
}
