package de.hhu.propra.blatt3.snake.coin;

import de.hhu.propra.blatt3.snake.field.Field;

import java.awt.Point;

public class Coin {
    private final Field field;
    private final int value;
    private final Point position;

    public Coin(Field field) {
        this.field = field;

        value = calculateValue();
        position = calculatePosition();
    }

    private Point calculatePosition() {
        return new Point(rnd(0, field.getW() - 1), rnd(0, field.getH() - 1));
    }

    private int calculateValue() {
        return rnd(1, 3);
    }

    private int rnd(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

    public int getValue() {
        return value;
    }

    public Point getPosition() {
        return position;
    }
}
