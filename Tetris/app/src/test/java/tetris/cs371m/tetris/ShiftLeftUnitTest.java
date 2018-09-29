package tetris.cs371m.tetris;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

    import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static tetris.cs371m.tetris.TestUtil.shiftLeft;
import static tetris.cs371m.tetris.TestUtil.DIRECTION;

/**
 * Created by zhitingz on 2/11/18.
 */
@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE)
public class ShiftLeftUnitTest {

    @Test
    public void shiftLeftI() throws Exception {
        // Normal
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.I();
        boolean ret = shiftLeft(tet, tg, 5, 5, 4, 5, 1,
                0, DIRECTION.CLOCK);
        assertTrue(ret);
    }

    @Test
    public void shiftLeftIBoundary() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.I();
        boolean ret = shiftLeft(tet, tg, 0, 5, 0, 5, 1,
                0, DIRECTION.CLOCK);
        assertFalse(ret);
    }

    @Test
    public void shiftLeftIBoundaryClockOnce() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.I();
        boolean ret = shiftLeft(tet, tg, 0, 5, -2, 5, 3,
                1, DIRECTION.CLOCK);
        assertFalse(ret);
    }

    @Test
    public void shiftLeftIBoundaryClockTwice() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.I();
        boolean ret = shiftLeft(tet, tg, 0, 5, 0, 5, 1,
                2, DIRECTION.CLOCK);
        assertFalse(ret);
    }

    @Test
    public void shiftLeftIBoundaryCounter() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.I();
        boolean ret = shiftLeft(tet, tg, 0, 5, -1, 5, 2,
                1, DIRECTION.COUNTER);
        assertFalse(ret);
    }

    @Test
    public void shiftLeftJ() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.J();
        boolean ret = shiftLeft(tet, tg, 5, 5, 4, 5, 1,
                0, DIRECTION.CLOCK);
        assertTrue(ret);
    }

    @Test
    public void shiftLeftJBoundary() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.J();
        boolean ret = shiftLeft(tet, tg, 0, 5, 0, 5, 1,
                0, DIRECTION.CLOCK);
        assertFalse(ret);
    }

    @Test
    public void shiftLeftJBoundaryRClockOnce() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.J();
        boolean ret = shiftLeft(tet, tg, 0, 5, -1, 5, 2,
                1, DIRECTION.CLOCK);
        assertFalse(ret);
    }

    @Test
    public void shiftLeftJBoundaryRClockTwice() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.J();
        boolean ret = shiftLeft(tet, tg, 0, 5, 0, 5, 1,
                2, DIRECTION.CLOCK);
        assertFalse(ret);
    }

    @Test
    public void shiftLeftJBoundaryRCounter() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.J();
        boolean ret = shiftLeft(tet, tg, 0, 5, 0, 5, 1,
                1, DIRECTION.COUNTER);
        assertFalse(ret);
    }

    @Test
    public void shiftLeftL() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.L();
        boolean ret = shiftLeft(tet, tg, 5, 5, 4, 5, 1,
                0, DIRECTION.CLOCK);
        assertTrue(ret);
    }

    @Test
    public void shiftLeftLBoundary() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.L();
        boolean ret = shiftLeft(tet, tg, 0, 5, 0, 5, 1,
                0, DIRECTION.CLOCK);
        assertFalse(ret);
    }

    @Test
    public void shiftLeftLBoundaryRClockOnce() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.L();
        boolean ret = shiftLeft(tet, tg, 0, 5, -1, 5, 2,
                1, DIRECTION.CLOCK);
        assertFalse(ret);
    }

    @Test
    public void shiftLeftLBoundaryRClockTwice() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.L();
        boolean ret = shiftLeft(tet, tg, 0, 5, 0, 5, 1,
                2, DIRECTION.CLOCK);
        assertFalse(ret);
    }

    @Test
    public void shiftLeftLBoundaryRCounter() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.L();
        boolean ret = shiftLeft(tet, tg, 0, 5, 0, 5, 1,
                1, DIRECTION.COUNTER);
        assertFalse(ret);
    }

    @Test
    public void shiftLeftO() throws Exception {
        // Normal
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.O();
        boolean ret = shiftLeft(tet, tg, 5, 5, 4, 5, 1,
                0, DIRECTION.CLOCK);
        assertTrue(ret);
    }

    @Test
    public void shiftLeftOBoundary() throws Exception {
        // Normal
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.O();
        boolean ret = shiftLeft(tet, tg, 0, 5, -1, 5, 2,
                0, DIRECTION.CLOCK);
        assertFalse(ret);
    }

    @Test
    public void shiftLeftOBoundaryRClockOnce() throws Exception {
        // Normal
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.O();
        boolean ret = shiftLeft(tet, tg, 0, 5, -1, 5, 2,
                1, DIRECTION.CLOCK);
        assertFalse(ret);
    }

    @Test
    public void shiftLeftOBoundaryRClockTwice() throws Exception {
        // Normal
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.O();
        boolean ret = shiftLeft(tet, tg, 0, 5, -1, 5, 2,
                2, DIRECTION.CLOCK);
        assertFalse(ret);
    }

    @Test
    public void shiftLeftOBoundaryRCounter() throws Exception {
        // Normal
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.O();
        boolean ret = shiftLeft(tet, tg, 0, 5, -1, 5, 2,
                1, DIRECTION.COUNTER);
        assertFalse(ret);
    }

    @Test
    public void shiftLeftS() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.S();
        boolean ret = shiftLeft(tet, tg, 5, 5, 4, 5, 1,
                0, DIRECTION.CLOCK);
        assertTrue(ret);
    }

    @Test
    public void shiftLeftSBoundary() throws Exception {
        // Normal
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.S();
        boolean ret = shiftLeft(tet, tg, 0, 5, 0, 5, 1,
                0, DIRECTION.CLOCK);
        assertFalse(ret);
    }

    @Test
    public void shiftLeftSBoundaryRClockOnce() throws Exception {
        // Normal
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.S();
        boolean ret = shiftLeft(tet, tg, 0, 5, -1, 5, 2,
                1, DIRECTION.CLOCK);
        assertFalse(ret);
    }

    @Test
    public void shiftLeftSBoundaryRClockTwice() throws Exception {
        // Normal
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.S();
        boolean ret = shiftLeft(tet, tg, 0, 5, 0, 5, 1,
                2, DIRECTION.CLOCK);
        assertFalse(ret);
    }

    @Test
    public void shiftLeftSBoundaryRCounter() throws Exception {
        // Normal
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.S();
        boolean ret = shiftLeft(tet, tg, 0, 5, 0, 5, 1,
                1, DIRECTION.COUNTER);
        assertFalse(ret);
    }

    @Test
    public void shiftLeftT() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.T();
        boolean ret = shiftLeft(tet, tg, 5, 5, 4, 5, 1,
                0, DIRECTION.CLOCK);
        assertTrue(ret);
    }

    @Test
    public void shiftLeftTBoundary() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.T();
        boolean ret = shiftLeft(tet, tg, 0, 5, 0, 5, 1,
                0, DIRECTION.CLOCK);
        assertFalse(ret);
    }

    @Test
    public void shiftLeftTBoundaryRClockOnce() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.T();
        boolean ret = shiftLeft(tet, tg, 0, 5, -1, 5, 2,
                1, DIRECTION.CLOCK);
        assertFalse(ret);
    }

    @Test
    public void shiftLeftTBoundaryRClockTwice() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.T();
        boolean ret = shiftLeft(tet, tg, 0, 5, 0, 5, 1,
                2, DIRECTION.CLOCK);
        assertFalse(ret);
    }

    @Test
    public void shiftLeftTBoundaryRCounter() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.T();
        boolean ret = shiftLeft(tet, tg, 0, 5, 0, 5, 1,
                1, DIRECTION.COUNTER);
        assertFalse(ret);
    }

    @Test
    public void shiftLeftZ() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.Z();
        boolean ret = shiftLeft(tet, tg, 5, 5, 4, 5, 1,
                0, DIRECTION.CLOCK);
        assertTrue(ret);
    }

    @Test
    public void shiftLeftZBoundary() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.Z();
        boolean ret = shiftLeft(tet, tg, 0, 5, 0, 5, 1,
                0, DIRECTION.CLOCK);
        assertFalse(ret);
    }

    @Test
    public void shiftLeftZBoundaryRClockOnce() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.Z();
        boolean ret = shiftLeft(tet, tg, 0, 5, -1, 5, 2,
                1, DIRECTION.CLOCK);
        assertFalse(ret);
    }

    @Test
    public void shiftLeftZBoundaryRClockTwice() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.Z();
        boolean ret = shiftLeft(tet, tg, 0, 5, 0, 5, 1,
                2, DIRECTION.CLOCK);
        assertFalse(ret);
    }

    @Test
    public void shiftLeftZBoundaryRCounter() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.Z();
        boolean ret = shiftLeft(tet, tg, 0, 5, 0, 5, 1,
                1, DIRECTION.COUNTER);
        assertFalse(ret);
    }
}
