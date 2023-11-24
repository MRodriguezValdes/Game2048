package com.example.game2048;

import java.util.Random;


public class GameBoard {

    private int[][] board;
    Random random;


    public GameBoard() {

        this.board = new int[4][4];
        this.random = new Random();
        this.generateRandomCell();
        this.generateRandomCell();
    }

    public boolean isValidOption(int i , int j) {
        return ( i >= 0 && i <4 && j>=0 && j<4 && this.board[i][j] == 0 );
    }

    public void generateRandomCell() {
        int x = random.nextInt(4);
        int y = random.nextInt(4);

        while (!isValidOption(x,y)){
             x = random.nextInt(4);
             y = random.nextInt(4);
        }

        this.board[x][y] = 2;
    }

    public int[][] getBoard() {
        return board;
    }
}
