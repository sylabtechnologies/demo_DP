// https://leetcode.com/contest/weekly-contest-205/problems/minimum-deletion-cost-to-avoid-repeating-letters/

class Solution
{
    int total;
    char[] arr;
    
    public int minCost(String s, int[] cost)
    {
        arr = s.toCharArray();
        for (int i = 1; i < arr.length; i++)
        {
            if (arr[i - 1] == arr[i])
            {
                int next = getMinCost(i - 1, cost);
                i = next;
            }
        }
        
        return total;
    }

    private int getMinCost(int start, int[] cost)
    {
        int count = 1;
        for (int j = start + 1; j < arr.length; j++)
        {
            if (arr[start] == arr[j])
                count++;
            else break;
        }
        
        ArrayList<Integer> cut = new ArrayList<>();
        for (int j = start; j < start + count; j++)
            cut.add(cost[j]);

        Collections.sort(cut);
        for (int j = 0; j < cut.size() - 1; j++)
            total += cut.get(j);
        
        return start + count;
    }
}
