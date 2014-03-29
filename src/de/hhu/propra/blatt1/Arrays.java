package de.hhu.propra.blatt1;

import java.util.function.Predicate;

public class Arrays {
    public static char[] reverse(char[] array) {
        char[] result = new char[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[array.length - 1 - i];
        }
        return result;
    }

    public static int[] filterEven(int[] array) {
        return filter(i -> i % 2 == 0, array);
    }

    public static int[] filter(Predicate<Integer> test, int[] array) {
        int goods = 0;
        for (int i : array) {
            if (test.test(i)) {
                goods++;
            }
        }
        int[] result = new int[goods];
        int i = 0;
        for (int good : array) {
            if (test.test(good)) {
                result[i++] = good;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] numbers = new int[args.length];
        int i = 0;
        for (String arg : args) {
            numbers[i++] = Integer.parseInt(arg);
        }

        for (int even : filterEven(numbers)) {
            System.out.print(even + " ");
        }
        System.out.println();
    }
}
