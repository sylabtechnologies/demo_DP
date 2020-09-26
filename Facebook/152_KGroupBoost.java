// https://leetcode.com/problems/reverse-nodes-in-k-group/
package duptree;
import java.util.*;

class Solution
{
    public ListNode reverseKGroup(ListNode head, int k)
    {
        if (head == null) return null;
        if (k <= 1) return head;
        
        // depth?
        ListNode cr = head;
        int cnt = 0;
        while (cnt < k && cr != null)
        {
            cr = cr.next;
            cnt++;
        }
        
        if (cnt < k) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tail = head;
        
        ListNode curr = head.next;
        head.next = null;
        cnt--;
        
        while (curr != null && cnt > 0)
        {
            ListNode temp = dummy.next;
            dummy.next = curr;
            
            curr = curr.next;
            dummy.next.next = temp;

            cnt--;
        }
        
        tail.next = reverseKGroup(curr, k);
        return dummy.next;
    }
}

