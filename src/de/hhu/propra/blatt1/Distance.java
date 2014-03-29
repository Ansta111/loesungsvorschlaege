package de.hhu.propra.blatt1;

public class Distance {
    private static int abs(int a) {
        if (a < 0) {
            a *= -1;
        }
        return a;
    }

    static int distance(int a, int b) {
        return abs(a - b);
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: java Distance <a> <b>");
            return;
        }

        System.out.println(distance(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
    }
}
