// https://leetcode.com/problems/create-sorted-array-through-instructions/
class Solution
{
    public int createSortedArray(int[] instructions)
    {
        final int mod = (int) 1e9 + 7;
        
        int res = 0;
        BinaryIndexedTree bit = new BinaryIndexedTree(100001);
        for (int i = 0; i < instructions.length; i++)
        {
            int ins = instructions[i];
            int left = bit.prefixSum(ins - 1);
            int rght = i - bit.prefixSum(ins);
            res += Math.min(left, rght);
            res = res % mod;
            
            bit.update(ins, 1);
        }
        
        return res;
    }
}
