// https://leetcode.com/problems/can-place-flowers/

package flowerpots;

public class FlowerPots
{
    public static void main(String[] args)
    {
        int [] pots = {0,0,1,0,0,0,0,1,0,1,0,0,0,1,0,0,1,0,1,0,1,0,0,0,1,0,1,0,1,
            0,0,1,0,0,0,0,0,1,0,1,0,0,0,1,0,0,1,0,0,0,1,0,0,1,0,0,1,0,0,0,1,0,0,0,0,1,
            0,0,1,0,0,0,0,1,0,0,0,1,0,1,0,0,0,0,0,0};
        System.out.println(canPlaceFlowers(pots, 17));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n)
    {
        if (n == 0) return true;
        
        int len = flowerbed.length;
        if (len == 1) return (flowerbed[0] == 0) ? true : false;
        
        int count = 0;
        int rowLen = 0;
        
        // see the ends
        int start = 0;
        while(start < len)
        {
            if (flowerbed[start] == 1) break;
            rowLen++;
            start++;
        }
        if (start == len)
        {
            count +=  (1 + rowLen) / 2;
            return count >= n;
        }
        else 
            count += rowLen / 2;
        
        int end  = len - 1;
        rowLen = 0;
        while(end > start)
        {
            if (flowerbed[end] == 1) break;
            rowLen++;
            end--;
        }
        count += rowLen / 2;
        rowLen = 0;
        
        for (int i = start; i < len; i++)
        {
            if (flowerbed[i] == 0)
                rowLen++;
            else
            {
                if (rowLen > 0)
                {
                    count += (rowLen - 1) / 2;
                    rowLen = 0;
                }
            }
        }
        
        return count >= n;
    }

    
}
