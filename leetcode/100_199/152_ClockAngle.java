package clockangle;

class Solution {
    public static double angleClock(int hour, int minutes)
    {
        double m = minutes * 6;
        
        if (hour == 12) hour = 0;
        double h = hour*30 + minutes / 2.0 ;
        
        double a = Math.abs(m - h);
        return Math.min(a, 360 - a);
    }
}

public class ClockAngle
{

    public static void main(String[] args)
    {
        System.out.println(Solution.angleClock(1, 57));
        System.out.println(Solution.angleClock(12, 30));
        System.out.println(Solution.angleClock(3, 30));
        System.out.println(Solution.angleClock(3, 15));
        System.out.println(Solution.angleClock(4, 50));
        System.out.println(Solution.angleClock(12, 0));
    }
    
}
