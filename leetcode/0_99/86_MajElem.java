// https://leetcode.com/problems/majority-element/
package majorityelem;

import java.util.TreeMap;
import java.util.Map;

// assume just find max
class Solution
{
    public static int majorityElement(int[] nums)
    {
        Map<Integer, Integer> map = new TreeMap<>();
        int maxFreq = 0;
        int maxElem = -1;
        
        for (int num : nums)
        {
            if (map.containsKey(num))
            {
                int freq = map.get(num);
                freq++;
                map.put(num, freq);
                
                if (freq > maxFreq) {
                    maxFreq = freq;
                    maxElem = num;
                }
            }
            else
            {
                map.put(num, 1);
                if (1 > maxFreq)
                {
                    maxFreq = 1;
                    maxElem = num;
                }
            }
        }

        return maxElem;
    }
}