package ru.mirea.task.two.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SquareComparison extends Remote {
    String squareComparison(int a, int b, int c) throws RemoteException;
}
