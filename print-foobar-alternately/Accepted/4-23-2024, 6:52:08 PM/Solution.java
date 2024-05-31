// https://leetcode.com/problems/print-foobar-alternately

import java.util.concurrent.Semaphore;

class FooBar {
    private int n;
    private Semaphore fooSem;
    private Semaphore barSem;

    public FooBar(int n) {
        this.n = n;
        fooSem = new Semaphore(1); // Initialize foo semaphore with 1 permit (available)
        barSem = new Semaphore(0); // Initialize bar semaphore with 0 permits (not available)
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            fooSem.acquire(); // Wait for foo semaphore
            printFoo.run();
            barSem.release(); // Signal bar semaphore
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            barSem.acquire(); // Wait for bar semaphore
            printBar.run();
            fooSem.release(); // Signal foo semaphore
        }
    }
}
