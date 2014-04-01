package de.hhu.propra.blatt3.snake.wurm;

import de.hhu.propra.blatt3.snake.field.Field;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

public class Wurm {
    public List<Point> getTail() {
        return getPath().subList(0, getPath().size() - 1);
    }

    public static enum Direction {
        North, South, East, West
    }

    private boolean blocked = false;
    private final Field field;
    private LinkedList<Point> path;
    private Direction direction = Direction.East;

    private int numCoins = 1;

    private void moveY(int step) {
        Point current = getCurrentPlace();
        int newY = current.y + step;
        if (newY < field.getH() && newY >= 0) {
            addNewPoint(new Point(current.x, newY));
        } else {
            blocked = true;
        }
    }

    private void moveX(int step) {
        Point current = getCurrentPlace();
        int newX = current.x + step;
        if (newX < field.getW() && newX >= 0) {
            addNewPoint(new Point(newX, current.y));
        } else {
            blocked = true;
        }
    }

    private void addNewPoint(Point newPoint) {
        if (!path.contains(newPoint)) {
            path.add(newPoint);

            if(path.size() > numCoins) {
                path.removeFirst();
            }
        } else {
            blocked = true;
        }
    }

    private void setupPath() {
        path = new LinkedList<>();
        path.add(new Point(0, 0));
    }

    public Wurm(Field field) {
        this.field = field;
        setupPath();
    }

    public Direction getDirection() {
        return direction;
    }

    private void setDirection(Direction direction) { this.direction = direction; }

    public List<Point> getPath() {
        return path;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void move() {
        switch (direction) {
            case North: moveY(1);
                break;
            case South: moveY(-1);
                break;
            case East: moveX(1);
                break;
            case West: moveX(-1);
                break;
        }
    }

    public void moveUp() {
        setDirection(Direction.North);
    }

    public void moveDown() {
        setDirection(Direction.South);
    }

    public void moveLeft() {
        setDirection(Direction.West);
    }

    public void moveRight() {
        setDirection(Direction.East);
    }

    public Point getCurrentPlace() {
        if (!path.isEmpty()) {
            return path.get(path.size() - 1);
        }
        return null;
    }

    public Field getField() {
        return field;
    }

    public void eatCoin(int coinValue) {
        numCoins += coinValue;
    }
}
