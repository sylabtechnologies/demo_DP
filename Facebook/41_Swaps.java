/*
1) Create a global variable which will store the maximum string or number.
2) Define a recursive function that takes the string as number and value of k
3) Run a nested loop, the outer loop from 0 to length of string -1 and inner loop from i+1 to end of string.
4) Swap the ith and jth character and check if the string is now maximum and update the maximum string.
5) Call the function recursively with parameters: string and k-1.
6) Now again swap back the ith and jth character.
*/

package swaps;
import java.util.*;

class Solution
{
    char max[];
    
    public String solve(String a, int maxSwaps)
    {
        if (a.length() < 2 || maxSwaps < 1) return new String(a);
        
        max = a.toCharArray();
        char data[] = a.toCharArray();
        
        helper(data, maxSwaps);
        return new String(max);
    }

    private void helper(char[] data, int maxSwaps)
    {
        if (maxSwaps <= 0) return;

        for (int i = 0; i < data.length - 1; i++)
        {
            for (int j = i + 1; j < data.length; j++)
            {
                swap(data, i, j);       // R&B
                
                if (greaterThan(data, max))
                    max = Arrays.copyOf(data, data.length);

                helper(data, maxSwaps - 1);
                swap(data, i, j);       // R&B
            }
        }
    }

    private void swap(char[] data, int left, int rght)
    {
        char temp = data[rght];
        data[rght] = data[left];
        data[left] = temp;
    }

    private boolean greaterThan(char[] test, char[] data)
    {
        if (test.length != data.length) throw new IllegalArgumentException("cant match");
        
        boolean ans = true;
        for (int i = 0; i < data.length - 1; i++)
        {
            if (test[i] > data[i])
                return true;
            else if (test[i] < data[i])
                return false;
        }
        
        if (test[data.length - 1] <= data[data.length - 1])
            ans = false;
        
        return ans;
    }
}
    
public class Swaps
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().solve("7599", 2));
    }
    
}

/*
7599

9597


*/