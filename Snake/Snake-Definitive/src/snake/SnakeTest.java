package snake;


import static org.junit.Assert.*;

import java.awt.Component;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import org.junit.Test;

public class SnakeTest {
	
	private ArrayList<Point> snake;
	private boolean isValid;
	private Point head;
	private MockSnake mc;
	private MockSnakeHead mh;
	
	@Test
	public void checkDirections() {
		
		Snake s = new Snake();		
	}
	@Test
	public void checkCherry() {
		
		//Position parameters 		
		int x = 1;
		int y = 1;		
		//Creation of the points that will be tested
		Point head = new Point(x,y);
		Point headFail = new Point(2*x,y);
		Point cherry = new Point(x,y);					
		
		//The snake doesn't collide with the cherry		
		while (x<50000) {
			
			isValid = Snake.checkCherry(headFail, cherry);
			assertFalse(isValid);
			x++;
			y++;
			headFail = new Point(2*x,y);
			cherry = new Point(x,y);			
		}		
		
		//The snake collides with the cherry
		while (x< 50000) {
			
			isValid = Snake.checkCherry(head,cherry);
			assertTrue(isValid);
			x++;
			y++;
			head = new Point(x,y);
			cherry = new Point(x,y);
		}
		
	}

	@Test
	public void noTailAt() {
		
		
	}
	
	@Test 
	public void keyPressed() {
			
		
	}
	
	@Test
	public void isValidPosition() {		
		
		//int counter = 1;
		//int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3;
		int direction = 0;
		int stateChanger = 2;
		int counter = 0;
		boolean isValid;
		mc = new MockSnake();
		mh = new MockSnakeHead();		
		while (mc.getState() < 4 ) {		
			snake = mc.snakeDecide();	
			while (mh.getState() < stateChanger && counter < 8) {				
				head = mh.snakeHeadDecide();									
				isValid = Snake.isValidPosition(head, snake, direction);
				System.out.println("\n");
				System.out.println("Hi im in the iteration " + mc.getState() + " of the outside loop");
				System.out.println("Hi im in the iteration " + mh.getState() + " of the inside loop");
				System.out.println("Hi the counter is : " + counter + " and the sValid is : " + isValid);
				System.out.println("The direction of the snake is: " + direction);
				if(counter %2 == 0) {
					 System.out.println("Hi i did the assertTrue");					 
					assertEquals(true,isValid);
					System.out.println("The asserTrue was successfull");					
				} else { 
					System.out.println("Hi i did the assertFalse");					
					assertEquals(false, isValid);
					System.out.println("The asserFalse was successfull");					
				}				
				counter ++;
			}
			if (counter == stateChanger) {
				stateChanger += 2;
			if (direction == 3	 ) {
				direction = 0;
			} else direction++;
				//direction = 0;
			} //else && direction == 3
				//direction ++;			
		}			
	}
	
	@Test 
	public void setCherry() {
		/*
		int x = 1;
		int y = 1;
		
		boolean isValid;
		
		//Creation of the points that will be tested		
		Point cherry = new Point(x,y);
		while(x < 50000) {
			
			Snake.setCherry(cherry);
			
		}
		*/
	}
	
}
