// https://leetcode.com/problems/path-sum/ - BFS

package treeancestor;
import java.util.*;

public class Solution
{
    public static boolean hasPathSum(TreeNode root, int sum)
    {
        if (root == null) return false;
        if (root.val == sum) return true;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        Map<TreeNode, Integer> pathSum = new HashMap<>();
        pathSum.put(root, root.val);

        while (!queue.isEmpty())
        {
            TreeNode curr = queue.poll();

            if (curr.left != null)
            {
                int lval = pathSum.get(curr) + curr.left.val;
                if (lval == sum) return true;
                pathSum.put(curr.left, lval);
                queue.offer(curr.left);
            }

            if (curr.right != null) {
                int rval = pathSum.get(curr) + curr.right.val;
                if (rval == sum) return true;
                pathSum.put(curr.right, rval);
                queue.offer(curr.right);
            }
        }

        return false;
    }

}

