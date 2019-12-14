package haystack;

public class Haystack
{
    public static int simpleHash(String test)
    {
        int hash = 0;
        for (int i = 0; i < test.length(); i++)
            hash += (int) test.charAt(i);
        return hash;
    }
    
    public static int strStr(String haystack, String needle)
    {
        if (needle.length() == 0) return 0;
        if (needle.length() > haystack.length()) return -1;
        if (needle.length() == haystack.length())
            return (needle.equals(haystack)) ? 0 : -1;
        
        int len = needle.length();
        int find = simpleHash(needle);
        int hash = simpleHash(haystack.substring(0, len));
        if (hash == find && needle.equals(haystack.substring(0, len)))
            return 0;
        
        for (int i = 0; i < haystack.length(); i++) {
            System.out.print(haystack.charAt(i) +  "  ");
            System.out.println(((int)(haystack.charAt(i))));
        }

        for (int i = 1; i < haystack.length() - len + 1; i++)
        {
            hash = hash - ((int)(haystack.charAt(i-1)));
            hash = hash + ((int)(haystack.charAt(i + len - 1)));
            if (hash == find && needle.equals(haystack.substring(i, i + len)))
                return i;
        }
                
        return -1;
    }
    
    public static void main(String[] args)
    {
        System.out.println(strStr("mississippi", "pi"));
    }
    
}
