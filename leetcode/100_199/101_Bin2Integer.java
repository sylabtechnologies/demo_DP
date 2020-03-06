/*
Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.

Return the decimal value of the number in the linked list.
*/

package bin2integer;

class ListNode
{
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution
{
    public static int getDecimalValue(ListNode node)
    {
        int one = 1;

        int res = 0;
        while (node != null)
        {
            res = res << 1;

            if (node.val == 1) res = res ^ one;
            
            node = node.next;
        }
        
        return res;
    }
}

public class Bin2Integer
{

    public static void main(String[] args)
    {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(0);
        
        System.out.println(Solution.getDecimalValue(head));
    }
    
}
