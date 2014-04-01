package de.hhu.propra.blatt3.tetris.view;

import de.hhu.propra.StdDraw;
import de.hhu.propra.blatt3.tetris.model.Board;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.Random;

import static de.hhu.propra.StdDraw.filledRectangle;

public class ElementView {
    private Point position;
    private Color[][] shape;
    private Dimension bounds;
    private static final Random random = new Random();

    public ElementView(int x, int y) {
        position = new Point(x, y);
        chooseShape();
    }

    private void chooseShape() {
        int index = random.nextInt(SHAPES.length);
        setShape(SHAPES[index]);
    }

    private void setShape(Color[][] shape) {
        this.shape = shape;
        calculateBoundingBox();
    }

    private void calculateBoundingBox() {
        int maxWidth = 0;
        // Find max width
        for (Color[] row : shape) {
            maxWidth = Math.max(row.length, maxWidth);
        }

        // Fill rows if necessary
        for (int y = 0; y < shape.length; y++) {
            if(shape[y].length < maxWidth) {
                Color[] filledRow = new Color[maxWidth];
                for (int x = 0; x < maxWidth; x++) {
                    if(x < shape[y].length) {
                        filledRow[x] = shape[y][x];
                    } else {
                        filledRow[x] = null;
                    }
                }
                shape[y] = filledRow;
            }
        }

        bounds = new Dimension(maxWidth, shape.length);
    }

    public ElementView makeTranslated(int x, int y) {
        ElementView newElementView = new ElementView(new Dimension(bounds), new Point(position), shape);
        newElementView.translate(x, y);
        return newElementView;
    }

    public void translate(int x, int y) {
        position.x += x;
        position.y += y;
    }

    public ElementView makeRotated() {
        ElementView newElementView = new ElementView(new Dimension(bounds), new Point(position), shape);
        newElementView.rotate();
        return newElementView;
    }

    private void rotate() {
        Color[][] newShape = new Color[bounds.width][bounds.height];

        // Transpose
        for (int y = 0; y < bounds.height; y++) {
            for (int x = 0; x < bounds.width; x++) {
                newShape[x][y] = shape[y][x];
            }
        }

        // Reverse (weird, i know)
        for (int y = 0; y < bounds.height; y++) {
            for (int x = 0; x < bounds.width / 2; x++) {
                Color old = newShape[x][y];
                newShape[x][y] = newShape[bounds.width - 1 - x][y];
                newShape[bounds.width - 1 - x][y] = old;
            }
        }

        setShape(newShape);
    }

    private ElementView(Dimension bounds, Point position, Color[][] shape) {
        this.bounds = bounds;
        this.position = position;
        this.shape = shape;
    }

    public Dimension getBounds() {
        return bounds;
    }

    public Point getPosition() {
        return position;
    }

    public Color[][] getShape() {
        return shape;
    }

    public static final Color[][][] SHAPES = new Color[][][] {

            /**
             * ####
             */
            new Color[][] {
                    {
                            Color.RED, Color.RED, Color.RED, Color.RED
                    }
            },

            /**
             *  #
             * ###
             */
            new Color[][] {
                    {
                            null, Color.BLUE,
                    },
                    {
                            Color.BLUE, Color.BLUE, Color.BLUE
                    }
            },

            /**
             *  ##
             * ##
             */
            new Color[][] {
                    {
                            null, Color.GREEN, Color.GREEN
                    },
                    {
                            Color.GREEN, Color.GREEN,
                    }
            },


            /**
             * ##
             * ##
             */
            new Color[][] {
                    {
                            Color.YELLOW, Color.YELLOW
                    },
                    {
                            Color.YELLOW, Color.YELLOW
                    }
            },

            /**
             * #
             * #
             * ##
             */
            new Color[][] {
                    {
                            Color.PINK
                    },
                    {
                            Color.PINK
                    },
                    {
                            Color.PINK, Color.PINK
                    }
            },

            /**
             *  #
             *  #
             * ##
             */
            new Color[][] {
                    {
                            null, Color.PINK
                    },
                    {
                            null, Color.PINK
                    },
                    {
                            Color.PINK, Color.PINK
                    }
            }
    };

    public void render() {
        for (int y = 0; y < bounds.height; y++) {
            for (int x = 0; x < bounds.width; x++) {
                Color color = shape[y][x];
                if (color != null) {
                    StdDraw.setPenColor(color);
                    filledRectangle(position.x + x + .5, Board.HEIGHT - (position.y + y + .5), .5, .5);
                }
            }
        }
    }
}
