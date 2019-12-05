package hammingweight;

class Solution
{
    public static int hammingWeight(int n)
    {
        int mask = 1;
        int count = 0;

        for (int i = 0; i < 31; i++)
        {
            if ( (n & mask) > 0) count++;
            mask = mask << 1;
        }
        
        if (n < 0) count++;
        
        return count;
    }

    public static int hammingDistance(int x, int y)
    {
        int mask = 1;
        int dist = 0;
        
        for (int i = 0; i < 31; i++)
        {
            int a = x & mask;
            int b = y & mask;
            
            if (a != b) dist++;
            
            mask = mask << 1;
        }

        return dist;
    }
    
}

public class HammingWeight
{

    public static void main(String[] args)
    {
        System.out.println(Solution.hammingWeight(-3));
        System.out.println(Solution.hammingDistance(1, 4));
    }
    
}
