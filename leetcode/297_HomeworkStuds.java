// https://leetcode.com/problems/number-of-students-doing-homework-at-a-given-time/

package homeworkstuds;
import java.util.*;

class Solution
{
    public int busyStudent(int[] startTime, int[] endTime, int queryTime)
    {
        MultiMap<Integer, Integer> events = new MultiMap<>();
        for (int t : startTime)
            events.put(t, 1);
        
        for (int t : endTime)
            events.put(t, -1);

        int count = 0;
        ArrayList<Integer> keys = events.getKeys(true);
        for (Integer time : keys)
        {
            ArrayList<Integer> row = events.getRow(time);
            int add = 0, delete = 0;
            for (Integer incr : row)
            {
                if (incr > 0)
                    add++;
                else
                    delete++;
            }
            
            if (time == queryTime)
            {
                count += add;
                break;
            }
            else if (time > queryTime)
                break;
            
            count += add - delete;
        }

        return count;
    }
}

public class HomeworkStuds
{
    public static void main(String[] args)
    {
//        int startTime[] = {64,80}, endTime[] = {86,93}, queryTime = 42;
//        int startTime[] = {1,2,3}, endTime[] = {3,2,7}, queryTime = 4;
//        int startTime[] = {9,8,7,6,5,4,3,2,1}, endTime[] = {10,10,10,10,10,10,10,10,10}, queryTime = 5;
        int startTime[] = {61,74,11,54}, endTime[] = {61,75,65,92}, queryTime = 75;
        System.out.println(new Solution().busyStudent(startTime, endTime, queryTime));
    }
    
}
