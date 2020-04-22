/**
 * A binary matrix means that all elements are 0 or 1. For each individual row
 * of the matrix, this row is sorted in non-decreasing order.
 * Given a row-sorted binary matrix binaryMatrix, return leftmost column
 * index(0-indexed) with at least a 1 in it.
 * If such index doesn't exist, return -1
 */

package leftmostbinary;
import java.util.ArrayList;
import java.util.List;

interface BinaryMatrix
{
    public int get(int x, int y);
    public List<Integer> dimensions();
};

class Solution
{
    // copy https://en.wikipedia.org/wiki/Binary_search_algorithm#Procedure_for_finding_the_leftmost_element
    public int leftMostColumnWithOne(BinaryMatrix bmat)
    {
        List<Integer> dim = bmat.dimensions();
        int n = dim.get(0);
        int m = dim.get(1);
        
        ArrayList<Integer> hits = new ArrayList<>();
        for (int i = 0; i < n; i++)
            hits.add(i);
        
        int left = 0, right = m, mid = -1, count = 0;
        while (left < right)
        {
            mid = left + (right - left) / 2;
            
            ArrayList<Integer> nextHits = findHits(bmat, mid, hits);
            count = nextHits.size();
            
            if (count == 1)
                return leftmost(bmat, nextHits.get(0));
            
            if (count == 0)
                left = mid + 1;
            else if (count == 1)
                return leftmost(bmat, mid);
            else
            {
                right = mid;
                hits = nextHits;
            }
        }

        return (left == m ) ? -1 : left;
    }
    
    private int leftmost(BinaryMatrix bmat, int index)
    {
        if (bmat.get(index, 0) == 1) return 0;
            
        int left = 0, right = bmat.dimensions().get(1);
        while (left < right)
        {
            int mid = left + (right - left) / 2;
            
            if (bmat.get(index, mid) == 0)
                left = mid + 1;                
            else
                right = mid;
        }
        
        return left;
    }    

    private ArrayList<Integer> findHits(BinaryMatrix bmat, int pivot, ArrayList<Integer> hits)
    {
        ArrayList<Integer> answer = new ArrayList<>();
        for (Integer hit : hits)
        {
            if (bmat.get(hit, pivot) == 1)
                answer.add(hit);
        }
        
        return answer;
    }
}

public class LeftmostBinary
{
    public static void main(String[] args)
    {
        BinaryMatrix mat = new Bmt();
        System.out.println(new Solution().leftMostColumnWithOne(mat));
        
//        System.out.println(" *** hits at " + pivot);
//        System.out.println(hits);
        
    }
    
    static class Bmt implements BinaryMatrix
    {
        private int mat[][] = {{0, 0}, {0, 0}};
//        private int mat[][] = {{0, 0, 0, 0, 1, 1}, {0, 0, 0, 1, 1, 1}, {0, 0, 0, 0, 1, 1},
//            {0, 0, 0, 0, 1, 1}, {0, 0, 0, 1, 1, 1}, {0, 0, 0, 1, 1, 1}};
//        private int mat[][] = 
//        {{0,0,0,0,1,1,1,1,1},{0,0,0,0,0,1,1,1,1},{0,0,0,0,1,1,1,1,1},
//        {0,0,0,0,0,0,1,1,1},{0,0,0,0,0,0,0,1,1},{0,0,0,1,1,1,1,1,1},
//        {0,0,0,0,1,1,1,1,1},{0,0,0,0,1,1,1,1,1},{0,0,0,0,0,0,0,0,1}};
        
        @Override
        public int get(int row, int col)
        {
            return mat[row][col];
        }

        @Override
        public List<Integer> dimensions()
        {
            List<Integer> ans = new ArrayList<>();
            ans.add(mat.length);
            ans.add(mat[0].length);
            return ans;
        }

    }
    
}
