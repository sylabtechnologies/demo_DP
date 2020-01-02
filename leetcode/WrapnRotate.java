/// https://leetcode.com/problems/rotate-string/submissions/

package rotatestring;
import java.util.*;

/**
 * subclass to get great mileage, cool to overwrite
 * b/c  collections will use ok too
 * 
 * mycharlist is list<char>
 */

class MyCharList extends AbstractList<Character>
{
    char[] data;

    public int size() { return data.length; }
    public MyCharList(String data) { this.data = data.toCharArray(); }
    public Character get(int index) { return data[index]; }

    public Character set(int index, Character element)
    {
        char r = data[index];
        data[index] = element;
        return r;
    }
}

class Solution
{
    public boolean rotateString(String A, String B)
    {
        int len = A.length();
        if (len != B.length()) return false;
        
        if (len == 0) return true;
        
        List<Character> lst1 = new MyCharList(A);
        List<Character> lst2 = new MyCharList(B);
        
        for (int i = 0; i < len - 1; i++)
        {
            if (lst1.equals(lst2)) return true;
            Collections.rotate(lst1, 1);
        }
        
        return false;
    }
}
