// https://leetcode.com/problems/add-two-numbers/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null & l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        ArrayList<ListNode> nodes = new ArrayList<>();
        int carry = 0;
        ListNode curr = null;
        
        while (l1 != null && l2 != null)
        {
            curr = new ListNode(l1.val + l2.val + carry);
            
            if (curr.val > 9)
            {
                carry = 1;
                curr.val -= 10;
            }
            else
                carry = 0;
            
            nodes.add(curr);
            l1 = l1.next;
            l2 = l2.next;
        }
        
        ListNode copy = null;
        if (l1 == null && l2 != null)
            copy = l2;
        else if (l1 != null && l2 == null)
            copy = l1;

        if (copy == null)
        {
            if (carry > 0)
            {
                nodes.add(new ListNode(carry));
                return linkup(nodes);
            }
        }
        
        while (copy != null)
        {
            ListNode nxt = new ListNode(copy.val);
            if (carry > 0)
            {
                nxt.val += carry;
                carry = 0;
            }
            
            if (nxt.val > 9)
            {
                carry = 1;
                nxt.val -= 10;
            }
            else
                carry = 0;
            
            nodes.add(new ListNode(nxt.val));
            copy = copy.next;
        }

        if (carry > 0)
            nodes.add(new ListNode(carry));

        return linkup(nodes);
    }
    
    private ListNode linkup(ArrayList<ListNode> nodes)
    {
        for (int i = 0; i < nodes.size() - 1; i++)
            nodes.get(i).next = nodes.get(i+1);

        return nodes.get(0);
    }
    
}

