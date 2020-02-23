// https://leetcode.com/problems/validate-binary-tree-nodes/

package validtree;
import java.util.*;

class Solution
{
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild)
    {
        Queue<Integer> bfs = new LinkedList<>();
        bfs.add(0);
        boolean[] visited = new boolean[n];
        int count = 0;
        
        while (!bfs.isEmpty())
        {
            //System.out.println(bfs);
            //System.out.println(Arrays.toString(visited));

            int node = bfs.poll();
            if (visited[node])
                return false;
            else
            {
                visited[node] = true;
                count++;
            }

            if (leftChild[node] != -1)
            {
                int newNode = leftChild[node];
                if (newNode == 0) return false;
                bfs.add(newNode);
            }
            
            if (rightChild[node] != -1)
            {
                int newNode = rightChild[node];
                if (newNode == 0) return false;
                bfs.add(newNode);
            }
        }
        
        if (visited.length != count) return false;

        //System.out.println(Arrays.toString(visited));
        
        return true;
    }
}


public class ValidTree
{

    public static void main(String[] args)
    {
        int n = 4;
        int[] leftChild = {1,-1,3,-1}, rightChild = {2,-1,-1,-1};
//        int[] leftChild = {1,-1,3,-1}, rightChild = {2,3,-1,-1};
        
        Solution sol = new Solution();
        System.out.println(sol.validateBinaryTreeNodes(n, leftChild, rightChild));
    }
    
}

            
/*            
                if (node == -2) return false;
                root.addLeft(i);
                leftChild[i] = -2;
            }
            
            if (rightChild[i] != -1)
            {
                if (rightChild[i] == -2) return false;
                root.addRight(i);
                rightChild[i] = -2;
            }
*/  
