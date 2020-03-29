/* wc "class + class"
https://leetcode.com/problems/linked-list-in-binary-tree
#DDD special tree w/ parents and depth - COMPUTE HASH BACKWARDS, reverse list
https://www.kirupa.com/developer/actionscript/depth_breadth_search.htm
https://www.topcoder.com/community/competitive-programming/tutorials/introduction-to-graphs-and-their-data-structures-section-2/
https://www.topcoder.com/community/competitive-programming/tutorials/

#DDD best = BFS/visited on end nodes w/ sliding window
*/

package listinbtree;
import java.util.ArrayList;
import java.util.Collections;

public class Solution
{
    public boolean isSubPath(ListNode head, TreeNode root)
    {
        LinkedTreeNode lRoot = doClone(root);
        
        ArrayList<Integer> list = doClone(head);
        Collections.reverse(list);
        long listHash = MyHash.getHash(list);
        
        return preorder(lRoot, list, listHash);
    }
    
    private boolean preorder(LinkedTreeNode node, ArrayList<Integer> list, long lH)
    {
        if (node == null) return false;
        
        int len = list.size();
        if (node.depth >= len)
        {
            long hash = MyHash.getHash(node, len);

            if (hash == lH)
            {
                if (compare(node, list, len))
                    return true;
            }
        }
        
        if (preorder(node.left, list, lH))
            return true;
        else
            return preorder(node.right, list, lH);
    }
    
    private LinkedTreeNode doClone(TreeNode root)
    {
        if (root == null)
            throw new IllegalArgumentException("tree clone");
        
        LinkedTreeNode rt = new LinkedTreeNode(root.val);
        
        rt.depth = 1;
        rt.left = connect(root.left, rt, 2);
        rt.right = connect(root.right, rt, 2);
        
        return rt;
    }
    
    private LinkedTreeNode connect(TreeNode node, LinkedTreeNode parent, int depth)
    {
        if (node == null) return null;
        
        LinkedTreeNode ltNode = new LinkedTreeNode(node.val);
        ltNode.depth = depth;
        ltNode.parent = parent;
        ltNode.left = connect(node.left, ltNode, depth + 1);
        ltNode.right = connect(node.right, ltNode, depth + 1);
    
        return ltNode;
    }
    

    private ArrayList<Integer> doClone(ListNode head)
    {
        if (head == null)
            throw new IllegalArgumentException("list clone");
        
        ArrayList<Integer> res = new ArrayList<>();
        res.add(head.val);
        
        head = head.next;
        while (head != null)
        {
            res.add(head.val);
            head = head.next;            
        }
        
        return res;
    }
    
    private boolean compare(LinkedTreeNode end, ArrayList<Integer> list, int size)
    {
        int curr = 0;
        while (end != null && curr < size)
        {
            if (end.val != list.get(curr))
                return false;
            
            end = end.parent;
            curr++;
        }

        return true;
    }

}

// wc "class + class"
class LinkedTreeNode
{
    int val;
    LinkedTreeNode parent;
    LinkedTreeNode left;
    LinkedTreeNode right;
    int depth;
    
    LinkedTreeNode(int x) { val = x; }
    void addLeft(int x) { left = new LinkedTreeNode(x); }
    void addRight(int x) { right = new LinkedTreeNode(x); }

    @Override
    public String toString() { return "[ @" + depth + "> " + val + ", " + left + ", " + right + " ]"; }
}

class MyHash
{
    private long hash;

    public MyHash()
    {
        hash = 5;
    }
    
    public MyHash(int val)
    {
        this();
        hash += val;
    }
    
    public void inc(int val)
    {
        hash = hash*13 + val;
    }

    public long getHash() { return hash; }

    public static long getHash(LinkedTreeNode node, int len)
    {
        MyHash ans = new MyHash(node.val);
        
        int count = 2;
        node = node.parent;
        while (count <= len && node != null)
        {
            ans.inc(node.val);
            count++;
            node = node.parent;            
        }
        
        return ans.getHash();
    }

    static long getHash(ArrayList<Integer> list)
    {
        MyHash ans = new MyHash(list.get(0));
        
        for (int i = 1; i < list.size(); i++)
            ans.inc(list.get(i));
        
        return ans.getHash();
    }
}


