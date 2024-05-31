// https://leetcode.com/problems/print-zero-even-odd

class ZeroEvenOdd {
    private int n;
    private int current;
    private Object lock;
    private boolean isZero;
    
    public ZeroEvenOdd(int n) {
        this.n = n;
        this.current = 1;
        this.lock = new Object();
        this.isZero = true;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        synchronized (lock) {
            for (int i = 0; i < n; i++) {
                while (!isZero) {
                    lock.wait();
                }
                printNumber.accept(0);
                isZero = false;
                lock.notifyAll();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        synchronized (lock) {
            for (int i = 2; i <= n; i += 2) {
                while (isZero || current % 2 != 0) {
                    lock.wait();
                }
                printNumber.accept(i);
                current++;
                isZero = true;
                lock.notifyAll();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        synchronized (lock) {
            for (int i = 1; i <= n; i += 2) {
                while (isZero || current % 2 == 0) {
                    lock.wait();
                }
                printNumber.accept(i);
                current++;
                isZero = true;
                lock.notifyAll();
            }
        }
    }
}
