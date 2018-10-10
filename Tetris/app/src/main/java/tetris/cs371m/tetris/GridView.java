package tetris.cs371m.tetris;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

// template from demo code, revamped for this project
public class GridView extends View {

    private TGrid g;
    private TGrid.CellVisitor cv;
    private Canvas drawingCanvas;
    private float x;
    private float y;

    private int counter;

    boolean isGame;

    Paint borderPaint;
    Paint colorPaint;

    private void init() {
        x = 0.0f;
        y = 0.0f;

        counter = 0;

        borderPaint = new Paint();
        borderPaint.setStyle(Paint.Style.STROKE);
        borderPaint.setColor(Color.BLACK);

        colorPaint = new Paint();
        colorPaint.setStyle(Paint.Style.FILL);

        cv = new TGrid.CellVisitor() {
            @Override
            public void visitCell(TCell tCell) {
                Log.d("visitCell", "Counter: " + ++counter);

                // does not print top three rows unless next block preview
                if (counter > g.getWidth() * 3 || !isGame) {
                    if (tCell != null) {
                        colorPaint.setColor(tCell.myColor);
                        drawBlock(colorPaint);
                    } else {
                        drawBlock(null);
                    }
                }
            }
        };
    }

    public GridView(Context context) {
        super(context);
        init();
    }

    public GridView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public GridView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void setGrid(TGrid g, boolean isGame) {
        this.g = g;
        this.isGame = isGame; // determines whether or not view is gameBoard or preview View
        invalidate();
    }

    public void drawBlock (Paint paint) {
        float dWidth = (float) this.getWidth()/(float) g.getWidth();
        float dHeight = isGame ? (float) this.getHeight()/(float) (g.getHeight() - 3)
                        : (float) this.getHeight()/(float) (g.getHeight());

        // draws both border and square; border thicker if tetromino piece
        if (paint != null) {
            drawingCanvas.drawRect(x, y, x + dWidth, y + dHeight, paint);
            borderPaint.setStrokeWidth(3.0f);  // arbitrary number; I just like this width for piece
        } else {
            borderPaint.setStrokeWidth(0.0f);
        }

        drawingCanvas.drawRect(x, y, x + dWidth, y + dHeight, borderPaint);

        x += dWidth;

        // - 1.0f used to account for rounding errors
        float gameWidth = (float) this.getWidth() - 1.0f;
        float gameHeight = (float) this.getHeight() - 1.0f;

        if (x >= gameWidth) {
            x = 0.0f;
            y += dHeight;
        }

        if (y >= gameHeight) {
            y = 0.0f;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawingCanvas = canvas;

        if (g != null) {
            g.visitCells(cv);
            counter = 0;  // reset the counter for redraws
        }
    }
}
