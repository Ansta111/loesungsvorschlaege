package de.hhu.propra.blatt3.wurm.printer;

import de.hhu.propra.StdDraw;
import de.hhu.propra.blatt2.wurm.printer.WurmPrinter;
import de.hhu.propra.blatt2.wurm.Wurm;

import javax.swing.Timer;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.List;

public class GfxWurmPrinter implements WurmPrinter {
    private Wurm wurm;

    public GfxWurmPrinter(Wurm wurm) {
        this.wurm = wurm;
    }

    @Override
    public void print() {
        new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StdDraw.show();
                StdDraw.clear();
                moveWurm();
                printPath();
                printWurm();
            }
        }).start();
    }

    private void moveWurm() {
        if (StdDraw.isKeyPressed(KeyEvent.VK_W)) {
            wurm.moveDown();
        }
        if (StdDraw.isKeyPressed(KeyEvent.VK_A)) {
            wurm.moveLeft();
        }
        if (StdDraw.isKeyPressed(KeyEvent.VK_S)) {
            wurm.moveUp();
        }
        if (StdDraw.isKeyPressed(KeyEvent.VK_D)) {
            wurm.moveRight();
        }
    }

    private void printPath() {
        List<Point> path = new LinkedList<>(wurm.getPath());
        path.remove(path.size() - 1);
        for (Point p : path) {
            StdDraw.circle(p.x / (double) wurm.getField().getW() + 0.1, p.y / (double) wurm.getField().getH() + 0.1,
                           0.01);
        }
    }

    private void printWurm() {
        StdDraw.picture(wurm.getCurrentPlace().x / (double) wurm.getField().getW() + 0.1,
                        wurm.getCurrentPlace().y / (double) wurm.getField().getH() + 0.1, "res/wurm.png");
    }
}
