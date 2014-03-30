package de.hhu.propra.blatt2.connect4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleBoardPrinter implements BoardPrinter {
    private final static Scanner sc = new Scanner(System.in);

    private final Board board;

    public ConsoleBoardPrinter(Board board) {
        this.board = board;
    }

    @Override
    public void askPlayer() {
        while (true) {
            System.out.print("Player " + board.getCurrentPlayer() + ": thou shall make a move: ");
            try {
                set(sc.nextInt());
                return;
            } catch (InputMismatchException e) {
                System.out.println("Only numbers are allowed as input");
                sc.next();
            }
        }
    }

    @Override
    public void showWinMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void drawBoard() {
        for (int row = board.getHeight() - 1; row >= 0; row--) {
            for (int col = 0; col < board.getWidth(); col++) {
                int p = board.get(row, col);
                if (0 == p) {
                    System.out.print("[ ]");
                } else {
                    System.out.printf("[%c]", p == 1 ? 'r' : 'g');
                }
            }
            System.out.println();
        }
    }

    @Override
    public void greetPlayer() {
        System.out.println("Welcome to KeilerConnectFour");
    }

    private void set(int column) {
        if (!board.canSet(column)) {
            System.out.println("This column is full!!!");
        } else {
            board.set(column);
        }
    }
}
