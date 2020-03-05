// https://leetcode.com/problems/linked-list-in-binary-tree/
// compare to https://leetcode.com/problems/linked-list-in-binary-tree/discuss/528687/Java-Brute-Force-(Runtime-better-than-99.66-Memory-better-than-100)
// compare to https://leetcode.com/problems/linked-list-in-binary-tree/discuss/528691/Java-beats-99.96-with-explanation

package listvstree;

class Solution
{
    public static boolean isSubPath(ListNode head, TreeNode root)
    {
        return helper(head, head, root);
    }

    private static boolean helper(ListNode head, ListNode current, TreeNode root)
    {
        if (current == null) return true;
        if (root == null) return false;
        
        if (current.val == root.val)
        {
            if (helper(head, current.next, root.left)) return true;

            if (helper(head, current.next, root.right)) return true;
        }

        if (helper(head, head, root.left)) return true;

        if (helper(head, head, root.right)) return true;

        return false;
    }
}


public class ListvsTree
{

    public static void main(String[] args)
    {
        // head = [4,2,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
        
        ListNode head = new ListNode(4);
        head.add(2);
        head.next.add(8);
        
        TreeNode root = new TreeNode(1);
        root.addLeft(4);
        root.left.addRight(2);
        root.left.right.addLeft(1);
        
        root.addRight(4);
        
        root.right.addLeft(2);
        root.right.left.addRight(8);
        root.right.left.addLeft(6);
        root.right.left.right.addLeft(1);
        root.right.left.right.addLeft(3);
        
        System.out.println(root);
        System.out.println(head);
        
        System.out.println(Solution.isSubPath(head, root));
        
    }
    
}
