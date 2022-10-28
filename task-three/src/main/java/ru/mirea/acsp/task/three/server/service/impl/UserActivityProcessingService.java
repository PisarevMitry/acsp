package ru.mirea.acsp.task.three.server.service.impl;

import ru.mirea.acsp.task.three.server.Server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class UserActivityProcessingService extends Thread {

    private final Socket socket;
    private final BufferedReader in;
    private final BufferedWriter out;

    public UserActivityProcessingService(Socket socket) throws IOException {
        this.socket = socket;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        Server.STORY_PROCESSING_SERVICE.printStory(out);
        start();
    }

    @Override
    public void run() {
        String word;
        try {
            word = in.readLine();
            try {
                out.write(word + "\n");
                out.flush();
            } catch (IOException ignored) {
            }
            try {
                while (true) {
                    word = in.readLine();
                    if (word.equals("stop")) {
                        this.downService();
                        break;
                    }
                    System.out.println("Echoing: " + word);
                    Server.STORY_PROCESSING_SERVICE.addStoryEl(word);
                    for (UserActivityProcessingService vr : Server.SERVER_LIST) {
                        vr.send(word);
                    }
                }
            } catch (NullPointerException ignored) {
            }
        } catch (IOException e) {
            this.downService();
        }
    }

    private void send(String msg) {
        try {
            out.write(msg + "\n");
            out.flush();
        } catch (IOException ignored) {
        }

    }

    private void downService() {
        try {
            if (!socket.isClosed()) {
                socket.close();
                in.close();
                out.close();
                for (UserActivityProcessingService vr : Server.SERVER_LIST) {
                    if (vr.equals(this)) {
                        vr.interrupt();
                    }
                    Server.SERVER_LIST.remove(this);
                }
            }
        } catch (IOException ignored) {
        }
    }
}
