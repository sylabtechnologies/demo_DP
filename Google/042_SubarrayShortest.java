package goog12;
import java.util.*;

// https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
class Solution
{
    public int findUnsortedSubarray(int[] nums)
    {
        final int len = nums.length;
        if (len == 1) return 0;
        if (len == 2)
            return nums[0] <= nums[1] ? 0 : 2;
        
        int copy[] = Arrays.copyOf(nums, len);
        Arrays.sort(copy);
        
        int start = 0;
        while (start < len)
        {
            if (copy[start] != nums[start]) break;
            start++;
        }
        
        if (start == len) return 0;
        
        int end = len - 1;
        while (end > start + 1)
        {
            if (copy[end] != nums[end]) break;
            end--;
        }
        
        return end - start + 1;
    }
}

public class Goog12
{
    public static void main(String[] args)
    {
        System.out.println(new Solution());
    }
    
}



class BinaryIndexedTree
{
    private int[] BITree;
    private int n;

    BinaryIndexedTree(int len)
    {
        // init all zeros by Java's default
        n = len;
        BITree = new int[len + 1];
    }

    void update(int index, int val)
    {
        index = index + 1; 
      
        while(index <= n) 
        { 
            BITree[index] += val; 
            index += index & (-index); 
        }
        
        // System.out.println(Arrays.toString(BITree));
    }

    int prefixSum(int index)
    {
        int sum = 0;
        index = index + 1; 
      
        while(index > 0) 
        { 
            sum += BITree[index]; 
            index -= index & (-index); 
        }
        
        return sum;         
    }
}