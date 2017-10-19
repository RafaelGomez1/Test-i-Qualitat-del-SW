package project1;
import org.junit.Test;
import static org.junit.Assert.*;
public class Board_test {
	
	@Test
	public void letterToNumber() {
		int isValid;				
		isValid =Board.letterToNumber(' ');	
		assertEquals(isValid,0);		
		isValid =Board.letterToNumber('A');	
		assertEquals(isValid,1);		
		isValid =Board.letterToNumber('B');	
		assertEquals(isValid,2);		
		isValid =Board.letterToNumber('C');	
		assertEquals(isValid,3);		
		isValid =Board.letterToNumber('D');	
		assertEquals(isValid,4);		
		isValid =Board.letterToNumber('E');	
		assertEquals(isValid,5);		
		isValid =Board.letterToNumber('F');	
		assertEquals(isValid,6);		
		isValid =Board.letterToNumber('G');	
		assertEquals(isValid,7);		
		isValid =Board.letterToNumber('H');	
		assertEquals(isValid,8);		
		isValid =Board.letterToNumber('I');	
		assertEquals(isValid,9);		
		isValid =Board.letterToNumber('J');	
		assertEquals(isValid,0);		
		isValid =Board.letterToNumber('K');	
		assertEquals(isValid,0);		
		isValid =Board.letterToNumber('L');	
		assertEquals(isValid,0);		
		isValid =Board.letterToNumber('M');	
		assertEquals(isValid,0);		
		isValid =Board.letterToNumber('N');	
		assertEquals(isValid,0);		
		isValid =Board.letterToNumber('Ñ');	
		assertEquals(isValid,0);		
		isValid =Board.letterToNumber('O');	
		assertEquals(isValid,0);		
		isValid =Board.letterToNumber('P');	
		assertEquals(isValid,0);		
		isValid =Board.letterToNumber('Q');	
		assertEquals(isValid,0);		
		isValid =Board.letterToNumber('R');	
		assertEquals(isValid,0);		
		isValid =Board.letterToNumber('S');	
		assertEquals(isValid,0);		
		isValid =Board.letterToNumber('T');	
		assertEquals(isValid,0);		
		isValid =Board.letterToNumber('U');	
		assertEquals(isValid,0);		
		isValid =Board.letterToNumber('V');	
		assertEquals(isValid,0);		
		isValid =Board.letterToNumber('W');	
		assertEquals(isValid,0);		
		isValid =Board.letterToNumber('X');	
		assertEquals(isValid,0);		
		isValid =Board.letterToNumber('Y');	
		assertEquals(isValid,0);		
		isValid =Board.letterToNumber('Z');	
		assertEquals(isValid,0);		
	}
	
	@Test
	public void	collide()
	{
		Board board = new Board('~', 'X');
		Boat boat = new Boat(0,0,1,false, 0);
		int row = 1;
		int col = 1;
		char [][] boats = new char[Board.max_dimension+1][Board.max_dimension+1];
		boolean isValid;
		
		
		Board.setBorders(boats);
		Board.setBoardValues(boats);
		//Placement of the Boats to test
		boats[1][8] = Board.barquito;
		boats[2][8] = Board.barquito;
		boats[3][8] = Board.barquito;
		boats[4][8] = Board.barquito;
		boats[2][1] = Board.barquito;
		boats[2][2] = Board.barquito;
		boats[2][3] = Board.barquito;
		boats[4][5] = Board.barquito;
		boats[5][5] = Board.barquito;
		boats[6][5] = Board.barquito;
		boats[7][2] = Board.barquito;
		boats[7][3] = Board.barquito;
		
		//Prints the matrix so you can check the tests are correct
		Boat.showMatrix(boats);
				
		//Tests True for the first row
		isValid =Board.collide(1,8,boats);
		assertEquals(isValid,true);
		//Tests True for the second row
		isValid =Board.collide(2,1,boats);
		assertEquals(isValid,true);
		isValid =Board.collide(2,2,boats);
		assertEquals(isValid,true);
		isValid =Board.collide(2,3,boats);
		assertEquals(isValid,true);
		isValid =Board.collide(2,8,boats);
		assertEquals(isValid,true);
		//Tests True for the third row
		isValid =Board.collide(3,8,boats);
		assertEquals(isValid,true);
		//Tests True for the fourth row
		isValid =Board.collide(4,5,boats);
		assertEquals(isValid,true);
		isValid =Board.collide(4,8,boats);
		assertEquals(isValid,true);
		//Tests True for the fifth row
		isValid =Board.collide(5,5,boats);
		assertEquals(isValid,true);
		//Tests True for the sixth row
		isValid =Board.collide(6,5,boats);
		assertEquals(isValid,true);
		//Tests True for the seventh row
		isValid =Board.collide(7,2,boats);
		assertEquals(isValid,true);
		isValid =Board.collide(7,3,boats);
		assertEquals(isValid,true);
		
		//Tests False for the first row
		isValid =Board.collide(1,5,boats);
		assertEquals(isValid,false);
		isValid =Board.collide(1,6,boats);
		assertEquals(isValid,false);
		isValid =Board.collide(1,1,boats);
		assertEquals(isValid,false);
		//Tests False for the second row
		isValid =Board.collide(2,4,boats);
		assertEquals(isValid,false);
		isValid =Board.collide(2,5,boats);
		assertEquals(isValid,false);
		isValid =Board.collide(2,9,boats);
		assertEquals(isValid,false);
		//Tests False for the third row 
		isValid =Board.collide(3,1,boats);
		assertEquals(isValid,false);
		isValid =Board.collide(3,6,boats);
		assertEquals(isValid,false);
		isValid =Board.collide(3,9,boats);
		assertEquals(isValid,false);
		//Tests False for the fourth row
		isValid =Board.collide(4,1,boats);
		assertEquals(isValid,false);
		isValid =Board.collide(4,4,boats);
		assertEquals(isValid,false);
		isValid =Board.collide(4,7,boats);
		assertEquals(isValid,false);
		//Tests False for the fifth row
		isValid =Board.collide(5,1,boats);
		assertEquals(isValid,false);
		isValid =Board.collide(5,6,boats);
		assertEquals(isValid,false);
		isValid =Board.collide(5,9,boats);
		assertEquals(isValid,false);
		//Tests False for the sixth row 
		isValid =Board.collide(6,1,boats);
		assertEquals(isValid,false);
		isValid =Board.collide(6,6,boats);
		assertEquals(isValid,false);
		isValid =Board.collide(6,9,boats);
		assertEquals(isValid,false);
		//Tests False for the seventh row
		isValid =Board.collide(7,1,boats);
		assertEquals(isValid,false);
		isValid =Board.collide(7,7,boats);
		assertEquals(isValid,false);
		isValid =Board.collide(7,8,boats);
		assertEquals(isValid,false);
		//Tests False for the eighth row
		isValid =Board.collide(8,1,boats);
		assertEquals(isValid,false);
		isValid =Board.collide(8,6,boats);
		assertEquals(isValid,false);
		isValid =Board.collide(8,9,boats);
		assertEquals(isValid,false);
		//Tests False for the ninth row 
		isValid =Board.collide(9,1,boats);
		assertEquals(isValid,false);
		isValid =Board.collide(9,6,boats);
		assertEquals(isValid,false);
		isValid =Board.collide(9,9,boats);
		assertEquals(isValid,false);	
		
		
	}

}
