// https://leetcode.com/problems/excel-sheet-column-title/discuss/427650/Simple-CPP-which-beats-100

package excelcolname;

class Solution
{
    public String convertToTitle(int n)
    {
        if (n <= 0) return new String();

        StringBuilder sb = new StringBuilder();

        while (n > 0)
        {
            sb.append(convertToChar( (n - 1) % 26 ));
            n = (n - 1)/ 26;
        }

        return sb.reverse().toString();
    }
    
    private char convertToChar(int n)
    {
        if (n < 0 || n > 25) throw new IllegalArgumentException();

        return (char)(65 + n) ;
    }
    
}

public class ExcelColName
{

    public static void main(String[] args)
    {
        Solution sol = new Solution();
        System.out.println(sol.convertToTitle(52));
        System.out.println(sol.convertToTitle(26));
        System.out.println(sol.convertToTitle(701));
    }
    
}
