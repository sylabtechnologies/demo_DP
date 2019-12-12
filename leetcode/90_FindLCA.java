// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
// #LCA

package treeancestor;
import java.util.*;

public class Solution
{
    // BFS parents (bfs p only?)
    static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
    {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        parent.put(root, null);
        
        // traverse the tree
        while (!parent.containsKey(p) || !parent.containsKey(q))
        {
            TreeNode curr = queue.poll();
            System.out.println("go " + curr.val);
            
            if (curr.left != null)
            {
                parent.put(curr.left, curr);
                queue.offer(curr.left);
                System.out.println("add " + curr.left.val);
            }

            if (curr.right != null)
            {
                parent.put(curr.right, curr);
                queue.offer(curr.right);
                System.out.println("add " + curr.right.val);
            }
        }
        
        // find ancestors of P
        Set<TreeNode> ancs = new HashSet<>();
        while (p != null)
        {
            ancs.add(p);
            System.out.println("ancestor " + p.val);
            
            p = parent.get(p);
        }
        
        // go up
        while (!ancs.contains(q))
            q = parent.get(q);
        
        return q;
    }
}

