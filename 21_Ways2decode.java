// https://leetcode.com/problems/decode-ways/submissions/
// convert to DP

class Solution
{
    
    private static final int MIN_CODE = 1;
    private static final int MAX_CODE = 26;

    public static int numDecodings(String test)
    {
        LinkedList<Integer> code = new LinkedList<>();
        
        for (int i = 0; i < test.length(); i++)
        {
            char c = test.charAt(i);
            code.add(((int)(c - '0')));
        }

        return ways(code);
    }    

    private static int ways(LinkedList<Integer> code)
    {
        if (code.size() == 0) return 0;
        
        if (code.size() < 2) return 1;
            
        int ans = 1;
        
        for (int i = 1; i < code.size(); i++)
        {
            if (code.get(i-1) > 2) continue;
            if (code.get(i) >= MAX_CODE) continue;
            
            int tester = 10*code.get(i-1) + code.get(i);
            
            if (tester <= MAX_CODE)
            {
                LinkedList<Integer> copy = new LinkedList<>(code);
                copy.remove(i);
                copy.set(i - 1, tester );
                ans = ans + ways(copy);
            }
            
        }
        
        return ans;
    }

}