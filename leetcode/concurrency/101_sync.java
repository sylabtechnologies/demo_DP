// https://leetcode.com/problems/print-in-order/

package printinorder;

import java.util.concurrent.atomic.AtomicInteger;

class Foo
{
    private volatile int order = 1;

    public Foo() {}

    private void waiter(int cnd) throws InterruptedException
    {
        while(order != cnd) 
            wait(0,1);
    }

    public synchronized void first(Runnable printFirst) throws InterruptedException
    {
        waiter(1);
        printFirst.run();
        order = 2;
        notifyAll();
    }

    public synchronized void second(Runnable printSecond) throws InterruptedException {
        waiter(2);
        printSecond.run();
        order = 3;
        notifyAll();
    }

    public synchronized void third(Runnable printThird) throws InterruptedException {
        waiter(3);
        printThird.run();
        notifyAll();
    }
    
}
