package tetris.cs371m.tetris;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

public class TetrisTimeHandler {
    public interface IUpdate {
        void updateTetrisBlock();
    }

    private Runnable rateLimitRequest;
    private Handler handler;

    private int rateLimitMillis = 1000; // 1 second

    public TetrisTimeHandler (final IUpdate iUpdate) {
        // tried to invalidate gameView on different thread but that doesn't work;
        // using main thread for this
        handler = new Handler(Looper.getMainLooper());

        rateLimitRequest = new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(this, rateLimitMillis);
                iUpdate.updateTetrisBlock();
            }
        };

        handler.postDelayed(rateLimitRequest, rateLimitMillis);
    }

    public void speedUp() {
        handler.removeCallbacks(rateLimitRequest);
        int diff = (int)(rateLimitMillis * 0.20);
        rateLimitMillis -= diff;
        handler.postDelayed(rateLimitRequest, rateLimitMillis);
    }

    public void stopCallbacks () {
        handler.removeCallbacks(rateLimitRequest);
    }

    public void resumeCallbacks () {
        handler.postDelayed(rateLimitRequest, rateLimitMillis);
    }
}
