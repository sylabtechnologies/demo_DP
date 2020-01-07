// https://leetcode.com/problems/print-foobar-alternately/
// just waiting for atomics

package printalt;
import java.util.concurrent.atomic.AtomicInteger;

class FooBar {
    private int n;
    AtomicInteger order = new AtomicInteger(0);

    public FooBar(int n) {
        this.n = n;
    }

    public synchronized void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
            while (order.get() == 1) wait(0,1);
        	printFoo.run();
            order.set(1);
        }
    }

    public synchronized void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
            while (order.get() == 0) wait(0,1);
        	printBar.run();
            order.set(0);
        }
    }
}