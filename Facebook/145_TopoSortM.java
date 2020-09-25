package templarges25;
import java.util.*;

class Solution
{
    public boolean canAttendMeetings(int[][] ivv)
    {
        Arrays.sort(ivv, new Comparator<int[]>()
        {
            @Override
            public int compare(int[] iv1, int[] iv2)
            {
                if (iv1[0] != iv2[0])
                    return Integer.compare(iv1[0], iv2[0]);
                else
                    return Integer.compare(iv1[1], iv2[1]);
            }
        });
        
        for (int i = 0; i < ivv.length - 1; i++)
        {
            int[] i1 = ivv[i];
            int[] i2 = ivv[i+1];
            
            ///  x1 < y1
            if (i1[1] > i2[0]) return false;
        }

        return true;
    }
}

public class TempLargeS25
{
    public static void main(String[] args)
    {
        
    }
}
