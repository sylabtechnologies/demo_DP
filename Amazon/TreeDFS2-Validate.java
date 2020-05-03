package validateroot2leaf;

class Solution
{
    public boolean isValidSequence(TreeNode root, int[] arr)
    {
        return preorder(root, arr, 0);
    }

    // dfs p/o
    private boolean preorder(TreeNode root, int[] arr, int index)
    {
        if (root == null || index >= arr.length) return false;
        
        if (root.val != arr[index]) return false;
        
        if (index == arr.length - 1 && root.left == null && root.right == null)
            return true;
        
        boolean ans = false;
        ans = preorder(root.left, arr, index + 1);
        
        if (ans) return true;
        return preorder(root.right, arr, index + 1);
    }
}

public class ValidateRoot2Leaf
{
    public static void main(String[] args)
    {
        TreeNode rt = new TreeNode(0);
        rt.addLeft(1); rt.addRight(0);
        
        rt.left.addLeft(0);
        rt.left.left.addRight(1);
        
        int arr[] = {0, 1, 0, 1};
        System.out.println(new Solution().isValidSequence(rt, arr));
    }
    
}
