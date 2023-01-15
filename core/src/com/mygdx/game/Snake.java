package com.mygdx.game;

import java.util.LinkedList;

public class Snake {
    private LinkedList<SnakeBody> snake;
    private SnakeBody head;
    public Snake() {
        snake = new LinkedList<>();
        head = new SnakeBody(true, 5, 7);

        snake.add(head);
    }

    public void add(SnakeBody body) {
        snake.add(body);
    }


    public LinkedList<SnakeBody> getSnake() {
        return snake;
    }

    public void setSnake(LinkedList<SnakeBody> snake) {
        this.snake = snake;
    }

    public SnakeBody getHead() {
        return head;
    }

    public void setHead(SnakeBody head) {
        this.head = head;
    }

    public void update() {
        for (int i = 0; i < snake.size() - 1; i++) {
            SnakeBody currentBody = snake.get(i);
            SnakeBody nextBody = snake.get(i + 1);
            if(i == 0)
                nextBody.updateCell(currentBody.getCellX(), currentBody.getCellY());
            else
                nextBody.updateCell(currentBody.getPrevCellX(), currentBody.getPrevCellY());
        }
    }

    public boolean collision(int headCellX, int headCellY) {
        for (int i = 2; i < snake.size(); i++) {
            if(headCellX == snake.get(i).getCellX() && headCellY == snake.get(i).getCellY()) {
                return true;
            }
        }
        return false;
    }
}
