// https://leetcode.com/problems/print-in-order/
// atomic access OK: https://docs.oracle.com/javase/tutorial/essential/concurrency/atomic.html
// https://stackoverflow.com/questions/57215749/why-does-it-seem-like-two-threads-are-accessing-one-lock-in-my-code!

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
