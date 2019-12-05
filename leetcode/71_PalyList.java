// https://leetcode.com/problems/palindrome-linked-list/

package palylist;

class Solution
{
    public boolean isPalindrome(ListNode head)
    {
        if (head == null) return true;
        if (head.next == null) return true;
        
        // make 2 ptrs
        ListNode copy = new ListNode(head.val);
        ListNode slow = head;
        ListNode fast = head.next.next;
        boolean isEven = true;
        
        while (fast != null)
        {
            fast = fast.next;
            slow = slow.next;
            
            copy = addtoHead(copy, slow.val);
            
            if (fast == null)
            {
                isEven = false;
                break;
            }
            else
                fast = fast.next;
        }
        
        if (isEven) slow = slow.next;
        
        return compareLists(slow, copy);
    }

    private static ListNode addtoHead(ListNode head, int val)
    {
        ListNode ans = new ListNode(val);
        ans.next = head;
        return ans;
    }

    // cmp two non-null lists
    private static boolean compareLists(ListNode first, ListNode second)
    {
        while (first != null && second != null)
        {
            if (first.val != second.val) return false;
            
            first = first.next;
            second = second.next;
        }
        
        if (first != null || second != null)
            return false;
        else
            return true;
    }
    
}
