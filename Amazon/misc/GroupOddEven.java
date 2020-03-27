// https://leetcode.com/problems/odd-even-linked-list/

package groupoddeven;

/* #1D go2 Corman */

class Solution
{
    public static ListNode oddEvenList(ListNode head)
    {
        if (head == null) return null;
        
        ListNode odd = head.next;
        if (odd == null || odd.next == null) return head;
        
        ListNode currOdd = odd, currEven = head, tail = null;

        while (currOdd != null)
        {
            currEven.next = currOdd.next;
            currEven = currEven.next;
            
            if (currEven == null)
                break;
            else
                tail = currEven;

            currOdd.next = currEven.next;
            currOdd = currOdd.next;
        }
        
        if (tail != null)
            tail.next = odd;
        
        return head;
    }
}

public class GroupOddEven
{

    public static void main(String[] args)
    {
        ListNode root = new ListNode(1);
        root.add(new ListNode(2));
//        root.next.add(new ListNode(3));
//        root.next.next.add(new ListNode(4));
//        root.next.next.next.add(new ListNode(5));
        
        System.out.println(Solution.oddEvenList(root));
    }
    
}
