package stringshift;

import java.util.LinkedList;

class Solution
{
    public String stringShift(String s, int[][] shift)
    {
        LinkedList<Character> lst = new LinkedList<>();
        for (char c : s.toCharArray())
            lst.add(c);
        
        for (int[] pait : shift)
            shift(lst, pait[0], pait[1]);

        StringBuilder sb = new StringBuilder();
        for (Character c : lst)
            sb.append(c);
        return sb.toString();
    }

    private void shift(LinkedList<Character> list, int direction, int numSteps)
    {
        if (direction == 1)
        {
            for (int i = 0; i < numSteps; i++)
            {
                Character c = list.removeLast();
                list.addFirst(c);
            }
            return;
        }
        
        if (direction == 0)
        {
            for (int i = 0; i < numSteps; i++)
            {
                Character c = list.removeFirst();
                list.addLast(c);
            }
        }
    }
}

public class StringShift
{
    public static void main(String[] args)
    {
        String str = "abcdefg";
        int test[][] = {{1, 1}, {1, 1}, {0, 2}, {1, 3}};
        System.out.println(new Solution().stringShift(str, test));  
    }
    
}
