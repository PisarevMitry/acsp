package ru.mirea.acsp.task.three.client;

import ru.mirea.acsp.task.three.client.service.impl.UserActivityProcessingService;

public class Client {

    public static String IP_ADDRESS = "localhost";
    public static Integer PORT = 8080;

    public static void main(String[] args) {
        new UserActivityProcessingService(IP_ADDRESS, PORT);
    }
}