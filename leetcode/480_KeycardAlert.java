// https://leetcode.com/problems/alert-using-same-key-card-three-or-more-times-in-a-one-hour-period/

package goog2;
import java.util.*;
import static java.time.temporal.ChronoUnit.MINUTES;
import java.time.LocalTime;

class Solution
{
    public List<String> alertNames(String[] keyName, String[] keyTime)
    {
        MultiMap<String, LocalTime> map = new MultiMap<>();
        for (int i = 0; i < keyTime.length; i++)
        {
            String name = keyName[i];
            String tt = keyTime[i];
            LocalTime time = LocalTime.parse(tt);
            map.put(name, time);
        }
        
        ArrayList<String> keys = map.getKeys(false);
        Set<String> res = new TreeSet<>();
        for (String key : keys)
        {
            ArrayList<LocalTime> row = map.getRow(key);
            if (row.size() < 3) continue;
            Collections.sort(row);
            for (int i = 0; i < row.size() - 2; i++)
            {
                LocalTime now = row.get(i);
                LocalTime nxt = row.get(i+2);

                if (MINUTES.between(now, nxt) <= 60)
                {
                    res.add(key); break;
                }
            }
        }

        return new ArrayList<String>(res);
    }    
}