package tetris.cs371m.tetris;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by zhitingz on 2/11/18.
 */

public class WellFormedI {

    public static void checkOrig(Tetromino I) {
        assertEquals(4, I.getWidth());
        assertEquals(4, I.getHeight());
        for (int i = 0; i < I.getWidth(); i++) {
            assertNull(I.getCellAt(i, 0));
            assertNotNull(I.getCellAt(i, 1));
            assertNull(I.getCellAt(i, 2));
            assertNull(I.getCellAt(i, 3));
        }
    }

    public static void checkOrigPos(Tetromino I, int xPos, int yPos) {
        TCell t = I.getCellAt(0, 1);
        assertEquals(xPos, t.getXPosition());
        assertEquals(yPos+1, t.getYPosition());
        t = I.getCellAt(1, 1);
        assertEquals(xPos+1, t.getXPosition());
        assertEquals(yPos+1, t.getYPosition());
        t = I.getCellAt(2, 1);
        assertEquals(xPos+2, t.getXPosition());
        assertEquals(yPos+1, t.getYPosition());
        t = I.getCellAt(3, 1);
        assertEquals(xPos+3, t.getXPosition());
        assertEquals(yPos+1, t.getYPosition());
    }


    public static void checkRClockOnce(Tetromino I) {
        assertEquals(4, I.getWidth());
        assertEquals(4, I.getHeight());
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < I.getHeight(); j++) {
                assertNull(I.getCellAt(i, j));
            }
        }
        for (int j = 0; j < I.getHeight(); j++) {
            assertNotNull(I.getCellAt(2, j));
        }
        for (int j = 0; j < I.getHeight(); j++) {
            assertNull(I.getCellAt(3, j));
        }
    }

    public static void checkRClockOncePos(Tetromino I, int xPos, int yPos) {
        TCell t = I.getCellAt(2, 0);
        assertEquals(xPos+2, t.getXPosition());
        assertEquals(yPos, t.getYPosition());
        t = I.getCellAt(2, 1);
        assertEquals(xPos+2, t.getXPosition());
        assertEquals(yPos+1, t.getYPosition());
        t = I.getCellAt(2, 2);
        assertEquals(xPos+2, t.getXPosition());
        assertEquals(yPos+2, t.getYPosition());
        t = I.getCellAt(2, 3);
        assertEquals(xPos+2, t.getXPosition());
        assertEquals(yPos+3, t.getYPosition());
    }



    public static void checkRClockTwice(Tetromino I) {
        assertEquals(4, I.getWidth());
        assertEquals(4, I.getHeight());
        for (int i = 0; i < I.getWidth(); i++) {
            assertNull(I.getCellAt(i, 0));
            assertNull(I.getCellAt(i, 1));
            assertNotNull(I.getCellAt(i, 2));
            assertNull(I.getCellAt(i, 3));
        }
    }

    public static void checkRClockTwicePos(Tetromino I, int xPos, int yPos) {
        TCell t = I.getCellAt(0, 2);
        assertEquals(xPos, t.getXPosition());
        assertEquals(yPos+2, t.getYPosition());
        t = I.getCellAt(1, 2);
        assertEquals(xPos+1, t.getXPosition());
        assertEquals(yPos+2, t.getYPosition());
        t = I.getCellAt(2, 2);
        assertEquals(xPos+2, t.getXPosition());
        assertEquals(yPos+2, t.getYPosition());
        t = I.getCellAt(3, 2);
        assertEquals(xPos+3, t.getXPosition());
        assertEquals(yPos+2, t.getYPosition());
    }

    public static void checkRCounterOnce(Tetromino I) {
        assertEquals(4, I.getWidth());
        assertEquals(4, I.getHeight());
        for (int i = 2; i < 4; i++) {
            for (int j = 0; j < I.getHeight(); j++) {
                assertNull(I.getCellAt(i, j));
            }
        }
        for (int j = 0; j < I.getHeight(); j++) {
            assertNotNull(I.getCellAt(1, j));
        }
        for (int j = 0; j < I.getHeight(); j++) {
            assertNull(I.getCellAt(0, j));
        }
    }

    public static void checkRCounterOncePos(Tetromino I, int xPos, int yPos) {
        TCell t = I.getCellAt(1, 0);
        assertEquals(xPos+1, t.getXPosition());
        assertEquals(yPos, t.getYPosition());
        t = I.getCellAt(1, 1);
        assertEquals(xPos+1, t.getXPosition());
        assertEquals(yPos+1, t.getYPosition());
        t = I.getCellAt(1, 2);
        assertEquals(xPos+1, t.getXPosition());
        assertEquals(yPos+2, t.getYPosition());
        t = I.getCellAt(1, 3);
        assertEquals(xPos+1, t.getXPosition());
        assertEquals(yPos+3, t.getYPosition());
    }

}
