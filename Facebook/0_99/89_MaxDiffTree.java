// https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/

package maxdifftree;
import java.util.HashMap;
import java.util.Map;

class Solution
{
    private HashMap<TreeNode, Integer> maxMap = new HashMap<>();
    private HashMap<TreeNode, Integer> minMap = new HashMap<>();
    
    public int maxAncestorDiff(TreeNode root)
    {
        if (root == null) return -1;
        
        postrder(root);

//        for (Map.Entry<TreeNode, Integer> elem : maxMap.entrySet())
//        {
//            TreeNode node = elem.getKey();
//            System.out.println(node.val + " [" + minMap.get(node) + ", " + maxMap.get(node) + "]");
//        }
        
        int max = 0;
        for (Map.Entry<TreeNode, Integer> elem : maxMap.entrySet())
        {
            TreeNode node = elem.getKey();
            
            if (node.left != null)
            {
                max = Math.max(max, Math.abs(node.val - maxMap.get(node.left)));
                max = Math.max(max, Math.abs(node.val - minMap.get(node.left)));
            }

            if (node.right != null)
            {
                max = Math.max(max, Math.abs(node.val - maxMap.get(node.right)));
                max = Math.max(max, Math.abs(node.val - minMap.get(node.right)));
            }
        }

        return max;
    }
    
    private void postrder(TreeNode root)
    {
        if (root == null) return;
        
        postrder(root.left);
        postrder(root.right);

        int min = root.val;
        int max = root.val;

        if (root.left != null)
        {
            min = Math.min(min, minMap.get(root.left));
            max = Math.max(max, maxMap.get(root.left));
        }

        if (root.right != null)
        {
            min = Math.min(min, minMap.get(root.right));
            max = Math.max(max, maxMap.get(root.right));
        }
        
        minMap.put(root, min);
        maxMap.put(root, max);
    }
}


public class MaxDiffTree
{
    public static void main(String[] args)
    {
        TreeNode rt = new TreeNode(1);
        rt.addRight(2);
        rt.right.addRight(0);
        rt.right.right.addLeft(3);
        System.out.println(new Solution().maxAncestorDiff(rt));
    }
}
