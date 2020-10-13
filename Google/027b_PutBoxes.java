// https://leetcode.com/problems/put-boxes-into-the-warehouse-i/
package buddy;
import java.util.*;

class Solution
{
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse)
    {
        PriorityQueue<Integer> boxStack = new PriorityQueue<>();
        for (int box : boxes) boxStack.add(box);

        PriorityQueue<Integer> rooms = new PriorityQueue<>();
        int lim = warehouse[0];
        rooms.add(lim);
        for (int i = 1; i < warehouse.length; i++)
        {
            int nxt = warehouse[i];
            if (nxt > lim)
                nxt = lim;
            else
                lim = nxt;
            
            rooms.add(nxt);
        }
        
        while (!boxStack.isEmpty() && !rooms.isEmpty())
        {
            int room = rooms.poll();
            int bx = boxStack.peek();
            
            if (room >= bx) boxStack.poll();
        }
        
        return boxes.length - boxStack.size();
    }
}

public class Buddy
{
    public static void main(String[] args)
    {
        int boxes[] = {4,3,4,1}, warehouse[] = {5, 3, 3, 4, 1};
        System.out.println(new Solution().maxBoxesInWarehouse(boxes, warehouse));
    }
}

