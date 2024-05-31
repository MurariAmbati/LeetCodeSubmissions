// https://leetcode.com/problems/building-h2o

import java.util.concurrent.Semaphore;

class H2O {
    private Semaphore hydrogenSemaphore;
    private Semaphore oxygenSemaphore;
    private Semaphore barrier;

    public H2O() {
        hydrogenSemaphore = new Semaphore(2); // Max 2 hydrogen atoms
        oxygenSemaphore = new Semaphore(1);   // Max 1 oxygen atom
        barrier = new Semaphore(0);           // Barrier to synchronize the threads
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hydrogenSemaphore.acquire();   // Wait for permission to release hydrogen
        releaseHydrogen.run();         // Release hydrogen
        barrier.acquire();             // Wait for oxygen thread to release barrier
        hydrogenSemaphore.release();   // Release the hydrogen semaphore
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oxygenSemaphore.acquire();     // Wait for permission to release oxygen
        releaseOxygen.run();           // Release oxygen
        barrier.release(2);            // Signal two hydrogen threads to proceed
        barrier.acquire(2);            // Wait for two hydrogen threads to complete
        oxygenSemaphore.release();     // Release the oxygen semaphore
    }
}
