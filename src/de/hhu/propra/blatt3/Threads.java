package de.hhu.propra.blatt3;

import java.util.concurrent.Executors;

public class Threads {
    public static void main(String[] args) {
        /**
         * Executors bieten mit den verschiedenen Typen von pools (siehe Doku!) eine weitaus bessere Kontrolle
         * über Threads als ein simples new Thread(() -> ...).start(); oder ähnlich
         */
        Executors.newSingleThreadExecutor().execute(() -> System.out.println("do something"));
    }
}
