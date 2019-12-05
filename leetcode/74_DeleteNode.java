/*
https://leetcode.com/problems/delete-node-in-a-linked-list/
*/

package deletenode;

class Solution
{
    // shift
    public static void deleteNode(ListNode node)
    {
        ListNode start = node;
        
        while (start.next.next != null)
        {
            start.val = start.next.val;
            start = start.next;
        }
        
        start.val = start.next.val;
        start.next = null;
    }
}

public class DeleteNode
{
    public static void main(String[] args)
    {
        ListNode test   = new ListNode(4);
        test.next       = new ListNode(5);
        test.next.next  = new ListNode(1);
        test.next.next.next = new ListNode(9);
        
        System.out.println(test);
        Solution.deleteNode(test.next);
        System.out.println(test);
    }
    
}
