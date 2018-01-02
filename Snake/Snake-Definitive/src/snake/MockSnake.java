package snake;

import java.awt.Point;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class MockSnake extends ArrayList<Point> {
	private int snake_maxLength = 10;
	private int state = 0;
	private int bottom_border = 66;
	private int top_border = 0;
	private int right_border = 79;
	//private ArrayList<Point> snake;
	
	public ArrayList<Point> snakeDecide() {	
		
		if (state == 0) {
			state = 1;
			return validSnakeUp();
			//this.setSnake(validSnakeUp());
			//return this.getSnake();
		} else if (state == 1) {
			//state = 0;
			state = 2;
			return validSnakeDown();
			//this.setSnake(validSnakeDown());
			//return this.getSnake();
		} else if (state == 2) {
			state = 3;
			return validSnakeLeft();
			//this.setSnake(validSnakeLeft());
			//return this.getSnake();
		} else if (state == 3) {
			state = 0;
			return validSnakeRight();
			//this.setSnake(validSnakeRight());
			//return this.getSnake();
		}
		return null;
	}
	
	public ArrayList<Point>  validSnakeUp() {
		ArrayList<Point> snake = new ArrayList<Point>();
		int x = 15;		
		for(int i = 2; i < snake_maxLength; i++) {			
			snake.add(new Point(i,15));			
		}
		return snake;		
	}
	

	public ArrayList<Point> notValidSnakeUp() {
		ArrayList<Point> snake = new ArrayList<Point>();
		int x = 15;		
		for(int i = 0; i < snake_maxLength; i++) {			
			snake.add(new Point(-i, 15));			
		}
		return snake;		
	}
	
	
	public ArrayList<Point> validSnakeDown() {		
		ArrayList<Point> snake = new ArrayList<Point>();
		for(int i = 64; i > bottom_border - snake_maxLength - 2 ; i--) {			
			snake.add(new Point(i,15));			
		}
		return snake;
	}
	
	public ArrayList<Point> validSnakeLeft() {
		
		ArrayList<Point> snake = new ArrayList<Point>();		
		for(int i = 2; i < snake_maxLength; i++) {			
			snake.add(new Point(30,i));			
		}
		return snake;
		
	}
	
	public ArrayList<Point> validSnakeRight() {
		
		ArrayList<Point> snake = new ArrayList<Point>();		
		for(int i = 77; i > right_border - 2 - snake_maxLength; i--) {			
			snake.add(new Point(30,i));			
		}
		return snake;	
	}
	
	public int getState() {
		return this.state;
	}
/*
	public ArrayList<Point> getSnake() {
		return snake;
	}

	public void setSnake(ArrayList<Point> snake) {
		this.snake = snake;
	}
	*/
	
	
}
