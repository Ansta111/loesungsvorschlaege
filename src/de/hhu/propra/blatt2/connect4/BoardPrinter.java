package de.hhu.propra.blatt2.connect4;

public interface BoardPrinter {
    void askPlayer();

    void showWinMessage(String winner);

    void drawBoard();

    void greetPlayer();
}
