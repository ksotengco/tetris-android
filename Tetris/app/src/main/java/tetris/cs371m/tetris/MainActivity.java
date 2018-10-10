package tetris.cs371m.tetris;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
                          implements TetrisTimeHandler.IUpdate {

    GridView gameView;
    GridView nextView;

    private TGrid gameBoard;
    private TGrid nextBoard;

    private Tetromino currentTet = null;
    private Tetromino nextTet    = null;

    private TetrisTimeHandler handler;

    private int score;
    private int rows;
    private int level;

    private boolean lost;

    TextView scoreView;
    TextView rowsView;
    TextView levelsView;

    public void spawnTetromino() {
        if (!lost) {
            if (currentTet == null) {
                currentTet = TetrominoBuilder.Random();
            } else {
                currentTet = nextTet;
            }

            if (nextTet != null) {
                nextTet.removeFromGrid();
            }

            if (!currentTet.insertIntoGrid(4, 0, gameBoard)) {
                youLose();
                return;
            }

            nextTet = TetrominoBuilder.Random();

            // will this ever be null?
            if (nextTet != null) {
                nextTet.insertIntoGrid(1, 1, nextBoard);
            }

            nextView.invalidate();
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        score = 0;
        rows =  0;
        level = 1;

        lost = false;

        scoreView = (TextView) findViewById(R.id.score_view);
        rowsView =  (TextView) findViewById(R.id.row_view);
        levelsView = (TextView) findViewById(R.id.level_view);

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
    protected void onRestart() {
        super.onRestart();
        Log.d("onRestart", "yey");
        handler.resumeCallbacks();
    }

    @Override
    protected void onStop() {
        super.onStop();
        handler.stopCallbacks();
        Log.d("onStop", "yey");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.stopCallbacks();
        Log.d("onDestroy", "yey");
    }

    public void onZoomDown (View view) {
        if (currentTet != null) {
            currentTet.zoomDown();
            checkRow();
            // TODO: possible race condition?
            spawnTetromino();
            gameView.invalidate();
        }
    }

    public void onShiftLeft (View view) {
        if (currentTet != null) {
            currentTet.shiftLeft();
            gameView.invalidate();
        }
    }

    public void onShiftRight (View view) {
        if (currentTet != null) {
            currentTet.shiftRight();
            gameView.invalidate();
        }
    }

    public void onRotateLeft (View view) {
        if (currentTet != null) {
            currentTet.rotateCounterClockwise();
            gameView.invalidate();
        }
    }

    public void onRotateRight (View view) {
        if (currentTet != null) {
            currentTet.rotateClockwise();
            gameView.invalidate();
        }
    }

    public void onReset (View view) {
        handler.stopCallbacks();
        gameBoard.clear();

        lost = false;

        if (currentTet != null) {
            currentTet.removeFromGrid();
            currentTet = null;
        }

        TetrominoBuilder.resetRandom();
        spawnTetromino();

        gameView.invalidate();
        handler.resumeCallbacks();
    }

    public void updateTetrisBlock() {
        if (currentTet != null && !currentTet.shiftDown()) {
            checkRow();
            spawnTetromino();
        }

        gameView.invalidate();
    }

    public void youLose() {
        handler.stopCallbacks();
        Toast.makeText(getApplicationContext(), R.string.lose, Toast.LENGTH_SHORT).show();
        lost = true;
        currentTet = null;
    }

    public void checkRow() {
        int row = gameBoard.getFirstFullRow();
        if (row != -1) {
            do {
                gameBoard.deleteRow(row);
                score += level;
                rows++;

                if (rows % 5 == 0) {
                    level++;
                    handler.speedUp();
                }

                row = gameBoard.getFirstFullRow();
            } while (row != -1);

            rowsView.setText("Rows: " + rows);
            scoreView.setText("Score: " + score);
            levelsView.setText("Level: " + level);
        }
    }
}
