// https://leetcode.com/problems/letter-case-permutation/
package lettercase;
import java.util.*;

class Solution
{
    public List<String> letterCasePermutation(String str)
    {
        List<String> resList = new ArrayList<>();
        char mychars[] = str.toCharArray();
        
        int count = 0;
        ArrayList<Integer> indices = new ArrayList<>();
        for (char c : mychars)
        {
            if (Character.isAlphabetic(c))
                indices.add(count);
            count++;
        }
       
        Subsets indList = new Subsets(indices);
        for (List<Integer> lst : indList.listOfSubsets)
        {
            if (lst.isEmpty())
            {
                resList.add(str); continue;
            }
            
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mychars.length; i++)
            {
                if (lst.contains(i))
                {
                    char c = mychars[i];
                    c = (Character.isLowerCase(c)) ? Character.toUpperCase(c) : Character.toLowerCase(c);
                    sb.append(c); continue;
                }
                else
                    sb.append(mychars[i]);
            }
                
            resList.add(sb.toString());
        }

        return resList;
    }
}


public class LetterCase
{
    public static void main(String[] args)
    {
        String test = "mQe";
        List<String> res = new Solution().letterCasePermutation(test);
        Collections.sort(res);
        System.out.println(res);
    }
    
}
