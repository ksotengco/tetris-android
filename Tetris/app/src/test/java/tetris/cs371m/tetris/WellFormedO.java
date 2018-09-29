package tetris.cs371m.tetris;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;

/**
 * Created by zhitingz on 2/11/18.
 */

public class WellFormedO {

    public static void checkOrig(Tetromino O) {
        assertEquals(3, O.getHeight());
        assertEquals(4, O.getWidth());
        for (int i = 0; i < 4; i++) {
            assertNull(O.getCellAt(i, 2));
        }
        for (int j = 0; j < 2; j++) {
            assertNull(O.getCellAt(0, j));
            assertNotNull(O.getCellAt(1, j));
            assertNotNull(O.getCellAt(2, j));
            assertNull(O.getCellAt(3, j));
        }
    }

    public static void checkOrigPos(Tetromino O, int xPos, int yPos) {
        TCell t = O.getCellAt(1, 0);
        assertEquals(xPos+1, t.getXPosition());
        assertEquals(yPos, t.getYPosition());
        t = O.getCellAt(2, 0);
        assertEquals(xPos+2, t.getXPosition());
        assertEquals(yPos, t.getYPosition());
        t = O.getCellAt(1, 1);
        assertEquals(xPos+1, t.getXPosition());
        assertEquals(yPos+1, t.getYPosition());
        t = O.getCellAt(2, 1);
        assertEquals(xPos+2, t.getXPosition());
        assertEquals(yPos+1, t.getYPosition());
    }
}
