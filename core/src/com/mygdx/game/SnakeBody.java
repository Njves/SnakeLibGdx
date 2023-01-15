package com.mygdx.game;

public class SnakeBody {
    private int cellX;
    private int cellY;

    private int prevCellX;

    private int prevCellY;

    private boolean isHead;

    public SnakeBody(boolean isHead,int cellX, int cellY) {
        this.isHead = isHead;
        this.cellX = cellX;
        this.cellY = cellY;
    }

    public int getPrevCellX() {
        return prevCellX;
    }

    public void setPrevCellX(int prevCellX) {
        this.prevCellX = prevCellX;
    }

    public int getPrevCellY() {
        return prevCellY;
    }

    public void setPrevCellY(int prevCellY) {
        this.prevCellY = prevCellY;
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

    public void updateCell(int newCellX, int newCellY) {
        prevCellX = cellX;
        prevCellY = cellY;
        cellX = newCellX;
        cellY = newCellY;
    }

    @Override
    public String toString() {
        return "SnakeBody{" +
                "cellX=" + cellX +
                ", cellY=" + cellY +
                ", prevCellX=" + prevCellX +
                ", prevCellY=" + prevCellY +
                ", isHead=" + isHead +
                '}';
    }
}
