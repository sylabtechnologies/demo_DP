import java.util.*;

// https://leetcode.com/problems/delete-nodes-and-return-forest/
class Solution
{
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete)
    {
        if (root == null) return null;
        
        HashSet<Integer> toDelete = new HashSet<>();
        for (int nodeVal : to_delete)
            toDelete.add(nodeVal);
        
        List<TreeNode> ret = new ArrayList<>();
        if (!toDelete.contains(root.val)) ret.add(root);
        forester(root, toDelete, ret);
        return ret;
    }

    // lrn
    private void forester(TreeNode root, HashSet<Integer> deleted, List<TreeNode> ans)
    {
        if (root == null) return;

        forester(root.left, deleted, ans);
        if (root.left != null && deleted.contains(root.left.val))
            root.left = null;
        
        forester(root.right, deleted, ans);
        if (root.right != null && deleted.contains(root.right.val))
            root.right = null;

        if (deleted.contains(root.val))
        {
            if (root.left != null)
            {
                ans.add(root.left);
                root.left = null;
            }

            if (root.right != null)
            {
                ans.add(root.right);
                root.right = null;
            }
        }
    }
}
