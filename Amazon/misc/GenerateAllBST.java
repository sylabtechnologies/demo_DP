// https://leetcode.com/problems/split-array-into-consecutive-subsequences/

package generatebst;

import java.util.*;

class Solution
{
    public List<TreeNode> generateTrees(int n)
    {
        if (n < 1) return new ArrayList<TreeNode>();
        
        ArrayList<TreeNode> nodes = new ArrayList<>();
        for (int i = 1; i <= n; i++)
            nodes.add(new TreeNode(i));
        
        return buildUty(nodes, 0, n-1);
    }
    
    private List<TreeNode> buildUty(ArrayList<TreeNode> nodes, int start, int end) 
    { 
        if (start > end) return null;
        
        List<TreeNode> result = new ArrayList<>();
        for (int i = start; i <= end; i++)
        {
            TreeNode curr = nodes.get(i);
            
            List<TreeNode> leftNodes = buildUty(nodes, start, i-1);
//            System.out.println(leftNodes);
            
            List<TreeNode> rightNodes = buildUty(nodes, i+1, end);
//            System.out.println(rightNodes);

            TreeNode root = new TreeNode(curr.val);

            if (leftNodes == null && rightNodes == null)
                result.add(root);
            else if (leftNodes == null && rightNodes != null)
            {
                for (TreeNode rr : rightNodes)
                {
                    root.right = rr;
                    result.add(treeCopy(root));
                }
            }
            else if (leftNodes != null && rightNodes == null)
            {
                for (TreeNode ll : leftNodes)
                {
                    root.left = ll;
                    result.add(treeCopy(root));
                }
            }
            else
            {
                for (TreeNode ll : leftNodes)
                {
                    for (TreeNode rr : rightNodes)
                    {
                        root.left = ll;
                        root.right = rr;
                        result.add(treeCopy(root));
                    }
                }
            }
            
        }

        return result; 
    } 

    private TreeNode treeCopy(TreeNode root)
    {
        if (root == null) return null;
        
        TreeNode res = new TreeNode(root.val);
        res.left = treeCopy(root.left);
        res.right = treeCopy(root.right);
        return res;        
    }
}

public class GenerateBST
{
    public static void main(String[] args)
    {
        List<TreeNode> lst = new Solution().generateTrees(3);
        
        for (TreeNode tn : lst)
            System.out.println(tn);
    }
}
