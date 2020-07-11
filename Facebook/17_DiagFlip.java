package rotate;
import java.util.*;

class Solution
{
    public void flip(ArrayList<ArrayList<Integer>> a)
    {
        int n = a.size();
        
        // elka
        for (int i = 0; i < n; i++)
        {
            // going down
            int start = i;
            int end = n - i;  
            for (int col = start + 1; col < end; col++)
            {
                swap(a, i, col, col, i);
            }
        }
    }

    private void swap(ArrayList<ArrayList<Integer>> a, int row1, int col1, int row2, int col2)
    {
        int temp = a.get(row1).get(col1);
        a.get(row1).set(col1, a.get(row2).get(col2));
        a.get(row2).set(col2, temp);
    }
}


public class Rotate
{
    public static void main(String[] args)
    {
        ArrayList<ArrayList<Integer>> test = new ArrayList<>();
        ArrayList<Integer> row1 = new ArrayList<>();
        row1.addAll(Arrays.asList(1, 2));
        test.add(row1);
        ArrayList<Integer> row2 = new ArrayList<>();
        row2.addAll(Arrays.asList(3, 4));
        test.add(row2);
        
        System.out.println(test);
        Solution s1 = new Solution();
        s1.flip(test);
        System.out.println(test);
    }
    
}
