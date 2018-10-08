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

    private final int rateLimitMillis = 1000; // full second

    public TetrisTimeHandler (final IUpdate iUpdate) {
        /*handlerThread = new HandlerThread("TetrisTimeHandler");
        handlerThread.start();*/

        // tried to invalidate gameView on different thread but that doesn't work;
        // using main thread for this
        handler = new Handler(Looper.getMainLooper());

        rateLimitRequest = new Runnable() {
            @Override
            public void run() {
                iUpdate.updateTetrisBlock();
                handler.postDelayed(this, rateLimitMillis);
            }
        };

        handler.postDelayed(rateLimitRequest, rateLimitMillis);
    }

    public void stopCallbacks () {
        handler.removeCallbacks(rateLimitRequest);
    }
}
