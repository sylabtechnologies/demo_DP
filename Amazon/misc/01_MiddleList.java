// https://leetcode.com/problems/middle-of-the-linked-list/
// null = node => [1, 2] = [2] 

package middlelist;

class Solution
{
    public ListNode middleNode(ListNode head)
    {
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode start = head, start2 = head.next.next;
        
        while (start2 != null)
        {
            start = start.next;
            
            if (start2.next != null)
                start2 = start2.next.next;
            else
                break;
        }
        
        // we got odd null
        if (start2 == null) start = start.next;
        return start;
    }
}

public class MiddleList
{
    public static void main(String[] args)
    {
        ListNode root = new ListNode(1);
        root.add(new ListNode(2));
        root.next.add(new ListNode(3));
        root.next.next.add(new ListNode(4));
        root.next.next.next.add(new ListNode(5));
        
        Solution s = new Solution();
        System.out.println(s.middleNode(root));
    }
}

class ListNode
{
    int val;
    ListNode next;
    ListNode(int x)
    {
        val = x;
    }
    
    void add(ListNode next)
    {
        this.next = next;
    }
    
    @Override
    public String toString()
    {
        ListNode curr = this;
        StringBuilder sb = new StringBuilder();

        while (curr != null)
        {
            sb.append(curr.val);
            sb.append(" ");
            curr = curr.next;
        }
        
        return sb.toString();
    }
    
}