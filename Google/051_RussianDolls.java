package dolls;
import java.util.*;

// https://leetcode.com/discuss/interview-question/856655/packaging-constraints-online-assessment-hackerrank
// seek until eliminating leetcode asteroids

class Result
{
    public static int findDolls(List<Integer> boxes)
    {
        int count = 0;
        PriorityQueue<Integer> q1 = new PriorityQueue<>(Collections.reverseOrder());
        q1.addAll(boxes);
        
        PriorityQueue<Integer> q2 = new PriorityQueue<>(Collections.reverseOrder());
        while (!q1.isEmpty())
        {
            int x = q1.poll();
            if(!q2.isEmpty())
            {
                int m = q2.peek();
                if(2*x <= m)
                {
                    q2.poll();
                    count++;
                }
                else
                    q2.add(x);
            }
            else
                q2.add(x);
            
            System.out.println(q1);
            System.out.println(q2);
        }
        
        return boxes.size() - count;
        
    }
}

public class Dolls
{
    public static void main(String[] args)
    {
        List<Integer> lst = Arrays.asList(9, 1, 6, 2, 6, 5, 8, 3 );
        System.out.println(Result.findDolls(lst));
    }
}
