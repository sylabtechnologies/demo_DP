package dtraverse;
import java.util.*;

class Solution
{
    private ArrayList<ArrayList<Integer>> diags = new ArrayList<>();
    
    public int[] solve(TreeNode root)
    {
        int diag = 0;
        inorder(root, diag);
        
        int count = 0;
        for (ArrayList<Integer> dg : diags)
            count += dg.size();

        int ans[] = new int[count];
        int ix = 0;
        for (ArrayList<Integer> dg : diags)
            for (int n : dg)
                ans[ix++] = n;

        return ans;
    }

    private void inorder(TreeNode root, int diag)
    {
        if (root == null) return;
        
        inorder(root.left, diag + 1);
        
        while (diags.size() - 1 < diag)
            diags.add(new ArrayList<>());
        
        diags.get(diag).add(root.val);
        
        inorder(root.right, diag);
    }
    
}


public class Dtraverse
{
    public static void main(String[] args)
    {
        TreeNode rt = new TreeNode(1);
        rt.addLeft(4);
        
        rt.left.addLeft(8);
        rt.left.addRight(5);
        rt.left.right.addLeft(9);
        rt.left.right.addRight(7);
        
        rt.addRight(2);
        rt.right.addRight(3);
        rt.right.right.addLeft(6);
        
        System.out.println(Arrays.toString(new Solution().solve(rt)));
    }
    
}
