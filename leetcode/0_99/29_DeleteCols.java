// https://leetcode.com/problems/delete-columns-to-make-sorted/
// do BFS

package deletecols;

public class DeleteCols
{

    public static void main(String[] args)
    {
        String[] A = { "abcdef","uvwxyz" };
        // String[] A = { "cba", "daf", "ghi" };
        System.out.println(minDeletionSize(A));
    }

    static int minDeletionSize(String[] A)
    {
        if (A.length < 2) return 0;
        
        int len = A[0].length();
        int ans = 0;
        boolean[] visited = new boolean[len];
        
        for (int i = 1; i < A.length; i++)
        {
            if (len != A[i].length())
                throw new IllegalArgumentException();
            
            for (int j = 0; j < len; j++)
            {
                if (visited[j]) continue;
                
                if (A[i-1].charAt(j) > A[i].charAt(j))
                {
                    visited[j] = true;
                    ans++;
                }
            }
        }
        
        return ans;
    }
    
}
