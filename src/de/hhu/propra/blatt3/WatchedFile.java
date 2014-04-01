package de.hhu.propra.blatt3;

import java.io.File;

public class WatchedFile {
    private File file;
    private long lastModified;

    public WatchedFile(String filename) {
        this(new File(filename));
    }

    public WatchedFile(File file) {
        this.file = file;
        lastModified = file.lastModified();
    }

    public File getFile() {
        return file;
    }

    public long getLastModified() {
        return lastModified;
    }

    public void setLastModified(long lastModified) {
        this.lastModified = lastModified;
    }
}
