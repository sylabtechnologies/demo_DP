package zzpath;

class Solution
{
    private static int maxZZ;
    
    public int longestZigZag(TreeNode root)
    {
        maxZZ = 0;
        int[] res = traverse(root);
        
        return maxZZ;
    }

    // traverse in order
    private int[] traverse(TreeNode root)
    {
        int[] res = {0, 0};

        if (root.left != null)
        {
            int[] larr = traverse(root.left);
            res[0] = larr[1] + 1;
        }

        if (root.right != null)
        {
            int[] rarr = traverse(root.right);
            res[1] = rarr[0] + 1;
        }
        
        maxZZ = Math.max( maxZZ, res[0]);
        maxZZ = Math.max( maxZZ, res[1]);
                
        return res;
    }
    
}

public class ZZPath
{

    public static void main(String[] args)
    {
        Solution sol = new Solution();

        TreeNode root = new TreeNode(1);
        System.out.println(sol.longestZigZag(root));
        root.addRight(1);
        
        TreeNode curr = root.right;
        curr.addLeft(1);
        curr.addRight(1);

        curr = curr.right;
        curr.addLeft(1);
        curr.addRight(1);
        
        curr = curr.left;
        TreeNode test = curr;
        curr.addRight(1);
        
        curr = curr.right;
        curr.addRight(1);
        
        System.out.println(sol.longestZigZag(root));
    }
    
}

/*
if (root.right == null)
{
    larr = traverse(root.left);
    return new int[]{larr[0] + 1, larr[0]};
}

int[] rarr; 
if (root.left == null)
{
    rarr = traverse(root.right);
    return new int[]{rarr[0], rarr[0] + 1};
}
*/

