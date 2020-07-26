// https://leetcode.com/problems/number-of-good-leaf-nodes-pairs/

package taskt;
import java.util.*;

class Solution
{
    private LinkedList<TreeNode> leafs = new LinkedList<>();
    private HashMap<TreeNode, ArrayList<TreeNode>> graph = new HashMap<>();
    private int goodNodeCount = 0;

    public int countPairs(TreeNode root, int distance)
    {
        inorder(root);
        inorder2(root);
        
        while (leafs.size() > 1)
        {
            TreeNode test = leafs.removeFirst();
            bfs(test, distance);
        }
        
        return goodNodeCount;
    }

    private void bfs(TreeNode root, int maxdist)
    {
        Queue<TreeNode> q = new LinkedList<>();

        HashSet<TreeNode> visited = new HashSet<>();
        HashMap<TreeNode, Integer> dist = new HashMap<>();
        q.add(root);
        dist.put(root, 0);
        
        while (!q.isEmpty())
        {
            TreeNode node = q.poll();
            if (visited.contains(node)) continue;
            visited.add(node);

            if (dist.get(node) > maxdist) continue;

            if (node != root && leafs.contains(node))
                goodNodeCount++;
            
            ArrayList<TreeNode> row = graph.get(node);
            if (row == null) continue;
                
            for (TreeNode next : row)
            {
                q.add(next);
                dist.put(next, dist.get(node) + 1);
            }
        }
    }
    
    private void inorder(TreeNode node)
    {
        if (node == null) return;
        
        inorder(node.left);
        
        if (node.left == null && node.right == null)
            leafs.add(node);
        
        inorder(node.right);
    }
    
    private void inorder2(TreeNode node)
    {
        if (node == null) return;
        
        inorder2(node.left);

        if (node.left != null)
            addEdge(node, node.left);
            
        if (node.right != null)
            addEdge(node, node.right);

        inorder2(node.right);
    }

    private void addEdge(TreeNode from, TreeNode to)
    {
        ArrayList<TreeNode> row1 = graph.getOrDefault(from, new ArrayList<>());
        row1.add(to);
        graph.put(from, row1);
        
        ArrayList<TreeNode> row2 = graph.getOrDefault(to, new ArrayList<>());
        row2.add(from);
        graph.put(to, row2);
    }
}

public class TaskT
{
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(1);
        root.addLeft(2); root.addRight(3);
        root.left.addRight(4);
        
        System.out.println(new Solution().countPairs(root, 3));
    }
    
}
