package dellstdups;

class ListNode
{
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
    void add(ListNode n) { next  = n; }
}

public class DelLstDups
{
    public static ListNode deleteDuplicates(ListNode head)
    {
        if (head == null) return null;
       
        int curVal = head.val;
        ListNode curNode = head;
        
        while (curNode.next != null)
        {
            if (curVal == curNode.next.val)
                curNode.next = curNode.next.next;
            else
            {
                curNode = curNode.next;
                curVal = curNode.val;
            }
        }
   
        return head;
    }

    public static void main(String[] args)
    {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        
        n2.add(n3);
        n1.add(n2);
        
        deleteDuplicates(n1);
    }
    
}
