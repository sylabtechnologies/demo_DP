/// stuck in gear 3

package onetwothree;
import java.util.concurrent.locks.*;
import java.util.concurrent.atomic.AtomicInteger;

class Foo
{
    AtomicInteger order = new AtomicInteger(1);
    private final Lock lock = new ReentrantLock();
    private final Condition next = lock.newCondition();

    public Foo() {}

    private void waiter(int cnd) throws InterruptedException
    {
        while(order.get() != cnd)
        {
            lock.lock();
            try
            {
                next.await();
            } finally {lock.unlock();}
        }
    }

    private void waker() throws InterruptedException
    {
        lock.lock();
        try
        {
            next.signalAll();
        } finally {lock.unlock();}
    }
    
    
    public void first(Runnable printFirst) throws InterruptedException
    {
        waiter(1);
        printFirst.run();
        order.set(2);
        waker();
    }

    public synchronized void second(Runnable printSecond) throws InterruptedException
    {
        waiter(2);
        printSecond.run();
        order.set(2);
        waker();
    }

    public synchronized void third(Runnable printThird) throws InterruptedException
    {
        waiter(3);
        printThird.run();
    }
}

public class Onetwothree
{
    public static void main(String[] args) throws InterruptedException
    {
        new Tester("second");
        Thread.sleep(5);
        new Tester("third");
        Thread.sleep(5);
        new Tester("first");
    }
    
}

class Tester extends Thread
{
    static Foo f = new Foo();

    public Tester(String s)
    {
        this.setName(s);
        this.start();
    }

    @Override
    public void run()
    {
        Runit r = new Runit(this.getName());

        try
        {
            switch (this.getName())
            {
                case "first":
                    f.first(r);
                    break;

                case "second":
                    f.second(r);
                    break;

                case "third":
                    f.third(r);
                    break;

                default: throw new IllegalArgumentException();
            }
        } catch (InterruptedException ex) {}
    }
}

class Runit implements Runnable
{
    String printit;

    public Runit(String printit) {
        this.printit = printit;
    }

    @Override
    public void run()
    {
        System.out.print(printit);
    }
}
