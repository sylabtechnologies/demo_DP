package goog30;
import java.util.*;

// https://leetcode.com/problems/additive-number/
// #S := tail z
class Solution
{
    public boolean isAdditiveNumber(String num)
    {
        final int len = num.length();
        if (len < 3) return false;
        if (num.equals(repeatChar('0', len))) return true;
        
        for (int i = len - 1; i >= len/2; i--)
        {
            long tail = Long.parseLong(num.substring(i));
            if (tail > 0 && num.charAt(i) == '0') continue;
            if (help(num, i, tail, len - i)) return true;
        }
        
        return false;
    }

    private boolean help(String num, int end, long z, int zlen)
    {
        for (int len = 1; end - len >= 0 && len <= zlen; len++)
        {
            long y = Long.parseLong(num.substring(end - len, end));
            if (y > 0 && num.charAt(end - len) == '0') continue;
            
            String x = Long.toString(z - y);
            if (x.length() > 1 && x.charAt(0) == 0) continue;
            
            int xstart = end - len - x.length();
            if (xstart < 0) break;
            if (xstart == 0 && num.substring(0, x.length()).equals(x)) return true;

            if (num.substring(xstart, end - len).equals(x))
            {
                if (help(num, end - len, y, len)) return true;
            }
        }
        
        return false;
    }

    private String repeatChar(char c, int length)
    {
        char rep[] = new char[length];
        Arrays.fill(rep, '0');
        return new String(rep);
    }
}

public class Goog30
{
    public static void main(String[] args)
    {
        String test[] = 
        {
            "121474836472147483648", 
        };
        
        
        for (String s : test)
            System.out.println(new Solution().isAdditiveNumber(s));

//        System.out.println(getParamsTypes(Solution.class));

          
    }

    // https://stackoverflow.com/questions/21455403/how-to-get-method-parameter-names-in-java-8-using-reflection
    // ret on first pucling method
    private static ArrayList<String> getParamsTypes(Class<?> cls)
    {
        ArrayList<String> ret = new ArrayList<>();
        
        for (Method m : cls.getDeclaredMethods())
        {
            if (m.getModifiers() != 1) continue;
            
            for (Class<?> type : m.getParameterTypes())
                ret.add(type.getCanonicalName());
            
            break;
        }
        
        return ret;
    }
}
