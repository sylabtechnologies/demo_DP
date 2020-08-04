// https://leetcode.com/problems/unique-binary-search-trees/

package uniqbst;
import java.util.*;

class Solution
{
    public ArrayList<TreeNode> generateTrees(int n)
    {
        ArrayList<Integer> nodes  =  new ArrayList<>();
        for (int i = 1; i <= n; i++)
            nodes.add(i);
        
        ArrayList<TreeNode> result = helper(nodes);
        return result;
    }

    private ArrayList<TreeNode> helper(ArrayList<Integer> nodes)
    {
        ArrayList<TreeNode> result = new ArrayList<>();
        for (int i = 0; i < nodes.size(); i++)
        {
            ArrayList<Integer> left = new ArrayList<>();
            for (int j = 0; j < i; j++)
                left.add(nodes.get(j));

            ArrayList<Integer> rght = new ArrayList<>();
            for (int j = i + 1; j < nodes.size(); j++)
                rght.add(nodes.get(j));

            if (left.isEmpty() && rght.isEmpty())
            {
                TreeNode root = new TreeNode(nodes.get(i));
                result.add(root);
                continue;
            }
            
            if (left.isEmpty())
            {
                ArrayList<TreeNode> rnodes = helper(rght);
                for (TreeNode rnode : rnodes)
                {
                    TreeNode root = new TreeNode(nodes.get(i));
                    root.right = rnode;
                    result.add(root);
                    continue;
                }
            }

            if (rght.isEmpty())
            {
                ArrayList<TreeNode> lnodes = helper(left);
                for (TreeNode lnode : lnodes)
                {
                    TreeNode root = new TreeNode(nodes.get(i));
                    root.left = lnode;
                    result.add(root);
                    continue;
                }
            }
            
            ArrayList<TreeNode> rnodes = helper(rght);
            ArrayList<TreeNode> lnodes = helper(left);
            
            for (TreeNode rnode : rnodes)
            {
                for (TreeNode lnode : lnodes)
                {
                    TreeNode root = new TreeNode(nodes.get(i));
                    root.left = lnode;
                    root.right = rnode;
                    result.add(root);
                }
            }
        }
        
        return result;
    }

}

public class UniqBST
{
    public static void main(String[] args)
    {
        ArrayList<TreeNode> all = new Solution().generateTrees(3);
        for (TreeNode node : all)
            System.out.println(node);
    }
    
}
