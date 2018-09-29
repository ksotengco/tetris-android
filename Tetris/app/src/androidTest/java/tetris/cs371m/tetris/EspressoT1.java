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
public class EspressoT1 {

    private List<Short> level2, lose;

    private ViewInteraction
            left_button, rotate_left_button, down_button,
            rotate_right_button, right_button, reset_button,
            level, score, cleared;



    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<MainActivity>(MainActivity.class);

    @Before
    public void prepareCommands() throws Exception {
        left_button = onView(withId(R.id.left));
        rotate_left_button = onView(withId(R.id.rotate_counter));
        down_button = onView(withId(R.id.down));
        rotate_right_button = onView(withId(R.id.rotate_clock));
        right_button = onView(withId(R.id.right));
        reset_button = onView(withId(R.id.reset));
        level = onView(withId(R.id.level));
        score = onView(withId(R.id.score));
        cleared = onView(withId(R.id.cleared));
    }

    @Test
    public void runToLevel2() throws Exception {
        level2 = readCommands("level2.txt");

        for (int i = 0; i < level2.size(); i++) {
            TestUtil.clickButtonEspresso(level2.get(i), right_button, left_button, down_button, rotate_left_button, rotate_right_button, reset_button);
            SystemClock.sleep(1000);
        }

        level.check(matches(withText("2")));
        score.check(matches(withText("7")));
        cleared.check(matches(withText("6")));
    }

    @Test
    public void lose() throws Exception {
        lose = readCommands("lose.txt");

        for (int i = 0; i < lose.size(); i++) {
            TestUtil.clickButtonEspresso(lose.get(i), right_button, left_button, down_button, rotate_left_button, rotate_right_button, reset_button);
            SystemClock.sleep(1000);
        }
        level.check(matches(withText("1")));
        score.check(matches(withText("0")));
        cleared.check(matches(withText("0")));
    }
}
