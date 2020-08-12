// segment = https://leetcode.com/problems/range-sum-query-mutable/solution/

class NumArray
{
    private int origSums[];
    private BinaryIndexedTree correct;
    private int myNums[];
    
    public NumArray(int[] nums)
    {
        int len = nums.length;
        myNums = Arrays.copyOf(nums, len);

        origSums = Arrays.copyOf(nums, len);
        for (int i = 1; i < len; i++)
            origSums[i] += origSums[i-1];
        
        correct = new BinaryIndexedTree(len);
    }
    
    public void update(int i, int val)
    {
        int delta = val - myNums[i];
        myNums[i] = val;
        correct.update(i, delta);
    }
    
    public int sumRange(int i, int j)
    {
        int prevSum = 0;
        if (i > 0)
            prevSum = origSums[i - 1] + correct.prefixSum(i - 1);
        
        return origSums[j] + correct.prefixSum(j) - prevSum;
    }
}

class BinaryIndexedTree
{
    private int[] BITree;
    private int n;

    BinaryIndexedTree(int len)
    {
        // init all zeros by Java's default
        n = len;
        BITree = new int[len + 1];
    }

    void update(int index, int val)
    {
        index = index + 1; 
      
        while(index <= n) 
        { 
            BITree[index] += val; 
            index += index & (-index); 
        }
        
        // System.out.println(Arrays.toString(BITree));
    }

    int prefixSum(int index)
    {
        int sum = 0;
        index = index + 1; 
      
        while(index > 0) 
        { 
            sum += BITree[index]; 
            index -= index & (-index); 
        }
        
        return sum;         
    }
}

