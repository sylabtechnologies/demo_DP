package goog43;
import java.util.List;

public class IntListComparator implements Comparator<List<Integer>>
{
    @Override
    public int compare(List<Integer> l1, List<Integer> l2) 
    {
        if (l1.size() != l2.size())
            return Integer.compare(l1.size(), l2.size());

        for (int i = 0; i < l1.size(); i++) 
        {
            if (l1.get(i) != l2.get(i))
                return Integer.compare(l1.get(i), l2.get(i));
        }

        return 0;                
    }
}

