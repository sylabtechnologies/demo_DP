package duptree;
import java.util.*;

// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/ w/ preorder
// https://leetcode.com/problems/serialize-and-deserialize-bst/
class Codec
{
    // Encodes a tree to a single string.
    public String serialize(TreeNode root)
    {
        if (root == null) return "()";
        return preorderHelp(root).toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data)
    {
        if (data.equals("()")) return null;

        char fst = data.charAt(0);
        char lst = data.charAt(data.length() - 1);
        
        if (fst != '(' || lst != ')')
            throw new IllegalArgumentException();
        
        int comma = data.indexOf(',');
        if (comma < 1) throw new IllegalArgumentException();
        
        TreeNode root = new TreeNode(Integer.parseInt(data.substring(1, comma)));
        
        String left = findChild(data, comma + 1);
        if (left.equals("null"))
            root.left = null;
        else
            root.left = deserialize(left);
        
        String rght = findChild(data, comma + left.length() + 2);
        if (rght.equals("null"))
            root.right = null;
        else
            root.right= deserialize(rght);
        
        return root;
    }

    private StringBuilder preorderHelp(TreeNode root)
    {
        if (root == null) return new StringBuilder("null");
        
        StringBuilder ret = new StringBuilder();
        ret.append('(');
        ret.append(Integer.toString(root.val));
        ret.append(',');
        
        ret.append(preorderHelp(root.left));
        ret.append(',');

        ret.append(preorderHelp(root.right));
        ret.append(')');
        
        return ret;
    }

    private String findChild(String data, int start)
    {
        if (data.charAt(start) != '(') return "null";
        
        boolean found = false;
        int beg = start++;
        int count = 1;
        boolean end = false;
        for (; start < data.length(); start++)
        {
            if (data.charAt(start) == '(')
                count++;
            else if (data.charAt(start) == ')')
                count--;
            
            if (count == 0)
            {
                found = true;
                break;
            }
        }
        if (!found) throw new IllegalArgumentException();
        
        return data.substring(beg, start + 1);
    }
}

public class Dups
{
    public static void main(String[] args)
    {
        TreeNode rt = new TreeNode(7);
        rt.addRight(15);
        rt.right.addLeft(9);
        rt.right.addRight(20);
        rt.addLeft(3);

        Codec cdc = new Codec();
        String tst = cdc.serialize(rt);
        System.out.println(tst);
        System.out.println(cdc.deserialize(tst));
    }
}
        
