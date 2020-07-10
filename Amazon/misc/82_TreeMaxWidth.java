package maxwidth;
import java.util.*;

class Solution
{
    public int widthOfBinaryTree(TreeNode root)
    {
        if (root == null) return 0;
        
        Queue<Elem> queue = new LinkedList<>();
        queue.offer(new Elem(root, 1)); 
        
        int max = Integer.MIN_VALUE;
        int first = 0, last = 0;

        // flatten and cound in 2s
        while (!queue.isEmpty())
        {
            first = queue.peek().position;
            int qlen = queue.size();
            
            for (int i = 0; i < qlen; i++)
            {
                Elem el = queue.poll();
                last = el.position;
                
                if (el.node.left != null)
                    queue.add(new Elem(el.node.left, last*2));
                
                if (el.node.right != null)
                    queue.add(new Elem(el.node.right, last*2 + 1));
            }
            
            max = Math.max(max, last - first + 1);
            
        }
        
        return max;
    }

    private static class Elem
    {
        TreeNode node;
        int position;

        public Elem(TreeNode node, int position)
        {
            this.node = node;
            this.position = position;
        }

        @Override
        public String toString()
        {
            return "[" + node.val + ", " + position + "]";
        }
    }
}

public class MaxWidth
{
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(1);
        root.addRight(3);
        root.addLeft(2);
        
        root.left.addLeft(4);
        root.left.addRight(5);
        
        Solution sl = new Solution();
        System.out.println(sl.widthOfBinaryTree(root));
    }
}
