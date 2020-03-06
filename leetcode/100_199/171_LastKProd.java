// https://leetcode.com/problems/product-of-the-last-k-numbers
/// maintain all products, refactor === JUST THE SPEC, return divided

package lastkprod;
import java.util.*;

class ProductOfNumbers
{
    ArrayList<Integer> allProducts = new ArrayList<>();
    int last;

    public ProductOfNumbers()
    {
        allProducts = new ArrayList<>();
        last = 1;
        allProducts.add(last);
    }
    
    public void add(int num)
    {
        if (num == 0)
        {
            allProducts.clear();
            last = 1;
            allProducts.add(last);
        }
        else
        {
            last *= num;
            allProducts.add(last);
        }
    }
    
    public int getProduct(int k)
    {
        if (k >= allProducts.size()) return 0;
        
        return last/allProducts.get(allProducts.size() - 1 - k);
    }
}

public class LastKProd
{

    public static void main(String[] args)
    {
        ProductOfNumbers o = new ProductOfNumbers();
        
        o.add(3);
        o.add(0);
        o.add(2);
        o.add(5);
        o.add(4);
        
        System.out.println(o.getProduct(2));
        System.out.println(o.getProduct(3));
        System.out.println(o.getProduct(4));
        
        o.add(8);
        System.out.println(o.getProduct(2));
    }
}

/*

prototype BUCKET inteface ie have absolutely correct mapping

class Bucket
{
    int product;
    int firstIndex;
    int lastIndex;      // plus one

    public Bucket(int prod, int first, int last)
    {
        product = prod;
        firstIndex = first;
        lastIndex = last;
    }
    
}

class ProductOfNumbers
{
    final static int BUCKET = 20;
    int mySize = 0;
    int myProd = 1;
    
    List<Integer> lst = new ArrayList<>();
    static List<Bucket> buckets;
    static int bucketsStart;

    public ProductOfNumbers()
    {
        lst = new ArrayList<>();
        
        if (buckets == null)
        {
            buckets = new ArrayList<>();
            bucketsStart = 0;
        }
    }
    
    public void add(int num)
    {
        lst.add(num);
        myProd *= num;
        mySize++;
        
        if (mySize % BUCKET == 0)
        {
            buckets.add(new Bucket(myProd, bucketsStart, mySize));
            bucketsStart += BUCKET;
            myProd = 1;
        }
    }
    
    public int getProduct(int k)
    {
        int delta = mySize - bucketsStart;
        
        if (delta == k)
            return myProd;
        else if (k < delta)
            return getRange(mySize - k, mySize);
        
        int prod = getRange(mySize - delta, mySize);
        k -= delta;
        
        int curr = buckets.size() - 1;
        while (k > BUCKET)
        {
            prod *= buckets.get(curr).product;
            k -= BUCKET;
            curr--;
        }
        
        int lastProd;
        
        if (k == BUCKET)
            lastProd = buckets.get(curr).product;
        else
            lastProd = getRange(buckets.get(curr).lastIndex - k, buckets.get(curr).lastIndex);
         
        return prod*lastProd;
    }

    private int getRange(int start, int finish)
    {
        int prod = 1;
        
        for (int i = start; i < finish; i++)
            prod *= lst.get(i);
        
        return prod;
    }
}

from

class ProductOfNumbers
{
    LinkedList<Integer> lst = new LinkedList<>();

    public ProductOfNumbers()
    {
        lst = new LinkedList<>();
    }
    
    public void add(int num)
    {
        lst.addFirst(num);
    }
    
    public int getProduct(int k)
    {
        int prod = 1;
        
        for (int i = 0; i < k; i++)
            prod *= lst.get(i);
        
        return prod;
    }
}

*/
