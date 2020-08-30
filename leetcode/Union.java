package largestcomponent;
import java.util.*;

class Union
{
    private Map<Integer,Integer> parent;

    Union()
    {
        parent = new HashMap<>();
    }

    public int findParent(int i)
    {
        if (parent.get(i) == null) parent.put(i,i);
        while (i != parent.get(i)) i = parent.get(i);
        return i;
    }

    public void makeUnion(int n, int m)
    {
        int findN = findParent(n);
        int findM = findParent(m);
        if (findN < findM)
            parent.put(findM,findN);
        else
            parent.put(findN,findM);
    }
}
