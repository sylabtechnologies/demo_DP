package seats;

import java.util.Arrays;

class Solution
{
    private static final int MYMOD = 10000003;

    public int seats(String str)
    {
        str = trim(str);

        if (str.isEmpty()) return 0;

        int jumps = 0, len = str.length();
        if (len % 2 == 0)
        {
            char left[] = readStr(str.substring(0, len/2), true);
            jumps = process(left);

            char rght[] = readStr(str.substring(len/2), false);
            jumps += process(rght);
        }
        else
        {
            char left[] = readStr(str.substring(0, len/2), true);
            char rght[] = readStr(str.substring(len/2), false);
            int jump1 = process(left) + process(rght);

            left = readStr(str.substring(0, len/2 + 1), true);
            rght = readStr(str.substring(len/2 + 1), false);
            int jump2 = process(left) + process(rght);
            jumps = Math.min(jump1, jump2);
        }

        return jumps;
    }

    private int process(char[] arr)
    {
        int jumps = 0;
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] != '.') continue;

            boolean found = false;
            for (int j = i + 1; j < arr.length; j++)
            {
                if (arr[j] != 'x') continue;

                found = true;
                jumps += j - i;
                arr[j] = '.';
                break;
            }

            if (!found) break;
        }

        return jumps;
    }


    private char[] readStr(String str, boolean reverse)
    {
        char seats[] = str.toCharArray();

        if (reverse)
        {
            int i = 0, j = seats.length - 1;
            while (i < j)
            {
                char temp = seats[i];
                seats[i] = seats[j];
                seats[j] = temp;
                i++; j--;
            }
        }

        return seats;
    }

    private String trim(String str)
    {
        int i = 0;
        for (; i < str.length(); i++)
            if (str.charAt(i) != '.') break;

        int j = str.length() - 1;
        for (; j >= 0; j--)
            if (str.charAt(j) != '.') break;

        return (i >= j) ? new String() : str.substring(i, j + 1);
    }

}

public class Seats
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().seats("x.x.xx.x.xxx.......x..x.xxx..x.xxx"));
    }
}
