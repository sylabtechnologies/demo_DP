package klarge;
import java.util.*;

class Solution
{
    // O(k + (n-k)Logk)
    public ArrayList<Integer> solve(ArrayList<Integer> arr, int k)
    {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int i = 0; i < k; i++)
        {
            Integer x = arr.get(i);
            heap.add(x);
        }
        
        for (int i = k; i < arr.size(); i++)
        {
            Integer x = arr.get(i);
            
            if (x > heap.peek())
            {
                heap.add(x);
                heap.poll();
            }
        }
        
        ArrayList<Integer> res = new ArrayList<>(heap);
        Collections.reverse(res);
        return res;
    }
}

public class Klarge
{
    public static void main(String[] args)
    {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(11, 3, 4, 5, 6));
        System.out.println(new Solution().solve(arr, 3));
    }
}
