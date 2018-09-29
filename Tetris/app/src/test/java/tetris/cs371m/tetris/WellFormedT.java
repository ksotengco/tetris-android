package tetris.cs371m.tetris;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;

/**
 * Created by zhitingz on 2/11/18.
 */

public class WellFormedT {

    public static void checkOrig(Tetromino T) {
        assertEquals(3, T.getHeight());
        assertEquals(3, T.getWidth());
        assertNotNull(T.getCellAt(0, 1));
        assertNotNull(T.getCellAt(1, 1));
        assertNotNull(T.getCellAt(2, 1));
        assertNotNull(T.getCellAt(1, 0));
        assertNull(T.getCellAt(2, 0));
        assertNull(T.getCellAt(0, 0));

        for (int i = 0; i < 3; i++) {
            assertNull(T.getCellAt(i, 2));
        }
    }

    public static void checkRClockOnce(Tetromino T) {
        assertEquals(3, T.getHeight());
        assertEquals(3, T.getWidth());
        for (int j = 0; j < 3; j++) {
            assertNull(T.getCellAt(0, j));
            assertNotNull(T.getCellAt(1, j));
        }
        assertNotNull(T.getCellAt(2, 1));
        assertNull(T.getCellAt(2, 0));
        assertNull(T.getCellAt(2, 2));
    }

    public static void checkRClockTwice(Tetromino T) {
        assertEquals(3, T.getWidth());
        assertEquals(3, T.getHeight());

        for (int i = 0; i < 3; i++) {
            assertNull(T.getCellAt(i, 0));
        }
        for (int i = 0; i < 3; i++) {
            assertNotNull(T.getCellAt(i, 1));
        }
        assertNull(T.getCellAt(0, 2));
        assertNotNull(T.getCellAt(1, 2));
        assertNull(T.getCellAt(2, 2));
    }

    public static void checkRCounterOnce(Tetromino T) {
        assertEquals(3, T.getWidth());
        assertEquals(3, T.getHeight());

        for (int i = 0; i < 3; i++) {
            assertNotNull(T.getCellAt(1, i));
        }
        for (int i = 0; i < 3; i++) {
            assertNull(T.getCellAt(2, i));
        }
        assertNotNull(T.getCellAt(0, 1));
        assertNull(T.getCellAt(0, 0));
        assertNull(T.getCellAt(0, 2));
    }

    public static void checkOrigPos(Tetromino T, int xPos, int yPos) {
        TCell t = T.getCellAt(1, 0);
        assertEquals(xPos+1, t.getXPosition());
        assertEquals(yPos, t.getYPosition());
        t = T.getCellAt(0, 1);
        assertEquals(xPos, t.getXPosition());
        assertEquals(yPos+1, t.getYPosition());
        t = T.getCellAt(1, 1);
        assertEquals(xPos+1, t.getXPosition());
        assertEquals(yPos+1, t.getYPosition());
        t = T.getCellAt(2, 1);
        assertEquals(xPos+2, t.getXPosition());
        assertEquals(yPos+1, t.getYPosition());
    }

    public static void checkRClockOncePos(Tetromino T, int xPos, int yPos) {
        TCell t = T.getCellAt(1, 0);
        assertEquals(xPos+1, t.getXPosition());
        assertEquals(yPos, t.getYPosition());
        t = T.getCellAt(1, 1);
        assertEquals(xPos+1, t.getXPosition());
        assertEquals(yPos+1, t.getYPosition());
        t = T.getCellAt(1, 2);
        assertEquals(xPos+1, t.getXPosition());
        assertEquals(yPos+2, t.getYPosition());
        t = T.getCellAt(2, 1);
        assertEquals(xPos+2, t.getXPosition());
        assertEquals(yPos+1, t.getYPosition());
    }

    public static void checkRClockTwicePos(Tetromino T, int xPos, int yPos) {
        TCell t = T.getCellAt(1, 2);
        assertEquals(xPos+1, t.getXPosition());
        assertEquals(yPos+2, t.getYPosition());
        t = T.getCellAt(0, 1);
        assertEquals(xPos, t.getXPosition());
        assertEquals(yPos+1, t.getYPosition());
        t = T.getCellAt(1, 1);
        assertEquals(xPos+1, t.getXPosition());
        assertEquals(yPos+1, t.getYPosition());
        t = T.getCellAt(2, 1);
        assertEquals(xPos+2, t.getXPosition());
        assertEquals(yPos+1, t.getYPosition());
    }

    public static void checkRCounterOncePos(Tetromino T, int xPos, int yPos) {
        TCell t = T.getCellAt(1, 0);
        assertEquals(xPos+1, t.getXPosition());
        assertEquals(yPos, t.getYPosition());
        t = T.getCellAt(1, 1);
        assertEquals(xPos+1, t.getXPosition());
        assertEquals(yPos+1, t.getYPosition());
        t = T.getCellAt(1, 2);
        assertEquals(xPos+1, t.getXPosition());
        assertEquals(yPos+2, t.getYPosition());
        t = T.getCellAt(0, 1);
        assertEquals(xPos, t.getXPosition());
        assertEquals(yPos+1, t.getYPosition());
    }
}
