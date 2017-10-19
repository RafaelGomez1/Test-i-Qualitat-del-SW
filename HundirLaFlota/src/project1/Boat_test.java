package project1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Boat_test {

	@Test
	public void isValidValue() {
		
		Boat b = new Boat(0,0,1,false,0);
		boolean valid;
		int i;
		//Tests True for either row or col
		for(i = 1; i<10; i++ )
		{
			valid = b.isValidValue(i);
			assertTrue(valid);
		}	
		//Tests False for either row or col 
		for(i = 10; i<100; i++ )
		{
			valid = b.isValidValue(i);
			assertFalse(valid);
		}		
	}
	
	@Test 
	public void isValidType()
	{
		Boat b = new Boat(0,0,2,false,0);
		boolean valid;
		int i;
		for(i = 1; i< 4;i++)
		{
			valid = b.isValidType(i);
			assertTrue(valid);
		}
		for(i = 4; i<100; i++)
		{
			valid = b.isValidType(i);
			assertFalse(valid);
		}		
		
	}
	
	@Test
	public void isValidVert()
	{
		Boat b = new Boat(0,0,2,false,0);
		boolean valid;
		int i;
		char ver;
		
		//Tests True for the vert value
			valid = b.isValidVert('Y');
			assertTrue(valid);
			valid = b.isValidVert('N');
			assertTrue(valid);
		//Tests False for the vert value		
		for(i=1; i< 20;i++)
		{
			ver = (char) ((char) i+48);
			valid = b.isValidType(ver);		
			System.out.println(ver);
			assertFalse(valid);
		}		
	}

	@Test 
	public void setLenght()
	{
		Boat b = new Boat(0,0,2,false,0);
		int valid;
		int i;
		//Tests True for the length value
		for(i=1;i<4;i++)
		{
			valid= b.setLenght(i);
			assertEquals(valid,(i+1));			
		}
		//Tests False for the length value		
		for(i=5;i<40;i++)
		{
			valid= b.setLenght(i);
			assertEquals(valid,-1);			
		}			
	}
	@Test 
	public void canPlaceBoats()
	{
		Boat b = new Boat(0,0,2,false,0);
		boolean canBePlaced;
		//Creates a board and puts the boards in a fixed positions in order to test in the same environment all the time
		char [][] boats = new char[Board.max_dimension+1][Board.max_dimension+1];
		boats = Player.initialitzacionBorder(boats);		
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
		
		//Tests False for the canBePlaced parameter
		//Boats that are already placed
		canBePlaced = b.canPlaceBoats(1,8,3,true,boats);
		assertFalse(canBePlaced);	
		canBePlaced = b.canPlaceBoats(2,1,2,false,boats);
		assertFalse(canBePlaced);
		canBePlaced = b.canPlaceBoats(2,2,2,false,boats);
		assertFalse(canBePlaced);
		canBePlaced = b.canPlaceBoats(2,3,2,false,boats);
		assertFalse(canBePlaced);		
		canBePlaced = b.canPlaceBoats(4,5,2,true,boats);
		assertFalse(canBePlaced);
		canBePlaced = b.canPlaceBoats(5,5,2,true,boats);
		assertFalse(canBePlaced);
		canBePlaced = b.canPlaceBoats(6,5,2,true,boats);
		assertFalse(canBePlaced);
		canBePlaced = b.canPlaceBoats(7,2,1,false,boats);
		assertFalse(canBePlaced);
		canBePlaced = b.canPlaceBoats(7,3,1,false,boats);
		assertFalse(canBePlaced);
		
		//Boats that we try to place in a wrong position
		canBePlaced = b.canPlaceBoats(1,9,2,false,boats);
		assertFalse(canBePlaced);
		canBePlaced = b.canPlaceBoats(1,1,2,true,boats);
		assertFalse(canBePlaced);
		canBePlaced = b.canPlaceBoats(1,2,1,true,boats);
		assertFalse(canBePlaced);
		canBePlaced = b.canPlaceBoats(1,3,3,true,boats);
		assertFalse(canBePlaced);
		canBePlaced = b.canPlaceBoats(2,9,2,false,boats);
		assertFalse(canBePlaced);
		canBePlaced = b.canPlaceBoats(2,5,3,true,boats);
		assertFalse(canBePlaced);
		canBePlaced = b.canPlaceBoats(3,9,2,false,boats);
		assertFalse(canBePlaced);
		canBePlaced = b.canPlaceBoats(4,9,2,false,boats);
		assertFalse(canBePlaced);
		canBePlaced = b.canPlaceBoats(4,6,3,false,boats);
		assertFalse(canBePlaced);
		canBePlaced = b.canPlaceBoats(7,1,1,false,boats);
		assertFalse(canBePlaced);
		canBePlaced = b.canPlaceBoats(8,2,2,true,boats);
		assertFalse(canBePlaced);
		canBePlaced = b.canPlaceBoats(8,2,2,true,boats);
		assertFalse(canBePlaced);		
		
		//Tests True for the canBePlaced parameter		
		canBePlaced = b.canPlaceBoats(1,1,2,false,boats);
		assertTrue(canBePlaced);
		Boat.showMatrix(boats);
		canBePlaced = b.canPlaceBoats(1,4,3,false,boats);
		assertTrue(canBePlaced);
		Boat.showMatrix(boats);
		canBePlaced = b.canPlaceBoats(1,9,3,true,boats);
		assertTrue(canBePlaced);
		Boat.showMatrix(boats);
		canBePlaced = b.canPlaceBoats(2,4,3,false,boats);
		assertTrue(canBePlaced);
		Boat.showMatrix(boats);
		canBePlaced = b.canPlaceBoats(3,1,3,true,boats);
		assertTrue(canBePlaced);
		Boat.showMatrix(boats);
		canBePlaced = b.canPlaceBoats(3,2,2,false,boats);
		assertTrue(canBePlaced);
		Boat.showMatrix(boats);
		canBePlaced = b.canPlaceBoats(3,5,1,false,boats);
		assertTrue(canBePlaced);
		Boat.showMatrix(boats);		
		canBePlaced = b.canPlaceBoats(3,7,1,true,boats);
		assertTrue(canBePlaced);	
		Boat.showMatrix(boats);
		canBePlaced = b.canPlaceBoats(4,2,2,false,boats);
		assertTrue(canBePlaced);
		Boat.showMatrix(boats);		
		canBePlaced = b.canPlaceBoats(4,6,1,true,boats);
		assertTrue(canBePlaced);
		Boat.showMatrix(boats);			
		canBePlaced = b.canPlaceBoats(5,2,2,false,boats);
		assertTrue(canBePlaced);
		Boat.showMatrix(boats);
		canBePlaced = b.canPlaceBoats(5,7,2,false,boats);
		assertTrue(canBePlaced);
		Boat.showMatrix(boats);
		canBePlaced = b.canPlaceBoats(6,2,2,false,boats);
		assertTrue(canBePlaced);
		Boat.showMatrix(boats);
		canBePlaced = b.canPlaceBoats(6,6,3,false,boats);
		assertTrue(canBePlaced);
		Boat.showMatrix(boats);
		canBePlaced = b.canPlaceBoats(7,1,2,true,boats);
		assertTrue(canBePlaced);
		Boat.showMatrix(boats);
		canBePlaced = b.canPlaceBoats(7,4,3,false,boats);
		assertTrue(canBePlaced);
		Boat.showMatrix(boats);
		canBePlaced = b.canPlaceBoats(7,8,1,false,boats);
		assertTrue(canBePlaced);
		Boat.showMatrix(boats);
		canBePlaced = b.canPlaceBoats(8,2,1,true,boats);
		assertTrue(canBePlaced);
		Boat.showMatrix(boats);
		canBePlaced = b.canPlaceBoats(8,3,1,true,boats);
		assertTrue(canBePlaced);
		Boat.showMatrix(boats);		
		canBePlaced = b.canPlaceBoats(8,4,3,false,boats);
		assertTrue(canBePlaced);
		Boat.showMatrix(boats);
		canBePlaced = b.canPlaceBoats(8,8,1,false,boats);
		assertTrue(canBePlaced);
		Boat.showMatrix(boats);
		canBePlaced = b.canPlaceBoats(9,4,2,false,boats);
		assertTrue(canBePlaced);
		Boat.showMatrix(boats);
		canBePlaced = b.canPlaceBoats(9,7,2,false,boats);
		assertTrue(canBePlaced);
		Boat.showMatrix(boats);		
	}
	@Test
	public void countBoats()
	{
		//Function that tests if the number of boats in the matrix is correct
		char [][] boats = new char[Board.max_dimension][Board.max_dimension];
		boats = Player.initialitzacionBorder(boats);
		Boat.showMatrix(boats);
		int boatscount = 0;
		int counter= 0;
		int i = 0;		
		while(i<50)
		{
			counter = Board.randomFill(boats);
			boatscount = Boat.countBoats(boats);
			assertEquals(counter,boatscount);
			Board.flushMatrix(boats);
			i+=1;
		}				
	}
}
