package de.hhu.propra.blatt1;

public class ConnectFour {
    static boolean checkWin(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (hasHorizWin(board, row, col, cols) || hasVerticWin(board, row, col, rows) ||
                        hasDiagWin(board, row, col, rows, cols)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean hasDiagWin(char[][] board, int row, int col, int rows, int cols) {
        char c = board[row][col];
        if (c == ' ') {
            return false;
        }
        return col + 3 < cols &&
                ((row + 3 < rows && c == board[row + 1][col + 1] && c == board[row + 2][col + 2] &&
                        c == board[row + 3][col + 3]) ||
                (row - 3 >= 0 && c == board[row - 1][col + 1] && c == board[row - 2][col + 2] &&
                        c == board[row - 3][col + 3]));
    }

    private static boolean hasVerticWin(char[][] board, int row, int col, int rows) {
        char c = board[row][col];
        if (c == ' ') {
            return false;
        }
        return row + 3 < rows && c == board[row + 1][col] && c == board[row + 2][col] && c == board[row + 3][col];
    }

    private static boolean hasHorizWin(char[][] board, int row, int col, int cols) {
        char c = board[row][col];
        if (c == ' ') {
            return false;
        }
        return col + 3 < cols && c == board[row][col + 1] && c == board[row][col + 2] && c == board[row][col + 3];
    }

    public static void main(String[] args) {
        char[][] board = {
                {' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', 'r', ' '},
                {' ', ' ', 'r', 'r', ' '},
                {' ', 'r', 'r', 'g', 'g'},
                {'r', 'g', 'g', 'g', 'r'},
        };
        System.out.println(checkWin(board));
    }
}
