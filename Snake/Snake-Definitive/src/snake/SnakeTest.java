package snake;


import static org.junit.Assert.*;

import java.awt.Point;
import java.util.Random;

import org.junit.Test;

public class SnakeTest {

	@Test
	public void checkDirections() {
		
		Snake s = new Snake();
		
		
	}
	@Test
	public void checkCherry() {
		
		//Position parameters 		
		int x = 1;
		int y = 1;
		boolean isValid;
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
