// https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/

package root2leaf;
import java.util.*;

class Solution
{
    public int sumRootToLeaf(TreeNode root)
    {
        ArrayList<ArrayList<Integer>> nums = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        int sum = 0;
        
        traverse(root, temp, nums);
        for (ArrayList<Integer> num : nums)
        {
            StringBuilder curr = new StringBuilder();
            for (Integer i : num)
                curr.append(Integer.toString(i));
            
            sum += Integer.parseInt(curr.toString(), 2);
        }
        
        return sum;
    }

    private void traverse(TreeNode root, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> nums)
    {
        if (root == null)
            return;

        temp.add(root.val);
        
        if (root.left == null && root.right == null)
        {
            nums.add(new ArrayList<>(temp));
            System.out.println(temp);
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
        
        System.out.println(new Solution().sumRootToLeaf(rt));
    }
}
