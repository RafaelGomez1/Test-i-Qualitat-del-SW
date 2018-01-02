package snake;

import java.awt.Point;

@SuppressWarnings("serial")
public class MockSnakeHead extends Point {
	
	private int top_border = 0;
	private int bottom_border = 66;
	private int right_border = 79;
	private int state = 0;
	Point head;
	
	public Point snakeHeadDecide() {
			
			if (state == 0) {
				state = 1;				
				return validSnakeHeadUp();
			} else if (state == 1) {
				//state = 0;
				//Remember to change this
				state = 2;
				return notValidSnakeHeadUp();
			} else if (state == 2) {
				state = 3;
				return validSnakeHeadDown();			
			} else if (state == 3) {
				state = 4;
				return notValidSnakeHeadDown();
			} else if (state == 4) {
				state = 5;
				return validSnakeHeadLeft();
			} else if (state == 5) {
				state = 6;
				return notValidSnakeHeadLeft();
			} else if (state == 6) {
				state = 7;
				return validSnakeHeadRight();
			} else if (state == 7) {
				state = 0;
				return notValidSnakeHeadRight();
			}
			return null;
		}
	
	
	//Valid Snakes' head functions
	public Point validSnakeHeadUp() {		
		return new Point(top_border + 2, 15);
	}	
	
	public Point validSnakeHeadDown() {		
		return new Point(bottom_border - 2, 15);
	}
	
	public Point validSnakeHeadLeft() {		
		return new Point(top_border + 30 , 2);
	}
	
	public Point validSnakeHeadRight() {		
		return new Point(30, 67);
	}
	
	//Not valid Snakes' head functions
	public Point notValidSnakeHeadDown() {		
		return new Point(15, bottom_border);
	}
	
	public Point notValidSnakeHeadUp() {		
		return new Point(15, top_border);
	}
	
	public Point notValidSnakeHeadLeft() {		
		return new Point(top_border, 15);
	}
	
	public Point notValidSnakeHeadRight() {		
		return new Point(right_border, 15);
	}
	public int getState() {
		return this.state;
	}
	
	
	
}