// https://leetcode.com/problems/merge-k-sorted-lists/
package duptree;
import java.util.*;

/// #cn = pq!
class Solution
{
    public ListNode mergeKLists(ListNode[] lists)
    {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>()
        {
            @Override
            public int compare(ListNode l1, ListNode l2)
            {
                return Integer.compare(l1.val, l2.val);                
            }
        });
        
        for (ListNode list : lists)
        {
            if (list != null)
                pq.add(list);
        }
        
        ListNode head = null, curr = null;
        while (!pq.isEmpty())
        {
            ListNode min = pq.poll();
            
            if (head == null)
            {
                head = min;
                curr = head;
            }
            else
            {
                curr.next = min;
                curr = curr.next;
            }
            
            min = min.next;
            if (min != null)
                pq.add(min);
        }
        
        return head;
    }
}

public class Dups
{
    public static void main(String[] args)
    {
        int arr[] = {1, 2, 3};

        TreeNode rt = new TreeNode(15);
        rt.addRight(18);
        rt.right.addLeft(17);
        rt.right.addRight(20);

        System.out.println(new Solution().mergeKLists(new ListNode[0]));
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

