package de.hhu.propra.blatt2.connect4;

public class Board {
    private final int[][] board;
    private final int width;
    private final int height;

    private int currentPlayer = 1;
    private boolean win = false;

    Board(int width, int height) {
        board = new int[height][width];
        this.width = width;
        this.height = height;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean hasWon() {
        return win;
    }

    public void set(int column) throws ColumnIsFullException {
        if (!canSet(column)) {
            throw new ColumnIsFullException();
        }
        int i = 0;
        for (; board[i][column] != 0; i++) {
        }
        board[i][column] = currentPlayer;

        if (checkWin()) {
            win = true;
        } else {
            switchPlayer();
        }
    }

    private void switchPlayer() {
        if (currentPlayer == 1) {
            currentPlayer = 2;
        } else {
            currentPlayer = 1;
        }
    }

    public boolean canSet(int col) {
        return col < width && 0 == board[height - 1][col];
    }

    private boolean checkWin() {
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                int p = board[row][col];
                if (p!= 0 && (hasHorizWin(p, row, col) || hasVerticWin(p, row, col) || hasDiagWin(p, row, col))) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasDiagWin(int p, int row, int col) {
        return col + 3 < width &&
                ((row + 3 < height && p == board[row + 1][col + 1] && p == board[row + 2][col + 2] &&
                        p == board[row + 3][col + 3]) ||
                        (row - 3 >= 0 && p == board[row - 1][col + 1] && p == board[row - 2][col + 2] &&
                                p == board[row - 3][col + 3]));
    }

    private boolean hasVerticWin(int p, int row, int col) {
        return row + 3 < height && p == board[row + 1][col] && p == board[row + 2][col] && p == board[row + 3][col];
    }

    private boolean hasHorizWin(int p, int row, int col) {
        return col + 3 < width && p == board[row][col + 1] && p == board[row][col + 2] && p == board[row][col + 3];
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int get(int row, int col) {
        return board[row][col];
    }

    public class ColumnIsFullException extends IllegalArgumentException {
    }
}
