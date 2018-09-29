package tetris.cs371m.tetris;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.SystemClock;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.ViewInteraction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static android.support.test.espresso.action.ViewActions.click;

public class TestUtil {

    public static final short RIGHT = 0;
    public static final short LEFT = 1;
    public static final short DOWN = 2;
    public static final short RCOUNTER = 3;
    public static final short RCLOCK = 4;
    public static final short RESET = 5;

    public static List<Short> readCommands(String fileName) throws IOException {
        Context context = InstrumentationRegistry.getContext();
        InputStream testInput = context.getAssets().open(fileName);
        List<Short> commands = new ArrayList<Short>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(testInput));
        String line;
        while ((line = reader.readLine()) != null) {
            switch (line) {
                case "right":
                    commands.add(RIGHT);
                    break;
                case "left":
                    commands.add(LEFT);
                    break;
                case "down":
                    commands.add(DOWN);
                    break;
                case "rcounter":
                    commands.add(RCOUNTER);
                    break;
                case "rclock":
                    commands.add(RCLOCK);
                    break;
                case "reset":
                    commands.add(RESET);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid command");
            }
        }
        return commands;
    }

    /**
     * Uses package manager to find the package name of the device launcher. Usually this package
     * is "com.android.launcher" but can be different at times. This is a generic solution which
     * works on all platforms.`
     */
    public static String getLauncherPackageName() {
        // Create launcher Intent
        final Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);

        // Use PackageManager to get the launcher package name
        PackageManager pm = InstrumentationRegistry.getContext().getPackageManager();
        ResolveInfo resolveInfo = pm.resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY);
        return resolveInfo.activityInfo.packageName;
    }

    public static void clickButtonEspresso(short button, ViewInteraction right_button, ViewInteraction left_button,
                                           ViewInteraction down_button, ViewInteraction rotate_left_button,
                                           ViewInteraction rotate_right_button, ViewInteraction reset_button) throws Exception {
        switch (button) {
            case RIGHT:
                right_button.perform(click());
                break;
            case LEFT:
                left_button.perform(click());
                break;
            case DOWN:
                down_button.perform(click());
                SystemClock.sleep(2000);
                break;
            case RCOUNTER:
                rotate_left_button.perform(click());
                break;
            case RCLOCK:
                rotate_right_button.perform(click());
                break;
            case RESET:
                reset_button.perform(click());
                break;
            default:
                throw new Exception("Invalid code");
        }
    }
}
