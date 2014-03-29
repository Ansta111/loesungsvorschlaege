package de.hhu.propra.blatt1;

public class CrossProduct {
    static int[] crossproduct(int[] a, int[] b) {
        int[] result = {
                a[1]*b[2] - a[2]*b[1],
                a[2]*b[0] - a[0]*b[2],
                a[0]*b[1] - a[1]*b[0]
        };
        return result;
    }

    public static void main(String[] args) {
        if (args.length != 6) {
            System.err.println("Usage: java CrossProduct <a1> <a2> <a3> <b1> <b2> <b3>");
            return;
        }

        int[] va = {Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2])};
        int[] vb = {Integer.parseInt(args[3]), Integer.parseInt(args[4]), Integer.parseInt(args[5])};
        System.out.print("( ");
        for (int i : crossproduct(va, vb)) {
            System.out.print(i + " ");
        }
        System.out.println(")");
    }
}