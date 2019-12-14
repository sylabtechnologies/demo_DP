/**
 * https://leetcode.com/problems/triangle/
 * 
 * DP from bottom, select local minimum for next row 
 * 
 */

/*
DP =
4 1 8 3
7 6 10 
9 10
11
*/

package trianglepath;

import java.util.*;

public class TrianglePath
{

    public static void main(String[] args)
    {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8 ,3));
        
        System.out.println(minimumTotal(triangle));
    }
   
    public static int minimumTotal(List<List<Integer>> triangle)
    {
        int len = triangle.size();
        int[] DP = new int[triangle.size()];
        
        for (int i = 0; i < len; i++)
        {
            DP[i] = triangle.get(len - 1).get(i);
        }
        
        for (int i = 1; i < len; i++)
        {
            for (int j = 1; j < len - i + 1; j++)
            {
                int apex = triangle.get(len - 1 - i).get(j - 1);
                DP[j-1] = Math.min(DP[j-1], DP[j]) + apex;
            }
        }
        
        return DP[0];
    }
    
    
}
