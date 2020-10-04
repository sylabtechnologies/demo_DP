// https://leetcode.com/problems/maximum-number-of-visible-points/
import java.util.*;

class Solution
{
    private static final double PI = Math.PI;
    
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location)
    {
        double myAngle = angle*PI/180;
        ArrayList<Double> theta = new ArrayList<>();
        
        int myX = location.get(0);
        int myY = location.get(1);
        int zeroCnt = 0;
        
        for (List<Integer> pt : points)
        {
            if (pt.get(0) == myX && pt.get(1) == myY)
            {
                zeroCnt++; continue;                
            }
            
            theta.add(Math.atan2(pt.get(1) - myY, pt.get(0) - myX));
        }
        
        Collections.sort(theta);
        if (theta.size() <= 1) return theta.size() + zeroCnt;
        
        // covering last + myAngle base
        // which starts from -PI
        Double last = theta.get(theta.size()-1);
        if (last > PI - myAngle)
        {
            for (int i = 0; i < theta.size(); i++)
            {
                Double curr = theta.get(i);
                if (curr > last + myAngle - 2*PI) break;
                theta.add(curr + 2*PI);
            }
        }
        
        int max = 1; 
        int i = 0, j = 1;
        double start = theta.get(0);
        while (j < theta.size())
        {
            double curr = theta.get(j);
            
            if (curr - start <= myAngle)
            {
                int len = j - i + 1;
                max = Math.max(max, len);
                j++;
            }
            else
            {
                i++;
                if (i == j) j++;
                start = theta.get(i);
            }
        }
        
        return max + zeroCnt;
    }
}

public class Goog4
{
    public static void main(String[] args)
    {
        int pt[][] = {{0,0},{0,2}}; // {{2,1},{2,2},{3,4}, {1,1}};
        List<List<Integer>> pts = new ArrayList<>();
        for (int[] pp : pt)
            pts.add(Arrays.asList(pp[0], pp[1]));
        
        List<Integer> loc = Arrays.asList(1,1);
        System.out.println(new Solution().visiblePoints(pts, 90, loc));
    }
    
}
