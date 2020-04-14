// https://leetcode.com/problems/last-stone-weight/

package stoneweight;
import java.util.*;

class Solution
{
    public int lastStoneWeight(int[] stones)
    {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> - o1.compareTo(o2));
        for (int stone : stones)
            queue.add(stone);
        
        while (!queue.isEmpty())
        {
            if (queue.size() == 1)
                return queue.poll();
            
            int y = queue.poll();
            int x = queue.poll();
            if (y == x) continue;
            
            queue.offer(y-x);
        }
        
        return 0;
    }
}

public class StoneWeight
{
    public static void main(String[] args)
    {
        int arr[] = {2,7,4,1,8,1};
        System.out.println(new Solution().lastStoneWeight(arr));
    }
    
}
