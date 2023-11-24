package com.example.game2048;

import android.content.Context;

public class Game {
    Context context;
    GameBoard gameBoard;
    int score;
    int bestScore;


    public Game(Context context) {

        this.gameBoard = new GameBoard();
        this.context = context;
        this.score = 0;

    }

    public void moveLeft() {
        for (int i = 0; i < gameBoard.getBoard().length; i++) {
            int lastMergedIndex = -1; // Variable para controlar la fusión de números

            for (int j = 1; j < gameBoard.getBoard()[i].length; j++) {
                if (gameBoard.getBoard()[i][j] != 0) {
                    int current = gameBoard.getBoard()[i][j];
                    int y = j - 1;

                    while (y > lastMergedIndex && gameBoard.getBoard()[i][y] == 0) {
                        y--;
                    }

                    if (y > lastMergedIndex && gameBoard.getBoard()[i][y] == current) {
                        gameBoard.getBoard()[i][y] *= 2;
                        this.score += gameBoard.getBoard()[i][y];
                        gameBoard.getBoard()[i][j] = 0;
                        lastMergedIndex = y;
                    } else {
                        int temp = gameBoard.getBoard()[i][j];
                        gameBoard.getBoard()[i][j] = 0;
                        gameBoard.getBoard()[i][y + 1] = temp;
                    }
                }
            }
        }
        ((MainActivity) context).fillTheGridLayout();
    }


    public void moveRight() {
        for (int i = 0; i < gameBoard.getBoard().length; i++) {
            int lastMergedIndex = gameBoard.getBoard()[i].length; // Comienza desde el final

            for (int j = gameBoard.getBoard()[i].length - 2; j >= 0; j--) {
                if (gameBoard.getBoard()[i][j] != 0) {
                    int current = gameBoard.getBoard()[i][j];
                    int y = j + 1;

                    while (y < lastMergedIndex && gameBoard.getBoard()[i][y] == 0) {
                        y++;
                    }

                    if (y < lastMergedIndex && gameBoard.getBoard()[i][y] == current) {
                        gameBoard.getBoard()[i][y] *= 2;
                        this.score += gameBoard.getBoard()[i][y];
                        gameBoard.getBoard()[i][j] = 0;
                        lastMergedIndex = y;
                    } else {
                        int temp = gameBoard.getBoard()[i][j];
                        gameBoard.getBoard()[i][j] = 0;
                        gameBoard.getBoard()[i][y - 1] = temp;
                    }
                }
            }
        }
        ((MainActivity) context).fillTheGridLayout();
    }


    public void moveUp() {
        for (int j = 0; j < gameBoard.getBoard()[0].length; j++) {
            int lastMergedIndex = -1; // Comienza desde el principio

            for (int i = 1; i < gameBoard.getBoard().length; i++) {
                if (gameBoard.getBoard()[i][j] != 0) {
                    int current = gameBoard.getBoard()[i][j];
                    int x = i - 1;

                    while (x > lastMergedIndex && gameBoard.getBoard()[x][j] == 0) {
                        x--;
                    }

                    if (x > lastMergedIndex && gameBoard.getBoard()[x][j] == current) {
                        gameBoard.getBoard()[x][j] *= 2;
                        this.score += gameBoard.getBoard()[x][j];
                        gameBoard.getBoard()[i][j] = 0;
                        lastMergedIndex = x;
                    } else {
                        int temp = gameBoard.getBoard()[i][j];
                        gameBoard.getBoard()[i][j] = 0;
                        gameBoard.getBoard()[x + 1][j] = temp;
                    }
                }
            }
        }
        ((MainActivity) context).fillTheGridLayout();
    }

    public void moveDown() {
        for (int j = 0; j < gameBoard.getBoard()[0].length; j++) {
            int lastMergedIndex = gameBoard.getBoard().length; // Comienza desde el final

            for (int i = gameBoard.getBoard().length - 2; i >= 0; i--) {
                if (gameBoard.getBoard()[i][j] != 0) {
                    int current = gameBoard.getBoard()[i][j];
                    int x = i + 1;

                    while (x < lastMergedIndex && gameBoard.getBoard()[x][j] == 0) {
                        x++;
                    }

                    if (x < lastMergedIndex && gameBoard.getBoard()[x][j] == current) {
                        gameBoard.getBoard()[x][j] *= 2;
                        this.score += gameBoard.getBoard()[x][j];
                        gameBoard.getBoard()[i][j] = 0;
                        lastMergedIndex = x;
                    } else {
                        int temp = gameBoard.getBoard()[i][j];
                        gameBoard.getBoard()[i][j] = 0;
                        gameBoard.getBoard()[x - 1][j] = temp;
                    }
                }
            }
        }
        ((MainActivity) context).fillTheGridLayout();
    }

}
