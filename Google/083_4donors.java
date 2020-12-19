package goog31;
import java.util.*;

// hrank Dec18 : a. 2ptr arrays a, b. treemap sums of c, d ?
class Result
{
    public static long numberOfWays(List<Integer> donationsA, List<Integer> donationsB,
            List<Integer> donationsC, List<Integer> donationsD, int k)
    {
        int a[] = getArr(donationsA);
        int b[] = getArr(donationsB);
        int c[] = getArr(donationsC);
        
        Collections.sort(donationsD);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < donationsD.size(); i++)
        {
            int fr = map.getOrDefault(donationsD.get(i), 0);
            map.put(donationsD.get(i), donationsD.size() - i);
        }
            
        
        int d[] = getArr(donationsD);

        long ans = 0l;
        for (int i : a)
            for (int j : b)
                for (int l : c)
                {
                    long sum = i;
                    sum += j;
                    sum += l;

                    if (sum >= k)
                        ans += donationsD.size();
                    else
                    {
                        int delta = (int) (k - sum);
                        
                        Integer key = map.ceilingKey(delta);
                        if (key != null) ans += map.get(key);
                    }
                    
                }
        
        return ans;
    }

    private static int[] getArr(List<Integer> donation)
    {
        int size = donation.size();
        int ret[] = new int[size];
        for (int i = 0; i < donation.size(); i++)
            ret[i] = donation.get(i);
        
        return ret;
    }
}


public class Goog31
{
    public static void main(String[] args)
    {
//        List<Integer> a = Arrays.asList(10,25,9);
//        List<Integer> b = Arrays.asList(34,35,1);
//        List<Integer> c = Arrays.asList(9);
//        List<Integer> d = Arrays.asList(18,21);

        List<Integer> a = Arrays.asList(2, 10);
        List<Integer> b = Arrays.asList(3);
        List<Integer> c = Arrays.asList(7,10,12);
        List<Integer> d = Arrays.asList(5, 8);
        System.out.println(Result.numberOfWays(a, b, c, d, 25));
    }
}

/*

*/