package preorder2bst;
import java.util.*;

class Solution
{
    private int curr;
    
    public TreeNode bstFromPreorder(int[] preorder)
    {
        curr = 0;
        return buildUty(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode buildUty(int[] preorder, int min, int max)
    {
        if (curr >= preorder.length) return null;

        int next = preorder[curr];
        TreeNode node = null;
        
        if (next > min && next < max)
        {
            node = new TreeNode(next);
            curr++;
            node.left  =  buildUty(preorder, min, next);
            node.right =  buildUty(preorder, next, max);
        }
        
        return node;
    }

}

public class PalyPaths
{
    public static void main(String[] args)
    {
        int arr[] = {8, 5, 1, 7, 10, 12};
        System.out.println(new Solution().bstFromPreorder(arr));
    }
    
}

