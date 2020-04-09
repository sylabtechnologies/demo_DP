// https://leetcode.com/problems/reverse-bits/

package reversebits;
import java.util.Arrays;

class Solution
{
    public int reverseBits(int n)
    {
        char binArray[] = new char[32];
        Arrays.fill(binArray, '0');
        
        String bin = Integer.toBinaryString(n);
        int count = bin.length() - 1;
        for (int i = 31; i >=0; i--)
        {
            binArray[i] = bin.charAt(count);
            
            if (count == 0)
                break;
            else
                count--;
        }
        
        int result = 0;
        for (int i = 31; i >=0; i--)
        {
            char c = binArray[i];
            result = result << 1;
            result = result | ( c - '0');            
        }
        
        return result;
    }
}

public class ReverseBits
{

    public static void main(String[] args)
    {
        System.out.println(new Solution().reverseBits(43261596));
    }
    
}

/*


*/