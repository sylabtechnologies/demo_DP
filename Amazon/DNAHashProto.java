/// https://leetcode.com/problems/repeated-dna-sequences/

package repeatdna;
import java.util.*;

class Solution
{
    private static final int DNALEN = 10;
    private static final int powered = (int) Math.pow(4.0, DNALEN  - 1);
    private final int register[];
    private final int converter[];

    Solution()
    {
        this.register  = new int[powered*4];
        this.converter = new int[26];
        Arrays.fill(converter, -1);
        
        converter[0] = 0;
        converter['C' - 'A'] = 1;
        converter['G' - 'A'] = 2;
        converter['T' - 'A'] = 3;
    }
    
    public List<String> findRepeatedDnaSequences(String s)
    {
        List<String> ans = new ArrayList<>();
        if (s.length() < DNALEN) return ans;
                
        char[] carr = s.toCharArray();
        int hash = getHash(carr, 0);
        register[hash] = 1;
        
        for (int curr = 1; curr + DNALEN <= s.length(); curr++)
        {
            hash = moveHash(carr, hash, curr);
            
            if (register[hash] == 1)
                ans.add(s.substring(curr, curr + DNALEN));
            
            register[hash]++;
        }
    
        return ans;
    }

    private int getHash(char[] carr, int start)
    {
        int hash = 0;
        for (int i = start; i < DNALEN; i++)
        {
            hash *= 4;
            
            int ix = carr[i] - 'A';
            if (converter[ix] < 0)
                throw new IllegalArgumentException("hash");
            
            hash += converter[ix];
        }
        
        return hash;
    }

    private int moveHash(char[] carr, int hash, int start)
    {
        if (hash >= powered) hash -= powered;
        
        int ix = carr[start + DNALEN - 1] - 'A';
        if (converter[ix] < 0)
            throw new IllegalArgumentException("hash");

        hash *= 4;
        hash += converter[ix];
        return hash;
    }
}

public class RepeatDNA
{
    public static void main(String[] args)
    {
        String dna = "GAGAGAGAGAG";
        System.out.println(new Solution().findRepeatedDnaSequences(dna));
    }
}
