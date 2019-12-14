/*
Given a list of intervals, remove all intervals that are covered by another interval in the list.
Interval [a,b) is covered by interval [c,d) if and only if c <= a and b <= d.
After doing so, return the number of remaining intervals
*/
package removeintervals;
import java.util.*;
import removeintervals.IntervalTree.Interval;

class Solution
{
    public static int removeCoveredIntervals(int[][] intervals)
    {
        IntervalTree tr = new IntervalTree();
        
        ArrayList<Interval> sorted = new ArrayList<>();
        for (int[] i : intervals)
            sorted.add(new Interval(i[0], i[1]));

        Collections.sort(sorted); // COVER ALL W/ x.len < y.len
        for (Interval iv : sorted)
            tr.overwriteCovered(iv); // skip encloser w/ static inner
        
        return tr.size();
    }
}


public class RemoveIntervals
{
    public static void main(String[] args)
    {
        int intervals[][] = {{1,4}, {2, 3}}; // {{1,4},{3,6},{2,8}};
        
        System.out.println(Solution.removeCoveredIntervals(intervals));
    }
}
