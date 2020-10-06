// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
package goog7;
import java.util.*;

class Solution
{
    public int findMinArrowShots(int[][] balloons)
    {
        LinkedList<Balloon> blns = new LinkedList<>();
        for (int[] iv : balloons)
            blns.add(new Balloon(iv[0], iv[1]));
        
        Collections.sort(blns);
        int arrows = 0;
        while (!blns.isEmpty())
        {
            Balloon mark = blns.removeFirst();
            arrows++;
            
            while (!blns.isEmpty() && blns.getFirst().start <= mark.fin)
            {
                mark.fin = Math.min(mark.fin, blns.getFirst().fin); // select min
                blns.removeFirst();
            }
        }

        return arrows;
    }

    private static class Balloon implements Comparable<Balloon>
    {
        int start, fin;

        public Balloon(int time, int delta)
        {
            this.start = time;
            this.fin = delta;
        }

        @Override
        public String toString() {
            return "(" + start + ", " + fin + ")";
        }

        @Override
        public int compareTo(Balloon bl)
        { 
            if (bl.start != this.start)
                return Integer.compare(this.start, bl.start);
            
            return Integer.compare(this.fin, bl.fin);
        }
    }
}

public class Goog7
{
    public static void main(String[] args)
    {
//        int blns[][] = {{10, 16}, {2,8}, {1, 6}, {7,12}};
        int blns[][] = {{1, 2}, {1, 5}, {4,5}};
        System.out.println(new Solution().findMinArrowShots(blns));
    }
}
