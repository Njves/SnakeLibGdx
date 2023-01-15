package com.mygdx.game;

import java.util.Arrays;
import java.util.Random;

public class Board {
    public static int CELL_SIZE = 20;
    private static int borderX = 800 / CELL_SIZE;
    private static int borderY = 800 / CELL_SIZE;
    Objects[][] board = new Objects[borderX][borderY];

    private Movement direction;

    private Snake snake;

    private Food food;

    public Board() {
        for (Objects[] objects : board) {
            Arrays.fill(objects, Objects.EMPTY);
        }
        board[35][29] = Objects.FOOD;
        direction = Movement.MOVE_UP;
        snake = new Snake();
        SnakeBody head = snake.getSnake().get(0);
        board[head.getCellX()][head.getCellY()] = Objects.HEAD;
        food = new Food(0, (800 / CELL_SIZE) - 1);
    }

    public void update() {
        clear();
        System.out.println(snake.getSnake());
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                for (int k = 0; k < snake.getSnake().size(); k++) {
                    if(k == 0)
                        board[snake.getSnake().get(k).getCellX()][snake.getSnake().get(k).getCellY()] = Objects.HEAD;
                    else
                        board[snake.getSnake().get(k).getCellX()][snake.getSnake().get(k).getCellY()] = Objects.BODY;
                }
                board[food.getCellX()][food.getCellY()] = Objects.FOOD;
            }
        }
        intersect();
        snake.update();

    }

    public void clear() {
        for (Objects[] objects : board) {
            Arrays.fill(objects, Objects.EMPTY);
        }
    }

    public Objects[][] getBoard() {
        return board;
    }

    public void setDirection(Movement direction) {
        this.direction = direction;
    }

    public Movement getDirection() {
        return direction;
    }

    public Snake getSnake() {
        return snake;
    }

    public void move() {
        System.out.println(direction);
        if(direction == Movement.MOVE_UP) {
            snake.getHead().updateCell(getSnake().getHead().getCellX(), getSnake().getHead().getCellY() + 1);
        }
        if(direction == Movement.MOVE_DOWN) {
            snake.getHead().updateCell(getSnake().getHead().getCellX(), getSnake().getHead().getCellY() - 1);
        }
        if(direction == Movement.MOVE_RIGHT) {
            snake.getHead().updateCell(getSnake().getHead().getCellX() + 1, getSnake().getHead().getCellY());
        }
        if(direction == Movement.MOVE_LEFT) {
            snake.getHead().updateCell(getSnake().getHead().getCellX() - 1, getSnake().getHead().getCellY() );
        }
    }

    public void intersect() {
        if(food.getCellX() == snake.getHead().getCellX() && food.getCellY() == snake.getHead().getCellY()) {
            snake.add(new SnakeBody(false, 0, 0));
            food.regenerate(0, (800 / CELL_SIZE) - 1);
        }
    }

    public int speed() {
        return 2 * snake.getSnake().size();
    }

    public boolean haveCollision() {
        return snake.collision(snake.getHead().getCellX(), snake.getHead().getCellY());
    }

    public void moveToBorder() {
    }
}
