package de.hhu.propra.blatt1;

public class Euklid {
    static int gcd(int a, int b) {
        while (b != 0) {
            if (a > b) {
                a -= b;
            } else {
                b -= a;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(gcd(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
    }
}
