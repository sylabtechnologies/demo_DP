// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
// make mapped version

package uniqlist;
import java.util.*;

class Solution
{
    public static ListNode deleteDuplicates(ListNode head)
    {
        if (head == null) return null;
        
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

        ListNode curr = head;
        while (curr != null)
        {
            Integer val = map.get(curr.val);
            
            if (val == null)
                map.put(curr.val, 1);
            else
                map.put(curr.val, val + 1);
            
            curr = curr.next;
        }
        
        ListNode result = null;
        curr = null;
        
        for (Map.Entry<Integer, Integer> elem : map.entrySet())
        {
            if (elem.getValue() > 1) continue;
            
            ListNode node = new ListNode(elem.getKey());
            
            if (result == null)
            {
                result = node;
                curr = node;
            }
            else
            {
                curr.next = node;
                curr = node;
            }
        }
        
        return result;
    }
}


public class UniqList
{
    public static void main(String[] args)
    {
        // 1->2->3->3->4->4->5
        
        ListNode head = new ListNode(1);
        ListNode curr = head;
        ListNode next = new ListNode(2); curr.add(next); curr = next;
        
        next = new ListNode(3); curr.add(next); curr = next;
        next = new ListNode(3); curr.add(next); curr = next;
        
        next = new ListNode(4); curr.add(next); curr = next;
        next = new ListNode(4); curr.add(next); curr = next;
        
        next = new ListNode(5); curr.add(next); curr = next;
        
        System.out.println(Solution.deleteDuplicates(head));
        
    }
    
}
