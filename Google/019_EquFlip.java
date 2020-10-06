// https://leetcode.com/problems/flip-equivalent-binary-trees/
class Solution
{
    public boolean flipEquiv(TreeNode rt1, TreeNode rt2)
    {
        if (rt1 == null && rt2 == null)
            return true;
        
        if ( (rt1 == null && rt2 != null) || (rt1 != null && rt2 == null))
            return false;

        if (rt1.val != rt2.val)
            return false;
        
        if (flipEquiv(rt1.left, rt2.left) && flipEquiv(rt1.right, rt2.right))
            return true;
        
        if (flipEquiv(rt1.left, rt2.right) && flipEquiv(rt1.right, rt2.left))
            return true;
     
        return false;
    }
}

