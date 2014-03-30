package de.hhu.propra.blatt2.wurm;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

public class Wurm {
    private final Field field;
    private List<Point> path;

    public Wurm(Field field) {
        this.field = field;
        setupPath();
    }

    private void setupPath() {
        path = new LinkedList<>();
        path.add(new Point(0, 0));
    }

    public List<Point> getPath() {
        return path;
    }

    public void moveUp() {
        moveY(-1);
    }

    public void moveDown() {
        moveY(1);
    }

    public void moveLeft() {
        moveX(-1);
    }

    public void moveRight() {
        moveX(1);
    }

    private void moveY(int step) {
        Point current = getCurrentPlace();
        int newY = current.y + step;
        if (newY < field.getH() && newY >= 0) {
            addNewPoint(new Point(current.x, newY));
        }
    }

    private void moveX(int step) {
        Point current = getCurrentPlace();
        int newX = current.x + step;
        if (newX < field.getW() && newX >= 0) {
            addNewPoint(new Point(newX, current.y));
        }
    }

    private void addNewPoint(Point newPoint) {
        if (!path.contains(newPoint)) {
            path.add(newPoint);
        }
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
}
