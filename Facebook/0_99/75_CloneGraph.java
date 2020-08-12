package clone;
import java.util.*;

class Solution
{
    HashMap<UndirectedGraphNode, UndirectedGraphNode> cloned = new HashMap<>();

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node)
    {
        cloned.clear();
        return dfs(node);
    }

    private UndirectedGraphNode dfs(UndirectedGraphNode node)
    {
        UndirectedGraphNode res = cloned.get(node);
        if (res != null) return res;

        res = new UndirectedGraphNode(node.label);
        cloned.put(node, res);
        
        for (UndirectedGraphNode ngb : node.neighbors)
            res.neighbors.add(dfs(ngb));
        
        return res;
    }
}


public class Clone
{
    public static void main(String[] args)
    {
        UndirectedGraphNode root = new UndirectedGraphNode(703);

        UndirectedGraphNode n1 = new UndirectedGraphNode(43);
        UndirectedGraphNode n2 = new UndirectedGraphNode(279);
        
        root.addNode(n1);
        root.addNode(n2);
        root.addNode(root);
        
        n1.addNode(n2);
        n1.addNode(root);
        
        n2.addNode(n1);
        n2.addNode(n2);
        n2.addNode(root);
        
        Solution sl = new Solution();
        UndirectedGraphNode clone = sl.cloneGraph(root);
        System.out.println(clone);
        
        for (UndirectedGraphNode n : clone.neighbors)
            System.out.println(n);
    }
}

/*

class UndirectedGraphNode
{
    int label;
    List<UndirectedGraphNode> neighbors;
    
    UndirectedGraphNode(int x)
    {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
    
    void addNode(UndirectedGraphNode node)
    {
        neighbors.add(node);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for (UndirectedGraphNode n : neighbors)
        {
            if (sb.length() == 0)
                sb.append("[");
            else
                sb.append(", ");
            sb.append(n.label);
        }
        
        if (sb.length() > 0) sb.append("]");
        sb.insert(0, new String(this.label + " "));
        return sb.toString();
    }
}

https://leetcode.com/problems/clone-graph/

class Solution
{
    HashMap<Node, Node> cloned = new HashMap<>();

    public Node cloneGraph(Node node)
    {
        if (node == null) return null;
        
        cloned.clear();
        return dfs(node);
    }

    private Node dfs(Node node)
    {
        Node res = cloned.get(node);
        if (res != null) return res;

        res = new Node(node.val);
        cloned.put(node, res);
        
        for (Node ngb : node.neighbors)
            res.neighbors.add(dfs(ngb));
        
        return res;
    }
}

*/