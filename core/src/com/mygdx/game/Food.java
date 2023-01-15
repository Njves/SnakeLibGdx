package com.mygdx.game;

import java.util.Random;

public class Food {
    private int cellX;
    private int cellY;

    private Random random = new Random();

    public Food(int min, int max) {
        regenerate(min, max);
    }

    public void intersect(SnakeBody head) {
        if(head.getCellX() == cellX && head.getCellY() == cellY) {

        }
    }

    public int getCellX() {
        return cellX;
    }

    public void setCellX(int cellX) {
        this.cellX = cellX;
    }

    public int getCellY() {
        return cellY;
    }

    public void setCellY(int cellY) {
        this.cellY = cellY;
    }

    public void regenerate(int min, int max) {
        cellX = random.nextInt(min, max);
        cellY = random.nextInt(min, max);
    }
}
