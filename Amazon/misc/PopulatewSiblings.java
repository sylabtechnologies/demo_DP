/// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

package populatewsiblings;

/// #ama# #D = preorder DFS w/ keeping depth and offset
/// #DD -> model at once
/// fin = link subtrees w/ right dfs = left dfs

class Solution
{
    public Node connect(Node root)
    {
        if (root == null) return null;

        preorder(root);
        return root;
    }

    private Node preorder(Node root)
    {
        System.out.println(" Node " + root.val + ":");

        if (root.left != null)
        {
            preorder(root.left);
            root.left.next = preorder(root.right);
        }
        
        return root;        
    }
}

public class PopulatewSiblings
{

    public static void main(String[] args)
    {
        Node root = new Node(1);
        root.addLeft(2);
        root.addRight(3);
        
        root.left.addLeft(4);
        root.left.addRight(5);

        root.right.addLeft(6);
        root.right.addRight(7);
        
        Solution s = new Solution();
        s.connect(root);
        
        printConnections(root);
    }

    private static void printConnections(Node root)
    {
        if (root == null) return;
        
        System.out.print(" Node " + root.val + ":");
        
        if (root.next == null)
        {
            System.out.println(" not connected ");
        }
        else
        {
            System.out.println(" connected to " + root.next.val);
        }
        
        printConnections(root.left);
        printConnections(root.right);
    }
    
}
