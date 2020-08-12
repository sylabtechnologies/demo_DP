package twosum;
import java.util.*;

class Solution
{
    public ArrayList<Integer> twoSum(final List<Integer> nums, int target)
    {
        Map<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        
        for (int i = nums.size() - 1; i >=0; i--)
            map.put(nums.get(i), i);

        ArrayList<ArrayList<Integer>> solutions = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++)
        {
            int delta = 0;
            delta = target - nums.get(i);

            if (!map.containsKey(delta)) continue;

            int deltaIndex = map.get(delta);
            if (deltaIndex == i) continue;
            
            ans.add(i+1);
            ans.add(deltaIndex+1);
            Collections.sort(ans);
            solutions.add(new ArrayList<>(ans));
            ans.clear();
        }
        
//        System.out.println(solutions);

        if (solutions.isEmpty()) return new ArrayList<>();

        int min = Integer.MAX_VALUE, minIx = -1;
        for (int i = 0; i < solutions.size(); i++)
        {
            ArrayList<Integer> row = solutions.get(i);
            if (row.get(1) < min)
                min = row.get(1);
        }
        
        int min2nd = Integer.MAX_VALUE;
        for (int i = 0; i < solutions.size(); i++)
        {
            ArrayList<Integer> row = solutions.get(i);
            if (row.get(1) == min)
            {
                if (row.get(0) < min2nd)
                {
                    min2nd = row.get(0);
                    minIx = i;
                }
            }
        }
        
        return solutions.get(minIx);
    }
}

public class TwoSum
{
    public static void main(String[] args)
    {
        ArrayList<Integer> test = new ArrayList<>(Arrays.asList(
            -10, -8, -9, -10, -7,
            -6, 5, -5, -10, 2,   
            8, -2, -2, -3, 5,
            -8, 3, -1, -6, 8,
            -7, -1, -2, -9, -6,
            3, 4, 3, -5, 9,
            -10, 0, -10, 10, 5,
            -6, 7, -9, -6, -7,
            5, 5, -6, -7, -10,
            3, 10, 6, 8, -4,
            5, -2, -5, -4, -7,
            2, -5, -7, 10, -7,
            7, -7, -4, 2, 7,
            6, -9, 8, -10, 8,
            -7, 8, 6, 7, 3,
            2, -1, 3, 6, -5,
            8, -5, -6, -6, 3,
            -9, -9, 5, 0, -7,
            -10, -6, -10, -10, 4, 3));
        System.out.println(new Solution().twoSum(test, 0));

    }
    
}

/*
        ArrayList<Integer> test = new ArrayList<>(Arrays.asList(
            4, 7, -4, 2, 2,
            2, 3, -5, -3, 9,
            -4, 9, -7, 7, -1,
            9, 9, 4, 1, -4,
            -2, 3, -3, -5, 4,
            -7, 7, 9, -4, 4,  -8));

*/