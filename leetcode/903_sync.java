// https://leetcode.com/problems/print-zero-even-odd/submissions/

class ZeroEvenOdd {
    private int n;
    private volatile int order = 0;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    public synchronized void zero(IntConsumer printNumber) throws InterruptedException
    {
        for(int i = 0; i < n; i++)
        {
    		while(order != 0) 
                wait(0,1);
                
            printNumber.accept(0);
            order = i % 2 + 1;
            notifyAll();
    	}        
    }

    public synchronized void even(IntConsumer printNumber) throws InterruptedException
    {
        for(int i = 2; i <= n; i+=2)
        {
    		while(order != 2) 
                wait(0,1);
                
            printNumber.accept(i);
            order = 0;
            notifyAll();
    	}        
    }

    public synchronized void odd(IntConsumer printNumber) throws InterruptedException
    {
        for(int i = 1; i <= n; i+=2)
        {
    		while(order != 1) 
                wait(0,1);
                
            printNumber.accept(i);
            order = 0;
            notifyAll();
    	}        
    }
}

