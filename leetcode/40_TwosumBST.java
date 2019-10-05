/* #H 1. inorder 2. go 3. optimize do not dry

Given two binary search trees, return True if and only if there is a node
in the first tree and a node in the second tree whose values sum
up to a given integer target

*/

package twosumbst;
import java.util.*;

// Definition for a binary tree node.
class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution
{
 
    private void inorder(TreeNode root, ArrayList<Integer> arr)
    {
        if (root.left != null) inorder(root.left, arr);
        arr.add(root.val);
        if (root.right != null) inorder(root.right, arr);
    }
     
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target)
    {
        // do inorder
        ArrayList<Integer> arr = new ArrayList<>();
        inorder(root1, arr);
        
        for (Integer i : arr)
        {
            if (find(root2, target - i)) return true;
        }

        return false;
    }
    
    public boolean find(TreeNode root, int target)
    {
        if (target > root.val)
        {
            if (root.right != null)
                return find(root.right, target);
        }
        else if (target < root.val)
        {
            if (root.left != null)
                return find(root.left, target);
        }
        else
            if (target == root.val) return true;
        
        return false;
    }

    
}

public class TwosumBST
{

    public static void main(String[] args)
    {
        // root1 = [2,1,4], root2 = [1,0,3], target = 5
        
        TreeNode r1 = new TreeNode(2);
        r1.left = new TreeNode(1);
        r1.right = new TreeNode(4);
        
        TreeNode r2 = new TreeNode(1);
        r2.left = new TreeNode(0);
        r2.right = new TreeNode(3);
        
        Solution sol = new Solution();
        System.out.println(sol.twoSumBSTs(r1, r2, 5));
    }
    
}
