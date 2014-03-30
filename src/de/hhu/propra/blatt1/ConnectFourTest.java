package de.hhu.propra.blatt1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConnectFourTest {
    @Test
    public void testHorizontal() {
        char[][] board1 = {
                {'r', 'r', 'r', 'r', ' '},
                {' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' '},
        };
        assertEquals(true, ConnectFour.checkWin(board1));
        char[][] board2 = {
                {' ', ' ', ' ', ' ', ' '},
                {' ', 'r', 'r', 'r', 'r'},
                {' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' '},
        };
        assertEquals(true, ConnectFour.checkWin(board2));
    }

    @Test
    public void testVertical() {
        char[][] board1 = {
                {'r', ' ', ' ', ' ', ' '},
                {'r', ' ', ' ', ' ', ' '},
                {'r', ' ', ' ', ' ', ' '},
                {'r', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' '},
        };
        assertEquals(true, ConnectFour.checkWin(board1));
        char[][] board2 = {
                {' ', ' ', ' ', ' ', ' '},
                {' ', 'r', ' ', ' ', ' '},
                {' ', 'r', ' ', ' ', ' '},
                {' ', 'r', ' ', ' ', ' '},
                {' ', 'r', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' '},
        };
        assertEquals(true, ConnectFour.checkWin(board2));
    }

    @Test
    public void testDiagonal() {
        char[][] board1 = {
                {'r', ' ', ' ', ' ', ' '},
                {' ', 'r', ' ', ' ', ' '},
                {' ', ' ', 'r', ' ', ' '},
                {' ', ' ', ' ', 'r', ' '},
                {' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' '},
        };
        assertEquals(true, ConnectFour.checkWin(board1));
        char[][] board2 = {
                {' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', 'r'},
                {' ', ' ', ' ', 'r', ' '},
                {' ', ' ', 'r', ' ', ' '},
                {' ', 'r', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' '},
        };
        assertEquals(true, ConnectFour.checkWin(board2));
        char[][] board3 = {
                {' ', ' ', ' ', 'r', ' '},
                {' ', ' ', 'r', ' ', ' '},
                {' ', 'r', ' ', ' ', ' '},
                {'r', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' '},
        };
        assertEquals(true, ConnectFour.checkWin(board3));
        char[][] board4 = {
                {' ', ' ', ' ', ' ', ' '},
                {' ', ' ', 'r', ' ', ' '},
                {' ', 'r', ' ', ' ', ' '},
                {'r', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' '},
        };
        assertEquals(false, ConnectFour.checkWin(board4));
        char[][] board5 = {
                {'r', 'r', 'g', 'r', ' '},
                {'g', 'g', 'r', ' ', ' '},
                {'r', 'r', ' ', ' ', ' '},
                {'r', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' '},
        };
        assertEquals(true, ConnectFour.checkWin(board5));
    }
}
