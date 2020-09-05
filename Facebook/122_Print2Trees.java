// https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
// bufferize to limits

package twotrees;
import java.util.*;

class Solution
{
    final static int BUFHALF = 5000;
    int buf[], size1, size2, curr;
    
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2)
    {
        buf = new int[BUFHALF*2];
        
        curr = 0; inorder(root1); size1 = curr;
        curr = BUFHALF; inorder(root2); size2 = curr;

        List<Integer> ans = new ArrayList<>();
        int i = 0, j = BUFHALF;
        while (i < size1 && j < size2)
        {
            if (buf[i] < buf[j])
                ans.add(buf[i++]);
            else
                ans.add(buf[j++]);
        }
        
        if (i == size1)
        {
            while(j < size2)
                ans.add(buf[j++]);
        }
        else
        {
            while(i < size1)
                ans.add(buf[i++]);
        }
        
        return ans;
    }

    private void inorder(TreeNode root)
    {
        if (root == null) return;
        
        inorder(root.left);
        buf[curr++] = root.val;
        inorder(root.right);
    }
}

public class TwoTrees
{
    public static void main(String[] args)
    {
        TreeNode rt1 = new TreeNode(2);
        rt1.addLeft(1); rt1.addRight(4);
        
        TreeNode rt2 = new TreeNode(1);
        rt2.addLeft(0); rt2.addRight(3);
        
        System.out.println(new Solution().getAllElements(rt1, rt2));
    }
}
