package googlst;
import java.util.*;

//  https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
/// #S - keep last count

class Solution 
{
    public ListNode deleteDuplicates(ListNode head) 
    {
        if (head == null) return null;
        
        ListNode cur = head;
        int lastVal = cur.val;
        int lastCnt = 1;
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        prev.next = cur;
        cur = cur.next;
        
        while (cur != null)
        {
            if (cur.val == lastVal) 
                lastCnt++;
            else
            {
                lastVal = cur.val;
                if (lastCnt > 1) 
                {
                    lastCnt = 1;
                    prev.next = cur;                    
                }
                else
                    prev = prev.next;
            }
            
            cur = cur.next;
        }
        
        if (lastCnt > 1) prev.next = null;
        return dummy.next;
    }
}

public class GoogLst
{
    public static void main(String[] args)
    {
        int arr[] = {1,2,3,3,4,4,5};
        ListNode hd = new ListNode(arr[0]);
        for (int i = 1; i < arr.length; i++) 
            hd.append(arr[i]);
        
        System.out.println(new Solution().deleteDuplicates(hd));
    }
}
