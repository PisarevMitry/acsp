package ru.mirea.acsp.task.three.server;

import ru.mirea.acsp.task.three.server.service.impl.StoryProcessingService;
import ru.mirea.acsp.task.three.server.service.impl.UserActivityProcessingService;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class Server {

    public static final Integer PORT = 8080;
    public static LinkedList<UserActivityProcessingService> SERVER_LIST = new LinkedList<>();
    public static StoryProcessingService STORY_PROCESSING_SERVICE;

    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(PORT)) {
            STORY_PROCESSING_SERVICE = new StoryProcessingService();
            System.out.println("Server Started");
            do {
                Socket socket = server.accept();
                try {
                    SERVER_LIST.add(new UserActivityProcessingService(socket));
                } catch (IOException e) {
                    socket.close();
                }
            } while (true);
        }
    }
}