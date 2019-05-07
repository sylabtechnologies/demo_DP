/** https://www.hackerrank.com/challenges/play-game/problem
 */

package brickgame;
import java.util.*;

public class BrickGame
{
    private static final Scanner scanner = new Scanner(System.in);    

    private static int solve(int[] bricks)
    {
        // revert
        int[] totals = new int[bricks.length];
        for (int i = 0; i < bricks.length; i++)
            totals[i] = bricks[bricks.length - 1 - i];
        
        // sum
        int sofar = totals[0];
        for (int i = 1; i < totals.length; i++)
        {
            sofar += totals[i];
            totals[i] = sofar;
        }
        
        // DP
        int[] dpArray =  new int[bricks.length];
        dpArray[0] = totals[0];
        dpArray[1] = totals[1];
        dpArray[2] = totals[2];
        
        for (int i = 3; i < dpArray.length; i++)
        {
            int correction = Math.min(Math.min(dpArray[i-3], dpArray[i-2]), dpArray[i-1]);
            dpArray[i] = totals[i] - correction;
        }

        // System.out.println(Arrays.toString(dpArray));
        return dpArray[dpArray.length - 1];
    }
    
    public static void main(String[] args)
    {
        int[] bricks = {0, 1, 1, 1, 999};
        
        System.out.println(solve(bricks));
    }
    
}
