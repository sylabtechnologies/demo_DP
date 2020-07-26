// https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum/

class Solution
{
    static int MOD = 1_000_000_007;
    
    public int numOfSubarrays(int[] arr)
    {
        int len = arr.length;
        if (len < 1) return 0;
        if (len == 1) return arr[0] % 2;
        
        int even = 0, odd = 0;
        int triangle[] = new int[len];
        
        triangle[0] = arr[0];
        
        if (triangle[0] % 2 == 1)
            odd++;
        else
            even++;
        
        for (int i = 1; i < len; i++)
        {
            triangle[i] = triangle[i-1] + arr[i];
            if (triangle[i] > MOD) triangle[i] -= MOD;

            if (triangle[i] % 2 == 1)
                odd++;
            else
                even++;
        }

        int ans = odd;
        if (ans > MOD) ans -= MOD;
        
//        System.out.println(Arrays.toString(triangle));

        for (int i = 0; i < len - 1; i++)
        {
            if (arr[i] % 2 == 1)
            {
                // flip odd and even
                int temp = odd;
                odd = even;
                even = temp - 1;                
            }
            else
                even--;

            ans += odd;
            if (ans > MOD) ans -= MOD;
        }
        
        return ans;
    }
}
