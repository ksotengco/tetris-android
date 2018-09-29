package tetris.cs371m.tetris;

import android.graphics.Color;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE)
public class BasicTCellTest {

    @Test
    public void color() {
        TCell tc = new TCell(Color.BLUE);
        assert (tc.getColor() == Color.BLUE);
        tc.setColor(Color.RED);
        assert (tc.getColor() == Color.RED);
    }

    @Test
    public void position() {
        TCell tc = new TCell(Color.RED);
        assert (tc.getXPosition() == -1);
        assert (tc.getYPosition() == -1);
        tc.setXPosition(3);
        tc.setYPosition(5);
        assert (tc.getXPosition() == 3);
        assert (tc.getYPosition() == 5);
        assert (tc.toString().equals("(3, 5)"));
    }
}
