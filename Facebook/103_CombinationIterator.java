// https://leetcode.com/problems/iterator-for-combination/
package comboiterator;
import java.util.ArrayList;

class CombinationIterator
{
    private ArrayList<String> combos = new ArrayList<>(1000);
    private int currPos = 0;
    private final int comboLen;
    
    public CombinationIterator(String str, int cLen)
    {
        comboLen = cLen;
        backtrack(combos, new StringBuilder(comboLen), str, 0);
    }
    
    public String next()
    {
        return combos.get(currPos++);
    }
    
    public boolean hasNext()
    {
        return currPos < combos.size();
    }

    private void backtrack(ArrayList<String> combos, StringBuilder sb, String str, int start)
    {
        if (sb.length() == comboLen)
        {
            combos.add(sb.toString());
            return;
        }
        
        for (int i = start; i < str.length(); i++)
        {
            char c = str.charAt(i);
            sb.append(c);
            backtrack(combos, sb, str, i + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

