package diffk2;
import java.util.*;

class Solution
{
    public int findPairs(int[] nums, int k)
    {
        if (k < 0) return 0;

        Map<Integer, Integer> map = new TreeMap<>();
        if (k == 0)
        {
            for (int i = 0; i < nums.length; i++)
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            
            int len = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet())
            {
                Integer value = entry.getValue();
                if (value > 1) len++;
            }
            
            return len;
        }
        
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], i);
        
        HashSet<Pair> result = new HashSet<>();
        System.out.println(map);
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            int num = entry.getKey();
            if (map.containsKey(num - k))
                result.add(new Pair(num, num - k));
            else if (map.containsKey(num + k))
                result.add(new Pair(num, num + k));
        }
        
        return result.size();
    }

    private static class Pair
    {
        int fst, snd;
        
        public Pair(int a, int b)
        {
            if (b > a)
            {
                fst = a; snd = b;
            }
            else
            {
                fst = b; snd = a;
            }
        }
        
        
        @Override
        public String toString() { return "[" + fst + ", " + snd + ']'; }

        @Override
        public int hashCode() {
            int hash = 3;
            hash = 53 * hash + this.fst;
            hash = 53 * hash + this.snd;
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass())
            {
                return false;
            }
            
            final Pair other = (Pair) obj;
            if (this.fst != other.fst) {
                return false;
            }
            if (this.snd != other.snd) {
                return false;
            }
            return true;
        }
        
    }
}

public class DiffK2
{
    public static void main(String[] args)
    {
        List<Integer> arr = Arrays.asList(1, 5, 3);
        
        int tst[] ={3,1,4,1,5};
        System.out.println(new Solution().findPairs(tst, 0));
    }
}
