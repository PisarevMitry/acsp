package ru.mirea.task.two.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {

    public static final String UNIQUE_BINDING_NAME = "server.squareComparison";

    public static void main(String[] args) throws RemoteException, NotBoundException {
        final Registry registry = LocateRegistry.getRegistry(8080);
        SquareComparison squareComparison = (SquareComparison) registry.lookup(UNIQUE_BINDING_NAME);
        Scanner scanner = new Scanner(System.in);
        System.out.print("a: ");
        int a = scanner.nextInt();
        System.out.print("b: ");
        int b = scanner.nextInt();
        System.out.print("c: ");
        int c = scanner.nextInt();
        System.out.println(squareComparison.squareComparison(a, b, c));
    }
}
