// https://www.interviewbit.com/problems/populate-next-right-pointers-tree/

package populatenext;
import java.util.*;

class Solution
{
    // traverse l/o
    public void connect(TreeLinkNode root)
    {
        if (root == null) return;
        
        Queue<TreeLinkNode> q = new LinkedList<>();
        q.add(root); q.add(null);
        
        while (!q.isEmpty())
        {
            TreeLinkNode curr = q.poll();
            
            if (curr == null)
            {
                if (!q.isEmpty()) q.add(null); // mark e/o/level
            }
            else
            {
                curr.next = q.peek();
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
        }
    }
}

public class PopulateNext
{
    public static void main(String[] args)
    {
        TreeLinkNode rt = new TreeLinkNode(1);
        rt.addLeft(2); rt.addRight(3);
        rt.left.addLeft(4);
        rt.left.addRight(5);
        rt.right.addLeft(6);
        rt.right.addRight(7);
        
        Solution sl = new Solution();
        sl.connect(rt);
        System.out.println(rt);
    }
}

/*** easy 8 //*/