package duptree;
import java.util.*;

// https://leetcode.com/problems/add-two-numbers-ii/

class Solution
{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        l1 = flip(l1);
        l2 = flip(l2);
        
        if (l1 == null & l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        int carry = 0;
        int curr = 0;
        ListNode retHelper = new ListNode(0);
        
        while (l1 != null || l2 != null)
        {
            curr = carry;
            if (l1 != null) curr += l1.val;
            if (l2 != null) curr += l2.val;
            
            if (curr > 9)
            {
                carry = 1;
                curr -= 10;
            }
            else
                carry = 0;

            insert(retHelper, curr);
            
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (carry > 0)
            insert(retHelper, carry);

        return retHelper.next;
    }

    private void insert(ListNode b4node, int val)
    {
        ListNode next = new ListNode(val);
        ListNode temp = b4node.next;
        b4node.next = next;
        next.next = temp;
    }
    
    private ListNode flip(ListNode node)
    {
        ListNode dummy = new ListNode(0);
        
        ListNode curr = node;
        while (curr != null)
        {
            insert(dummy, curr.val);
            curr = curr.next;
        }
        
        return dummy.next;
    }
}
