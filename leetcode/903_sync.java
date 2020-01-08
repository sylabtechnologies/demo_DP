// https://leetcode.com/problems/print-zero-even-odd/submissions/
// just wait for it

class ZeroEvenOdd {
    private int n;
    private volatile int order = 0;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // sync for waiting
    public synchronized void zero(IntConsumer printNumber) throws InterruptedException
    {
        for(int i = 0; i < n; i++)
        {
            waiter(0);
            printNumber.accept(0);
            order = i % 2 + 1;
            notifyAll();
    	}        
    }

    // sync for waiting
    public synchronized void even(IntConsumer printNumber) throws InterruptedException
    {
        for(int i = 2; i <= n; i+=2)
        {
            waiter(2);
            printNumber.accept(i);
            order = 0;
            notifyAll();
    	}        
    }

    // sync for waiting
    public synchronized void odd(IntConsumer printNumber) throws InterruptedException
    {
        for(int i = 1; i <= n; i+=2)
        {
            waiter(1);
            printNumber.accept(i);
            order = 0;
            notifyAll();
    	}        
    }

    private void waiter(int cnd) throws InterruptedException
    {
        while(order != cnd) 
            wait(0,1);
    }
}
