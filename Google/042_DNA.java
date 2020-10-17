// https://leetcode.com/problems/repeated-dna-sequences/ = RK
class Solution
{
    private static final int DNALEN = 10;
    private static final int powered = (int) Math.pow(4.0, DNALEN  - 1);
    private static final HashMap<Character, Integer> converter;
    static
    {
        converter = new HashMap<>();
        converter.put('A', 0);
        converter.put('C', 1);
        converter.put('G', 2);
        converter.put('T', 3);
    }

    private final int register[];
    private int[] myCodes;
    
    Solution()
    {
        this.register  = new int[powered*4];
    }
    
    public List<String> findRepeatedDnaSequences(String s)
    {
        List<String> ans = new ArrayList<>();
        if (s.length() < DNALEN) return ans;
                
        myCodes = new int[s.length()];
        for (int i = 0; i < myCodes.length; i++)
            myCodes[i] = converter.get(s.charAt(i));
        
        int hash = getHash(myCodes, 0);
        register[hash] = 1;
        
        for (int curr = 1; curr + DNALEN <= s.length(); curr++)
        {
            hash = moveHash(myCodes, hash, curr);
            
            if (register[hash] == 1)
                ans.add(s.substring(curr, curr + DNALEN));
            
            register[hash]++;
        }
    
        return ans;
    }

    private int getHash(int[] carr, int start)
    {
        int hash = 0;
        for (int i = start; i < DNALEN; i++)
        {
            hash *= 4;
            hash += carr[i];
        }
        
        return hash;
    }

    private int moveHash(int[] carr, int hash, int start)
    {
        int val1 = carr[start - 1];
        int val2 = carr[start + DNALEN - 1];

        if (val1 != 0)
            hash = hash % (val1*powered);
        
        hash *= 4;
        hash += val2;
        return hash;
    }
}
