// https://leetcode.com/problems/minimum-number-of-frogs-croaking/

package frogcroak;
import java.util.*;

class Solution
{
    public int minNumberOfFrogs(String croakOfFrogs)
    {
        MultiMap<Character, Integer> positions = new MultiMap<>();
        int pos = 0;
        for (char c : croakOfFrogs.toCharArray())
            positions.put(c, pos++);
        
        ArrayList<ArrayList<Integer>> test = new ArrayList<>();
        test.add(positions.getRow('c'));
        test.add(positions.getRow('r'));
        test.add(positions.getRow('o'));
        test.add(positions.getRow('a'));
        test.add(positions.getRow('k'));
        

        /**
         * validate given order/size of pos
         */
        int mysize = test.get(0).size();
        for (int i = 1; i < 5; i++)
            if (test.get(i).size() != mysize) return -1;
        
        for (pos = 0; pos < mysize; pos++)
        {
            int start = test.get(0).get(pos);
            for (int j = 1; j < 5; j++)
            {
                int next = test.get(j).get(pos);
                if ( next <= start) return -1;
                start = next;
            }
        }

        int currFrogs = 0; int maxFrogs = 0;
        for (char c : croakOfFrogs.toCharArray())
        {
            if (c == 'c')
            {
                currFrogs++;
                maxFrogs = Math.max(maxFrogs, currFrogs);
            }
            else if (c == 'k')
                currFrogs--;
        }

        return maxFrogs;
    }
}

public class FrogCroak
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().minNumberOfFrogs("crcoakroak"));
        System.out.println(new Solution().minNumberOfFrogs("aoocrrackk"));
    }
    
}

