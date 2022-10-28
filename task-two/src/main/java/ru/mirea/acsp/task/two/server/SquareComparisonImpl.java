package ru.mirea.acsp.task.two.server;

import ru.mirea.acsp.task.two.client.SquareComparison;

import java.rmi.RemoteException;

public class SquareComparisonImpl implements SquareComparison {

    private double D;

    private double x1;

    private double x2;

    public SquareComparisonImpl() {
        x1 = 0;
        x2 = 0;
        D = 0;
    }

    @Override
    public String squareComparison(int a, int b, int c) throws RemoteException {
        D = b * b - 4 * a * c;
        if (D > 0) {
            x1 = (-b - Math.sqrt(D)) / (2 * a);
            x2 = (-b + Math.sqrt(D)) / (2 * a);
            return "Корни уравнения: x1 = " + x1 + ", x2 = " + x2;
        } else if (D == 0) {
            double x = -b / (2 * a);
            return "Уравнение имеет единственный корень: x = " + x;
        } else {
            return "Уравнение не имеет действительных корней!";
        }
    }
}
