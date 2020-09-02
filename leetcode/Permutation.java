package permut;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutation
{
    List<List<Integer>> all;
    private List<Integer> current;
    
    public Permutation(int[] nums)
    {
        if (nums == null) return;
        if (nums.length == 0) return;

        all = new ArrayList<>();
        current = new ArrayList<>();
        for (int n : nums) current.add(n);
        
        permutate(0);
    }

    private void permutate(int start)
    {
        if (start == current.size())
        {
            all.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = start; i < current.size(); i++)
        {
            Collections.swap(current, i, start);
            permutate(start + 1);
            Collections.swap(current, i, start);
        }
    }
    
}
