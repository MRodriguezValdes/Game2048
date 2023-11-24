package com.example.game2048;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Game game;
    GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        game = new Game(this);

        this.fillTheGridLayout();
        gestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
            private static final int SWIPE_THRESHOLD = 100;
            private static final int SWIPE_VELOCITY_THRESHOLD = 100;


            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                float diffX = e2.getX() - e1.getX();
                float diffY = e2.getY() - e1.getY();
                if (Math.abs(diffX) > Math.abs(diffY)) {
                    if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                        if (diffX > 0) {
                            game.moveRight();
                            game.gameBoard.generateRandomCell();
                        } else {
                            game.moveLeft();
                            game.gameBoard.generateRandomCell();
                        }
                    }
                } else {
                    if (Math.abs(diffY) > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                        if (diffY > 0) {
                            game.moveDown();
                            game.gameBoard.generateRandomCell();
                        } else {
                            game.moveUp();
                            game.gameBoard.generateRandomCell();
                        }
                    }
                }
                return super.onFling(e1, e2, velocityX, velocityY);

            }
        });


    }

    public void fillTheGridLayout() {
            GridLayout gridLayout = findViewById(R.id.gridLayout);
            TextView scoreTextView = findViewById(R.id.score);
            scoreTextView.setText("Best:" + "" + String.valueOf(game.score));

        int numRows = gridLayout.getRowCount();
        int numColumns = gridLayout.getColumnCount();

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                int index = i * numColumns + j;
                TextView textView = (TextView) gridLayout.getChildAt(index);

                int cellValue = game.gameBoard.getBoard()[i][j];
                textView.setText(String.valueOf(cellValue));

                int color = getColorForValue(cellValue);
                textView.setBackgroundColor(color);
            }
        }
    }

    private void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    private int getColorForValue(int value) {
        switch (value) {
            case 2:
                return 0xFFF1E9DB; // Color para el valor 2
            case 4:
                return 0xFFF3E6D8; // Color para el valor 4
            case 8:
                return 0xFFF5DFAA; // Color para el valor 8
            case 16:
                return 0xFFF8C98E; // Color para el valor 16
            case 32:
                return 0xFFF9B97C; // Color para el valor 32
            case 64:
                return 0xFFFAA860; // Color para el valor 64
            case 128:
                return 0xFFEDCE79; // Color para el valor 128
            case 256:
                return 0xFFEECB6B; // Color para el valor 256
            case 512:
                return 0xFFEEC75A; // Color para el valor 512
            case 1024:
                return 0xFFEEC447; // Color para el valor 1024
            case 2048:
                return 0xFFEEC233; // Color para el valor 2048
            default:
                return 0xFFCDC1B4; // Color predeterminado para otros valores
        }
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event) || super.onTouchEvent(event);
    }

}