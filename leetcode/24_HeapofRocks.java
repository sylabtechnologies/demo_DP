/**
  We have a collection of rocks, each rock has a positive integer weight.
 Each turn, we choose the two heaviest rocks and smash them together. 
 Suppose the stones have weights x and y with x <= y.  The result of this smash is:

 If x == y, both stones are totally destroyed;
 If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
 At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)
 * = MAX HEAP!
 * https://massivealgorithms.blogspot.com/2014/06/convex-hull-set-1-jarviss-algorithm-or.html
 * 
 */
package heavyrox;
import java.util.*;

class Solution
{
    public int lastStoneWeight(int[] stones)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)-> b - a);
        for (int s : stones) pq.offer(s);
        
        for (int i = 0; i < stones.length - 1; ++i)
            pq.offer(pq.poll() - pq.poll());
        
        return pq.poll();                
    }
    
}
