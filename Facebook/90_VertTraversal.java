// https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
package vertorder;
import java.util.*;

class Solution
{
    private MultiMap<Integer, Point> vlevels;
    
    public List<List<Integer>> verticalTraversal(TreeNode root)
    {
        vlevels = new MultiMap<>();
        preorder(root, 0, 0);
        
        ArrayList<Integer> lines = vlevels.getKeys(true);
        List<List<Integer>> result = new ArrayList<>();
        for (int line : lines)
        {
            ArrayList<Point> ln = vlevels.getRow(line);
            if (ln.isEmpty()) continue;
            
            Collections.sort(ln);                    
            ArrayList<Integer> next = new ArrayList<>();
            for (Point p : ln)
                next.add(p.value);
            result.add(next);
        }
        
        return result;
    }

    private void preorder(TreeNode root, int d, int x)
    {
        if (root == null) return;
        
        vlevels.put(x, new Point(root.val, d));
        preorder(root.left, d+1, x-1);
        preorder(root.right, d+1, x+1);
    }

    private static class Point implements Comparable<Point>
    {
        int value, depth;
        public Point(int v, int d) { value = v; depth = d; }

        @Override
        public int compareTo(Point pt)
        {
            if (this.depth == pt.depth)
                return this.value - pt.value;
            else
                return this.depth - pt.depth;
        }
    }
}

public class VertOrder
{
    public static void main(String[] args)
    {
        TreeNode rt = new TreeNode(3);
        rt.addLeft(9); rt.addRight(20);
        rt.right.addLeft(15); rt.right.addRight(7);
        
        System.out.println(new Solution().verticalTraversal(rt));
    }

}
