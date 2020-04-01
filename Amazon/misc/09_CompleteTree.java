// https://leetcode.com/problems/check-completeness-of-a-binary-tree/

package completetree;
import java.util.*;
/// #D2 can count ##ama = breeze diverse string and avgset

class Solution
{
    // #D max nodes!
    private final static int OK = 0;
    private final static int NOBALANCE = -2;
    private final static int ALMOST    = -1;
    
    public boolean isCompleteTree(TreeNode root)
    {
        if (root == null) return true;

        return helper(root, 1).status != NOBALANCE;
    }
    
    private Status helper(TreeNode root, int level)
    {
        if (root.left == null && root.right == null)
            return new Status(level, OK);
        
        if (root.left == null && root.right != null)
            return new Status(-1, NOBALANCE);
        
        if (root.left != null && root.right == null)
        {
            Status left = helper(root.left, level + 1);
            
            if (left.height == level + 1 && left.status == OK)
                return new Status(level + 1, ALMOST);
            else
                return new Status(-1, NOBALANCE);
        }

        Status left = helper(root.left, level + 1);
        if (left.status != OK)
            return new Status(level + 1, NOBALANCE);

        Status right = helper(root.right, level + 1);
        if (right.status == NOBALANCE)
            return new Status(level + 1, NOBALANCE);
        
        if (left.height != right.height)
            return new Status(level + 1, NOBALANCE);
        
        return new Status(level + 1, right.status);
    }

    private static class Status
    {
        int height;
        int status;

        public Status(int height, int status)
        {
            this.height = height;
            this.status = status;
        }

        @Override
        public String toString()
        {
            return "h=" + height + ", " + status;
        }
    }
}

public class CompleteTree
{

    public static void main(String[] args)
    {
        TreeNode rt = new TreeNode(1);
        rt.addLeft(2); rt.addRight(3);
        rt.left.addLeft(4);
        rt.left.addRight(5);
        rt.right.addRight(6);
        
        Solution sl = new Solution();
        System.out.println(sl.isCompleteTree(rt));
        
    }
    
}
