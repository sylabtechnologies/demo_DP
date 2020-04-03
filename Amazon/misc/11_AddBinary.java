/// https://leetcode.com/problems/add-binary/

package addbinary;

//#D s/b two reversed strings to prosperity

class Solution
{
    public String addBinary(String a, String b)
    {
        if (a.isEmpty() && b.isEmpty()) return new String();
        if (a.isEmpty() ) return new String(b);
        if (b.isEmpty() ) return new String(a);
        
        StringBuilder one = new StringBuilder(a); one.reverse();
        StringBuilder two = new StringBuilder(b); two.reverse();
        
        int i1 = 0, i2 = 0, carry = 0;
        int len1 = one.length(), len2 = two.length();
        StringBuilder res = new StringBuilder();
        while (i1 < len1 || i2 < len2)
        {
            int d1 = ( i1 < len1 ) ? (one.charAt(i1) - '0') : 0;
            int d2 = ( i2 < len2 ) ? (two.charAt(i2) - '0') : 0;
            int r1 = d1 + d2;
            
            switch(r1)
            {
                case 0:
                    r1 += carry; carry = 0; break;
                case 1:
                    if (carry == 0)
                    {
                        r1 += carry; carry = 0;
                    }
                    else
                    {
                        r1 = 0;
                    }
                    break;
                case 2:
                    if (carry == 0)
                    {
                        r1 = 0; carry = 1;
                    }
                    else
                    {
                        r1 = carry; r1 = 1;
                    }
                    break;
                default:
                    throw new IllegalArgumentException("bad binary");
            }
            
            res.insert(0, ((char) ('0' + r1)));
            i1++; i2++;
        }
        
        if (carry != 0)
            res.insert(0, ((char) ('0' + carry)));
        
        return res.toString();
    }
}

public class AddBinary
{
    public static void main(String[] args)
    {
        Solution sl = new Solution();
        System.out.println(sl.addBinary("11", "11"));
    }
    
}
