// https://leetcode.com/problems/path-sum-ii/

package root2leaf;
import java.util.*;

class Solution
{
    public List<List<Integer>> pathSum(TreeNode root, int target)
    {
        List<List<Integer>> nums = new LinkedList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        
        traverse(root, temp, nums);

        // lnk lst to delete
        for (Iterator<List<Integer>> it = nums.iterator(); it.hasNext();)
        {
            List<Integer> next = it.next();

            int sum = 0;
            for (Integer ii : next)
                sum += ii;

            if (sum != target) it.remove();
        }
        
        return nums;
    }

    private void traverse(TreeNode root, ArrayList<Integer> temp, List<List<Integer>> nums)
    {
        if (root == null)
            return;

        temp.add(root.val);
        
        if (root.left == null && root.right == null)
        {
            nums.add(new ArrayList<>(temp));
//            System.out.println(temp);
        }
        else
        {
            traverse(root.left, temp, nums);
            traverse(root.right, temp, nums);
        }

        temp.remove(temp.size() - 1);
    }
}

public class Root2Leaf
{
    public static void main(String[] args)
    {
        TreeNode rt = new TreeNode(1);
        rt.addLeft(0); rt.addRight(1);
        
        rt.left.addLeft(0);
        rt.left.addRight(1);
        
        rt.right.addLeft(0);
        rt.right.addRight(1);
        
        // System.out.println(new Solution().sumRootToLeaf(rt));
    }
}
