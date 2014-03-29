package de.hhu.propra.blatt1;

import java.util.function.DoubleUnaryOperator;

public class Newton {
    private final static double eps = 0.00001;
    private final static DoubleUnaryOperator f = (x) -> x * x * x * x + 3 * x * x * x + 0.5 * x - 1;
    private final static DoubleUnaryOperator fs = (x) -> 4 * x * x * x + 9 * x * x + 0.5;

    static double newton(double x) {
        System.out.println(x);
        if (Math.abs(f.applyAsDouble(x)) <= eps) {
            return x;
        } else {
            return newton(x - f.applyAsDouble(x) / fs.applyAsDouble(x));
        }
    }

    public static void main(String[] args) {
        System.out.println(newton(Double.parseDouble(args[0])));
    }
}
