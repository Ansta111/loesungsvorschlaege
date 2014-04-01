package de.hhu.propra.blatt3.tetris;

import de.hhu.propra.StdDraw;
import de.hhu.propra.blatt3.tetris.controller.BoardController;
import de.hhu.propra.blatt3.tetris.model.Board;
import de.hhu.propra.blatt3.tetris.view.BoardView;
import de.hhu.propra.blatt3.tetris.view.ElementView;

import javax.swing.Timer;
import java.awt.Color;

public class Spiel {

    public static void main(String[] args) {
        StdDraw.setCanvasSize(Board.WIDTH * 25, Board.HEIGHT * 25);
        StdDraw.setXscale(0, Board.WIDTH);
        StdDraw.setYscale(0, Board.HEIGHT);

        // Setup model
        Board board = new Board();
        board.setFallingElementView(new ElementView(3, 0));

        // Setup controller & view
        final BoardController ctrl = new BoardController(board);
        final BoardView view = new BoardView(board);

        // Start rendering
        new Timer(100, (src) -> {
            StdDraw.clear(Color.lightGray);
            view.render();
        }).start();

        // Start logic
        new Timer(350, (src) -> {
            ctrl.update();
        }).start();
    }
}
