package lastkprod;
import java.util.*;

class ProductOfNumbers
{
    final static int BUCKET = 20;
    static ProductOfNumbers[] allProducts  = new ProductOfNumbers[2000];
    static int allProductsSize  = 0;
    int[] myBucket = new int[BUCKET];

    int mySize;
    int myProd;
    
    public ProductOfNumbers()
    {
        mySize = 0;
        myProd = 1;
    }
    
    private ProductOfNumbers(ProductOfNumbers p)
    {
        this.mySize = p.mySize;
        this.myProd = p.myProd;
        this.myBucket = Arrays.copyOfRange(p.myBucket, 0, p.mySize);
    }
    
    public void add(int num)
    {
        myBucket[mySize++] = num;
        myProd *= num;
        
        if (mySize < BUCKET) return;

        allProducts[allProductsSize] = new ProductOfNumbers(this);
        allProductsSize++;
        myProd = 1;
        mySize = 0;
    }
    
    public int getProduct(int k)
    {
        if (k == mySize) return myProd;
        
        int prod = 1;
        if (k < BUCKET)
        {
            int j = 0;
            
            for (int i = mySize - 1; i >= 0; i--)
            {
                prod *= myBucket[i];
                j++;
                if (j == k ) break;
            }
            
            return prod;
        }
        
        prod = 1;
        
        for (int i = allProductsSize; i >= 0; i--)
        {
            ProductOfNumbers elem = allProducts[i];

            if (k == 0)
                break;
            else if (k < BUCKET)
            {
                prod *= elem.getProduct(k);
                return prod;
            }
            
            prod *= elem.myProd;
            k -= BUCKET;
        }
        
        return prod;
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
