package listsplice;

class ListNode
{
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

// barbell
public class ListSplice
{
    public static void main(String[] args)
    {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);
        printList(list1);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);
        printList(list2);
        
        ListNode splice = mergeTwoLists(list1, list2);
        
        printList(splice);
        
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {
        if (l1 == null) return null;
        
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode worker = new ListNode(0), ans = worker;
        
        while (true)
        {
            // copy 2 and try to advance
            worker.val = cur1.val;
            worker.next = new ListNode(cur2.val);
            
            cur1 = cur1.next;
            cur2 = cur2.next;
            
            if (cur1 == null) break;
            worker = worker.next;
            worker.next = new ListNode(0);
            worker = worker.next;
        }
        
        return ans;        
    }

    private static void printList(ListNode root)
    {
        while (root != null)
        {
            System.out.println(root.val);
            root = root.next;
        }

        System.out.println("--");
    }
    
}
