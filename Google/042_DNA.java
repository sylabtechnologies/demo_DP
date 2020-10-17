// https://leetcode.com/problems/repeated-dna-sequences/
class Solution
{
    private static final int DNALEN = 10;
    private static final int powered = (int) Math.pow(4.0, DNALEN  - 1);
    private final int register[];
    private static final HashMap<Character, Integer> converter;
    static
    {
        converter = new HashMap<>();
        converter.put('A', 0);
        converter.put('C', 1);
        converter.put('G', 2);
        converter.put('T', 3);
    }

    Solution()
    {
        this.register  = new int[powered*4];
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
            hash += converter.get(carr[i]);
        }
        
        return hash;
    }

    private int moveHash(char[] carr, int hash, int start)
    {
        char prevC = carr[start - 1];
        char nextC = carr[start + DNALEN - 1];
        
        int val1 = converter.get(prevC);
        int val2 = converter.get(nextC);

        if (val1 != 0)
            hash = hash % (val1*powered);
        
        hash *= 4;
        hash += val2;
        return hash;
    }
}
