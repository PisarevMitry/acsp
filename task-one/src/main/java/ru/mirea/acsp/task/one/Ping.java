package ru.mirea.acsp.task.one;

public class Ping implements Runnable {

    private final PingStreamSynchronization pingStreamSynchronization;

    private final PongStreamSynchronization pongStreamSynchronization;

    private int count = 0;

    public Ping(PingStreamSynchronization pingStreamSynchronization, PongStreamSynchronization pongStreamSynchronization) {
        this.pingStreamSynchronization = pingStreamSynchronization;
        this.pongStreamSynchronization = pongStreamSynchronization;
    }

    public void run() {
        for (int i = 0; i < 11; i++) {
            count++;
            pingStreamSynchronization.put();
            pongStreamSynchronization.take();
            System.out.print("PING ");
        }
    }
}
