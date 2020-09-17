// https://leetcode.com/problems/recover-a-tree-from-preorder-traversal/
package recover;
import java.util.*;

class Solution
{
    public TreeNode recoverFromPreorder(String str)
    {
        if (str == null || str.length() == 0) return null;

        ArrayList<Pair> tokens = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int prefLen = 0;

        for (char c : str.toCharArray())
        {
            if (Character.isDigit(c))
            {
                sb.append(c);
                continue;
            }
            
            if (sb.length() != 0)
            {
                tokens.add(new Pair(prefLen, Integer.parseInt(sb.toString())));
                sb.setLength(0);
                prefLen = 0;
            }
            
            prefLen++;
        }
        
        if (sb.length() != 0)
        {
            tokens.add(new Pair(prefLen, Integer.parseInt(sb.toString())));
            sb.setLength(0);
        }
        
        return helper(tokens, 0, 0, tokens.size());
    }

    private TreeNode helper(ArrayList<Pair> tokens, int level, int beg, int fin)
    {
        Pair start = tokens.get(beg);
        
        TreeNode root = new TreeNode(start.value);
        
        level++;
        int left = -1, right = -1;
        for (int i = beg + 1; i < fin; i++)
        {
            Pair curr = tokens.get(i);
            
            if (curr.prefixLen == level)
            {
                if (left < 0)
                    left = i;
                else if (right < 0)
                {
                    right = i;
                    break;
                }
            }
        }
        
        if (left < 0 && right < 0) return root;

        if (right < 0)
        {
            root.left = helper(tokens, level, left, fin);
            return root;
        }
        
        root.left = helper(tokens, level, left, right);
        root.right = helper(tokens, level, right, fin);
        return root;
    }

    private static class Pair
    {
        int prefixLen, value;
        public Pair(int p, int v) { prefixLen = p; value = v;}
        @Override
        public String toString() { return "(" + value + " @ " + prefixLen + ")";
        }
    }
}

public class Insort
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().recoverFromPreorder("1-401--349---90--88"));
    }
}
