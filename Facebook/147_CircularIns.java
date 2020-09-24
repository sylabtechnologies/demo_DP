// https://leetcode.com/problems/insert-into-a-sorted-circular-linked-list/
package ttemps24;

class Solution
{
    public Node insert(Node head, int insert)
    {
        if (head == null)
        {
            head = simpleIns(head, insert);
            head.next = head;
            return head;
        }
        else if (head.next == head)
        {
            head.next = null;            
            head = simpleIns(head, insert);
            head.next.next = head;
            return head;
        }
        
        int min = head.val, max = head.val;
        Node curr = head.next;
        Node minNode = head;
        while (curr != head)
        {
            if (curr.val < min)
            {
                min = curr.val;
                minNode = curr;
            }
            
            max = Math.max(max, curr.val);
            curr = curr.next;
        }

        if (min == max)
            return helper(head, insert);
        else
            return helper(minNode, insert);
    }

    private Node helper(Node head, int insert)
    {
        Node curr = head.next;
        while (curr.next != head)
            curr = curr.next;

        curr.next = null;
        head = simpleIns(head, insert);
        curr = head;
        while (curr.next != null)
            curr = curr.next;
        curr.next = head;
        return head;
    }
    
    // r&d into regulars
    private Node simpleIns(Node head, int insert)
    {
        Node res = new Node(insert);

        if (head == null) return res;
        if (head.val > insert)
        {
            res.next = head;
            return res;
        }
        
        Node curr = head;
        Node prev = curr;
        while (curr != null && curr.val <= insert)
        {
            prev = curr;
            curr = curr.next;
        }
        
        prev.next = res;
        res.next = curr;
            
        return head;
    }
}

public class TtempS24
{
    public static void main(String[] args)
    {
        Node hd = new Node(3);
        hd.add(5);
        hd.add(1);
        hd.next.next.next = hd;
        System.out.println(new Solution().insert(hd, 0));
    }
}

