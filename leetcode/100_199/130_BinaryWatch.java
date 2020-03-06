// https://leetcode.com/problems/binary-watch/
// do BST, OPTIMIZE for travel restrictions

package binarywatch;
import java.util.*;

class Solution
{
    private final static int MAXHOUR = 11;
    private final static int MAXMNUT = 59;
    
    private final static BinLevelTree hourTree = new BinLevelTree(3);
    private final static BinLevelTree minsTree = new BinLevelTree(5);
  
    public static List<String> readBinaryWatch(int num)
    {
        List<String> res = new ArrayList<>();
        
        for (int i = 0; i <= num; i++)
        {
            List<Integer> hourList = new ArrayList<>();
            inorder(hourTree, hourList, i);
            
            List<Integer> minsList = new ArrayList<>();
            inorder(minsTree, minsList, num - i);
            
            System.out.println(hourList);
            System.out.println(minsList);
            
            for (Integer h : hourList)
            {
                if (h > MAXHOUR) continue;
                
                for (Integer m : minsList)
                {
                    if (m > MAXMNUT) continue;
                    res.add(String.format("%d:%02d", h, m));
                }
            }
        }
        
        return res;
    }

    private static void inorder(BinLevelTree root, List<Integer> list, int maxRights)
    {
        if (maxRights < 0) return;
        
        if (maxRights == 0)
        {
            list.add(root.val);
            return;
        }
        
        if (root.left != null) inorder(root.left, list, maxRights);
        if (root.right != null) inorder(root.right, list, maxRights - 1);
    }

}

public class BinaryWatch
{
    public static void main(String[] args)
    {
        System.out.println(Solution.readBinaryWatch(1));
    }
    
}

class BinLevelTree
{
    final int val;
    final int level;
    BinLevelTree left;
    BinLevelTree right;
    
    BinLevelTree(int maxLevel)
    {
        val = 0;
        level = -1;

        if (maxLevel < 0) return;

        left  = new BinLevelTree(0, false, 0, maxLevel);
        right = new BinLevelTree(0, true, 0, maxLevel);
    }

    private BinLevelTree(int superVal, boolean isRight, int level, int maxLevel)
    {
        this.level = level;
        int levelVal = (int) Math.pow(2, level);
        
        if (!isRight)
            val = superVal;
        else
            val = superVal + levelVal;
        
        if (level == maxLevel) return;
            
        left  = new BinLevelTree(val, false, level + 1, maxLevel);
        right = new BinLevelTree(val, true, level + 1, maxLevel);
    }

    @Override
    public String toString() { return "[ " + val + ", " + left + ", " + right + " ]"; }
}
