package tetris.cs371m.tetris;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;

/**
 * Created by zhitingz on 2/11/18.
 */

public class WellFormedJ {

    public static void checkOrig(Tetromino J) {
        assertEquals(3, J.getHeight());
        assertEquals(3, J.getWidth());
        assertNotNull(J.getCellAt(0, 0));
        assertNotNull(J.getCellAt(0, 1));
        assertNotNull(J.getCellAt(1, 1));
        assertNotNull(J.getCellAt(2, 1));
        assertNull(J.getCellAt(1, 0));
        assertNull(J.getCellAt(2, 0));

        for (int i = 0; i < 3; i++) {
            assertNull(J.getCellAt(i, 2));
        }
    }

    public static void checkOrigPos(Tetromino J, int xPos, int yPos) {
        TCell t = J.getCellAt(0, 0);
        assertEquals(xPos, t.getXPosition());
        assertEquals(yPos, t.getYPosition());
        t = J.getCellAt(0, 1);
        assertEquals(xPos, t.getXPosition());
        assertEquals(yPos+1, t.getYPosition());
        t = J.getCellAt(1, 1);
        assertEquals(xPos+1, t.getXPosition());
        assertEquals(yPos+1, t.getYPosition());
        t = J.getCellAt(2, 1);
        assertEquals(xPos+2, t.getXPosition());
        assertEquals(yPos+1, t.getYPosition());
    }

    public static void checkRClockOnce(Tetromino J) {
        assertEquals(3, J.getHeight());
        assertEquals(3, J.getWidth());
        for (int j = 0; j < 3; j++) {
            assertNull(J.getCellAt(0, j));
            assertNotNull(J.getCellAt(1, j));
        }
        assertNotNull(J.getCellAt(2, 0));
        assertNull(J.getCellAt(2, 1));
        assertNull(J.getCellAt(2, 2));
    }

    public static void checkRClockOncePos(Tetromino J, int xPos, int yPos) {
        TCell t = J.getCellAt(1, 0);
        assertEquals(xPos+1, t.getXPosition());
        assertEquals(yPos, t.getYPosition());
        t = J.getCellAt(1, 1);
        assertEquals(xPos+1, t.getXPosition());
        assertEquals(yPos+1, t.getYPosition());
        t = J.getCellAt(1, 2);
        assertEquals(xPos+1, t.getXPosition());
        assertEquals(yPos+2, t.getYPosition());
        t = J.getCellAt(2, 0);
        assertEquals(xPos+2, t.getXPosition());
        assertEquals(yPos, t.getYPosition());
    }

    public static void checkRClockTwice(Tetromino J) {
        assertEquals(3, J.getWidth());
        assertEquals(3, J.getHeight());

        for (int i = 0; i < 2; i++) {
            assertNull(J.getCellAt(i, 0));
            assertNotNull(J.getCellAt(i, 1));
            assertNull(J.getCellAt(i, 2));
        }
        assertNull(J.getCellAt(2, 0));
        assertNotNull(J.getCellAt(2, 1));
        assertNotNull(J.getCellAt(2, 2));
    }

    public static void checkRClockTwicePos(Tetromino J, int xPos, int yPos) {
        TCell t = J.getCellAt(2, 2);
        assertEquals(xPos+2, t.getXPosition());
        assertEquals(yPos+2, t.getYPosition());
        t = J.getCellAt(0, 1);
        assertEquals(xPos, t.getXPosition());
        assertEquals(yPos+1, t.getYPosition());
        t = J.getCellAt(1, 1);
        assertEquals(xPos+1, t.getXPosition());
        assertEquals(yPos+1, t.getYPosition());
        t = J.getCellAt(2, 1);
        assertEquals(xPos+2, t.getXPosition());
        assertEquals(yPos+1, t.getYPosition());
    }

    public static void checkRCounterOnce(Tetromino J) {
        assertEquals(3, J.getWidth());
        assertEquals(3, J.getHeight());

        for (int i = 0; i < 3; i++) {
            assertNotNull(J.getCellAt(1, i));
        }
        for (int i = 0; i < 3; i++) {
            assertNull(J.getCellAt(2, i));
        }
        for (int i = 0; i < 2; i++) {
            assertNull(J.getCellAt(0, i));
        }
        assertNotNull(J.getCellAt(0, 2));
    }

    public static void checkRCounterOncePos(Tetromino J, int xPos, int yPos) {
        TCell t = J.getCellAt(1, 0);
        assertEquals(xPos+1, t.getXPosition());
        assertEquals(yPos, t.getYPosition());
        t = J.getCellAt(1, 1);
        assertEquals(xPos+1, t.getXPosition());
        assertEquals(yPos+1, t.getYPosition());
        t = J.getCellAt(1, 2);
        assertEquals(xPos+1, t.getXPosition());
        assertEquals(yPos+2, t.getYPosition());
        t = J.getCellAt(0, 2);
        assertEquals(xPos, t.getXPosition());
        assertEquals(yPos+2, t.getYPosition());
    }

}
