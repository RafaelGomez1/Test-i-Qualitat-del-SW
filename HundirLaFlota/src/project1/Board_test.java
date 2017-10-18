package project1;
import org.junit.Test;
import static org.junit.Assert.*;
public class Board_test {
	
	@Test
	public void letterToNumber() {
		int isValid;
		Board b = new Board('~', 'X');		
		isValid =b.letterToNumber(' ');	
		assertEquals(isValid,0);		
		isValid =b.letterToNumber('A');	
		assertEquals(isValid,1);		
		isValid =b.letterToNumber('B');	
		assertEquals(isValid,2);		
		isValid =b.letterToNumber('C');	
		assertEquals(isValid,3);		
		isValid =b.letterToNumber('D');	
		assertEquals(isValid,4);		
		isValid =b.letterToNumber('E');	
		assertEquals(isValid,5);		
		isValid =b.letterToNumber('F');	
		assertEquals(isValid,6);		
		isValid =b.letterToNumber('G');	
		assertEquals(isValid,7);		
		isValid =b.letterToNumber('H');	
		assertEquals(isValid,8);		
		isValid =b.letterToNumber('I');	
		assertEquals(isValid,9);		
		isValid =b.letterToNumber('J');	
		assertEquals(isValid,0);		
		isValid =b.letterToNumber('K');	
		assertEquals(isValid,0);		
		isValid =b.letterToNumber('L');	
		assertEquals(isValid,0);		
		isValid =b.letterToNumber('M');	
		assertEquals(isValid,0);		
		isValid =b.letterToNumber('N');	
		assertEquals(isValid,0);		
		isValid =b.letterToNumber('Ñ');	
		assertEquals(isValid,0);		
		isValid =b.letterToNumber('O');	
		assertEquals(isValid,0);		
		isValid =b.letterToNumber('P');	
		assertEquals(isValid,0);		
		isValid =b.letterToNumber('Q');	
		assertEquals(isValid,0);		
		isValid =b.letterToNumber('R');	
		assertEquals(isValid,0);		
		isValid =b.letterToNumber('S');	
		assertEquals(isValid,0);		
		isValid =b.letterToNumber('T');	
		assertEquals(isValid,0);		
		isValid =b.letterToNumber('U');	
		assertEquals(isValid,0);		
		isValid =b.letterToNumber('V');	
		assertEquals(isValid,0);		
		isValid =b.letterToNumber('W');	
		assertEquals(isValid,0);		
		isValid =b.letterToNumber('X');	
		assertEquals(isValid,0);		
		isValid =b.letterToNumber('Y');	
		assertEquals(isValid,0);		
		isValid =b.letterToNumber('Z');	
		assertEquals(isValid,0);		
	}
	
	@Test
	public void	collide()
	{
		boolean isValid;
		Board b = new Board('~', 'X');
		Boat boat = new Boat(0,0,1,false, 0);
		
		boat.createBoats();
		
		
		
	}

}
