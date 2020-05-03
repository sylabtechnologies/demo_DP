// https://leetcode.com/problems/find-the-kth-smallest-sum-of-a-matrix-with-sorted-rows/

package ksmallestsum;
import java.util.*;

class Solution
{
    public int kthSmallest(int[][] mat, int k)
    {
        int nrow = mat.length;
        int ncol = mat[0].length;
        int accu[] = new int[k];
        int accuSize = Math.min(ncol, k);
        for (int i = 0; i < accuSize; i++)
            accu[i] = mat[0][i];
        
        // accumulate best 1..k
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 1; i < nrow; i++)
        {
            temp.clear();
            for (int j = 0; j < ncol; j++)
            {
                for (int l = 0; l < accuSize; l++)
                    temp.add(mat[i][j] + accu[l]);
            }
            
            Collections.sort(temp);
            if (temp.size() > accuSize)
                accuSize = Math.min(temp.size(), k);
            
            for (int j = 0; j < accuSize; j++)
                accu[j] = temp.get(j);
        }

        return accu[k - 1];
    }
}

public class KSmallestArray
{
    public static void main(String[] args)
    {
        int arr[][] =         
    {{77,95,112,122,148,171,178,214,216,238,319,350,369,373,395},
    {42,51,69,70,116,116,120,157,159,168,178,205,213,214,278},
    {11,25,30,137,164,171,176,254,286,303,311,315,350,372,378},
    {13,20,29,33,57,65,155,161,175,235,247,261,315,341,359},
    {20,24,44,54,96,179,209,283,321,324,346,348,352,386,390},
    {23,42,57,58,60,61,69,186,224,249,277,289,338,362,381},
    {28,57,69,164,210,230,234,262,273,291,325,339,354,371,375},
    {10,46,56,60,78,108,130,293,310,340,364,372,372,377,377},
    {24,56,81,93,128,140,147,158,187,206,272,316,318,347,359}};
    
        System.out.println(new Solution().kthSmallest(arr, 10));
    }
    
}
