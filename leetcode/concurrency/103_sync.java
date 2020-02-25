// https://leetcode.com/problems/print-zero-even-odd/submissions/
// ??? no dry!

class ZeroEvenOdd {
    private final int n;
    private volatile int order = 0;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    private synchronized void waitForCndr(int cnd, IntConsumer printNumber, int number) throws InterruptedException
    {
        while(order % 3 != cnd) 
            wait();

        order++;

        printNumber.accept(number);
        notifyAll();
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for(int i = 0; i < n; i++)
        {
            waitForCndr(0, printNumber, 0);
    	}        
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for(int i = 0; i < n; i++)
        {
            waitForCndr(1, printNumber, i);
    	}        
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for(int i = 0; i < n; i++)
        {
            waitForCndr(2, printNumber, i);
    	}        
    }

}
