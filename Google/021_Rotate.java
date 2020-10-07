// https://leetcode.com/problems/rotate-list/
class Solution
{
    public ListNode rotateRight(ListNode head, int k)
    {
        if (head == null) return null;
        
        ListNode curr = head, last = curr;
        int cnt = 0;
        
        while (curr != null)
        {
            last = curr;
            curr = curr.next;
            cnt++;
        }
        
        if (k % cnt == 0) return head;
        
        curr = head;
        for (int i = 0; i < cnt - k % cnt - 1; i++)
            curr = curr.next;

        ListNode ret = curr.next;
        curr.next = null;
        
        last.next = head;
        return ret;
    }
}
