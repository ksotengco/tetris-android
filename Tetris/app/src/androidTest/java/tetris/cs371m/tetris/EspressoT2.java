package tetris.cs371m.tetris;

import android.os.SystemClock;
import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static tetris.cs371m.tetris.TestUtil.readCommands;

/**
 * Created by zhitingz on 2/10/18.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class EspressoT2 {

    private List<Short> level3;

    private ViewInteraction
            left_button, rotate_left_button, down_button,
            rotate_right_button, right_button, reset_button,
            level, score, cleared;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<MainActivity>(MainActivity.class);

    @Before
    public void prepareCommands() throws Exception {
        left_button = onView(withId(R.id.left_button));
        rotate_left_button = onView(withId(R.id.rotate_left_button));
        down_button = onView(withId(R.id.zoom_down_button));
        rotate_right_button = onView(withId(R.id.rotate_right_button));
        right_button = onView(withId(R.id.right_button));
        reset_button = onView(withId(R.id.reset_button));
        level = onView(withId(R.id.level_view));
        score = onView(withId(R.id.score_view));
        cleared = onView(withId(R.id.row_view));
    }

    @Test
    public void runToLevel3() throws Exception {
        level3 = readCommands("level3.txt");

        for (int i = 0; i < level3.size(); i++) {
            TestUtil.clickButtonEspresso(level3.get(i), right_button, left_button, down_button, rotate_left_button, rotate_right_button, reset_button);
            SystemClock.sleep(1000);
        }
        level.check(matches(withText("Level: 3")));
        score.check(matches(withText("Score: 24")));
        cleared.check(matches(withText("Rows: 13")));
    }


}
