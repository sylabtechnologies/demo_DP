// https://leetcode.com/problems/bulb-switcher-iii/

package SwitchBulbs3;

import java.util.Arrays;

class Solution
{
    public static int numTimesAllBlue(int[] light)
    {
        int result = 0;
        int len = light.length;
        // 0..n-1 boxes of marbles
//        int[] bulbOn = new int[len];
        
        int rightMost = -1;
        int rightMostBlue = 0;
        
        BinaryIndexedTree bit = new BinaryIndexedTree(len);
        
        for (int bulb : light)
        {
            int ix = bulb - 1;
            if (ix > rightMost) rightMost = ix;
            
//            bulbOn[ix] = 1;
//            System.out.println(Arrays.toString(bulbOn));

            // add marble
            bit.update(ix, 1);
            
            boolean allBlue = true;
            for (int i = rightMostBlue; i <= rightMost; i++)
            {
                if (bit.prefixSum(i) != i + 1)
                {
                    allBlue = false;
                    break;
                }
            }
            
            if (allBlue)
            {
                rightMostBlue = ix;
                result++;
            }
        }

        return result;
    }

}

public class SwitchBulbs3
{

    public static void main(String[] args)
    {
        int[] light = {4,1,2,3};
//        int[] light = {1, 2, 3, 4, 5, 6};
//        int[] light = {2,1,3,5,4};
        System.out.println(Solution.numTimesAllBlue(light));
    }
    
}
