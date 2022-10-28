package ru.mirea.acsp.task.one;

public class Pong implements Runnable {

    private final PingStreamSynchronization pingStreamSynchronization;

    private final PongStreamSynchronization pongStreamSynchronization;

    private int count = 0;

    public Pong(PingStreamSynchronization pingStreamSynchronization, PongStreamSynchronization pongStreamSynchronization) {
        this.pingStreamSynchronization = pingStreamSynchronization;
        this.pongStreamSynchronization = pongStreamSynchronization;
    }

    public void run() {
        for (int i = 0; i < 11; i++) {
            count++;
            pingStreamSynchronization.take();
            System.out.print("PONG ");
            pongStreamSynchronization.put();
        }
    }
}
