// https://www.interviewbit.com/problems/knight-on-chess-board/

package knight;
import java.util.*;

class Solution
{
    public int knight(int sizeX, int sizeY, int startX, int startY, int endX, int endY)
    {
        startX--; startY--; endX--; endY--;
        
        Queue<Point> q = new LinkedList<>();
        Point start = new Point(startX, startY);
        q.offer(start);
        
        boolean visited[][] = new boolean[sizeX][sizeY];
        int count[][] = new int[sizeX][sizeY];
            
        while (!q.isEmpty())
        {
            Point p = q.poll();
            if (visited[p.x][p.y]) continue;
            
            visited[p.x][p.y] = true;            
            int currCnt = count[p.x][p.y];
            if (p.x == endX && p.y == endY)
                return currCnt;
            
            ArrayList<Point> next = getMoves(sizeX, sizeY, p);
            for (Point pt : next)
            {
                q.add(pt);
                count[pt.x][pt.y] = currCnt + 1;
            }
        }
        
        return -1;
    }

    private ArrayList<Point> getMoves(int sizeX, int sizeY, Point start)
    {
        ArrayList<Point> candidate = new ArrayList<>();
        candidate.add(new Point(start.x - 1, start.y + 2));
        candidate.add(new Point(start.x + 1, start.y + 2));
        candidate.add(new Point(start.x - 1, start.y - 2));
        candidate.add(new Point(start.x + 1, start.y - 2));
        candidate.add(new Point(start.x + 2, start.y - 1));
        candidate.add(new Point(start.x + 2, start.y + 1));
        candidate.add(new Point(start.x - 2, start.y + 1));
        candidate.add(new Point(start.x - 2, start.y - 1));
        
        ArrayList<Point> res = new ArrayList<>();
        for (Point pt : candidate)
        {
            if (pt.x < 0 || pt.x >= sizeX) continue;
            if (pt.y < 0 || pt.y>= sizeY) continue;
            
            res.add(pt);
        }
        
        return res;
    }

    private static class Point
    {
        int x, y;
        public Point(int x, int y) {this.x = x; this.y = y; }
    }
}

public class Knight
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().knight(2, 20, 1, 18, 1, 5));
    }
}
