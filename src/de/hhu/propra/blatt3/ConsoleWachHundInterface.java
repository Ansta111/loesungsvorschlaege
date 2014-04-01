package de.hhu.propra.blatt3;

import java.io.File;
import java.util.Scanner;

public class ConsoleWachHundInterface implements WachHundInterface {
    private static final Scanner sc = new Scanner(System.in);
    private boolean running = true;
    private WatchDog watchDog;

    public ConsoleWachHundInterface(WatchDog watchDog) {
        this.watchDog = watchDog;
    }

    @Override
    public void startRepl() {
        System.out.println("Type command. ? for help");
        while(running) {
            System.out.print("$ ");
            String command = sc.nextLine();
            switch(command) {
                case "quit":
                case "exit":
                    stop();
                    break;
                case "list":
                    listFiles();
                    break;
                case "ls":
                    showFilesInDirectory();
                    break;
                case "?":
                    printHelp();
                    break;

            }

            if (command.startsWith("watch ")) {
                System.out.println(command.substring(6, command.length()));
                watchDog.watchFile(command.substring(6, command.length()));
            } else if (command.startsWith("unwatch ")) {
                watchDog.unwatchFile(command.substring(8, command.length()));
            } else if (command.startsWith("ls ")) {
                showFilesInDirectory(command.substring(3, command.length()));
            }
        }
    }

    private void showFilesInDirectory(String filename) {
        File directory = new File(filename);
        System.out.println(directory.getAbsolutePath());
        for (File file : directory.listFiles()) {
            System.out.print(file.getName());
            if (file.isDirectory()) {
                System.out.println("/");
            } else {
                System.out.println();
            }
        }
    }

    private void showFilesInDirectory() {
        showFilesInDirectory(".");
    }

    private void printHelp() {
        System.out.println("help - print this help");
        System.out.println("list - list watched files");
        System.out.println("exit, quit - quit");
        System.out.println("watch <file> - unwatch file");
        System.out.println("unwatch <file> - unwatch file");
        System.out.println("ls [directory] - list files in current or subdirectory");
    }

    private void listFiles() {
        for (WatchedFile file : watchDog.getFiles()) {
            System.out.println(file.getFile().getAbsolutePath());
        }
    }

    private void stop() {
        running = false;
    }

    @Override
    public void accept(String filename) {
        System.out.println(filename + " geändert");
    }
}
