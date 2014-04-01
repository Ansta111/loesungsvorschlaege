package de.hhu.propra.blatt3.tetris.model;

import de.hhu.propra.blatt3.tetris.view.ElementView;

import java.awt.Color;

public class Board {

    public static final int WIDTH = 10, HEIGHT = 20;

    private boolean finished = false;
    private Color[][] grid = new Color[HEIGHT][WIDTH];
    private ElementView fallingElementView;

    public Color[][] getGrid() {
        return grid;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public ElementView getFallingElementView() {
        return fallingElementView;
    }

    public void freezeFalling() {
        ElementView elementView = getFallingElementView();
        for (int y = 0; y < elementView.getBounds().height; y++) {
            for (int x = 0; x < elementView.getBounds().width; x++) {
                if (elementView.getShape()[y][x] != null) {
                    grid[y + elementView.getPosition().y][x + elementView.getPosition().x] =
                            elementView.getShape()[y][x];
                }
            }
        }
        setFallingElementView(null);
    }

    public void setFallingElementView(ElementView fallingElementView) {
        this.fallingElementView = fallingElementView;
    }

    public boolean isCollidingWithBoard(ElementView elementView) {
        for (int y = 0; y < elementView.getBounds().height; y++) {
            for (int x = 0; x < elementView.getBounds().width; x++) {
                Color color = elementView.getShape()[y][x];
                int ty = elementView.getPosition().y + y;
                int tx = elementView.getPosition().x + x;
                if (ty < 0 || ty >= HEIGHT ||
                        tx < 0 || tx >= WIDTH) {
                    return true;
                }

                Color boardColor = grid[ty][tx];

                if (color != null && boardColor != null) {
                    return true;
                }
            }
        }

        return false;
    }

    public void removeFullRows() {
        for(int i = 0; i < HEIGHT;) {
            if(isRowFull(i)) {

                for (int y = 0; y < i; y++) {
                    for (int x = 0; x < WIDTH; x++) {
                        grid[i - y][x] = grid[i - (y + 1)][x];
                    }
                }

                for (int x = 0; x < WIDTH; x++) {
                    grid[0][x] = null;
                }
            } else {
                i++;
            }
        }
    }

    private boolean isRowFull(int row) {
        for (Color element : grid[row]) {
            if(element == null) {
                return false;
            }
        }
        return true;
    }
}
