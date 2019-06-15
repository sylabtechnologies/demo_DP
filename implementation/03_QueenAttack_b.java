/**
 * https://www.hackerrank.com/challenges/queens-attack-2/problem
 * 
 * * * encap2p
 * 
 */

package queenattack;
import static toolz.Util.readFile;
import java.util.*;

enum DirectionType {UP, UPRIGHT, RIGHT, DOWNRIGHT, DOWN, DOWNLEFT, LEFT, UPLEFT };

class Direction
{
    public static int startX;
    public static int startY;
    public static int boardSize;
 
    private DirectionType dirType;
    private int deltaX;
    private int deltaY;
    private int minDistance;

    public Direction(DirectionType dt, int x, int y)
    {
        if (Math.abs(x) > 1 || Math.abs(x) > 1)
            throw new IllegalArgumentException();

        if (x == 0 && y == 0)
            throw new IllegalArgumentException();

        dirType =  dt;
        deltaX = x;
        deltaY = y;
        
        switch (dirType)
        {
            case UP:
                minDistance = boardSize - startY;
                break;
                
            case DOWN:
                minDistance = startY;
                break;

            case RIGHT:
                minDistance = boardSize - startX;
                break;

            case LEFT:
                minDistance = startX;
                break;

            case UPRIGHT:
                minDistance = Math.min(boardSize - startX, boardSize - startY);
                break;
                
            case DOWNRIGHT:
                minDistance = Math.min(startY, boardSize - startX);
                break;

            case DOWNLEFT:
                minDistance = Math.min(startX, startY);
                break;

            case UPLEFT:
                minDistance = Math.min(startX, boardSize - startY);
                break;
                
            default:
                throw new IllegalArgumentException();
        }

        
    }

    public boolean isConnected(int x, int y)
    {
        switch (dirType)
        {
            case UP:
                if (startX != x) return false;
                if (startY > y) return false;
                break;
                
            case DOWN:
                if (startX != x) return false;
                if (startY < y) return false;
                break;

            case RIGHT:
                if (startY != y) return false;
                if (startX > x) return false;
                break;

            case LEFT:
                if (startY != y) return false;
                if (startX < x) return false;
                break;

            case UPRIGHT:
                if (startY >= y) return false;
                if (startX >= x) return false;
                if (x - startX != y - startY) return false;
                break;
                
            case DOWNRIGHT:
                if (startY <= y) return false;
                if (startX >= x) return false;
                if (startX - x != y - startY) return false;
                break;

            case DOWNLEFT:
                if (startY <= y) return false;
                if (startX <= x) return false;
                if (startX - x != startY - y) return false;
                break;

            case UPLEFT:
                if (startY >= y) return false;
                if (startX <= x) return false;
                if (startX - x != y - startY) return false;
                break;
                
            default:
                throw new IllegalArgumentException();
        }

        return true;
        
    }

    public int getMinDistance()
    {
        return minDistance;
    }

    public DirectionType getDirType()
    {
        return dirType;
    }
    
    void resetMin(int x, int y)
    {
        int distance = 0;
        
        switch (dirType)
        {
            case UP:
                distance = y - startY - 1;
                break;
                
            case DOWN:
                distance = startY - y - 1;
                break;

            case RIGHT:
                distance = x - startX - 1;
                break;

            case LEFT:
                distance = startX - x - 1;
                break;

            case UPRIGHT:
                distance = Math.min(x - startX - 1, y - startY - 1);
                break;
                
            case DOWNRIGHT:
                distance = Math.min(x - startX - 1, startY - y - 1);
                break;

            case DOWNLEFT:
                distance = Math.min(startX - x - 1, startY - y - 1);
                break;

            case UPLEFT:
                distance = Math.min(startX - x - 1, y - startY - 1);
                break;
                
            default:
                throw new IllegalArgumentException();
        }
        
        if (distance < minDistance) minDistance = distance;
    }
    
}


public class QueenAttack
{
    
    public static void main(String[] args)
    {

        List<String> myInput = toolz.Util.readFile("C:\\Users\\Dennis\\Desktop\\tempo.txt");
        
        int[][] obstacles = new int[myInput.size()][2];
        
        for (int i = 0; i < myInput.size(); i++)
        {
            String[] str = myInput.get(i).split(" ");
            
            obstacles[i][0] = Integer.valueOf(str[0]);
            obstacles[i][1] = Integer.valueOf(str[1]);
        }
        
        int ans = queensAttack(100, 100, 48, 81, obstacles);
        System.out.println(ans);
        
        
    }
    
    
    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles)
    {
        Direction.startX = c_q - 1;
        Direction.startY = r_q - 1;
        Direction.boardSize = n - 1;

        ArrayList<Direction> dir = new ArrayList<>();
        
        Direction dd = new Direction(DirectionType.UP, 0, 1);
        if (dd.getMinDistance() > 0) dir.add(dd);
        dd = new Direction(DirectionType.UPRIGHT, 1, 1);
        if (dd.getMinDistance() > 0) dir.add(dd);
        dd = new Direction(DirectionType.RIGHT, 1, 0);
        if (dd.getMinDistance() > 0) dir.add(dd);
        dd = new Direction(DirectionType.DOWNRIGHT, 1, -1);
        if (dd.getMinDistance() > 0) dir.add(dd);
        dd = new Direction(DirectionType.DOWN, 0, -1);
        if (dd.getMinDistance() > 0) dir.add(dd);
        dd = new Direction(DirectionType.DOWNLEFT, -1, -1);
        if (dd.getMinDistance() > 0) dir.add(dd);
        dd = new Direction(DirectionType.LEFT, -1, 0);
        if (dd.getMinDistance() > 0) dir.add(dd);
        dd = new Direction(DirectionType.UPLEFT, -1, 1);
        if (dd.getMinDistance() > 0) dir.add(dd);
        
        if (k > 0)
            for (int i = 0; i < k; i++)
            {
                int y = obstacles[i][0] - 1;
                int x = obstacles[i][1] - 1;

                for (Direction d : dir)
                {
                    // System.out.println(d.getDirType() + " " + d.getMinDistance());

                    if (d.isConnected(x, y))
                        d.resetMin(x, y);
                }
            }
        
        return canAttack(dir);

    }

    private static int findMin(ArrayList<Direction> dir)
    {
        int min = 1000000000;
        for (Direction d : dir)
        {
            if (d.getMinDistance() < min) min = d.getMinDistance();
        }
        
        return min;
    }

    private static int canAttack(ArrayList<Direction> dir)
    {
        int sum = 0;
        for (Direction d : dir)
        {
            System.out.println(d.getDirType() + " " + d.getMinDistance());
            
            sum += d.getMinDistance();
        }
        
        return sum;
    }
   
    
}
