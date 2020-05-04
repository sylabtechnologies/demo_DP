package overlap;

class Solution
{
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H)
    {
        long area = (C-A)*(D-B) + (G-E)*(H-F);
        
        boolean overlaps = overlap(A, C, E, G) && overlap(B, D, F, H);
        if (overlaps)
        {
            area -= intersection(A, C, E, G) * intersection(B, D, F, H);
        }
        
        return (int) area;
    }

    private int intersection(int start1, int end1, int start2, int end2)
    {
        return Math.max(start1, start2) - Math.min(end1, end2);
    }

    private boolean overlap(int start1, int end1, int start2, int end2)
    {
        return (start1 < end2) && (start2 < end1);
    }
}

public class Overlap
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
    }
    
}
