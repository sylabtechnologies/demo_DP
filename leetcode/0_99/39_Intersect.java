/*
Given three integer arrays arr1, arr2 and arr3 sorted in strictly increasing
order, return a sorted array of only the integers that appeared
in all three arrays.
*/

package intersect;
import java.util.*;

class Solution
{
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3)
    {
        Set<Integer> set1 = new TreeSet<>();
        for (int i : arr1)
        {
            set1.add(i);
        }
        
        Set<Integer> set2 = new TreeSet<>();
        for (int i : arr2)
        {
            set2.add(i);
        }

        Set<Integer> set3 = new TreeSet<>();
        for (int i : arr3)
        {
            set3.add(i);
        }
        
        set2.retainAll(set3);
        set1.retainAll(set2);
        
        return new ArrayList<Integer>(set1);
    }
}

public class Intersect
{

    public static void main(String[] args)
    {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {1,2,5,7,9};
        int[] arr3 = {1,3,4,5,8};
        Solution sol = new Solution();
        
        List<Integer> ans = sol.arraysIntersection(arr1, arr2, arr3);
        
        System.out.println(ans);
        
    }
    
}
