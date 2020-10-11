package goog8;
import java.util.*;

class Result
{

/*
Given a binary string  of length , you can cyclically shift this string any number of times. For example, consecutively applying cyclic shift operation to the binary string "" you will get "", "" and so on.
Let  be the decimal representation of string . Find the greatest power of  with which  can be divisible with, if it can be divisible with arbitrarily large power print "".
For the result, you are required to print a single integer denoting the maximum power of  by which  can be divisible with.
For example if string "", we can cyclically shift  time to get string "" which in decimal is  and is divisible with , hence the answer is .
*/

    public static int maximumPower(String s)
    {
        int len = s.length();
        if (len == 0) return -1;
        if (len == 1) return (s.charAt(0) == '1') ? 0 : -1;
        
        int prefx = 0;
        for (int i = 0; i < len; i++)
        {
            if (s.charAt(i) == '0')
                prefx++;
            else
                break;
        }
        
        int suffx = 0;
        for (int i = len - 1; i >= prefx; i--)
        {
            if (s.charAt(i) == '0')
                suffx++;
            else
                break;
        }
        
        int max = prefx + suffx, curr = 0;
        if (max == len) return -1;
        
        for (int i = len - suffx - 1; i >= prefx; i--)
        {
            if (s.charAt(i) == '1')
                curr = 0;
            else
                curr++;
            
            max = Math.max(max, curr);
        }
        
        if (max == 0) return 0;
        
        return max;
    }

   public static int maximumStones(List<Integer> arr)
    {
        int odd = 0, even = 0;
        for (int i = 0; i < arr.size(); i++)
        {
            int n = arr.get(i);
            
            if ( (i + 1) % 2 == 1)
                odd += n;
            else
                even += n;
        }

        return Math.min(odd, even)*2;
    }    

/*
In a new numbers game, players are given aninteger array of length .
The players take turns, in each turn the current player does the following:
If a player can reorder the array elements to form a strictly increasing sequence, they win the game.
Otherwise the player can choose any element and remove it from the array.
Determine which player wins the game if both players play optimally and the first player plays first.
*/    
    
    public static String whoIsTheWinner(List<Integer> game)
    {
        Collections.sort(game);
        int len = game.size();
        if (len == 1) return "First";
        
        int prev = game.get(0), sameLen = 1;
        ArrayList<Integer> same = new ArrayList<>();
        for (int i = 1; i < len; i++)
        {
            int curr = game.get(i);
            if (curr > prev)
            {
                prev = curr;
                if (sameLen > 1)
                    same.add(sameLen);
                sameLen = 1;
            }
            else
                sameLen++;
        }
        
        if (sameLen > 1)
            same.add(sameLen);
        
        int total = 0;
        for (int ll : same)
            total += ll;
        
        if (total == 0) return "First";

        int diff = len - total;
        Boolean canwin = null;
        
        if (diff % 2 == 0)
        {
            for (int ll : same)
            {
                if (ll % 2 == 1)
                {
                    canwin = true;
                    break;
                }
                
                if (canwin == null)
                    canwin = false;
            }
        }
        else
        {
            for (int ll : same)
            {
                if (ll % 2 == 0)
                {
                    canwin = true;
                    break;
                }
                
                if (canwin == null)
                    canwin = false;
            }
        }

        return canwin ? "First" : "Second";
    }
}

public class Goog8
{
    
    public static void main(String[] args)
    {
        System.out.println(Result.whoIsTheWinner(Arrays.asList(1,2,3)));  
        System.out.println(Result.whoIsTheWinner(Arrays.asList(1,2,2,3)));  
    }
}
