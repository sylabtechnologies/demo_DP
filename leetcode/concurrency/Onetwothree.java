package onetwothree;
import java.util.List;

public class Onetwothree
{
    public static void main(String[] args) throws InterruptedException
    {
        List<Integer> order = RUtil.getRandomList();
        
        String[] msg = {"first ", "second ", "third "};
        Foo ff = new Foo();

        Thread[] tt = new Thread[3];
        tt[0] = new Thread( new Runnable()
        {
        @Override
        public void run() {
            try {
                ff.first( () -> System.out.print(msg[0]));
            } catch (InterruptedException ex) {}
        }
        });

        tt[1] = new Thread( new Runnable()
        {
        @Override
        public void run() {
            try {
                ff.second( () -> System.out.print(msg[1]));
            } catch (InterruptedException ex) {}
        }
        });

        tt[2] = new Thread( new Runnable()
        {
        @Override
        public void run() {
            try {
                ff.third( () -> System.out.print(msg[2]));
            } catch (InterruptedException ex) {}
        }
        });
        
        System.out.println(order);
        for (int o : order)
        {
            tt[o - 1].start();
        }
        
    }
}

// parallel threads will wait for 1 2 3
class Foo
{
    private volatile int order;

    public Foo()
    {
        order = 1;
    }

    private synchronized void waitForAndInc(int cnd, Runnable print) throws InterruptedException
    {
        while(order != cnd) 
            wait();

        order++;
        print.run();
        
        notifyAll();
    }

    public void first(Runnable printFirst) throws InterruptedException
    {
        waitForAndInc(1, printFirst);
    }

    public void second(Runnable printSecond) throws InterruptedException {
        waitForAndInc(2, printSecond);
    }

    public void third(Runnable printThird) throws InterruptedException {
        waitForAndInc(3, printThird);
    }
}

