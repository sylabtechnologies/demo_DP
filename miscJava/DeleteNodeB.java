package testtest;

class ListNode
{
     public int data;
     public ListNode next;

     public ListNode(int nodeData)
     {
         this.data = nodeData;
         this.next = null;
     }

    @Override
    public String toString()
    {
        return Integer.toString(data);
    }
     
 }

class LinkedList
{
    public ListNode head;
    public ListNode tail;

    public LinkedList()
    {
        this.head = null;
        this.tail = null;
    }

    public void insertNode(int nodeData)
    {
        ListNode node = new ListNode(nodeData);

        if (this.head == null)
            this.head = node;
        else
            this.tail.next = node;

        this.tail = node;
    }

    @Override
    public String toString()
    {
        ListNode curr = this.head;
        StringBuilder sb = new StringBuilder();

        while (curr != null)
        {
            sb.append(curr.data);
            
            if (curr.next != null)
                sb.append(' ');
            
            curr = curr.next;
        }
        
        return sb.toString();
    }
    
    
}

public class Testtest
{

    public static void main(String[] args)
    {
        LinkedList lst = new LinkedList();
        lst.insertNode(2);
        lst.insertNode(4);
        lst.insertNode(3);
        lst.insertNode(10);
        lst.insertNode(9);
        
        ListNode ans = deleteNode(lst, 3);

        System.out.println(lst);
        if (ans != null)
            System.out.println(ans.toString());
        
    }

    private static ListNode deleteNode(LinkedList root, int test)
    {
        if (root == null) return null;
        
        ListNode prev = root.head, curr = prev;
        while (curr.data != test)
        {
            if (curr.next == null) return null;
            prev = curr;
            curr = curr.next;
        }
        
        if (prev == root.head)
            root.head = root.head.next;
        else
            prev.next = curr.next;
        
        curr.next = null;
        return curr;
    }
    
}
