package testtest;

class ListNode
{
    int val;
    ListNode next;
    ListNode(int x)
    {
        val = x;
    }
    
    void add(ListNode nxt) { next = nxt;}
    
    @Override
    public String toString()
    {
        ListNode curr = this;
        StringBuilder sb = new StringBuilder();

        while (curr != null)
        {
            sb.append(curr.val);
            
            if (curr.next != null)
                sb.append(' ');
            
            curr = curr.next;
        }
        
        return sb.toString();
    }
}

public class Testtest {

    public static void main(String[] args)
    {
        ListNode r1 = new ListNode(2);
        
        ListNode v1 = new ListNode(4);
        ListNode v2 = new ListNode(3);
        ListNode v3 = new ListNode(10);
        ListNode v4 = new ListNode(9);
        
        v3.add(v4);
        v2.add(v3);
        v1.add(v2);
        r1.add(v1);
        
        ListNode ans = deleteNode(r1, 2);
        if (ans != null)
            System.out.println(ans.toString());
        
    }

    private static ListNode deleteNode(ListNode root, int test)
    {
        if (root == null) return null;
        
        ListNode prev = root, curr = root;
        while (curr.val != test)
        {
            if (curr.next == null) return null;
            prev = curr;
            curr = curr.next;
        }
        
        if (prev == root)
            root = curr.next;
        else
            prev.next = curr.next;
        
        System.out.println(root);
        
        curr.next = null;
        return curr;
    }
    
}
