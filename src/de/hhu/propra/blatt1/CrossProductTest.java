package de.hhu.propra.blatt1;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CrossProductTest {
    @Test
    public void testCrossProduct() {
        int[] va = {1, -5, 2};
        int[] vb = {2, 0, 3};
        int[] expected = {-15, 1, 10};
        assertEquals(expected, CrossProduct.crossproduct(va, vb));
    }
}
