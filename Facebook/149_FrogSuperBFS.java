// https://leetcode.com/problems/frog-jump/
package templarges25;
import java.util.*;

class Solution
{
    public boolean canCross(int[] stones)
    {
        int ssize = stones.length;
        
        if (ssize == 1) return true;
        if (ssize >= 2 && stones[1] != 1) return false;
        
        // dfs
        Set<Integer> stoneSet = new TreeSet<>();
        for (int stone : stones)
            stoneSet.add(stone);

        int last = stones[ssize - 1];
        HashSet<FrogJump> visited = new HashSet<>();
        Queue<FrogJump> bfs = new LinkedList<>();
        bfs.add(new FrogJump(0, 1));
        
        while(!bfs.isEmpty())
        {
            FrogJump mv = bfs.poll();

            if (mv.stone == last ) return true;
            
//            System.out.println(mv);
            
            if (visited.contains(mv))
                continue;
            else
                visited.add(mv);
            
            for (int i = mv.step-1; i <= mv.step+1; i++)
            {
                if (i <= 0) continue;
                
                if (stoneSet.contains(mv.stone + i))
                    bfs.add(new FrogJump(mv.stone + i, i));
            }
        }

        return false;
    }

    private static class FrogJump
    {
        int stone, step;
        public FrogJump(int stn, int stp)
        {
            this.step = stp; this.stone = stn;
        }

        @Override
        public int hashCode()
        {
            int hash = 7;
            hash = 41 * hash + this.stone;
            hash = 41 * hash + this.step;
            return hash;
        }

        @Override
        public boolean equals(Object obj)
        {
            if (this == obj)
                return true;
            
            if (obj == null)
                return false;
            
            if (getClass() != obj.getClass())
                return false;
            
            final FrogJump other = (FrogJump) obj;
            if (this.stone != other.stone)
                return false;
            
            if (this.step != other.step)
                return false;
            
            return true;
        }

        @Override
        public String toString()
        {
            return "@ " + stone + " jumped " + step;
        }
    }
}

public class TempLargeS25
{
    public static void main(String[] args)
    {
        int stones[] = {0, 2};// {0,1,3,5,6,8,12,17};
        System.out.println(new Solution().canCross(stones));
    }
}
