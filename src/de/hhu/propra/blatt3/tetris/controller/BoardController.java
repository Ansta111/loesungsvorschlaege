package de.hhu.propra.blatt3.tetris.controller;

import de.hhu.propra.StdDraw;
import de.hhu.propra.blatt3.tetris.model.Board;
import de.hhu.propra.blatt3.tetris.view.ElementView;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BoardController {

    private Board board;

    public BoardController(Board board) {
        this.board = board;

        // Register input handling
        StdDraw.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    rotateFalling();
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    move(-1, 0);
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    move(1, 0);
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    move(0, 1);
                }
            }
        });
    }

    private void move(int x, int y) {
        if(board.isFinished()) {
            return;
        }

        ElementView falling = board.getFallingElementView();

        // Make a copy to check collision
        ElementView next = falling.makeTranslated(x, y);

        if(!board.isCollidingWithBoard(next)) {
            board.setFallingElementView(next);
        }
    }

    private void rotateFalling() {
        if(board.isFinished()) {
            return;
        }

        ElementView falling = board.getFallingElementView();

        // Make a copy to check collision
        ElementView next = falling.makeRotated();

        if(!board.isCollidingWithBoard(next)) {
            board.setFallingElementView(next);
        }
    }

    public void update() {
        if(board.isFinished()) {
            return;
        }

        ElementView falling = board.getFallingElementView();

        // Make a copy to check collision
        ElementView next = falling.makeTranslated(0, 1);

        if(board.isCollidingWithBoard(next)) {

            // The falling has landed, freeze it!
            board.freezeFalling();
            board.removeFullRows();

            // Create new element
            ElementView newElementView = new ElementView(3, 0);
            if(board.isCollidingWithBoard(newElementView)) {
                // No space, game is over
                board.setFinished(true);
            } else {
                // Set the element as new falling element
                board.setFallingElementView(newElementView);
            }
        } else {
            board.setFallingElementView(next);
        }
    }
}
