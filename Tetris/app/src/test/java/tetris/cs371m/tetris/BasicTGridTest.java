package tetris.cs371m.tetris;

import android.graphics.Color;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertTrue;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE)
public class BasicTGridTest {

    @Test
    public void clear() {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.I();
        int x = 0;
        int y = 18;
        tet.insertIntoGrid(x, y, tg);
        WellFormedI.checkOrig(tet);
        WellFormedI.checkOrigPos(tet, x, y);
        tg.clear();
        assertNull (tg.getCellAt(x, y+1));
        assertNull (tg.getCellAt(x+1, y+1));
        assertNull (tg.getCellAt(x+2, y+1));
        assertNull (tg.getCellAt(x+3, y+1));
    }

    @Test
    public void fullRowclearRow() {
        TGrid tg = new TGrid(10, 20);
        Tetromino i1 = TetrominoBuilder.I();
        i1.insertIntoGrid(0, 18, tg);
        Tetromino i2 = TetrominoBuilder.I();
        i2.insertIntoGrid(4, 18, tg);
        // Not a full row yet
        assert(tg.getFirstFullRow() == -1);
        Tetromino o = TetrominoBuilder.O();
        o.insertIntoGrid(7, 18, tg);
        for (int i = 0; i < 10; i++) {
            assertNotNull(tg.getCellAt(i, 19));
        }
        assertNotNull(tg.getCellAt(8, 18));
        assertNotNull(tg.getCellAt(9, 18));
        // delete the last row
        int first_full_row_number = tg.getFirstFullRow();
        assert(first_full_row_number == 19);
        assertTrue(tg.deleteRow(19));
        for (int i = 0; i < 8; i++) {
            assertNull(tg.getCellAt(i, 19));
        }
        assertNotNull(tg.getCellAt(8, 19));
        assertNotNull(tg.getCellAt(9, 19));
    }

    @Test
    public void getCell() {
        TGrid tg = new TGrid(10, 20);
        Tetromino i1 = TetrominoBuilder.I();
        i1.insertIntoGrid(0, 18, tg);
        assertNull(tg.getCellAt(-1, 19));
        assertNull(tg.getCellAt(10, 19));
        assertNull(tg.getCellAt(0, -1));
        assertNull(tg.getCellAt(0, 20));
    }

    @Test
    public void putCellRemoveCell() {
        TGrid tg = new TGrid(4,4);
        assertFalse(tg.putCell(-1, 0, new TCell(Color.RED)));
        assertFalse(tg.putCell(4, 0, new TCell(Color.RED)));
        assertFalse(tg.putCell(0, -1, new TCell(Color.RED)));
        assertFalse(tg.putCell(0, 4, new TCell(Color.RED)));
        TCell t = new TCell(Color.RED);
        tg.putCell(0, 3, t);
        assert(t.getYPosition() == 3);
        assert(t.getXPosition() == 0);

        TGrid tet = new Tetromino(4, 4);
        assertFalse(tet.putCell(-1, 0, new TCell(Color.RED)));
        assertFalse(tet.putCell(4, 0, new TCell(Color.RED)));
        assertFalse(tet.putCell(0, -1, new TCell(Color.RED)));
        assertFalse(tet.putCell(0, 4, new TCell(Color.RED)));
        TCell t1 = new TCell(Color.RED);
        tet.putCell(0, 3, t1);
        assert(t1.getYPosition() == -1);
        assert(t1.getXPosition() == -1);

        assertFalse(tet.removeCell(-1, 0));
        assertFalse(tet.removeCell(4, 0));
        assertFalse(tet.removeCell(0, -1));
        assertFalse(tet.removeCell(0, 4));
        assertTrue(tet.removeCell(0, 3));
        assertNull(tet.getCellAt(0, 3));
    }
}
