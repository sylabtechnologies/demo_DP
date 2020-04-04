package rectncircle;

// https://leetcode.com/problems/circle-and-rectangle-overlapping/
/// #D/#C: point + binsearch of closest
class Solution
{
    private static final double TOLERANCE = 0.0000001;
    
    public boolean checkOverlap(int radius, int x_center, int y_center, int x1, int y1, int x2, int y2)
    {
        Point cent = new Point(x_center, y_center);
        
        Point topr = new Point(x2, y2);
        Point topl = new Point(x1, y2);
        Point botl = new Point(x1, y1);
        Point botr = new Point(x2, y1);
        
        boolean OK = insideCircle(radius, cent, topr);
        OK = OK | insideCircle(radius, cent, topl);
        OK = OK | insideCircle(radius, cent, botl);
        OK = OK | insideCircle(radius, cent, botr);
        if (OK) return true;
        
        OK = insideRect(radius, cent, topr, topl, botl, botr);
        if (OK) return true;

        OK = testClosest(radius, cent, topl, topr);
        if (OK) return true;

        OK = testClosest(radius, cent, topr, botr);
        if (OK) return true;

        OK = testClosest(radius, cent, botl, botr);
        if (OK) return true;

        OK = testClosest(radius, cent, topl, botl);
        if (OK) return true;
        
        return false;
    }

    private boolean testClosest(int radius, Point cent, Point left, Point right)
    {
        double minDist = getClosest(radius, cent, left, right);
        return minDist <= radius;
    }

    // binsearch
    private double getClosest(int radius, Point cent, Point left, Point right)
    {
        double d1, d2, midx = 0, midy = 0;
        
        while (true)
        {
            midx = (left.x + right.x) / 2;
            midy = (left.y + right.y) / 2;
            d1 = distance(cent, left.x, left.y);
            d2 = distance(cent, right.x, right.y);
            
            if (Math.abs(d1 - d2) <  TOLERANCE) break;
            
            double midd = distance(cent, midx, midy);
            if (midd < d2)
                right = new Point(midx, midy);
            else
                left = new Point(midx, midy);
        }
        
        return distance(cent, midx, midy);
    }
    
    private boolean insideRect(int radius, Point cent, Point topr, Point topl, Point botl, Point botr)
    {
        Point left = new Point(cent.x - radius, cent.y);
        Point right = new Point(cent.x + radius, cent.y);
        Point top = new Point(cent.x, cent.y + radius);
        Point bot = new Point(cent.x, cent.y - radius);
        
        boolean inside = (topl.x <= left.x && left.x <= topr.x) && (topl.y >= left.y && left.y >= botl.y);
        if (inside) return true;

        inside = (topl.x <= right.x && right.x<= topr.x) && (topl.y >= right.y && right.y >= botl.y);
        if (inside) return true;
        
        inside = (topl.x <= top.x && top.x <= topr.x) && (topl.y >= top.y && bot.y >= botl.y);
        if (inside) return true;
        
        inside = (topl.x <= bot.x && top.x <= topr.x) && (topl.y >= bot.y && bot.y >= botl.y);
        if (inside) return true;
        
        return false;
    }
    
    private boolean insideCircle(int radius, Point center, Point test)
    {
        double xx = center.x - test.x;
        double yy = center.y - test.y;
        return xx*xx + yy*yy <= radius*radius;
    }

    private double distance(Point cent, double x, double y)
    {
        double d1 = cent.x - x;
        double d2 = cent.y - y;
        return Math.sqrt(d1*d1 + d2* d2);
    }

    private static class Point
    {
        double x, y;

        public Point(double x, double y)
        {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() { return "[" + x + ", " + y + "]"; }
    }
}

public class RectnCircle
{
    public static void main(String[] args)
    {
        Solution sl = new Solution();
        System.out.println(sl.checkOverlap(1, 1, 1, 1, -3, 2, -1));
    }
    
}

/*
//cx,cy is center point of the circle 
public PointF ClosestIntersection(float cx, float cy, float radius,
                                  PointF lineStart, PointF lineEnd)
{
    PointF intersection1;
    PointF intersection2;
    int intersections = FindLineCircleIntersections(cx, cy, radius, lineStart, lineEnd, out intersection1, out intersection2);

    if (intersections == 1)
        return intersection1; // one intersection

    if (intersections == 2)
    {
        double dist1 = Distance(intersection1, lineStart);
        double dist2 = Distance(intersection2, lineStart);

        if (dist1 < dist2)
            return intersection1;
        else
            return intersection2;
    }

    return PointF.Empty; // no intersections at all
}

private double Distance(PointF p1, PointF p2)
{
    return Math.Sqrt(Math.Pow(p2.X - p1.X, 2) + Math.Pow(p2.Y - p1.Y, 2));
}

// Find the points of intersection.
private int FindLineCircleIntersections(float cx, float cy, float radius,
                                        PointF point1, PointF point2, out               
                                        PointF intersection1, out PointF intersection2)
{
    float dx, dy, A, B, C, det, t;

    dx = point2.X - point1.X;
    dy = point2.Y - point1.Y;

    A = dx * dx + dy * dy;
    B = 2 * (dx * (point1.X - cx) + dy * (point1.Y - cy));
    C = (point1.X - cx) * (point1.X - cx) + (point1.Y - cy) * (point1.Y - cy) - radius * radius;

    det = B * B - 4 * A * C;
    if ((A <= 0.0000001) || (det < 0))
    {
        // No real solutions.
        intersection1 = new PointF(float.NaN, float.NaN);
        intersection2 = new PointF(float.NaN, float.NaN);
        return 0;
    }
    else if (det == 0)
    {
        // One solution.
        t = -B / (2 * A);
        intersection1 = new PointF(point1.X + t * dx, point1.Y + t * dy);
        intersection2 = new PointF(float.NaN, float.NaN);
        return 1;
    }
    else
    {
        // Two solutions.
        t = (float)((-B + Math.Sqrt(det)) / (2 * A));
        intersection1 = new PointF(point1.X + t * dx, point1.Y + t * dy);
        t = (float)((-B - Math.Sqrt(det)) / (2 * A));
        intersection2 = new PointF(point1.X + t * dx, point1.Y + t * dy);
        return 2;
    }
}
*/