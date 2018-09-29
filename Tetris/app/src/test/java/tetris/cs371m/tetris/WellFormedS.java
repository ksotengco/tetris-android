package tetris.cs371m.tetris;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;

/**
 * Created by zhitingz on 2/11/18.
 */

public class WellFormedS {

    public static void checkOrig(Tetromino S) {
        assertEquals(3, S.getHeight());
        assertEquals(3, S.getWidth());
        for (int i = 1; i < 3; i++) {
            assertNotNull(S.getCellAt(i, 0));
        }
        for (int i = 0; i < 2; i++) {
            assertNotNull(S.getCellAt(i, 1));
        }
        assertNull(S.getCellAt(2, 1));
        assertNull(S.getCellAt(0, 0));

        for (int i = 0; i < 3; i++) {
            assertNull(S.getCellAt(i, 2));
        }
    }

    public static void checkOrigPos(Tetromino S, int xPos, int yPos) {
        TCell t = S.getCellAt(1, 0);
        assertEquals(xPos+1, t.getXPosition());
        assertEquals(yPos, t.getYPosition());
        t = S.getCellAt(2, 0);
        assertEquals(xPos+2, t.getXPosition());
        assertEquals(yPos, t.getYPosition());
        t = S.getCellAt(0, 1);
        assertEquals(xPos, t.getXPosition());
        assertEquals(yPos+1, t.getYPosition());
        t = S.getCellAt(1, 1);
        assertEquals(xPos+1, t.getXPosition());
        assertEquals(yPos+1, t.getYPosition());
    }

    public static void checkRClockOnce(Tetromino S) {
        assertEquals(3, S.getHeight());
        assertEquals(3, S.getWidth());
        for (int j = 0; j < 3; j++) {
            assertNull(S.getCellAt(0, j));
        }
        for (int j = 0; j < 2; j++) {
            assertNotNull(S.getCellAt(1, j));
        }
        assertNull(S.getCellAt(1, 2));
        for (int j = 1; j < 3; j++) {
            assertNotNull(S.getCellAt(2, j));
        }
        assertNull(S.getCellAt(2, 0));
    }

    public static void checkRClockOncePos(Tetromino S, int xPos, int yPos) {
        TCell t = S.getCellAt(1, 0);
        assertEquals(xPos+1, t.getXPosition());
        assertEquals(yPos, t.getYPosition());

        t = S.getCellAt(1, 1);
        assertEquals(xPos+1, t.getXPosition());
        assertEquals(yPos+1, t.getYPosition());

        t = S.getCellAt(2, 1);
        assertEquals(xPos+2, t.getXPosition());
        assertEquals(yPos+1, t.getYPosition());
        t = S.getCellAt(2, 2);
        assertEquals(xPos+2, t.getXPosition());
        assertEquals(yPos+2, t.getYPosition());
    }

    public static void checkRClockTwice(Tetromino S) {
        assertEquals(3, S.getWidth());
        assertEquals(3, S.getHeight());

        for (int i = 0; i < 3; i++) {
            assertNull(S.getCellAt(i, 0));
        }
        for (int i = 1; i < 3; i++) {
            assertNotNull(S.getCellAt(i, 1));
        }
        for (int i = 0; i < 2; i++) {
            assertNotNull(S.getCellAt(i, 2));
        }

        assertNull(S.getCellAt(0, 1));
        assertNull(S.getCellAt(2, 2));
    }

    public static void checkRClockTwicePos(Tetromino S, int xPos, int yPos) {
        TCell t = S.getCellAt(2, 1);
        assertEquals(xPos+2, t.getXPosition());
        assertEquals(yPos+1, t.getYPosition());

        t = S.getCellAt(1, 1);
        assertEquals(xPos+1, t.getXPosition());
        assertEquals(yPos+1, t.getYPosition());

        t = S.getCellAt(0, 2);
        assertEquals(xPos, t.getXPosition());
        assertEquals(yPos+2, t.getYPosition());
        t = S.getCellAt(1, 2);
        assertEquals(xPos+1, t.getXPosition());
        assertEquals(yPos+2, t.getYPosition());
    }

    public static void checkRCounterOnce(Tetromino S) {
        assertEquals(3, S.getWidth());
        assertEquals(3, S.getHeight());

        for (int i = 0; i < 2; i++) {
            assertNotNull(S.getCellAt(0, i));
        }
        for (int i = 1; i < 3; i++) {
            assertNotNull(S.getCellAt(1, i));
        }
        for (int i = 1; i < 3; i++) {
            assertNull(S.getCellAt(2, i));
        }
        assertNull(S.getCellAt(0, 2));
        assertNull(S.getCellAt(1, 0));
    }

    public static void checkRCounterOncePos(Tetromino S, int xPos, int yPos) {
        TCell t = S.getCellAt(0, 0);
        assertEquals(xPos, t.getXPosition());
        assertEquals(yPos, t.getYPosition());

        t = S.getCellAt(0, 1);
        assertEquals(xPos, t.getXPosition());
        assertEquals(yPos+1, t.getYPosition());

        t = S.getCellAt(1, 1);
        assertEquals(xPos+1, t.getXPosition());
        assertEquals(yPos+1, t.getYPosition());
        t = S.getCellAt(1, 2);
        assertEquals(xPos+1, t.getXPosition());
        assertEquals(yPos+2, t.getYPosition());
    }
}
