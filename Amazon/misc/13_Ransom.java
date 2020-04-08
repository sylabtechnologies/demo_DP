// https://leetcode.com/problems/ransom-note/

package ransom;

class Solution
{
    public boolean canConstruct(String ransomNote, String magazine)
    {
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        setFreq(ransomNote, arr1);
        setFreq(magazine, arr2);

        for (int i = 0; i < 26; i++)
            if (arr1[i] > arr2[i]) return false;
        
        return true;
    }
    
    private void setFreq(String str, int freq[])
    {
        if (freq.length != 26) throw new IllegalArgumentException("check inputs");
            
        for (char c : str.toCharArray())
        {
            freq[c - 'a']++;
        }
    }    
    
}

public class Ransom
{
    public static void main(String[] args)
    {
        System.out.println(new Solution().canConstruct("aa", "ab"));
    }
}
