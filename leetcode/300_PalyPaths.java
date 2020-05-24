// https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/

package palypaths;

class Solution
{
    private int digs[] = new int[10], totalCount = 0;
    
    public int pseudoPalindromicPaths (TreeNode root)
    {
        countUty(root);
        return totalCount;
    }

    private void countUty(TreeNode root)
    {
        if (root == null) return;
        
        if (root.left == null && root.right == null)
        {
            digs[root.val]++;
            
            if (oddCount()) totalCount++;
            
            digs[root.val]--;
            return;
        }
        
        digs[root.val]++;
        countUty(root.left);
        countUty(root.right);
        digs[root.val]--;
    }

    // at least one permutation of the node values in the path is a palindrome.
    private boolean oddCount()
    {
        int odd = 0;
        for (int cnt : digs)
        {
            if (cnt % 2 == 1) odd++;
        }
        
        return odd <= 1;
    }
}

public class PalyPaths
{
    public static void main(String[] args)
    {
        TreeNode rt = new TreeNode(2);
        rt.addLeft(3); rt.addRight(1);
        
        rt.left.addLeft(3);
        rt.left.addRight(1);
        
        rt.right.addRight(1);
        
        System.out.println(new Solution().pseudoPalindromicPaths(rt));
    }
    
}

