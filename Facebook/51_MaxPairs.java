package maxpairs;
import java.util.*;

class Solution
{
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B)
    {
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(new Comparator<Pair>()
        {
            @Override
            public int compare(Pair a, Pair b) {
                return Integer.compare(b.val, a.val);
            }
        });
        
        Set<Pair> set = new HashSet<>();
        ArrayList<Integer> result = new ArrayList<>();
        Collections.sort(A, Collections.reverseOrder());
        Collections.sort(B, Collections.reverseOrder());
        
        Pair pair = new Pair(0, 0, A.get(0) + B.get(0));
        
        maxHeap.add(pair);
        set.add(pair);
        
        // all combos keeping max on top
        while (result.size() < A.size())
        {
            Pair p = maxHeap.poll();
            result.add(p.val);
            
            if (p.i + 1 < A.size())
            {
                Pair n = new Pair(p.i + 1, p.j, A.get(p.i + 1) + B.get(p.j));
                if (set.add(n)) maxHeap.add(n);
            }
            
            if (p.j + 1 < B.size())
            {
                Pair n = new Pair(p.i, p.j + 1, A.get(p.i) + B.get(p.j + 1));
                if (set.add(n)) maxHeap.add(n);
            }
        }
        
        return result;
    }
}

public class MaxPairs
{
    public static void main(String[] args)
    {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 3, 4, 2));
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(2, 5, 6, 1));
        
        System.out.println(new Solution().solve(a, b));
    }
}

class Pair
{
    int i;
    int j;
    int val;

    public Pair(int i, int j, int val) {
        this.i = i;
        this.j = j;
        this.val = val;
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = hash * 13 + this.i;
        hash = hash * 13 + this.j;
        return hash;
    }

    @Override
    public boolean equals(Object o)
    {
        Pair p = (Pair) o;
        return p.i == this.i && p.j == this.j;
    }

    @Override
    public String toString()
    {
        return "(" + i + ", " + j + ") = " + val;
    }
}
