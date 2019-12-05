package intersectlists;
import java.util.HashSet;

class Solution
{
    public ListNode getIntersectionNode(ListNode headA, ListNode headB)
    {
        if (headA == null || headB == null) return null;
        
        ListNode curr = headA;
        HashSet<ListNode> set = new HashSet<>();
        while (curr != null)
        {
            set.add(curr);
            curr = curr.next;
        }

        curr = headB;
        while (curr != null)
        {
            if (set.contains(curr)) break;
            curr = curr.next;
        }
        
        return curr;
    }    
}
