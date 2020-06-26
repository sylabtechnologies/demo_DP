// https://leetcode.com/problems/sum-root-to-leaf-numbers/
package roottoleaf;
import java.util.ArrayList;

class Solution
{
    public int sumNumbers(TreeNode root)
    {
        if (root == null) return 0;
        
        ArrayList<MyNumber> numbers = postorder(root);
        int sum = 0;
        for (MyNumber num : numbers)
            sum += num.number;
        return sum;
    }

    private ArrayList<MyNumber> postorder(TreeNode root)
    {
        if (root == null) return null;
        
        ArrayList<MyNumber> result = new ArrayList<>();

        ArrayList<MyNumber> left = postorder(root.left);
        if (left != null)
            combine(root.val, left, result);
        
        ArrayList<MyNumber> right = postorder(root.right);
        if (right != null)
            combine(root.val, right, result);
        
        if (result.isEmpty())
            result.add(new MyNumber(root.val, 1));
        
        return result;
    }

    private void combine(int prefix, ArrayList<MyNumber> src, ArrayList<MyNumber> dest)
    {
        for (int i = 0; i < src.size(); i++)
        {
            MyNumber num = src.get(i);
            int val = prefix * (int) Math.pow(10.0, num.depth);
            dest.add(new MyNumber(val + num.number, num.depth + 1));
        }
    }
    
    private static class MyNumber
    {
        int number, depth;

        public MyNumber(int number, int depth)
        {
            this.number = number;
            this.depth = depth;
        }

        @Override
        public String toString() { return "[" + number + ", " + depth + "]"; }
    }
}

public class RootToLeaf
{
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(1);
        root.addRight(1);
        root.right.addRight(6);
        root.addLeft(5);
        
        System.out.println(new Solution().sumNumbers(root)); 
    }    
}

/*
        TreeNode root = new TreeNode(4);
        root.addRight(0);
        root.addLeft(9);
        root.left.addLeft(5);
        root.left.addRight(1);
*/
