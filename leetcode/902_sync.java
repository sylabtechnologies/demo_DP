// https://leetcode.com/problems/print-foobar-alternately/
// just wait for it

package printalt;

class FooBar {
    private int n;
    private volatile int order = 0;

    public FooBar(int n) {
        this.n = n;
    }

    public synchronized void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++)
        {
            waiter(0);
            printFoo.run();
            order = 1;
            notify();
        }
    }

    public synchronized void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++)
        {
            waiter(1);
            printBar.run();
            order = 0;
            notify();
        }
    }

    private void waiter(int cnd) throws InterruptedException
    {
        while(order != cnd) 
            wait(0,1);
    }

}