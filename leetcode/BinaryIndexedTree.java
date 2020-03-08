// https://www.geeksforgeeks.org/binary-indexed-tree-or-fenwick-tree-2/
// https://www.careercup.com/question?id=5668664122540032
package SwitchBulbs3;
// import java.util.Arrays;

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
