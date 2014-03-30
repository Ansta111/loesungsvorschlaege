package de.hhu.propra.blatt2.wurm.printer;

import de.hhu.propra.blatt2.wurm.Wurm;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ConsoleWurmPrinter implements WurmPrinter {
    private Wurm wurm;

    public ConsoleWurmPrinter(Wurm wurm) {
        this.wurm = wurm;
    }

    @Override
    public void print() {
        while (true) {
            printPath();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Was tun? (x bricht ab)");
            String move = scanner.nextLine();
            switch (move) {
                case "x":
                    return;
                case "w":
                    wurm.moveUp();
                    break;
                case "a":
                    wurm.moveLeft();
                    break;
                case "s":
                    wurm.moveDown();
                    break;
                case "d":
                    wurm.moveRight();
                    break;
            }
        }
    }
    private void printPath() {
        char[][] field = createField();

        printHorizontalBounds();
        System.out.println();
        for (int i = 0; i<wurm.getField().getW(); i++) {
            for (int j = 0; j < wurm.getField().getH() + 2; j++) {
                if (j == 0 || j >= wurm.getField().getH() + 1) {
                    System.out.print('|');
                } else {
                    if (field[i][j-1] != 0) {
                        System.out.print(field[i][j-1]);
                    } else {
                        System.out.print(' ');
                    }
                }
            }
            System.out.println();
        }
        System.out.println();
        printHorizontalBounds();
        System.out.println();
    }

    private char[][] createField() {
        List<Point> path = new LinkedList<>(wurm.getPath());
        path.remove(path.size() - 1);
        char[][] field = new char[wurm.getField().getW()][wurm.getField().getH()];
        for (Point point : path) {
            field[point.y][point.x] = '#';
        }
        Point current = wurm.getCurrentPlace();
        field[current.y][current.x] = 'W';
        return field;
    }

    private void printHorizontalBounds() {
        for (int i = 0; i < wurm.getField().getW() + 2; i++) {
            System.out.print('-');
        }
    }
}
