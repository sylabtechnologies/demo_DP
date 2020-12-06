package goog17;
import java.util.*;

// sweep from top https://leetcode.com/problems/the-skyline-problem/
class Solution
{
    public List<List<Integer>> getSkyline(int[][] buildings)
    {
        List<List<Integer>> ret = new ArrayList<>();
        if (buildings.length == 0) return ret;
        
        MultiMap<Integer, Interval> levels = new MultiMap<>();
        for (int[] b : buildings)
            levels.put(b[2], new Interval(b[0], b[1], b[2]));

        ArrayList<Integer> heights = levels.getKeys(true);
        TreeSet<Interval> zero = new TreeSet<>();
        zero.add(new Interval(Integer.MIN_VALUE, Integer.MAX_VALUE));
        
        ArrayList<Interval> solved = new ArrayList<>();
        for (int i = heights.size() - 1; i >= 0; i--)
        {
            ArrayList<Interval> curLevel = levels.getRow(heights.get(i));
            Collections.sort(curLevel);
            merge(curLevel);
            
            for (Interval curTop : curLevel)
            {
                ArrayList<Interval> overlaps = new ArrayList<>();
                Interval first = zero.floor(curTop);
                if (first != null)
                    overlaps.add(first);
                
                for (Interval ii : zero.tailSet(curTop))
                {
                    if (ii.beg > curTop.end) break;
                    overlaps.add(ii);
                }
                
                for (Interval test : overlaps)
                {
                    if (!test.overlaps(curTop)) continue;
                    if (test.end == curTop.beg || curTop.end == test.beg) continue;

                    zero.remove(test);
                    if (curTop.contains(test) || curTop.equals(test))
                    {
                        solved.add(new Interval(test.beg, test.end, curTop.height));
                    }
                    else if (test.contains(curTop))
                    {
                        if (test.beg != curTop.beg)
                            zero.add(new Interval(test.beg, curTop.beg));

                        if (test.end != curTop.end)
                            zero.add(new Interval(curTop.end, test.end));
                        solved.add(curTop);
                    }
                    else if (test.end < curTop.end)
                    {
                        solved.add(new Interval(curTop.beg, test.end, curTop.height));
                        zero.add(new Interval(test.beg, curTop.beg));
                    }
                    else
                    {
                        solved.add(new Interval(test.beg, curTop.end, curTop.height));
                        zero.add(new Interval(curTop.end, test.end));
                    }
                }
            }
        }

        for (Interval iv : zero)
        {
            if (iv.beg == Integer.MIN_VALUE || iv.end == Integer.MAX_VALUE) continue;
            solved.add(iv);
        }
        
        Collections.sort(solved);
        int currH = 0;
        Interval last = null;
        for (Interval iv : solved)
        {
            ret.add(Arrays.asList(iv.beg, iv.height));
            last = iv;
        }
        ret.add(Arrays.asList(last.end, 0));
        
        return ret;
    }
    
    private void merge(ArrayList<Interval> list)
    {
        LinkedList<Interval> res = new LinkedList<>();
        int i = 0;
        while (i < list.size())
        {
            Interval curr = list.get(i++);
            
            int j = i;
            while (j < list.size())
            {
                Interval next = list.get(j);
                if (!curr.overlaps(next)) break;
                
                curr = curr.merge(next);
                i++; j++;
            }
            
            res.add(curr);
        }
        
        list.clear();
        list.addAll(res);
    }
}

public class Goog17
{
    public static void main(String[] args)
    {
        int b[][] = { {1,2,1 }, {2147483646,2147483647,2147483647}};
        System.out.println(new Solution().getSkyline(b));
//        int b[][] = { {2,9,10}, {3,7,15}, {5,12,12}, {15,20,10}, {19,24,8} };
//        int b[][] = {{0,5,7},{5,10,7},{5,10,12},{10,15,7},{15,20,7},{15,20,12},{20,25,7}};
    }
}

