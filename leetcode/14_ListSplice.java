package listsplice;

class ListNode
{
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

// barbell it & get very efficient
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

        ListNode list3 = new ListNode(0);
        
        ListNode splice = mergeTwoLists(null, list3);
        
        printList(splice);
        
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {
        if (l1 == null && l2 == null) return null;
        
        ListNode worker = new ListNode(0), ans = worker;
        while (l1 != null || l2 != null)
        {
            if (l1 != null)
            {
                worker.next = new ListNode(l1.val);
                worker = worker.next;
                l1 = l1.next;
            }

            if (l2 != null)
            {
                worker.next = new ListNode(l2.val);
                worker = worker.next;
                l2 = l2.next;
            }
        }
        
        return ans.next;
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
