package twoeqtwo;
import java.util.*;

class Solution
{
    private MultiMap<Integer, Pair> map = new MultiMap<>();
    private int result[] = new int[4];
    private boolean resultIsEmpty = true;

    public ArrayList<Integer> equal(ArrayList<Integer> nums)
    {
        if (nums.size() < 4) return getResult();

        // memoize pairs
        HashSet<Pair> visited = new HashSet<>();
        for (int i = 0; i < nums.size() - 3; i++)
        {
            for (int j = i + 1; j < nums.size() - 2; j++)
            {
                Pair curr = new Pair(i, j);
                
                if (visited.contains(curr))
                    continue;
                else
                    visited.add(curr);
                
                int sum = nums.get(i) + nums.get(j);
                map.put(sum, curr);
            }
        }
        visited.clear();
        
        for (int i = 1; i < nums.size() - 1; i++)
        {
            for (int j = i + 1; j < nums.size(); j++)
            {
                int sum = nums.get(i) + nums.get(j);
                ArrayList<Pair> row = map.getRow(sum);
                if (row == null) continue;
                
                for (Pair p : row)
                {
                    if (p.fst >= i) continue;
                    if (p.snd == j) continue;
                    if (p.snd == i) continue;
                    
                    addOrUpdate(p.fst, p.snd, i, j);
                }
            }
        }

        return getResult();
    }

    private void addOrUpdate(int i, int j, int x, int y)
    {
        if (resultIsEmpty)
        {
            setResult(i, j, x, y);
            resultIsEmpty = false;
            return;
        }

        if (i < result[0])
              setResult(i, j, x, y);
        else if (i == result[0])
        {
            if (j < result[1])
                setResult(i, j, x, y);
            else if (j == result[1])
            {
                if (x < result[2])
                    setResult(i, j, x, y);
                else if (x == result[2])
                {
                    if (y < result[3])
                        setResult(i, j, x, y);
                }
            }
        }        
    }

    private void setResult(int i, int j, int x, int y)
    {
        result[0] = i;
        result[1] = j;
        result[2] = x;
        result[3] = y;
    }

    private ArrayList<Integer> getResult()
    {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i : result)
            ans.add(i);
        return ans;
    }
    
    private class Pair
    {
        int fst, snd;
        public Pair(int a, int b) { fst = a; snd = b; }
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

public class TwoEqTwo
{
    public static void main(String[] args)
    {
        ArrayList<Integer> test = new ArrayList<>(Arrays.asList(3, 4, 7, 1, 2, 9, 8));
        System.out.println(new Solution().equal(test));
    }
    
}
