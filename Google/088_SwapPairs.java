package duptree;
import java.util.*;

class Solution
{
    public ListNode swapPairs(ListNode head)
    {
        if (head == null || head.next == null) return head;
        
        ListNode dmy = new ListNode(0), curr = dmy;
        
        boolean odd = true;
        ListNode save = null;
        while (head != null)
        {
            if (odd)
            {
                save = head;
                head = head.next;
                save.next = null;
            }
            else
            {
                curr.next = head;
                head = head.next;
                curr = curr.next;
                curr.next = save;
                save = null;
                curr = curr.next;
            }

            odd = !odd;
        }
        
        if (save != null) curr.next = save;

        return dmy.next;
    }
}

public class Dups
{
    public static void main(String[] args)
    {
        ListNode h = new ListNode(0);
        h.append(1);
        h.append(2);
        h.append(3);
        h.append(4);
        System.out.println(new Solution().swapPairs(h));
    }
}

