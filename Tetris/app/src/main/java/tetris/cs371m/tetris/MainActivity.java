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
    GridView nextView;

    private TGrid gameBoard;
    private TGrid nextBoard;

    private Tetromino currentTet = null;
    private Tetromino nextTet    = null;

    private TetrisTimeHandler handler;

    public void spawnTetromino() {
        if (currentTet == null) {
            currentTet = TetrominoBuilder.Random();
        } else {
            currentTet = nextTet;
            nextTet.removeFromGrid();
        }

        currentTet.insertIntoGrid(4, 0, gameBoard);
        nextTet = TetrominoBuilder.Random();

        // will this ever be null?
        if (nextTet != null) {
            nextTet.insertIntoGrid(1, 1, nextBoard);
        }

        nextView.invalidate();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gameView = (GridView) findViewById(R.id.game_board);
        gameBoard = new TGrid(10, 23);

        nextView = (GridView) findViewById(R.id.next_piece_view);
        nextBoard = new TGrid(5, 5);

        spawnTetromino();

        handler = new TetrisTimeHandler(this);

        gameView.setGrid(gameBoard, true);
        nextView.setGrid(nextBoard, false);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.stopCallbacks();
    }

    public void onZoomDown (View view) {
        currentTet.zoomDown();
        checkRow();
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

    public void onRotateLeft (View view) {
        currentTet.rotateCounterClockwise();
        gameView.invalidate();
    }

    public void onRotateRight (View view) {
        currentTet.rotateClockwise();
        gameView.invalidate();
    }

    public void onReset (View view) {
        gameBoard.clear();
        currentTet.removeFromGrid();
        gameView.invalidate();
    }

    public void updateTetrisBlock() {
        if (!currentTet.shiftDown()) {
            checkRow();
            spawnTetromino();
        }

        gameView.invalidate();
    }

    public void checkRow() {
        int row = gameBoard.getFirstFullRow();
        if (row != -1) {
            gameBoard.deleteRow(row);
        }
    }
}
