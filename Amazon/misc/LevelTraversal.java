// https://leetcode.com/problems/binary-tree-level-order-traversal/
// #D preorder plus pere river

package leveltraversal;
import java.util.*;

class Solution
{
    public List<List<Integer>> levelOrder(TreeNode root)
    {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        
        result.add(new ArrayList<>());
        preorder(root, 0, result);
        return result;
    }
    
    private void preorder(TreeNode root, int depth, List<List<Integer>> result)
    {
        if (result.size() < depth + 1)
            result.add(new ArrayList<>());

        List<Integer> row = result.get(depth);
        row.add(root.val);
        
        if (root.left != null) preorder(root.left, depth + 1, result);
        if (root.right != null) preorder(root.right, depth + 1, result);
    }        
    
}

public class LevelTraversal
{
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(3);
        root.addLeft(9);
        root.addRight(20);
        
        root.right.addLeft(15);
        root.right.addRight(7);

        Solution o = new Solution();
        System.out.println(o.levelOrder(root));
    }
    
}
