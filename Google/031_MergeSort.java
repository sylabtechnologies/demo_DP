package duptree;
import java.util.*;

// https://leetcode.com/problems/sort-list/
/// #mergesort STS:
class Solution
{
    public ListNode sortList(ListNode head)
    {
        if (head == null) return null;

        int len = 0;
        ListNode cur = head;
        while (cur != null)
        {
            len++;
            cur = cur.next;
        }
        
        return mergeSort(head, len);
    }
    
    private ListNode mergeSort(ListNode head, final int len)
    {
        if (len == 1) return head;

        if (len == 2)
        {
            sort2(head, head.next);
            return head;
        }
        
        int mid = len/2;
        ListNode other = head, prev = null;
        for (int i = 0; i < mid; i++)
        {
            prev = other;
            other = other.next;
        }
        
        prev.next = null;
        other = mergeSort(other, len - mid);
        head = mergeSort(head, mid);
        
        ListNode dummy = new ListNode(0), cur = dummy;
        while (other != null || head != null)
        {
            if (head == null)
            {
                cur.next = other;
                other = other.next;
            }
            else if (other == null)
            {
                cur.next = head;
                head = head.next;
            }
            else if (head.val > other.val)
            {
                cur.next = other;
                other = other.next;
            }
            else
            {
                cur.next = head;
                head = head.next;
            }
            
            cur.next.next = null;
            cur = cur.next;
        }
        
        return dummy.next;
    }

    private void sort2(ListNode a, ListNode b)
    {
        if (a.val > b.val)
        {
            int temp = a.val;
            a.val = b.val;
            b.val = temp;
        }
    }
}
