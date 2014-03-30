package de.hhu.propra.blatt2.connect4;

import de.hhu.propra.StdDraw;

import java.awt.Color;

public class GuiBoardPrinter implements BoardPrinter {
    private static final int SCALE = 100;
    private static final double R = 0.5;

    private final Color[] colors = new Color[] {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.ORANGE};

    private final Board board;
    private final double centerX;
    private final double centerY;
    private Color c1, c2;

    GuiBoardPrinter(Board board) {
        this.board = board;
        centerX = board.getWidth() / 2.0;
        centerY = board.getHeight() / 2.0;
        setupStdDraw();
    }

    private void setupStdDraw() {
        StdDraw.setCanvasSize(board.getWidth() * SCALE, board.getHeight() * SCALE);
        StdDraw.setXscale(0, board.getWidth());
        StdDraw.setYscale(0, board.getHeight());
        StdDraw.show(0);
    }

    @Override
    public void askPlayer() {
        StdDraw.clear();
        drawText("Player " + (board.getCurrentPlayer() == 1 ? "One" : "Two") + ", its thine turn", 500);
    }

    @Override
    public void showWinMessage(String winner) {
        drawText(winner, 2000);
        drawBoard();
    }

    @Override
    public void drawBoard() {
        StdDraw.clear();
        for (int row = 0; row < board.getHeight(); row++) {
            for (int col = 0; col < board.getWidth(); col++) {
                int p = board.get(row, col);
                switch (p) {
                    case 1: StdDraw.setPenColor(c1); break;
                    case 2: StdDraw.setPenColor(c2); break;
                    default: StdDraw.setPenColor();
                }

                if (p != 0) {
                    StdDraw.filledCircle(col + R, row + R, R);
                } else {
                    StdDraw.circle(col + R, row + R, R);
                }
            }
        }
        StdDraw.show(0);
        waitMoves();
    }

    private void waitMoves() {
        while (!StdDraw.mousePressed()) {
        }

        int col = (int) StdDraw.mouseX();
        set(col);
    }

    private void set(int col) {
        if (board.canSet(col)) {
            board.set(col);
        }
    }

    @Override
    public void greetPlayer() {
        drawText("Welcome to KeilerConnectFour", 3000);
        colorChoose();
    }

    private void colorChoose() {
        StdDraw.show(0);
        StdDraw.clear();
        c1 = colorChoose("Player 1");
        drawText("Player one has choosen his color!!");

        c2 = colorChoose("Player 2");
        drawText("Player two has choosen his color!!");
    }

    private void drawColors() {
        for (float i = -3, j = 0; i <= 3; i += 1.5, j++) {
            StdDraw.setPenColor(colors[(int) j]);
            StdDraw.filledCircle(centerX + i, centerY, R);
        }
        StdDraw.show(0);
    }
    private Color colorChoose(String name) {
        StdDraw.clear();
        drawColors();

        StdDraw.setPenColor();
        StdDraw.text(centerX, centerY + 2, name + ": Thou shall chooze thy colour");
        StdDraw.show(0);

        Color c = null;
        while (c == null) {
            double mouseX = StdDraw.mouseX(), mouseY = StdDraw.mouseY();

            if (StdDraw.mousePressed()) {
                int j = 0;
                for (float i = -3; i <= 3; i += 1.5, j++) {
                    if (circContains(mouseX, mouseY, i)) {
                        if (!colors[j].equals(Color.white)) {
                            c = colors[j];
                            colors[j] = Color.white;
                            break;
                        }
                    }
                }
            }
        }

        return c;
    }

    private boolean circContains(double mouseX, double mouseY, float i) {
        return (Math.pow(mouseX - (centerX + i), 2) + (Math.pow(mouseY - centerY, 2)) - R * R) < 1e-15;
    }

    private void drawText(String string) {
        drawText(string, 1000);
    }

    private void drawText(String string, int duration) {
        StdDraw.clear();
        StdDraw.text(centerX, centerY, string);
        StdDraw.show(duration);
    }
}
