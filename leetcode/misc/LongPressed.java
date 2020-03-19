/*
https://leetcode.com/problems/long-pressed-name/

make LinkedList nameList, typedList

*/

class Solution
{
    public boolean isLongPressedName(String name, String typed)
    {
        if (name.equals(typed)) return true;
        
        if (name.length() == 0 && typed.length() == 0) return true;
        if (name.length() == 0 || typed.length() == 0) return false;
        
        char c = name.charAt(0);
        if (typed.charAt(0) != c) return false;

        if (name.length() > 1 && typed.length() > 1)
        {
            if (typed.charAt(1) == name.charAt(1))
                return isLongPressedName(name.substring(1), typed.substring(1));
        }

        int delChar = 1;
        if (typed.length() > 1)
        {
            while (typed.charAt(delChar) == c)
            {
                delChar++;
                if (delChar == typed.length()) break;
            }
        }
        
        return isLongPressedName(name.substring(1), typed.substring(delChar));
    }
}
