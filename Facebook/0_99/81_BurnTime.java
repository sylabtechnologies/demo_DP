// https://www.interviewbit.com/problems/burn-a-tree/

package burntree;
import java.util.*;

class Solution
{
    private MultiMap<Integer, Integer> connected = new MultiMap<>();
    private HashMap<Integer, Integer> burnTime = new HashMap<>();
    
    public int solve(TreeNode root, int burn)
    {
        preorder(root);
        
        Queue<Integer> q = new LinkedList<>();
        burnTime.put(burn, 1);
        q.offer(burn);
        for (Integer x : connected.getRow(burn))
        {
            burnTime.put(x, 1);
            q.offer(x);
        }
        
        int max = 0;
        while (!q.isEmpty())
        {
            int node = q.poll();
            int bt = burnTime.get(node);
            max = Math.max(max, bt);
            
            for (Integer y : connected.getRow(node))
            {
                Integer when = burnTime.get(y);
                if (when == null)
                {
                    q.offer(y);
                    burnTime.put(y, bt + 1);
                }
            }
        }

        return max;
    }

    private void preorder(TreeNode root)
    {
        if (root == null) return;
        
        if (root.left != null)
        {
            connected.put(root.val, root.left.val);
            connected.put(root.left.val, root.val);
        }
                        
        if (root.right != null)
        {
            connected.put(root.val, root.right.val);
            connected.put(root.right.val, root.val);
        }
        
        preorder(root.left);
        preorder(root.right);
    }
}


public class BurnTree
{
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(1);
        root.addLeft(2); root.addRight(3);
        root.left.addLeft(4);
        root.right.addLeft(5);
        root.right.addRight(6);
        
        System.out.println(new Solution().solve(root, 4));
    }
    
}

class MultiMap<K extends Comparable<K>, V>
{
    private HashMap<K, ArrayList<V> > map = new HashMap<>();
    private ArrayList<K> keys = new ArrayList<>();

    public void put(K key, V val)
    {
        ArrayList<V> row = map.get(key);

        if (row == null)
        {
            row = new ArrayList<>();
            map.put(key, row);
            keys.add(key);
        }

        row.add(val);
    }

    public ArrayList<V> getRow(K key)
    {
        return map.get(key);
    }
    
    public ArrayList<K> getKeys(boolean sorted)
    {
        ArrayList<K> ans = new ArrayList<>();
        ans.addAll(keys);

        if (sorted) Collections.sort(ans);
        return ans;
    }

    public static int[] listToInt(List<Integer> lst)
    {
        int[] ans = new int[lst.size()];
        
        for (int i = 0; i < lst.size(); i++)
            ans[i] = lst.get(i);
        
        return ans;
    }
    
    @Override
    public String toString()
    {
        return map.toString();
    }
}