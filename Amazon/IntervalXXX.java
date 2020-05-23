package intervals;
import java.util.ArrayList;

class Solution
{
    public int[][] intervalIntersection(int[][] a, int[][] b)
    {
        if (a.length == 0 || b.length == 0) return new int[0][];
        
        ArrayList<Integer> start = new ArrayList<>(), end = new ArrayList<>();
        
        int currA = 0, currB = 0, count = 0;
        while (currA < a.length && currB < b.length)
        {
            int s1 = a[currA][0];
            int s2 = b[currB][0];
            int e1 = a[currA][1];
            int e2 = b[currB][1];
            
            if (e1 < s2)
                currA++;
            else if (s1 > e2)
                currB++;
            else
            {
                int ix = Math.max(s1, s2);
                int ex = Math.min(e1, e2);
                
                start.add(ix);
                end.add(ex);
                count++;
                
                if (ex == e1) currA++; else currB++;
            }
        }
        
        int ans[][] = new int[count][];
        for (int i = 0; i < count; i++)
        {
            int row[] = new int[2];
            row[0] = start.get(i);
            row[1] = end.get(i);
            ans[i] = row;
        }

        return ans;
    }
}

public class Intervals
{
    public static void main(String[] args)
    {
        int A[][] = {{0,2},{5,10},{13,23},{24,25}}, B[][] = {{1,5},{8,12},{15,24},{25,26}};

        int x[][] = new Solution().intervalIntersection(A, B);
        for (int[] i : x)
            System.out.println(i[0] + " " + i[1]);
    }
    
}
