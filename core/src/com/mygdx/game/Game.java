package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Game extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Texture snakeHead;
	Texture snakeBody;
	Texture cell;
	Texture food;
	private Board board;



	@Override
	public void create () {
		batch = new SpriteBatch();
		snakeHead = new Texture("snake_head.png");
		snakeBody = new Texture("snake_body.png");
		food = new Texture("food.png");
		cell = new Texture("cell.png");
		board = new Board();
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0.3f, 0, 1);

		Objects[][] matrix = board.getBoard();

		batch.begin();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if(matrix[i][j] == Objects.EMPTY) {
					batch.draw(cell, i * Board.CELL_SIZE, j * Board.CELL_SIZE, Board.CELL_SIZE, Board.CELL_SIZE);
				}
				if(matrix[i][j] == Objects.HEAD) {
					batch.draw(snakeHead, i * Board.CELL_SIZE, j * Board.CELL_SIZE, Board.CELL_SIZE, Board.CELL_SIZE);
				}
				if(matrix[i][j] == Objects.BODY) {
					batch.draw(snakeBody, i * Board.CELL_SIZE, j * Board.CELL_SIZE, Board.CELL_SIZE, Board.CELL_SIZE);
				}
				if(matrix[i][j] == Objects.FOOD) {
					batch.draw(food, i * Board.CELL_SIZE, j * Board.CELL_SIZE, Board.CELL_SIZE, Board.CELL_SIZE);
				}
			}
		}
		if(Gdx.input.isKeyPressed(Input.Keys.W) && board.getDirection() != Movement.MOVE_DOWN) {
			board.setDirection(Movement.MOVE_UP);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.S) && board.getDirection() != Movement.MOVE_UP) {
			board.setDirection(Movement.MOVE_DOWN);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.A) && board.getDirection() != Movement.MOVE_RIGHT) {
			board.setDirection(Movement.MOVE_LEFT);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.D) && board.getDirection() != Movement.MOVE_LEFT) {
			board.setDirection(Movement.MOVE_RIGHT);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
			Board.CELL_SIZE += 1;
		}
		if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
			Board.CELL_SIZE -= 1;
		}
		try {
			if(100 - board.speed() >= 0) {
				Thread.sleep(100 - board.speed());
			}
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		board.move();
		board.update();
		if(board.haveCollision()) {
			System.exit(0);
		}
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
