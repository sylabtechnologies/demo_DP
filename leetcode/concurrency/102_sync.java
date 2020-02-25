// https://leetcode.com/problems/print-foobar-alternately/
///// sync order&check only

package printalt;

class FooBar {
    private volatile int order = 0;
    private final    int n;

    public FooBar(int x) {this.n = x;};

    private synchronized void waitForRemainder(int cnd, Runnable print) throws InterruptedException
    {
        while(order % 2 != cnd) 
            wait();

        order++;
        print.run();
        
        notifyAll();
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++)
        {
            waitForRemainder(0, printFoo);
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++)
        {
            waitForRemainder(1, printBar);
        }
    }

}