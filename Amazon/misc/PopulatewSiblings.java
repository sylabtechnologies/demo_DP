/// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
//#D link right view to left view in each subtree
// & #ama KEY postorder w/ r/l most view #ama7 = BluPtr

package populatewsiblings;

import java.util.LinkedList;

class Solution
{
    public Node connect(Node root)
    {
        if (root == null) return null;

        helper(root);
        return root;
    }

    private void helper(Node root)
    {
        // check only one
        if (root.left == null) return;
        
        helper(root.left);
        helper(root.right);
        linkLtoR(root.left, root.right);
    }

    private void linkLtoR(Node left, Node right)
    {
        while (left != null)
        {
            left.next = right;
            
            left = left.right;
            right = right.left;
        }
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

