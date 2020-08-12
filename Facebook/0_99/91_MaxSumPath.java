// https://www.interviewbit.com/problems/max-sum-path-in-binary-tree/
package maxsumpath;

class Solution
{
    private int globMax = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root)
    {
        myUtil(root);
        return globMax;
    }

    private int myUtil(TreeNode node)
    {
        if (node == null) return 0;
        
        int goLeft = myUtil(node.left);
        int goRght = myUtil(node.right);
        int solo   = Math.max(Math.max(goLeft, goRght) + node.val, node.val);
        int combo  = Math.max(solo, goLeft + goRght + node.val );
        globMax  =  Math.max(globMax, combo);
        return solo;
    }
}

public class MaxSumPath
{
    public static void main(String[] args)
    {
        TreeNode rt = new TreeNode(10);
        rt.addLeft(5); rt.addRight(-3); rt.right.addRight(11);
        
        rt.left.addLeft(3);
        rt.left.addRight(2); rt.left.right.addRight(1);
        rt.left.left.addLeft(3);
        rt.left.left.addRight(-2);

        System.out.println(new Solution().maxPathSum(rt));
    }   
}

