package ru.mirea.acsp.task.one;

public class Main {
    public static void main(String[] args) {
        PingStreamSynchronization pingStreamSynchronization = new PingStreamSynchronization();
        PongStreamSynchronization pongStreamSynchronization = new PongStreamSynchronization();
        (new Thread(new Ping(pingStreamSynchronization, pongStreamSynchronization))).start();
        (new Thread(new Pong(pingStreamSynchronization, pongStreamSynchronization))).start();
    }
}


