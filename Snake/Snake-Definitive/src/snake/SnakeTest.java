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
	private MockSnake ms;
	private MockSnakeHead mh;
	
	@Test
	public void checkDirections() {
		
		//direction -> UP = 0 / DOWN = 1 / LEFT = 2 / RIGHT = 3
		int direction = 0;
		int max_testCases = 4;
		int testCases_done = 0;
		int innerLoopCounter = 0;
		int innerLoopMax = 2;
		int ticks = 2;
		
		boolean paused = false;
		boolean over = false;
		boolean isValid;
		//Snake s = new Snake();
		ms = new MockSnake();
		mh = new MockSnakeHead();
		ArrayList<Point> snake;
		Point snakeHead;
		Point temp = null;
		Point result;
		
		//loop that iterates with every snake received by the mock
		while (testCases_done < max_testCases) {
				snake = ms.snakeDecide();
				//inner loop that tests each snake with a valid/invalid head
				while (innerLoopCounter < innerLoopMax) {
						snakeHead = mh.snakeHeadDecide();
						result = Snake.checkDirection(snake, snakeHead, ticks, paused,over,direction);
						temp = temporalPointCreator(temp,snakeHead,direction);
						if (temp.equals(result)) {
							isValid = true;
							assertTrue(isValid);
						} else {
							isValid = false;
							assertFalse(isValid);
						}
						innerLoopCounter++;						
				}				
				innerLoopMax += 2;
				System.out.println("hi direction's value is : " + direction);
				direction++;
				System.out.println("hi direction's value is now : " + direction);
				testCases_done++;
		}		
	}
	
	public Point temporalPointCreator(Point destiny, Point origin, int direction) {
		
		switch (direction) {
			//up case
			case 0:
				destiny = new Point(origin.x, origin.y - 1);
				break;
			//down case
			case 1:
				destiny = new Point(origin.x, origin.y + 1);
				break;
			//left case
			case 2: 
				destiny = new Point(origin.x - 1, origin.y);
				break;
			//right case
			case 3:
				destiny = new Point(origin.x + 1, origin.y);
				break;
		}
		return destiny;
		
	}	
	@Test
	public void checkCherry() {
		
		//Position parameters 		
		int x = 1;
		int y = 1;		
		//Creation of the points that will be tested
		Point head = new Point(x,y);
		Point headFail = new Point(2*x,y);
		
		//Case where the cherry is null
		Point cherry = null;
		isValid = Snake.checkCherry(headFail, cherry);
		assertFalse(isValid);
		
		//Case where the head does not equal cherry
		
		cherry = new Point(x,y);
		head = new Point(x,2*y);
		isValid = Snake.checkCherry(head, cherry);
		assertFalse(isValid);
		
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
		x = 1;
		y = 1;
		head = new Point(x,y);
		cherry = new Point(x,y);
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
			
		//En principio (hasta la tutoria con Xavi) no se puede testear
	}
	
	@Test
	public void isValidPosition() {		
		
		//int counter = 1;
		//int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3;
		int direction = 0;
		int stateChanger = 2;
		int counter = 0;
		boolean isValid;
		ms = new MockSnake();
		mh = new MockSnakeHead();		
		while (ms.getState() < 4 ) {
			snake = ms.snakeDecide();			
			while (mh.getState() < stateChanger && counter < 8) {				
				head = mh.snakeHeadDecide();									
				isValid = Snake.isValidPosition(head, snake, direction);
				
				System.out.println("\n");
				System.out.println("Hi im in the iteration " + ms.getState() + " of the outside loop");
				System.out.println("Hi im in the iteration " + mh.getState() + " of the inside loop");
				System.out.println("Hi the counter is : " + counter + " and the sValid is : " + isValid);
				System.out.println("The direction of the snake is: " + direction);
				
				if(counter %2 == 0) {
					//System.out.println("Hi i did the assertTrue");					 
					assertEquals(true,isValid);
					//System.out.println("The asserTrue was successfull");					
				} else { 
					//System.out.println("Hi i did the assertFalse");					
					assertEquals(false, isValid);
					//System.out.println("The asserFalse was successfull");					
				}				
				counter ++;
			}
			System.out.println("hi im almost at the last if");
			if (counter == stateChanger && counter < 8) {
				stateChanger += 2;				
				if (direction == 3	 ) {
					direction = 0;
				} else direction++;	
			}
		}
		
	}
		
}
	

