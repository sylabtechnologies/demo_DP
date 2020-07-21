package twoeqtwo;
import java.util.*;

class Solution
{
    MultiMap<Integer, Integer> map;
    ArrayList<Integer> result;

    public ArrayList<Integer> equal(ArrayList<Integer> nums) {
        if (nums.size() < 4) {
            return new ArrayList<>();
        }

        result = new ArrayList<Integer>();
        map = new MultiMap<>();
        for (int i = 0; i < nums.size(); i++)
            map.put(nums.get(i), i);

        for (int i = 0; i < nums.size() - 3; i++)
            for (int j = i + 1; j < nums.size() - 2; j++) {
                ArrayList<Integer> candids = getPairs(nums, i, j, nums.get(i) + nums.get(j));

                if (!candids.isEmpty()) addOrReplace(i, j, candids);
            }

        return result;
    }

    private ArrayList<Integer> getPairs(ArrayList<Integer> nums, int ia, int ib, int target)
    {
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = ia + 1; i < nums.size() - 1; i++)
        {
            if (i == ib) continue;

            int delta = target - nums.get(i);
            ArrayList<Integer> row = map.getRow(delta);
            if (row == null) continue;

            for (Integer ix : row)
            {
                if (ix == ib) continue;
                if (ix <= i)  continue;

                ans.add(i);
                ans.add(ix);
            }
        }

        return ans;
    }

    private void addOrReplace(int i, int j, ArrayList<Integer> candids)
    {
        for (int k = 0; k < candids.size(); k += 2)
        {
            if (result.isEmpty())
            {
                setResult(i, j, candids.get(k), candids.get(k+1));
                continue;
            }
            
            if (i < result.get(0))
                setResult(i, j, candids.get(k), candids.get(k+1));
            else if (i == result.get(0))
            {
                if (j < result.get(1))
                    setResult(i, j, candids.get(k), candids.get(k+1));
                else if (j == result.get(1))
                {
                    if (candids.get(k) < result.get(2))
                        setResult(i, j, candids.get(k), candids.get(k+1));
                    else if (candids.get(k) == result.get(2))
                    {
                        if (candids.get(k + 1) < result.get(3))
                            setResult(i, j, candids.get(k), candids.get(k+1));
                    }
                }
            }
        }
    }

    private void setResult(int i, int j, int x, int y)
    {
        result.clear();;
        result.add(i);
        result.add(j);
        result.add(x);
        result.add(y);
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
