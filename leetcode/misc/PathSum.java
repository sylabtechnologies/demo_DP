/// /// /// TO THE PATH ALGO
/// https://leetcode.com/problems/path-sum/

package pathsum;

class Solution
{
    public boolean hasPathSum(TreeNode root, int sum)
    {
        if (root == null) return false; // move to Assistant
        
        if (root.left == null && root.right == null)
            return root.val == sum;
        
        sum = sum - root.val;
        boolean ans = false;

        if (root.left != null)
        {
            ans = hasPathSum(root.left, sum);
            if (ans) return ans;
        }
            
        if (root.right != null)
        {
            ans = hasPathSum(root.right, sum);
            if (ans) return ans;
        }
        
        return ans;
    }
}