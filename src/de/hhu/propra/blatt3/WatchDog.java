package de.hhu.propra.blatt3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

public class WatchDog implements Runnable {

    public static void main(String[] args) {
        WatchDog watchDog =
                new WatchDog(args[0]);
        WachHundInterface wachHundInterface = new ConsoleWachHundInterface(watchDog);
        watchDog.setOnFileChangedListener(wachHundInterface);
        watchDog.watch();
        wachHundInterface.startRepl();
    }

    private void setOnFileChangedListener(Consumer<String> onFileChangedListener) {
        this.onFileChangedListener = onFileChangedListener;
    }

    private List<WatchedFile> files = new ArrayList<>();

    private Consumer<String> onFileChangedListener;

    public WatchDog(String filename) {
        this(new WatchedFile(filename));
    }

    public WatchDog(WatchedFile file) {
        files.add(file);
    }

    public void watch() {
        Executors.newSingleThreadExecutor().execute(this);
    }

    @Override
    public void run() {
        while (true) {
            for (WatchedFile file : files) {
                long lastModified = file.getFile().lastModified();

                if (file.getLastModified() < lastModified) {
                    file.setLastModified(lastModified);
                    onFileChangedListener.accept(file.getFile().getName());
                }
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
        }
    }

    public List<WatchedFile> getFiles() {
        return files;
    }

    public void watchFile(String filename) {
        files.add(new WatchedFile(filename));
    }

    public void unwatchFile(String filename) {
        files.removeIf((file) -> file.getFile().getName().equals(filename));
    }
}
