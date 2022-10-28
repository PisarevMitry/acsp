package ru.mirea.task.two.server;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
    public static final String UNIQUE_BINDING_NAME = "server.squareComparison";

    public static void main(String[] args) throws RemoteException, AlreadyBoundException, InterruptedException {
        final SquareComparisonImpl server = new SquareComparisonImpl();
        final Registry registry = LocateRegistry.createRegistry(8080);
        Remote stub = UnicastRemoteObject.exportObject(server, 0);
        registry.bind(UNIQUE_BINDING_NAME, stub);
        Thread.sleep(Integer.MAX_VALUE);
    }
}
