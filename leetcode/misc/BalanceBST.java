package balancebst;
import java.util.*; 

public class Solution
{
    TreeNode balanceBST(TreeNode root) 
    { 
        ArrayList<TreeNode> nodes = new ArrayList<>(); 
        saveBST(root, nodes); 

        int n = nodes.size(); 
        return buildUty(nodes, 0, n - 1); 
    } 

    TreeNode buildUty(ArrayList<TreeNode> nodes, int start, int end) 
    { 
        if (start > end) return null; 

        int mid = (start + end) / 2; 
        TreeNode node = nodes.get(mid); 

        node.left = buildUty(nodes, start, mid - 1); 
        node.right = buildUty(nodes, mid + 1, end); 

        return node; 
    } 
    
    void saveBST(TreeNode root, ArrayList<TreeNode> nodes) 
    { 
        if (root == null) return; 
        // do inorder
        saveBST(root.left, nodes); 
        nodes.add(root); 
        saveBST(root.right, nodes); 
    } 
}
