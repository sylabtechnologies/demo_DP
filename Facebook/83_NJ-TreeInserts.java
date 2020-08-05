package nj3;
import java.util.*;

class Solution
{
    public int cntMatrix(TreeNode A, TreeNode B)
    {
        boolean allright = lessOrSameStructure(A, B);
        if (!allright) return -1;
        
        return inorder(B) - inorder(A);
    }

    private boolean lessOrSameStructure(TreeNode one, TreeNode two)
    {
        if (one != null && two == null) return false;
        
        if (one != null && two != null)
            return lessOrSameStructure(one.left, two.left) && lessOrSameStructure(one.right, two.right);
        
        return true;                
    }

    private int inorder(TreeNode root)
    {
        if (root == null) return 0;
        return inorder(root.left) + 1 + inorder(root.right);
    }
}

public class Nj3
{
    public static void main(String[] args)
    {
        TreeNode t1 = new TreeNode(10);
        t1.addLeft(9); t1.addRight(20);
        
        TreeNode t2 = new TreeNode(5);
        t2.addLeft(2); t2.addRight(7);
        t2.left.addLeft(1);
        
        System.out.println(new Solution().cntMatrix(t1, t2));
    }
}

/*
Given two binary trees T1 and T2, you have to find minimum number of insertions
to be done in T1 to make it structurally identical to T2. Return -1 if not possible.

Assume insertions are done in a normal fashion in the BSTs.
Assume while inserting, if the value of a node v is equal to value being inserted,
we insert it in left subtree of node v.
You can insert any positive or negative integer.
*/

