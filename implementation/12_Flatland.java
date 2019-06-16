/**
 * make it DP
 * https://www.hackerrank.com/challenges/flatland-space-stations/editorial
 * 
 */

package flatland;
import java.util.*;

public class Flatland
{
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args)
    {
        String[] nt = scanner.nextLine().split(" ");
        int cities  = Integer.parseInt(nt[0]);
        int stations = Integer.parseInt(nt[1]);

        int[] map = new int[cities];
        int[] distanceMap = new int[cities];    // distance to nearest space station
        
        int leftNearest = cities + 1;
        int rightNearest = -1;
        int maxDistance  = 0;        
        
        for (int i = 0; i < stations; i++)
        {
            int station = scanner.nextInt();
            map[station] = 1;
            
            if (station > rightNearest) rightNearest = station;
            if (station < leftNearest) leftNearest = station;
        }

        for(int i = 0; i < cities; i++)
        {
            if(map[i] == 1)
            {
                distanceMap[i] = 0;
                leftNearest = i;
            }
            else
            {
                if(i > leftNearest)
                    distanceMap[i] = i - leftNearest;
                else
                    distanceMap[i] = cities + 1;
            }
        }        
        
        for(int i = cities - 1; i >= 0; i--)
        {
            if(map[i] == 1)
                rightNearest = i;
            else if(rightNearest > i)
                    distanceMap[i] = (distanceMap[i] > rightNearest - i) ? rightNearest - i : distanceMap[i];
            
            maxDistance = (distanceMap[i] > maxDistance) ? distanceMap[i] : maxDistance;
        }
        
        System.out.println(maxDistance);
        
    }
    
}
