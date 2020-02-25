// https://leetcode.com/problems/print-in-order/

package printinorder;

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