// https://leetcode.com/problems/merge-sorted-array/
// merge from the end

package mergesorted;

class Solution
{
    public void merge(int[] nums1, int len1, int[] nums2, int len2)
    {
        int curr = len1 + len2 - 1, curr1 = len1 - 1, curr2 = len2 - 1;
        
        while (curr1 >= 0 || curr2 >= 0)
        {
            if (curr1 >= 0 && curr2 >= 0)
            {
                if (nums1[curr1] >= nums2[curr2])
                {
                    nums1[curr] = nums1[curr1];
                    curr1--;
                    curr--;
                }
                else
                {
                    nums1[curr] = nums2[curr2];
                    curr2--;
                    curr--;
                }
            }
            else if (curr1 >= 0)
            {
                nums1[curr] = nums1[curr1];
                curr1--;
                curr--;
            }
            else
            {
                nums1[curr] = nums2[curr2];
                curr2--;
                curr--;
            }
        }
    }
}

public class MergeSorted
{
    public static void main(String[] args)
    {
        Solution sol = new Solution();
        int[] a1 = {1,2,3,0,0,0};
        int[] a2 = {2,5,6};
        sol.merge(a1, 3, a2, 3);
        
        for (int i : a1) { System.out.println(i);}
    }
    
}
