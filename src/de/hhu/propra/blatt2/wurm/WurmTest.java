package de.hhu.propra.blatt2.wurm;

import org.junit.Before;
import org.junit.Test;

import java.awt.Point;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class WurmTest {
    private int w=5;
    private int h=5;
    private Wurm wurm;

    @Before
    public void setUp() {
        wurm = new Wurm(new Field(w, h));
    }

    @Test
    public void testDontMoveOutOfBounds1() {
        wurm.moveUp();
        ArrayList<Point> result = new ArrayList<>();
        result.add(new Point(0, 0));
        assertEquals(result, wurm.getPath());
    }

    @Test
    public void testDontMoveOutOfBounds2() {
        wurm.moveLeft();
        ArrayList<Point> result = new ArrayList<>();
        result.add(new Point(0, 0));
        assertEquals(result, wurm.getPath());
    }

    @Test
    public void testDontMoveOutOfBounds3() {
        for (int i = 0; i <=w+1; i++) {
            wurm.moveRight();
        }

        ArrayList<Point> result = new ArrayList<>();
        result.add(new Point(0, 0));
        result.add(new Point(1, 0));
        result.add(new Point(2, 0));
        result.add(new Point(3, 0));
        result.add(new Point(4, 0));

        assertEquals(result, wurm.getPath());
    }

    @Test
    public void testDontMoveOutOfBounds4() {
        for (int i = 0; i <=h+1; i++) {
            wurm.moveDown();
        }

        ArrayList<Point> result = new ArrayList<>();
        result.add(new Point(0, 0));
        result.add(new Point(0, 1));
        result.add(new Point(0, 2));
        result.add(new Point(0, 3));
        result.add(new Point(0, 4));

        assertEquals(result, wurm.getPath());
    }

    @Test
    public void testDontTouchVisitedPlaces1() {
        wurm.moveDown();
        wurm.moveDown();
        wurm.moveRight();
        wurm.moveUp();
        wurm.moveLeft();

        ArrayList<Point> result = new ArrayList<>();
        result.add(new Point(0, 0));
        result.add(new Point(0, 1));
        result.add(new Point(0, 2));
        result.add(new Point(1, 2));
        result.add(new Point(1, 1));

        assertEquals(result, wurm.getPath());
    }

    @Test
    public void testDontTouchVisitedPlaces2() {
        wurm.moveRight();
        wurm.moveRight();
        wurm.moveDown();
        wurm.moveLeft();
        wurm.moveUp();

        ArrayList<Point> result = new ArrayList<>();
        result.add(new Point(0, 0));
        result.add(new Point(1, 0));
        result.add(new Point(2, 0));
        result.add(new Point(2, 1));
        result.add(new Point(1, 1));

        assertEquals(result, wurm.getPath());
    }
}
