/**
 * https://www.hackerrank.com/challenges/equality-in-a-array/problem
 * - calculate max freq and subtract from array size
 */
package eqarray;

import java.util.Map;
import java.util.TreeMap;

public class EqArray
{
    static int equalizeArray(int[] arr)
    {
        TreeMap<Integer, Integer> freqMap = new TreeMap<>();
        
        for (int i : arr)
        {
            Integer freq = freqMap.get(i);
            
            if (freq == null)
                freqMap.put(i, 1);
            else
                freqMap.put(i, freq + 1);
        }
        
        int maxFreq = 0;
        for (Map.Entry<Integer, Integer> e : freqMap.entrySet())
        {
            if (e.getValue() > maxFreq)
                maxFreq = e.getValue();
        }
        
        return arr.length - maxFreq;
    }    

    public static void main(String[] args)
    {
        int[] arr = {3, 3, 2, 1, 3};
        
        System.out.println(equalizeArray(arr));
    }
    
}
