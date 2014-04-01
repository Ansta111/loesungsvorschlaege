package de.hhu.propra.blatt3;

import java.util.function.Consumer;

public interface WachHundInterface extends Consumer<String> {
    void startRepl();
}
