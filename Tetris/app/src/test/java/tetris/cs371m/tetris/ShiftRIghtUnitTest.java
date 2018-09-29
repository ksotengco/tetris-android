package tetris.cs371m.tetris;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.*;
import static tetris.cs371m.tetris.TestUtil.DIRECTION;
import static tetris.cs371m.tetris.TestUtil.shiftRight;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE)
public class ShiftRIghtUnitTest {

    @Test
    public void shiftRightI() throws Exception {
        // Normal
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.I();
        boolean ret = shiftRight(tet, tg, 5, 5, 6, 5, 1,
                0, DIRECTION.CLOCK);
        assertTrue(ret);
    }

    @Test
    public void shiftRightIBoundary() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.I();
        boolean ret = shiftRight(tet, tg, 6, 5, 6, 5, 1,
                0, DIRECTION.CLOCK);
        assertFalse(ret);
    }

    @Test
    public void shiftRightIBoundaryRClockOnce() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.I();
        boolean ret = shiftRight(tet, tg, 6, 5, 7, 5, 2,
                1, DIRECTION.CLOCK);
        assertFalse(ret);
    }

    @Test
    public void shiftRightIBoundaryRClockTwice() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.I();
        boolean ret = shiftRight(tet, tg, 6, 5, 6, 5, 1,
                2, DIRECTION.CLOCK);
        assertFalse(ret);
    }

    @Test
    public void shiftRightIBoundaryRCounter() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.I();
        boolean ret = shiftRight(tet, tg, 6, 5, 8, 5, 3,
                1, DIRECTION.COUNTER);
        assertFalse(ret);
    }

    @Test
    public void shiftRightJ() throws Exception {
        // Normal
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.J();
        boolean ret = shiftRight(tet, tg, 5, 5, 6, 5, 1,
                0, DIRECTION.CLOCK);
        assertTrue(ret);
    }

    @Test
    public void shiftRightJBoundary() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.J();
        boolean ret = shiftRight(tet, tg, 7, 5, 7, 5, 1,
                0, DIRECTION.CLOCK);
        assertFalse(ret);
    }

    @Test
    public void shiftRightJBoundaryRClockOnce() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.J();
        boolean ret = shiftRight(tet, tg, 7, 5, 7, 5, 1,
                1, DIRECTION.CLOCK);
        assertFalse(ret);
    }

    @Test
    public void shiftRightJBoundaryRClockTwice() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.J();
        boolean ret = shiftRight(tet, tg, 7, 5, 7, 5, 1,
                2, DIRECTION.CLOCK);
        assertFalse(ret);
    }

    @Test
    public void shiftRightJBoundaryRCounter() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.J();
        boolean ret = shiftRight(tet, tg, 7, 5, 8, 5, 2,
                1, DIRECTION.COUNTER);
        assertFalse(ret);
    }

    @Test
    public void shiftRightL() throws Exception {
        // Normal
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.L();
        boolean ret = shiftRight(tet, tg, 5, 5, 6, 5, 1,
                0, DIRECTION.CLOCK);
        assertTrue(ret);
    }

    @Test
    public void shiftRightLBoundary() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.L();
        boolean ret = shiftRight(tet, tg, 7, 5, 7, 5, 1,
                0, DIRECTION.CLOCK);
        assertFalse(ret);
    }

    @Test
    public void shiftRightLBoundaryRClockOnce() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.L();
        boolean ret = shiftRight(tet, tg, 7, 5, 7, 5, 1,
                1, DIRECTION.CLOCK);
        assertFalse(ret);
    }

    @Test
    public void shiftRightLBoundaryRClockTwice() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.L();
        boolean ret = shiftRight(tet, tg, 7, 5, 7, 5, 1,
                2, DIRECTION.CLOCK);
        assertFalse(ret);
    }

    @Test
    public void shiftRightLBoundaryRCounter() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.L();
        boolean ret = shiftRight(tet, tg, 7, 5, 8, 5, 2,
                1, DIRECTION.COUNTER);
        assertFalse(ret);
    }

    @Test
    public void shiftRightO() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.O();
        boolean ret = shiftRight(tet, tg, 5, 5, 6, 5, 1,
                0, DIRECTION.CLOCK);
        assertTrue(ret);
    }

    @Test
    public void shiftRightOBoundary() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.O();
        boolean ret = shiftRight(tet, tg, 6, 5, 7, 5, 2,
                0, DIRECTION.CLOCK);
        assertFalse(ret);
    }

    @Test
    public void shiftRightOBoundaryRClockOnce() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.O();
        boolean ret = shiftRight(tet, tg, 6, 5, 7, 5, 2,
                1, DIRECTION.CLOCK);
        assertFalse(ret);
    }

    @Test
    public void shiftRightOBoundaryRClockTwice() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.O();
        boolean ret = shiftRight(tet, tg, 6, 5, 7, 5, 2,
                2, DIRECTION.CLOCK);
        assertFalse(ret);
    }

    @Test
    public void shiftRightOBoundaryRCounter() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.O();
        boolean ret = shiftRight(tet, tg, 6, 5, 7, 5, 2,
                1, DIRECTION.COUNTER);
        assertFalse(ret);
    }

    @Test
    public void shiftRightS() throws Exception {
        // Normal
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.S();
        boolean ret = shiftRight(tet, tg, 5, 5, 6, 5, 1,
                0, DIRECTION.CLOCK);
        assertTrue(ret);
    }

    @Test
    public void shiftRightSBoundary() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.S();
        boolean ret = shiftRight(tet, tg, 7, 5, 7, 5, 1,
                0, DIRECTION.CLOCK);
        assertFalse(ret);
    }

    @Test
    public void shiftRightSBoundaryRClockOnce() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.S();
        boolean ret = shiftRight(tet, tg, 7, 5, 7, 5, 1,
                1, DIRECTION.CLOCK);
        assertFalse(ret);
    }

    @Test
    public void shiftRightSBoundaryRClockTwice() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.S();
        boolean ret = shiftRight(tet, tg, 7, 5, 7, 5, 1,
                2, DIRECTION.CLOCK);
        assertFalse(ret);
    }

    @Test
    public void shiftRightSBoundaryRCounter() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.S();
        boolean ret = shiftRight(tet, tg, 7, 5, 8, 5, 2,
                1, DIRECTION.COUNTER);
        assertFalse(ret);
    }

    @Test
    public void shiftRightT() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.T();
        boolean ret = shiftRight(tet, tg,5,5,6,5, 1,
                0, DIRECTION.CLOCK);
        assertTrue(ret);
    }

    @Test
    public void shiftRightTBoundary() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.T();
        boolean ret = shiftRight(tet, tg, 7,5, 7,5,1,
                0, DIRECTION.CLOCK);
        assertFalse(ret);
    }

    @Test
    public void shiftRightTBoundaryRClockOnce() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.T();
        boolean ret = shiftRight(tet, tg, 7,5, 7,5,1,
                1, DIRECTION.CLOCK);
        assertFalse(ret);
    }

    @Test
    public void shiftRightTBoundaryRClockTwice() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.T();
        boolean ret = shiftRight(tet, tg, 7,5, 7,5,1,
                2, DIRECTION.CLOCK);
        assertFalse(ret);
    }

    @Test
    public void shiftRightTBoundaryRCounter() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.T();
        boolean ret = shiftRight(tet, tg, 7,5, 8,5,2,
                1, DIRECTION.COUNTER);
        assertFalse(ret);
    }

    @Test
    public void shiftRightZ() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.Z();
        boolean ret = shiftRight(tet, tg, 5, 5, 6, 5, 1,
                0, DIRECTION.CLOCK);
        assertTrue(ret);
    }

    @Test
    public void shiftRightZBoundary() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.Z();
        boolean ret = shiftRight(tet, tg, 7, 5, 7, 5, 1,
                0, DIRECTION.CLOCK);
        assertFalse(ret);
    }

    @Test
    public void shiftRightZBoundaryClockOnce() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.Z();
        boolean ret = shiftRight(tet, tg, 7, 5, 7, 5, 1,
                1, DIRECTION.CLOCK);
        assertFalse(ret);
    }

    @Test
    public void shiftRightZBoundaryClockTwice() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.Z();
        boolean ret = shiftRight(tet, tg, 7, 5, 7, 5, 1,
                2, DIRECTION.CLOCK);
        assertFalse(ret);
    }

    @Test
    public void shiftRightZBoundaryCounter() throws Exception {
        TGrid tg = new TGrid(10, 20);
        Tetromino tet = TetrominoBuilder.Z();
        boolean ret = shiftRight(tet, tg, 7, 5, 8, 5, 2,
                1, DIRECTION.COUNTER);
        assertFalse(ret);
    }
}