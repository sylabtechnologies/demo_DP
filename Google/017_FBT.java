import java.util.*;

// https://leetcode.com/problems/all-possible-full-binary-trees/
class Solution
{
    private HashMap<Integer, List<TreeNode>> memo = new HashMap<>();
    
    public List<TreeNode> allPossibleFBT(final int nn)
    {
        List<TreeNode> sav = memo.get(nn);
        if (sav != null) return sav;
        
        List<TreeNode> ret = new ArrayList<>();
        if (nn == 1)
        {
            ret.add(new TreeNode(0));
        }
        else
        {
            /// all odd values gen b/c we have
            //  1 or 3 or .. on both left and right
            for (int x = 1; x < nn; x += 2)
            {
                int y = nn - 1 - x;
                for (TreeNode left : allPossibleFBT(x))
                {
                    for (TreeNode right : allPossibleFBT(y))
                    {
                        TreeNode root = new TreeNode(0);
                        root.left = left;
                        root.right = right;
                        ret.add(root);
                    }
                }
            }
        }

        memo.put(nn, ret);
        return ret;
    }
}
