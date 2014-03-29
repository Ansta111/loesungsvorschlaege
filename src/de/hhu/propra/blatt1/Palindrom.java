package de.hhu.propra.blatt1;

public class Palindrom {
    static boolean isPalindrom(String string) {
        return java.util.Arrays.equals(string.toCharArray(), Arrays.reverse(string.toCharArray()));
    }

    public static void main(String[] args) {
        if (isPalindrom(args[0])) {
            System.out.println(args[0] + " ist ein Palindrom");
        } else {
            System.out.println(args[0] + " ist kein Palindrom");
        }
    }
}

