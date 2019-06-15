/**
 * https://www.hackerrank.com/challenges/lisa-workbook/problem
 * 
 * carry out traversing
 * 
 */
package workbook;

public class Workbook
{
    static int workbook(int n, int k, int[] arr)
    {
        int page = 0;
        int count = 0;
        
        for (int i = 0; i < n; i++)
        {
            
            int problemNo = 0;
            
            while (problemNo < arr[i])
            {
                
                int lastProblem = (problemNo + k) <= arr[i] ? (problemNo + k) : arr[i];
                        
                if (problemNo <= page && page < lastProblem)
                {
                    count++;
//                    System.out.println("special problem "  + count);
                }
                
                problemNo += k;
                
                page++;
            }
            
        }
        
        return count;
    }

    public static void main(String[] args)
    {
        int[] arr = {4, 2};
        
        workbook(2, 3, arr);

    }
    
}
