package insertbst;

class Solution
{
    public TreeNode insertIntoBST(TreeNode root, int val)
    {
        if (val > root.val)
        {
            if (root.right == null)
                root.right = new TreeNode(val);
            else
                insertIntoBST(root.right, val); /// #D-AMA cellwise
        }
        else
        {
            if (root.left == null)
                root.left = new TreeNode(val);
            else
                insertIntoBST(root.left, val);
        }
        
        return root;
    }
}

public class InsertBST
{
    public static void main(String[] args)
    {
        TreeNode rt = new TreeNode(4);
        rt.addLeft(2);
        rt.addRight(7);
        
        rt.left.addLeft(1);
        rt.left.addRight(3);
        
        Solution sl = new Solution();
        sl.insertIntoBST(rt, 5);
        System.out.println(rt);
    }
}
