// https://leetcode.com/problems/group-anagrams

package groupanagrams;
import java.util.*;

class Solution
{
    public List<List<String>> groupAnagrams(String[] strs)
    {
        MultiMap<String, String> map = new MultiMap<>();
        
        for (String str : strs)
        {
            String key = getKey(str);
            map.put(key, str);
        }

        List<List<String>> result = new ArrayList<>();
        ArrayList<String> keys = map.getKeys(false);
        for (String key : keys)
        {
            ArrayList<String> row = new ArrayList<>();
            row.addAll(map.getRow(key));
            result.add(row);
        }

        return result;
    }
    
    private String getKey(String str)
    {
        int[] arr = new int[26];
        for (char c : str.toCharArray())
        {
            arr[c - 'a']++;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++)
        {
            char cc = (char)('a' + i);

            while (arr[i] > 0)
            {
                sb.append(cc);
                arr[i]--;
            }
        }
        return sb.toString();
    }    
    
}


public class GroupAnagrams
{
    public static void main(String[] args)
    {
        String arr[] = { "eat", "tea", "tan", "ate", "nat", "bat" };
        System.out.println(new Solution().groupAnagrams(arr));
    }
    
}
