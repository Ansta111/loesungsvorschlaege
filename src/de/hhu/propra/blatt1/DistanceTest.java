package de.hhu.propra.blatt1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DistanceTest {
    @Test
    public void testAbs() {
        assertEquals(37, Distance.distance(42, 5));
        assertEquals(6, Distance.distance(5, 11));
    }
}
