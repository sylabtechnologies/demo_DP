package pathsum3;

class Solution
{
    private int target = 0; // count single nodes
    
    public int pathSum(TreeNode root, int sum)
    {
        target = sum;
        return subTreePaths(root);
    }

    // dfs all
    private int subTreePaths(TreeNode current)
    {
        if (current == null) return 0;

        return dfsPaths(current, current.val)
            + subTreePaths(current.left) + subTreePaths(current.right);
    }

    // add patj
    private int dfsPaths(TreeNode current, int sum)
    {
        int res = 0;
        
        if (sum == target) res++;

        if (current.left != null)
            res += dfsPaths(current.left, sum  + current.left.val);
        
        if (current.right != null)
            res += dfsPaths(current.right, sum  + current.right.val);
        
        return res;
    }
}

public class PathSum3
{
    public static void main(String[] args)
    {
        TreeNode rt = new TreeNode(1);
        rt.addLeft(-2); rt.addRight(-3);
        rt.right.addLeft(-2);
        
        rt.left.addLeft(1);
        rt.left.addRight(3);
        
        rt.left.left.addLeft(-1);
        
        System.out.println(new Solution().pathSum(rt, -1));
    }
}

