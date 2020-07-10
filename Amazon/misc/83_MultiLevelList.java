// https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/

package multilevel;

class Solution
{
    public Node flatten(Node head)
    {
        Node res[] = helper(head);
        return res[0];
    }

    public Node[] helper(Node head)
    {
        Node ans[] = {null, null};
        if (head == null) return ans;
        
        Node curr = head; ans[0] = head;
        while (curr != null)
        {
            if (curr.child != null)
            {
                Node nextChain = curr.next;
                
                Node lnk[] = helper(curr.child);
                curr.child = null;
                
                lnk[0].prev = curr;
                curr.next = lnk[0];
                
                lnk[1].next = nextChain;
                
                if (nextChain != null)
                    nextChain.prev = lnk[1];
            }
            
            ans[1] = curr;
            curr = curr.next;
        }
    
        return ans;
    }
}

public class MultiLevel
{
    public static void main(String[] args)
    {
        Node head = new Node(1);
        head.add(2);
        head.addChild(3);
        
        System.out.println(new Solution().flatten(head)); 
    }
}
