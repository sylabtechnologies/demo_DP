package convert2bst;

/**
 * interface?
 * implementation?
 */

class ListNode
{
    int val;
    ListNode next;
    ListNode(int x)
    {
        val = x;
    }
    
    void append(int x)
    {
        ListNode current = this;
        
        while (current.next != null)
            current = current.next;

        current.next = new ListNode(x);
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

