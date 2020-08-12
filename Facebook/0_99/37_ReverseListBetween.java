package addnums;

 class Solution
 {
    public ListNode reverseBetween(ListNode lst, int from, int to)
    {
        ListNode res, top, lstTop = lst;
        
        if (from > 1)
        {
            res = new ListNode(lst.val);
            lst = lst.next;
            top = res;
            for (int i = 1; i < from- 1; i++)
            {
                res.next = new ListNode(lst.val);
                res = res.next;
                lst = lst.next;
            }

            res.next = flipRange(lst, from, to);
        }
        else
        {
            res = flipRange(lst, 1, to);
            if (to < 2) return res;
            top = res;
        }
        
        res = top;
        lst = lstTop;
        boolean go = true;
        while (go)
        {
            if (res.next == null)
            {
                while (lst.next != null)
                {
                    res.next = new ListNode(lst.next.val);
                    res = res.next;
                    lst = lst.next;
                }
                
                go = false;
                break;
            }
            
            if (go)
            {
                res = res.next;
                lst = lst.next;
            }
        }
        
        return top;
    }

    private static ListNode flipRange(ListNode lst, int from, int to)
    {
        ListNode top = null;
        boolean isFirst = true;
        for (int i = from; i <= to ; i++)
        {
            if (isFirst)
            {
                top = new ListNode(lst.val);
                isFirst = false;
            }
            else
                top = insertNode(top, lst.val);
            
            lst = lst.next;
        }
        
        return top;
    }
    
    private static ListNode insertNode(ListNode node, int carry)
    {
        ListNode ans = new ListNode(carry);
        ans.next = node;
        return ans;
    }

 }

public class AddNums
{

    public static void main(String[] args)
    {
        int arr[] = { 97, 63, 89, 34, 82, 95, 4, 70, 14, 41, 38, 83, 49, 32, 68, 56, 99, 52, 33, 54};
        ListNode lst = new ListNode(arr[0]), top = lst;
        for (int i = 1; i < arr.length; i++)
        {
            lst.next = new ListNode(arr[i]);
            lst = lst.next;
        }
        
//        System.out.println(top);
        
        System.out.println(new Solution().reverseBetween(top, 13, 15));
    }
}

class ListNode
{
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        
        ListNode curr = this;
        while (curr != null)
        {
            sb.append(curr.val);
            sb.append(" ");
            curr = curr.next;
        }
        
        return sb.toString();
    }
}