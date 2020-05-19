// https://leetcode.com/problems/online-stock-span/
// https://medium.com/algorithms-and-leetcode/monotonic-queue-explained-with-leetcode-problems-7db7c530c1d6
package stockspan;

class StockSpanner
{
    private static final int MAXSIZE = 10001;
    private int top;
    private final Elem priceStack[];

    public StockSpanner()
    {
        top = 0;
        priceStack = new Elem[MAXSIZE];        
    }
    
    public int next(int p)
    {
        Elem curr = new Elem(p, 1);
        int prevSpan = 0;
        
        if (top > 0)
        {
            while (priceStack[top-1].price <= p)
            {
                prevSpan += priceStack[top-1].span;
                top--;
                if (top == 0) break;
            }
        }

        curr.span += prevSpan;
        priceStack[top] = curr;
        int result = priceStack[top].span;
        top++;
        return result;
    }
    
    private static class Elem
    {
        int price, span;
        public Elem(int price, int span)
        {
            this.price = price;
            this.span = span;
        }

        @Override
        public String toString() { return "[" + price + ", " + span + "]"; }
    }
}

public class StockSpan
{
    public static void main(String[] args)
    {
        int price[] = {100, 80, 60, 70, 60, 75, 85};
        
        StockSpanner sp = new StockSpanner();
        for (int p : price)
        {
            System.out.println(sp.next(p));
        }
        
    }
    
}
