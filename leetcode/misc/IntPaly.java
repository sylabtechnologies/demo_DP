// https://leetcode.com/problems/palindrome-number/
class Solution {
    public static boolean isPalindrome(int x)
    {
        if (x < 0) return false;
            
        ArrayList<Integer> test = new ArrayList<>();
        
        while(x > 0)
        {
            test.add(x%10);
            x /= 10;
        }
        
        int i = 0;
        int j = test.size() - 1;
        
        boolean ans = true;
        while (i < j)
        {
            if (!test.get(i).equals(test.get(j)))
            {
                ans = false;
                break;
            }

            i++; j--;
        }
        
        return ans;
    }
}
