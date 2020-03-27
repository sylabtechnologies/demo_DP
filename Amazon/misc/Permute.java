package permute;
import java.util.*;

class Solution
{
    public List<List<Integer>> permute(LinkedList<Integer> first)
    {
        if (first == null) return null;
            
//        System.out.println(first);
 
        List<List<Integer>> res = new ArrayList<>();
        
        res.add(new LinkedList(first));

        int len = first.size();
        if (len == 1)
            return res;
        else if (len == 2)
        {
            Collections.swap(first, 0, 1);
            res.add(new ArrayList(first));
            Collections.swap(first, 1, 0);
            
            return res;
        }
        
        for (int i = 1; i < len; i++)
        {
            Collections.swap(first, 0, i);
            res.add(new ArrayList(first));
            Collections.swap(first, i, 0);
        }

//        System.out.println(res);
        
        int seed = res.size();
        for (int i = 0; i < seed; i++)
        {
            LinkedList<Integer> next = new LinkedList<>(res.get(i));
            Integer elem1 = next.remove(0);

            List<List<Integer>> addon = permute(next);
            
            for (int j = 1; j < addon.size(); j++)
            {
                List<Integer> lst = addon.get(j);
                lst.add(0, elem1);
                res.add(lst);
            }

//            System.out.println(res);
        }
        
        return res;
    }
    
    public List<List<Integer>> permute(int[] nums)
    {
        LinkedList<Integer> helper  = new LinkedList<>();

        for (int n : nums)
            helper.add(n);
        
        return permute(helper);
    }
}

public class Permute
{

    public static void main(String[] args)
    {
        int arr[] = {5,4,6,2};
//        int arr[] = {1,2,3};
        Solution obj = new Solution();
        
        List<List<Integer>> test = obj.permute(arr);
        System.out.println(test);
    }
    
}
