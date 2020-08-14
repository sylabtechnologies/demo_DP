// https://www.interviewbit.com/problems/root-to-leaf-paths-with-sum/

package allpaths;
import java.util.*;

class Solution
{
    ArrayList<ArrayList<Integer>> paths;
    ArrayList<ArrayList<Integer>> sums;
    
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int target)
    {
        paths = new ArrayList<>();
        if (root == null) return paths;
        
        dfs(root, new ArrayList<Integer>(), 0, target);
        return paths;
    }

    // lrn
    private void dfs(TreeNode root, ArrayList<Integer> curr, int sum, int target)
    {
        if (root == null) return;

        curr.add(root.val);
        
//        System.out.println(curr);
        
        if (root.left != null)
            dfs(root.left, curr, sum + root.val, target);

        if (root.left == null && root.right == null && sum + root.val == target)
            paths.add(new ArrayList<>(curr));

        if (root.right != null)
            dfs(root.right, curr, sum + root.val, target);
            
        curr.remove(curr.size() - 1);
    }
}

public class TreeIter
{
    public static void main(String[] args)
    {
        TreeNode rt = new TreeNode(8);
        rt.addLeft(3); rt.addRight(10);
        
        rt.left.addLeft(13);
        rt.left.addRight(6);
        
        rt.right.addRight(14);
        rt.right.right.addLeft(13);
        
        rt.left.right.addLeft(4);
        rt.left.right.addRight(7);
        
        Solution sl = new Solution();
        
        ArrayList<ArrayList<Integer>> ans = sl.pathSum(rt, 24);
        for (ArrayList<Integer> row : ans)
            System.out.println(row);
    }
}
