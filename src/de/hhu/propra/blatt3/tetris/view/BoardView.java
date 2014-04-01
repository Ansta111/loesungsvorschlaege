package de.hhu.propra.blatt3.tetris.view;

import de.hhu.propra.StdDraw;
import de.hhu.propra.blatt3.tetris.model.Board;

import java.awt.Color;

public class BoardView {

    private Board board;

    public BoardView(Board board) {
        this.board = board;
    }

    public void render() {
        // Render the falling element
        if (board.getFallingElementView() != null) {
            board.getFallingElementView().render();
        }

        // Render the static board
        for (int y = 0; y < Board.HEIGHT; y++) {
            for (int x = 0; x < Board.WIDTH; x++) {
                Color color = board.getGrid()[y][x];
                if (color != null) {
                    StdDraw.setPenColor(color);
                    StdDraw.filledRectangle(x + .5, Board.HEIGHT - (y + .5), .5, .5);
                }
            }
        }

        if (board.isFinished()) {
            StdDraw.setPenColor(Color.BLACK);
            StdDraw.text(Board.WIDTH / 2.0, -0.02 * Board.HEIGHT, "GAME OVER!");
        }
    }
}
