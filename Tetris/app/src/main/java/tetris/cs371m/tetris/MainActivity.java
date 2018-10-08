package tetris.cs371m.tetris;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
                          implements TetrisTimeHandler.IUpdate {

    GridView gameView;
    private TGrid gameBoard;
    private Tetromino currentTet = null;
    private Tetromino nextTet    = null;

    private TetrisTimeHandler handler;

    public void spawnTetromino() {
        if (currentTet == null) {
            currentTet = TetrominoBuilder.Random();
        } else {
            currentTet = nextTet;
        }

        currentTet.insertIntoGrid(4, 0, gameBoard);
        nextTet = TetrominoBuilder.Random();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gameView = (GridView) findViewById(R.id.game_board);
        gameBoard = new TGrid(10, 23);

        spawnTetromino();

        handler = new TetrisTimeHandler(this);

        gameView.setGrid(gameBoard);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.stopCallbacks();
    }

    public void onZoomDown (View view) {
        currentTet.zoomDown();
        // TODO: possible race condition?
        spawnTetromino();
        gameView.invalidate();
    }

    public void onShiftLeft (View view) {
        currentTet.shiftLeft();
        gameView.invalidate();
    }

    public void onShiftRight (View view) {
        currentTet.shiftRight();
        gameView.invalidate();
    }

    public void updateTetrisBlock() {
        if (!currentTet.shiftDown()) {
            spawnTetromino();
        }
        gameView.invalidate();
    }
}
