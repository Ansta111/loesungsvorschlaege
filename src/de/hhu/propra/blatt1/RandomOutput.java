package de.hhu.propra.blatt1;

import java.util.Random;

public class RandomOutput {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            random1('a', 't', 'g', 'c');
        }

        for (int i = 0; i < 100; i++) {
            random2('a', 't', 'g', 'c');
        }
    }

    private static void random1(char a, char b, char c, char d) {
        String s = "";
        while (a != ' ' || b != ' ' || c != ' ' || d != ' ') {
            int r = (int) (Math.random() * 4);

            if (r == 0 && a != ' ') {
                s += a;
                a = ' ';
            } else if (r == 1 && b != ' ') {
                s += b;
                b = ' ';
            } else if (r == 2 && c != ' ') {
                s += c;
                c = ' ';
            } else if (r == 3 && d != ' ') {
                s += d ;
                d = ' ';
            }
        }
        System.out.println(s);
    }

    private static void random2(char a, char b, char c, char d) {
        char[] s = {a, b, c, d};
        Random r = new Random();
        for (int i = s.length - 1; i > 0; i--) {
            int idx = r.nextInt(i + 1);

            char tmp = s[idx];
            s[idx] = s[i];
            s[i] = tmp;
        }
        for (char ch : s) {
            System.out.print(ch);
        }
        System.out.println();
    }
}
