package de.hhu.propra.blatt1;

import java.util.Arrays;

public class StringSearch {

    static int search(String[] array, String string) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(string)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        if (args.length > 1) {
            String[] haystack = Arrays.copyOfRange(args, 0, args.length - 2);
            String needle = args[args.length - 1];
            System.out.println(search(haystack, needle));
        }
    }
}
