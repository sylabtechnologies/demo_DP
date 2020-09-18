// https://leetcode.com/problems/decode-ways/ & great MMZ

class Solution
{
    private static HashSet<Integer> mySet;
    static
    {
        mySet = new HashSet<>();
        for (int i = 1; i <= 26; i++)
            mySet.add(i);
    }
    
    private HashMap<Integer, Integer> memo = new HashMap<>();
    
    public int numDecodings(String s)
    {
        if (s.isEmpty() || s.charAt(0) == '0') return 0;
                
        int arr[] = new int[s.length()];
        for (int i = 0; i < arr.length; i++)
            arr[i] = s.charAt(i) - '0';
        
        return helper(arr, 0);
    }
    
    private int helper(int arr[], int curr)
    {
        if (arr[curr] == 0) return 0;
        
        Integer mmz = memo.get(curr);
        if (mmz != null) return mmz;

        if (curr == arr.length - 1) return 1;
        
        int num = arr[curr]*10 + arr[curr+1];
        int ans = 0;
        
        if (curr == arr.length - 2)
        {
            if (mySet.contains(num))
                ans = (arr[curr + 1] != 0) ? 2 : 1;
            else
                ans = (arr[curr + 1] != 0) ? 1 : 0;
        }
        else
        {
            if (mySet.contains(num))
                ans = helper(arr, curr + 1) + helper(arr, curr + 2);
            else
                ans = helper(arr, curr + 1);        
        }
        
        memo.put(curr, ans);
        return ans;
    }
}
