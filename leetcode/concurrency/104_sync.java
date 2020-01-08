/**
 * https://leetcode.com/problems/building-h2o
 * 
 * If an oxygen thread arrives at the barrier when no hydrogen threads are present,
 * it has to wait for two hydrogen threads.
 * If a hydrogen thread arrives at the barrier when no other threads are present,
 * it has to wait for an oxygen thread and another hydrogen thread
 */

package hho;

class H2O
{
    private volatile char molecule;
    
    public H2O()
    {
        molecule = 'h';
    }

    private void waiter(char cnd) throws InterruptedException
    {
        while(molecule != cnd) 
            wait(0,1);
    }    
    
    public synchronized void hydrogen(Runnable releaseHydrogen) throws InterruptedException
    {
        while (molecule == 'O')
            wait(0,1);
        
        molecule = (molecule == 'h') ? 'H' : 'O';
        releaseHydrogen.run();
        notifyAll();
    }

    public synchronized void oxygen(Runnable releaseOxygen) throws InterruptedException
    {
        waiter('O');
        releaseOxygen.run();
        molecule = 'h';
        notifyAll();
    }
}