// https://leetcode.com/problems/merge-two-sorted-lists/

package mergelists;

/** solve as copy in sync and separate-append
 *  R/D WORKS & LOGIC OK!
 */

class Solution
{
    private static ListNode appendList(ListNode appendTo, ListNode appendFrom)
    {
        if (appendTo == null) return null;

        ListNode curr = appendTo;
        while (curr.next != null)
            curr = curr.next;

        while (appendFrom != null)
        {
            curr.next = new ListNode(appendFrom.val);
            curr = curr.next;
            appendFrom = appendFrom.next;
        }
        
        return appendTo;
    }
    
    // sort, short-circuit AND
    public ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {    
        if (l1 == null && l2 == null) return null;
        
        ListNode ans = new ListNode(0);
        
        ListNode tail = ans;

        while (l1 != null && l2 != null)
        {
            if (l1.val <= l2.val)
            {
                tail.next = new ListNode(l1.val);
                tail = tail.next;
                l1 = l1.next;
            }
            else
            {
                tail.next = new ListNode(l2.val);
                tail = tail.next;
                l2 = l2.next;
            }
        }

        if (l1 == null && l2 == null) return ans.next;
        
        if (l1 == null) 
        {
            ans = appendList(ans, l2);
            return ans.next;
        }
        else
        {
            ans = appendList(ans, l1);
            return ans.next;
        }
    }
    
    /*
    unsort
    public ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {    
        if (l1 == null && l2 == null) return null;
        
        ListNode ans = new ListNode(0);
        
        ListNode tail = ans;

        while (l1 != null && l2 != null)
        {
            tail.next = new ListNode(l1.val);
            tail = tail.next;
            
            tail.next = new ListNode(l2.val);
            tail = tail.next;

            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1 == null && l2 == null) return ans.next;
        
        if (l1 == null) 
        {
            ans = appendList(ans, l2);
            return ans.next;
        }
        else
        {
            ans = appendList(ans, l1);
            return ans.next;
        }
    }
    
    */
    
}
