/**
 * Given a binary tree, return the sum of values of its deepest leaves.
 * (move to hashmap and maxdepth)
 */

package deepestleaves;
import java.util.*;

class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution
{
    // return depth
    private void inorder(int depth, TreeNode root, TreeMap<Integer, List<Integer>> depthMap)
    {
        if (root.left != null) inorder(depth + 1, root.left, depthMap);

        List<Integer> obj = depthMap.get(depth);
        if (obj != null)
            obj.add(root.val);
        else
        {
            List<Integer> lst = new ArrayList<Integer>();
            lst.add(root.val);
            depthMap.put(depth, lst);
        }
        
        if (root.right != null) inorder(depth + 1, root.right, depthMap);
    }    
    
    public int deepestLeavesSum(TreeNode root)
    {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        inorder(0, root, map);
//        System.out.println(map);
        
        List<Integer> ans = map.get(map.lastKey());
        
        int sum = 0;
        for (Integer i : ans)
            sum += i;
        
        return sum;
    }
}

public class DeepestLeaves
{

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        
        root.left.right = new TreeNode(5);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(7);

        root.right.right = new TreeNode(6);
        root.right.right.right = new TreeNode(8);
        
        Solution obj = new Solution();
        System.out.println(obj.deepestLeavesSum(root));
    }
    
}
