// https://leetcode.com/problems/peak-index-in-a-mountain-array/

package binmountain;

class Solution
{
    // modify bin search: LIST ALL LOGIX probably to lo = hi + 2
    public static int peakIndexInMountainArray(int[] arr)
    {
        printArray(arr);
        
        int lo = 0;
        int hi = arr.length;
        int mid = 0;
        
        while (lo < hi)
        {
            mid = lo + (hi - lo) / 2;

            boolean leftOK = arr[mid] > arr[mid - 1];
            boolean riteOK = arr[mid] > arr[mid + 1];
            
            if (riteOK & leftOK) return mid;
            
            if (arr[mid] > arr[lo])
            {
                if (leftOK)
                    lo = mid;
                else
                    hi = mid;
                
                continue;
            }
            else
            {
                if (riteOK)
                    hi = mid;
                else
                    lo = mid;
            }
        }
        
        return -1;
    }
    
    private static void printArray(int[] nums)
    {
        for (int i = 0; i < nums.length; i++)
        {
            System.out.print(nums[i] + " ");
        }
        System.out.println(";");
    }
    
}
