package remhalf;

class Solution
{
    // lrn
    public TreeNode solve(TreeNode node)
    {
        if (node == null) return null;
        
        node.left  = solve(node.left);
        node.right = solve(node.right);

        if (node.left == null && node.right == null) 
            return node; 
        
        if (node.left == null)
            return node.right; 
        
        if (node.right == null)
            return node.left; 
        
        return node;
    }
}

public class Remhalf
{
    public static void main(String[] args)
    {
        TreeNode rt = new TreeNode(1);
        
        rt.addLeft(2); rt.addRight(3);
        rt.left.addLeft(4);
                
        System.out.println(new Solution().solve(rt));
    }
    
}
