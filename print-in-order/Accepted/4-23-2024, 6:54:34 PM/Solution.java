// https://leetcode.com/problems/print-in-order

import java.util.concurrent.Semaphore;

class Foo {
    private Semaphore semaphore1;
    private Semaphore semaphore2;

    public Foo() {
        semaphore1 = new Semaphore(0); // Initialize semaphore for first() method
        semaphore2 = new Semaphore(0); // Initialize semaphore for second() method
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        semaphore1.release(); // Signal that first() is done
    }

    public void second(Runnable printSecond) throws InterruptedException {
        semaphore1.acquire(); // Wait for first() to complete
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        semaphore2.release(); // Signal that second() is done
    }

    public void third(Runnable printThird) throws InterruptedException {
        semaphore2.acquire(); // Wait for second() to complete
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
