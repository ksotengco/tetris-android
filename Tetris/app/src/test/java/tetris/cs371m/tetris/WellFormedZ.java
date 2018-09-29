package tetris.cs371m.tetris;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;

/**
 * Created by zhitingz on 2/11/18.
 */

public class WellFormedZ {

    public static void checkOrig(Tetromino Z) {
        assertEquals(3, Z.getHeight());
        assertEquals(3, Z.getWidth());
        for (int i = 1; i < 3; i++) {
            assertNotNull(Z.getCellAt(i, 1));
        }
        for (int i = 0; i < 2; i++) {
            assertNotNull(Z.getCellAt(i, 0));
        }
        assertNull(Z.getCellAt(2, 0));
        assertNull(Z.getCellAt(0, 1));

        for (int i = 0; i < 3; i++) {
            assertNull(Z.getCellAt(i, 2));
        }
    }

    public static void checkRClockOnce(Tetromino Z) {
        assertEquals(3, Z.getHeight());
        assertEquals(3, Z.getWidth());
        for (int j = 0; j < 3; j++) {
            assertNull(Z.getCellAt(0, j));
        }
        for (int j = 0; j < 2; j++) {
            assertNotNull(Z.getCellAt(2, j));
        }
        assertNull(Z.getCellAt(2, 2));
        for (int j = 1; j < 3; j++) {
            assertNotNull(Z.getCellAt(1, j));
        }
        assertNull(Z.getCellAt(1, 0));
    }

    public static void checkRClockTwice(Tetromino Z) {
        assertEquals(3, Z.getWidth());
        assertEquals(3, Z.getHeight());

        for (int i = 0; i < 3; i++) {
            assertNull(Z.getCellAt(i, 0));
        }
        for (int i = 1; i < 3; i++) {
            assertNotNull(Z.getCellAt(i, 2));
        }
        for (int i = 0; i < 2; i++) {
            assertNotNull(Z.getCellAt(i, 1));
        }

        assertNull(Z.getCellAt(2, 1));
        assertNull(Z.getCellAt(0, 2));
    }

    public static void checkRCounterOnce(Tetromino Z) {
        assertEquals(3, Z.getWidth());
        assertEquals(3, Z.getHeight());

        for (int i = 0; i < 2; i++) {
            assertNotNull(Z.getCellAt(1, i));
        }
        for (int i = 1; i < 3; i++) {
            assertNotNull(Z.getCellAt(0, i));
        }
        for (int i = 1; i < 3; i++) {
            assertNull(Z.getCellAt(2, i));
        }
        assertNull(Z.getCellAt(0, 0));
        assertNull(Z.getCellAt(1, 2));
    }

    public static void checkOrigPos(Tetromino Z, int xPos, int yPos) {
        TCell t = Z.getCellAt(1, 0);
        assertEquals(xPos+1, t.getXPosition());
        assertEquals(yPos, t.getYPosition());
        t = Z.getCellAt(0, 0);
        assertEquals(xPos, t.getXPosition());
        assertEquals(yPos, t.getYPosition());
        t = Z.getCellAt(2, 1);
        assertEquals(xPos+2, t.getXPosition());
        assertEquals(yPos+1, t.getYPosition());
        t = Z.getCellAt(1, 1);
        assertEquals(xPos+1, t.getXPosition());
        assertEquals(yPos+1, t.getYPosition());
    }

    public static void checkRClockOncePos(Tetromino Z, int xPos, int yPos) {
        TCell t = Z.getCellAt(1, 2);
        assertEquals(xPos+1, t.getXPosition());
        assertEquals(yPos+2, t.getYPosition());

        t = Z.getCellAt(1, 1);
        assertEquals(xPos+1, t.getXPosition());
        assertEquals(yPos+1, t.getYPosition());

        t = Z.getCellAt(2, 1);
        assertEquals(xPos+2, t.getXPosition());
        assertEquals(yPos+1, t.getYPosition());
        t = Z.getCellAt(2, 0);
        assertEquals(xPos+2, t.getXPosition());
        assertEquals(yPos, t.getYPosition());
    }

    public static void checkRClockTwicePos(Tetromino Z, int xPos, int yPos) {
        TCell t = Z.getCellAt(0, 1);
        assertEquals(xPos, t.getXPosition());
        assertEquals(yPos+1, t.getYPosition());

        t = Z.getCellAt(1, 1);
        assertEquals(xPos+1, t.getXPosition());
        assertEquals(yPos+1, t.getYPosition());

        t = Z.getCellAt(2, 2);
        assertEquals(xPos+2, t.getXPosition());
        assertEquals(yPos+2, t.getYPosition());
        t = Z.getCellAt(1, 2);
        assertEquals(xPos+1, t.getXPosition());
        assertEquals(yPos+2, t.getYPosition());
    }

    public static void checkRCounterOncePos(Tetromino Z, int xPos, int yPos) {
        TCell t = Z.getCellAt(0, 2);
        assertEquals(xPos, t.getXPosition());
        assertEquals(yPos+2, t.getYPosition());

        t = Z.getCellAt(0, 1);
        assertEquals(xPos, t.getXPosition());
        assertEquals(yPos+1, t.getYPosition());

        t = Z.getCellAt(1, 1);
        assertEquals(xPos+1, t.getXPosition());
        assertEquals(yPos+1, t.getYPosition());
        t = Z.getCellAt(1, 0);
        assertEquals(xPos+1, t.getXPosition());
        assertEquals(yPos, t.getYPosition());
    }
}
