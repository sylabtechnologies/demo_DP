package servicelane;
import java.io.*;
import java.util.*;

public class ServiceLane
{
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException
    {
        String[] nt = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nt[0]);
        int t = Integer.parseInt(nt[1]);

        int[] width = new int[n];

        String[] widthItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int widthItem = Integer.parseInt(widthItems[i]);
            width[i] = widthItem;
        }

        int[][] cases = new int[t][2];
        for (int i = 0; i < t; i++) {
            String[] casesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int casesItem = Integer.parseInt(casesRowItems[j]);
                cases[i][j] = casesItem;
            }
        }

        scanner.close();
        
        for (int i = 0; i < t; i++)
        {
            int start = cases[i][0];
            int finsh = cases[i][1];
            
            int vehicle = 3;
            
            while (start <= finsh)
            {
                if (vehicle > width[start])
                    vehicle = width[start];
                
                start++;
            }
            
            System.out.println(vehicle);
        }
        
    }
    
}
