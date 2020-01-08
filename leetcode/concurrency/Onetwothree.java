package onetwothree;

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
