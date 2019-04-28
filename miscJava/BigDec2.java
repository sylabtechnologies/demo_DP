// https://www.hackerrank.com/challenges/java-bigdecimal/problem
// is TreeSet<String> logical?

package solution;

import java.math.BigDecimal;
import java.util.*;

class Solution
{
    public static void main(String []args){
        //Input
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();

        String []s=new String[n+2];
        for(int i=0;i<n;i++)
        {
            s[i]=sc.next();
        }
        sc.close();
        
        TreeMap<BigDecimal, ArrayList<String>> index = new TreeMap<>();

        for(int i=0; i< n; i++)
        {
            BigDecimal bd = new BigDecimal(s[i]);
            
            if (index.containsKey(bd))
            {
                ArrayList<String> item = index.get(bd);
                item.add(s[i]);
            }
            else
            {
                ArrayList<String> item = new ArrayList<>();
                item.add(s[i]);
                index.put(bd, item);
            }
                
        }
        
        List<ArrayList<String>> result = new ArrayList<>(index.values());
        Collections.reverse(result);
        
        int j = 0;
        for (ArrayList<String> item : result)
        {
            for (String elem : item)
                s[j++] = elem;
        }

        for(int i=0;i<n;i++)
        {
            System.out.println(s[i]);
        }
        
    }
}
