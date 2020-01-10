package onetwothree;
import java.util.*;

public class RUtil
{
    public static List<Integer> getRandomList()
    {
        List<Integer> num = new ArrayList<>();
        
        for (int i = 0; i < 20; i++)
            num.add((int) Math.ceil(Math.random() * 3));

        Set<Integer> check = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        
        for (Integer n : num)
        {
            if (!check.contains(n))
            {
                check.add(n);
                res.add(n);
            }
        }
        
        return res;
    }
}
