// https://leetcode.com/problems/put-boxes-into-the-warehouse-ii/
package buddy;
import java.util.*;

class Solution
{
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse)
    {
        PriorityQueue<Integer> boxStack = new PriorityQueue<>();
        for (int box : boxes) boxStack.add(box);
        
        if (warehouse.length == 1)
            return  (warehouse[0] <= boxStack.peek()) ? 1 : 0;
        
        PriorityQueue<Integer> lf = new PriorityQueue<>();
        PriorityQueue<Integer> rg = new PriorityQueue<>();
        
        int i = 0, j = warehouse.length - 1;
        int llim = warehouse[i++], rlim = warehouse[j--];
        lf.add(llim); rg.add(rlim);

        while (i <= j)
        {
            int ll = Math.min(llim, warehouse[i]);
            int rr = Math.min(rlim, warehouse[j]);
            
            if (ll >= rr)
            {
                lf.add(ll);
                llim = ll;
                i++;
            }
            else
            {
                rg.add(rr);
                rlim = rr;
                j--;
            }
        }

        while (!boxStack.isEmpty())
        {
            if (lf.isEmpty() && rg.isEmpty()) break;
            
            int bx = boxStack.peek();
            int ll = lf.isEmpty() ? Integer.MAX_VALUE : lf.peek();
            int rr = rg.isEmpty() ? Integer.MAX_VALUE : rg.peek();
            
            if (ll <= rr)
            {
                int room = lf.poll();
                if (bx <= room) boxStack.poll();
            }
            else
            {
                int room = rg.poll();
                if (bx <= room) boxStack.poll();
            }
        }
        
        return boxes.length - boxStack.size();
    }
}

public class Buddy
{
    public static void main(String[] args)
    {
        int boxes[] = {1,2,2,3,4}, warehouse[] = {3,4,1,2};
        System.out.println(new Solution().maxBoxesInWarehouse(boxes, warehouse));
    }
}

