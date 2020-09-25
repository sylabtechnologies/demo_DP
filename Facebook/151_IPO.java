// 
package duptree;
import java.util.*;

class Solution
{
    /// #CN
    public int findMaximizedCapital(int limit, int myCap, int[] profits, int[] capital)
    {
        int cplen = profits.length;
        
        PriorityQueue<int[]> projects = new PriorityQueue<>((x, y) -> (x[0] - y[0]));
        for(int i = 0; i < cplen; i++)
            projects.add(new int[] {capital[i], profits[i]});
        
        PriorityQueue<Integer> doit = new PriorityQueue<>((x, y) -> (y - x));
        while (limit > 0)
        {
            while (!projects.isEmpty() && projects.peek()[0] < myCap)
                doit.add(projects.poll()[1]);
            
            if (doit.isEmpty()) break;
            
            myCap += doit.poll();
            limit--;
        }
        
        return myCap;
    }

//    private void help(int limit, int[] profits, int[] capital)
//    {
//        if (limit == 0) return;
//        
//        for (int i = 0; i < profits.length; i++)
//        {
//            if (visited[i]) continue;
//
//            if (capital[i] <= currCap)
//            {
//                visited[i] = true;
//                currCap += profits[i];
//
//                maxProfit = Math.max(maxProfit, currCap);
//                
//                help(limit-1, profits, capital);
//                
//                visited[i] = false;
//                currCap -= profits[i];
//            }
//        }
//    }
}

public class Dups
{
    public static void main(String[] args)
    {
        int prof[] = {1,2,3};
        int cap[] = {0,1,1};   // {1,1,2};
        System.out.println(new Solution().findMaximizedCapital(2, 0, prof, cap));
        
//        int arr[] = {1, 2, 3};
//        TreeNode rt = new TreeNode(15);
//        rt.addRight(18);
//        rt.right.addLeft(17);
//        rt.right.addRight(20);
    }
}

/*
    TreeNode rt = new TreeNode(7);
    rt.addLeft(4); rt.addRight(3);
    rt.right.addLeft(6);
    rt.right.addRight(19);

    int test[] = {6, 5, 3, 1, 8, 7}; //  {4,2,1,3};
    ListNode ls = new ListNode(test[0]);
    for (int i = 1; i < test.length; i++)
        ls.append(test[i]);            
    System.out.println(new Solution().insertionSortList(ls));  
*/

