// https://leetcode.com/problems/building-h2o

import java.util.concurrent.Semaphore;

class H2O {
    private Semaphore hydrogenSemaphore;
    private Semaphore oxygenSemaphore;

    public H2O() {
        hydrogenSemaphore = new Semaphore(2); // Max 2 hydrogen atoms
        oxygenSemaphore = new Semaphore(1);   // Max 1 oxygen atom
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hydrogenSemaphore.acquire(); // Wait for permission to release hydrogen
        releaseHydrogen.run();       // Release hydrogen
        oxygenSemaphore.release();   // Signal oxygen semaphore if both hydrogen atoms released
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oxygenSemaphore.acquire();   // Wait for permission to release oxygen
        releaseOxygen.run();         // Release oxygen
        hydrogenSemaphore.release(2); // Signal hydrogen semaphore after releasing two hydrogen atoms
    }
}
