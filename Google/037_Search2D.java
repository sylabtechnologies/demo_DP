package goog10;
import java.util.*;

//https://leetcode.com/problems/search-a-2d-matrix-ii/
//R&D
class Solution2
{
    public boolean searchMatrix(int[][] mat, int target)
    {
        if (mat == null || mat.length == 0) return false;

        return rdHelp(mat, 0, mat.length-1, 0, mat[0].length-1, target);
    }

    private boolean rdHelp(int[][] mat, int yBeg, int yEnd, int xBeg, int xEnd, int target)
    {
        if (target > mat[yEnd][xEnd]) return false;
        if (target < mat[yBeg][xBeg]) return false;
        
        if (yBeg == yEnd)
            return Arrays.binarySearch(mat[yBeg], target) >= 0;
        
        int yMid = yBeg + (yEnd - yBeg) / 2;
        int xMid = xBeg + (xEnd - xBeg) / 2;
        
        if (rdHelp(mat, yBeg, yMid, xBeg, xMid, target))
            return true;
        
        if (xBeg != xEnd && rdHelp(mat, yBeg, yMid, xMid + 1, xEnd, target))
            return true;
        
        if (rdHelp(mat, yMid + 1, yEnd, xBeg, xMid, target))
            return true;
        
        if (xBeg != xEnd && rdHelp(mat, yMid + 1, yEnd, xMid + 1, xEnd, target))
            return true;
        
        return false;
    }
}


// https://leetcode.com/problems/search-a-2d-matrix/
class Solution
{
    public boolean searchMatrix(int[][] matrix, int target)
    {
        if (matrix.length == 0) return false;
        
        if (matrix.length == 1)
            return Arrays.binarySearch(matrix[0], target) >= 0;

        int begRow = 0;
        int endRow = matrix.length - 1;
        
        while (begRow <= endRow)
        {
            int mid = begRow + (endRow - begRow) / 2 ;
            
            int beg = matrix[mid][0];
            int end = matrix[mid][matrix[0].length - 1];
            
            if (beg <= target && target <= end)
                return Arrays.binarySearch(matrix[mid], target) >= 0;
            
            if (beg < target)
                begRow = mid + 1;
            else
                endRow = mid - 1;
        }

        return false;
    }
}

public class Goog10
{
    public static void main(String[] args)
    {
        int mat[][] = {{1}, {3}, {5}};
        System.out.println(new Solution().searchMatrix(mat, 2));
    }
}


