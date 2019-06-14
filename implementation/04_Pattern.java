package gridsearch;
import java.util.*;

public class Pattern
{
    private int hash;
    final private int hashMax = 1000000;    // cover 0-999,999
    private int bufferHash;

    LinkedList<Integer> pattern;
    LinkedList<Integer>  buffer;

    public Pattern(final String ptrn, final String initial)
    {
        this.buffer = new LinkedList<>();
        this.pattern = new LinkedList<>();
        
        if (ptrn.length() != initial.length())
            throw new IllegalArgumentException();

        if (ptrn.isEmpty())
            throw new IllegalArgumentException();

        fill(pattern, ptrn);
        hash = getHash(pattern);

        fill(buffer, initial);
        bufferHash = getHash(buffer);
    }

    void rebuffer(String str)
    {
        buffer.clear();
        fill(buffer, str);
        bufferHash = getHash(buffer);
    }
    
    public void push(char c)
    {
        int intC = Integer.valueOf(c - '0');
        int delta = intC -  buffer.getFirst();

        buffer.add(intC);
        buffer.removeFirst();

        if (delta == 0) return;

        if (delta > 0)
        {
            bufferHash += delta;
            if (bufferHash >= hashMax) bufferHash -= hashMax;
        }
        else
        {
            bufferHash += delta;
            if (bufferHash < 0) bufferHash = hashMax + bufferHash;
        }

    }

    public boolean found()
    {
        if (hash != bufferHash) return false;
        
        for (int i = 0; i < pattern.size(); i++)
        {
            if (pattern.get(i) != buffer.get(i)) return false;
        }

        return true;
    }

    private int getHash(LinkedList<Integer> lst)
    {
        long sum = 0;

        for (int i = 0; i < lst.size(); i++)
            sum += lst.get(i);

        return (int) sum % hashMax;
    }

    private void fill(List<Integer> lst, String str)
    {
        for (int i = 0; i < str.length(); i++)
            lst.add(Integer.valueOf(str.charAt(i)) - '0');
    }
   
    
}
