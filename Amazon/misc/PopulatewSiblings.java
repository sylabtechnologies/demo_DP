/// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

package populatewsiblings;

/// #ama# #D = preorder DFS w/ keeping depth and offset

class Node
{
    int val;
    Node left;
    Node right;
    Node next;
    Node(int x) { val = x; }
    void addLeft(int x) { left = new Node(x); }
    void addRight(int x) { right = new Node(x); }

    @Override
    public String toString() { return "[ " + val + ", " + left + ", " + right + " ]"; }
}

class Solution
{
    public Node connect(Node root)
    {
        if (root == null) return null;

        helper(root);
        return root;
    }

    private Node helper(Node root)
    {
        if (root.left == null) return null;
        
        System.out.println(" Node " + root.val + ":");
        
        // if one is checked the other is fine
        /// make a chain
        root.left.next = helper(root.right);
        helper(root.left);
        
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
        
       // printConnections(root);
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
