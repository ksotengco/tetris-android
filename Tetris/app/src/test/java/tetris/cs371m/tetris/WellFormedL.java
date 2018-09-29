package tetris.cs371m.tetris;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;

/**
 * Created by zhitingz on 2/11/18.
 */

public class WellFormedL {

    public static void checkOrig(Tetromino L) {
        assertEquals(3, L.getHeight());
        assertEquals(3, L.getWidth());
        assertNotNull(L.getCellAt(0, 1));
        assertNotNull(L.getCellAt(1, 1));
        assertNotNull(L.getCellAt(2, 1));
        assertNotNull(L.getCellAt(2, 0));
        assertNull(L.getCellAt(1, 0));
        assertNull(L.getCellAt(0, 0));

        for (int i = 0; i < 3; i++) {
            assertNull(L.getCellAt(i, 2));
        }
    }

    public static void checkRClockOnce(Tetromino L) {
        assertEquals(3, L.getHeight());
        assertEquals(3, L.getWidth());
        for (int j = 0; j < 3; j++) {
            assertNull(L.getCellAt(0, j));
            assertNotNull(L.getCellAt(1, j));
        }
        assertNotNull(L.getCellAt(2, 2));
        assertNull(L.getCellAt(2, 0));
        assertNull(L.getCellAt(2, 1));
    }

    public static void checkRClockTwice(Tetromino L) {
        assertEquals(3, L.getWidth());
        assertEquals(3, L.getHeight());

        for (int i = 1; i < 3; i++) {
            assertNull(L.getCellAt(i, 0));
            assertNotNull(L.getCellAt(i, 1));
            assertNull(L.getCellAt(i, 2));
        }
        assertNull(L.getCellAt(0, 0));
        assertNotNull(L.getCellAt(0, 1));
        assertNotNull(L.getCellAt(0, 2));
    }

    public static void checkRCounterOnce(Tetromino L) {
        assertEquals(3, L.getWidth());
        assertEquals(3, L.getHeight());

        for (int i = 0; i < 3; i++) {
            assertNotNull(L.getCellAt(1, i));
        }
        for (int i = 0; i < 3; i++) {
            assertNull(L.getCellAt(2, i));
        }
        for (int i = 1; i < 3; i++) {
            assertNull(L.getCellAt(0, i));
        }
        assertNotNull(L.getCellAt(0, 0));
    }

    public static void checkOrigPos(Tetromino L, int xPos, int yPos) {
        TCell t = L.getCellAt(2, 0);
        assertEquals(xPos+2, t.getXPosition());
        assertEquals(yPos, t.getYPosition());
        t = L.getCellAt(0, 1);
        assertEquals(xPos, t.getXPosition());
        assertEquals(yPos+1, t.getYPosition());
        t = L.getCellAt(1, 1);
        assertEquals(xPos+1, t.getXPosition());
        assertEquals(yPos+1, t.getYPosition());
        t = L.getCellAt(2, 1);
        assertEquals(xPos+2, t.getXPosition());
        assertEquals(yPos+1, t.getYPosition());
    }

    public static void checkRClockOncePos(Tetromino L, int xPos, int yPos) {
        TCell t = L.getCellAt(1, 0);
        assertEquals(xPos+1, t.getXPosition());
        assertEquals(yPos, t.getYPosition());
        t = L.getCellAt(1, 1);
        assertEquals(xPos+1, t.getXPosition());
        assertEquals(yPos+1, t.getYPosition());
        t = L.getCellAt(1, 2);
        assertEquals(xPos+1, t.getXPosition());
        assertEquals(yPos+2, t.getYPosition());
        t = L.getCellAt(2, 2);
        assertEquals(xPos+2, t.getXPosition());
        assertEquals(yPos+2, t.getYPosition());
    }

    public static void checkRClockTwicePos(Tetromino L, int xPos, int yPos) {
        TCell t = L.getCellAt(0, 2);
        assertEquals(xPos, t.getXPosition());
        assertEquals(yPos+2, t.getYPosition());
        t = L.getCellAt(0, 1);
        assertEquals(xPos, t.getXPosition());
        assertEquals(yPos+1, t.getYPosition());
        t = L.getCellAt(1, 1);
        assertEquals(xPos+1, t.getXPosition());
        assertEquals(yPos+1, t.getYPosition());
        t = L.getCellAt(2, 1);
        assertEquals(xPos+2, t.getXPosition());
        assertEquals(yPos+1, t.getYPosition());
    }

    public static void checkRCounterOncePos(Tetromino L, int xPos, int yPos) {
        TCell t = L.getCellAt(1, 0);
        assertEquals(xPos+1, t.getXPosition());
        assertEquals(yPos, t.getYPosition());
        t = L.getCellAt(1, 1);
        assertEquals(xPos+1, t.getXPosition());
        assertEquals(yPos+1, t.getYPosition());
        t = L.getCellAt(1, 2);
        assertEquals(xPos+1, t.getXPosition());
        assertEquals(yPos+2, t.getYPosition());
        t = L.getCellAt(0, 0);
        assertEquals(xPos, t.getXPosition());
        assertEquals(yPos, t.getYPosition());
    }

}
