package ru.mirea.acsp.task.one;

public class PingStreamSynchronization {

    private boolean isActive = true;

    public synchronized void take() {
        while (isActive) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        isActive = true;
        notifyAll();
    }

    public synchronized void put() {
        while (!isActive) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        isActive = false;
        notifyAll();
    }
}
