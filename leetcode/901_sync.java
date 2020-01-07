// https://leetcode.com/problems/print-in-order/
// atomic sync OK?, https://docs.oracle.com/javase/tutorial/essential/concurrency/atomicvars.html

package printinorder;

import java.util.concurrent.atomic.AtomicInteger;

class Foo
{
    AtomicInteger order = new AtomicInteger();

    public Foo()
    {
        order.set(1);
    }

    public synchronized void first(Runnable printFirst) throws InterruptedException
    {
        while (true)
        {
            if (order.get() == 1)
            {
                printFirst.run();
                order.set(2);
                break;
            }
        }
    }

    public synchronized void second(Runnable printSecond) throws InterruptedException {
        while (true)
        {
            if (order.get() == 2)
            {
                printSecond.run();
                order.set(3);
                break;
            }
        }
    }

    public synchronized void third(Runnable printThird) throws InterruptedException {
        while (true)
        {
            if (order.get() == 3)
            {
                printThird.run();
                break;
            }
        }
    }
    
}
