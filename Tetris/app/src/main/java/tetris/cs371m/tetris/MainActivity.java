package tetris.cs371m.tetris;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    GridView gameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gameView = (GridView) findViewById(R.id.game_board);
        TGrid gameBoard = new TGrid(10, 23);

        gameView.setGrid(gameBoard);
    }
}
