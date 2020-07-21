package twoeqtwo;
import java.util.*;

class Solution
{
    MultiMap<Integer, Integer> map;
    ArrayList<Integer> result;

    public ArrayList<Integer> equal(ArrayList<Integer> nums)
    {
        result = new ArrayList<Integer>();
        if (nums.size() < 4) return result;

        map = new MultiMap<>();
        for (int i = 0; i < nums.size(); i++)
            map.put(nums.get(i), i);

        for (int i = 0; i < nums.size() - 3; i++)
        {
            for (int j = i + 1; j < nums.size() - 2; j++)
            {
                for (int k = i + 1; k < nums.size() - 1; k++)
                {
                    if (k == j) continue;

                    int target = nums.get(i) + nums.get(j) - nums.get(k);
                    ArrayList<Integer> row = map.getRow(target);
                    if (row == null) continue;
                    
                    for (int x : row)
                    {
                        if (x == j) continue;
                        if (x <= k) continue;
                        
                        addOrUpdate(i, j, k, x);
                    }
                    
                }
            }
        }

        return result;
    }

    private void addOrUpdate(int i, int j, int x, int y)
    {
        if (result.isEmpty())
        {
            setResult(i, j, x, y);
            return;
        }

        if (i < result.get(0))
              setResult(i, j, x, y);
        else if (i == result.get(0))
        {
            if (j < result.get(1))
                setResult(i, j, x, y);
            else if (j == result.get(1))
            {
                if (x < result.get(2))
                    setResult(i, j, x, y);
                else if (x == result.get(2))
                {
                    if (y < result.get(3))
                        setResult(i, j, x, y);
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
