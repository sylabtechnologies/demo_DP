package goog18;
import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/* kforce by city/cntry count
ID,NAME,CITY,COUNTRY,CPERSON,EMPLCNT,CONTRCNT,CONTRCOST\n
00000001,Breadpot,Sydney,Australia,Sam.Keng@info.com,250,48,1024.00
00000002,Hoviz,Manchester,UK,harry.ham@hoviz.com,150,7,900.00
00000003,Hoviz,London,UK,hamlet.host@hoviz.com,1500,12800,10510.50
00000004,Grenns,London,UK,grenns@grenns.com,200,12800,128.30
00000005,Magnolia,Chicago,USA,man@info.com,1024,25600,512000.00
00000006,Dozen,San Francisco,USA,dozen@dozen.com,1000,5,1000.20
00000007,Sun,San Francisco,USA,sunny@sun.com,2000,2,10000.01
*/


class Solution
{
    public static void dotheFile()
    {
//        File infl = new File("/root/customers/data.csv");
        File infl = new File("\\rooo\\customers\\data.csv");
        int custId = 0;
        TreeMap<String, Integer> custByCity = new TreeMap<>();
        TreeMap<String, Integer> custByCountry = new TreeMap<>();
        TreeMap<String, Integer> contrCount = new TreeMap<>();
        int max = 0;
        
        try (BufferedReader bRead = new BufferedReader(new FileReader(infl));)
        {
            boolean first = true;
            String line;
            while ((line = bRead.readLine()) != null)
            {
                if (first)
                {
                    first = false; continue;
                }
                
                String data[] = line.split(",");
                
                if (data.length != 8)
                    throw new IllegalArgumentException(line);
                
                custId++;

                int byCity = custByCity.getOrDefault(data[2], 0) + 1;
                custByCity.put(data[2], byCity);
                
                int byCntry = custByCountry.getOrDefault(data[3], 0) + 1;
                custByCountry.put(data[3], byCntry);

                int cntr = contrCount.getOrDefault(data[3], 0) + Integer.parseInt(data[6]);
                contrCount.put(data[3], cntr);
                max = Math.max(max, cntr);
            }
        }
        catch (FileNotFoundException ex)
        {
            Logger.getLogger(Solution.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex)
        {
            Logger.getLogger(Solution.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Total customers:");
        System.out.println(custId);

        System.out.println("Customers by city:");
        for (Map.Entry<String, Integer> entry : custByCity.entrySet())
        {
            String city = entry.getKey();
            Integer cnt = entry.getValue();
            System.out.println(city + ": " + cnt);
        }
        
        System.out.println("Customers by country:");
        for (Map.Entry<String, Integer> entry : custByCountry.entrySet())
        {
            String city = entry.getKey();
            Integer cnt = entry.getValue();
            System.out.println(city + ": " + cnt);
        }
        
        String largest = null;
        for (Map.Entry<String, Integer> entry : contrCount.entrySet())
        {
            Integer cnt = entry.getValue();
            if (cnt == max)
            {
                String key = entry.getKey();
                if (largest == null)
                    largest = key;
                else if (largest.compareTo(key) < 0)
                    largest = key;
            }
        }
        
        System.out.println("Country with the largest number of customers' contracts:");
        System.out.println(largest + " (" + max + " contracts)");
        
        System.out.println("Unique cities with at least one customer:");
        System.out.println(custByCity.size());
    }
}

public class Goog18
{
    public static void main(String[] args)
    {
        int arr[] = {4,2,5,7};
        Solution.dotheFile();
//        System.out.println(new Solution().binaryPatternMatching("010", "amazing"));
    }
}

