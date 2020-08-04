// https://leetcode.com/problems/find-the-winner-of-an-array-game/
package gamea;
import java.util.*;

class Solution
{
    public int getWinner(int[] arr, int k)
    {
        int winner = arr[0], winCnt = 0, max = winner;
        LinkedList<Integer> lst = new LinkedList<>();

        for (int i = 1; i < arr.length; i++)
        {
            lst.add(arr[i]);
            max = Math.max(arr[i], max);
        }
        
        if (k >= arr.length) return max;
        
        for (int i = 0; i < 2*arr.length + 1; i++)
        {
            int next = lst.removeFirst();
            
            if (winner > next)
            {
                lst.addLast(next);
                winCnt++;
            }
            else
            {
                winCnt = 1;
                lst.addLast(winner);
                winner = next;
            }

            if (winCnt == k) return winner;
        }

        return -1;
    }
}

public class GameA
{
    public static void main(String[] args)
    {
        int arr[] = {1,25,35,42,68,70};
        System.out.println(new Solution().getWinner(arr, 4));
    }
    
}
