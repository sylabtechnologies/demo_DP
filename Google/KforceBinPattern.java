package kforce1;
import java.util.*;

public class Kforce1
{
    static int binaryPatternMatching(String pattern, String str)
    {
        Character vow[] = {'a', 'e', 'i', 'o', 'u', 'y'};
        HashSet<Character> vowels = new HashSet<>();
        vowels.addAll(Arrays.asList(vow));
        
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray())
        {
            if (vowels.contains(c))
                sb.append('0');
            else
                sb.append('1');
        }
        
        int cnt = 0;
        while (sb.length() > 0)
        {
            int ix = sb.indexOf(pattern);
            if (ix < 0) break;
            
            cnt++;
            if (ix > 0)
                sb.replace(0, ix + 1, "");
            else
                sb.deleteCharAt(0);
        }
                
        return cnt;
    }
    
    public static void main(String[] args)
    {
        System.out.println(binaryPatternMatching("010", "amazing"));
        
    }
}
