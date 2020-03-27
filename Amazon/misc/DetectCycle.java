class Solution
{
    public ListNode detectCycle(ListNode head)
    {
        HashSet<ListNode> listSet = new HashSet<>();
        
        ListNode curr = head;
        while (curr != null)
        {
            if (listSet.contains(curr)) return curr;
            
            listSet.add(curr);
            curr = curr.next;
        }
        
        return null;
    }
}
