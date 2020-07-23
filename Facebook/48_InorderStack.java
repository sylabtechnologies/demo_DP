package inorder;
import java.util.*;

class Solution
{
    public List<Integer> inorderTraversal(TreeNode root)
    {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        
        Stack<TreeNode> stk = new Stack<>();
        TreeNode curr = root;
        stk.add(root);
        
        while (!stk.isEmpty())
        {
            if (curr.left != null)
            {
                stk.push(curr.left);
                curr = curr.left;
                continue;
            }
            
            TreeNode leaf = stk.pop();
            res.add(leaf.val);
            
            if (leaf.right != null)
            {
                stk.push(leaf.right);
                curr = leaf.right;
                continue;
            }
        }
        
        return res;
    }
}

public class Inorder
{
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(1);
        root.addRight(2);
        root.right.addLeft(3);
        
        System.out.println(new Solution().inorderTraversal(root));
    }
    
}
