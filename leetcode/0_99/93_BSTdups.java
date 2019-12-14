// https://leetcode.com/problems/find-mode-in-binary-search-tree/
/// traverse inorder w/ max dup cutoff (or do specual tree to keep dups?)

package bstmode;
import java.util.*;

class Solution
{
    public int[] findMode(TreeNode root)
    {
        if (root == null) return new int[0];
        
        FrequencySet ans = new FrequencySet();
        inorder(root, ans);

        if (ans.getMaxFreq() > 1)
            ans.cutoff();
        
        int[] res = new int[ans.size()];
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : ans.entrySet())
            res[count++] = entry.getKey();

        return res;
    }
    
    private void inorder(TreeNode root, FrequencySet  set)
    {
        if (root.left != null) inorder(root.left, set);
        set.addElement(root.val);
        if (root.right != null) inorder(root.right, set);
    }    

}

class FrequencySet extends HashMap<Integer, Integer>
{
    private int maxFreq;

    public FrequencySet()
    {
        super();
        maxFreq = -1;
    }
    
    public void addElement(int elem)
    {
        int freq;
        if (super.containsKey(elem))
            freq = super.get(elem) + 1;
        else
            freq = 1;

        super.put(elem, freq);
        if (freq > maxFreq) maxFreq = freq;
    }

    public int getMaxFreq() { return maxFreq; }

    public void cutoff()
    {
        Iterator<Entry<Integer, Integer>> it = super.entrySet().iterator();

        while (it.hasNext())
        {
            Entry<Integer, Integer> elem = it.next();

            if (elem.getValue() < maxFreq)
                it.remove();
        }
    }
    
}
