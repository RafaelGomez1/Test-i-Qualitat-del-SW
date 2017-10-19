package project1;

import static org.junit.Assert.*;
import org.junit.Test;

public class PlayerTest {

	@Test
	public void shoot() {
			
		Player p = new Player();
		int value = 0;
		char [][] board = new char[Board.max_dimension][Board.max_dimension];
		int [] hit =  new int [3];		
		Board.setBorders(board);
		Board.setBoardValues(board);
		//Placement of the Boats to test
		board[1][8] = Board.barquito;
		board[2][8] = Board.barquito;
		board[3][8] = Board.barquito;
		board[4][8] = Board.barquito;
		board[2][1] = Board.barquito;
		board[2][2] = Board.barquito;
		board[2][3] = Board.barquito;
		board[4][5] = Board.barquito;
		board[5][5] = Board.barquito;
		board[6][5] = Board.barquito;
		board[7][2] = Board.barquito;
		board[7][3] = Board.barquito;
		
		//Tests True for the shoot function
		hit = p.shoot(board,1,'H');		
		value = hit[0];		
		assertEquals(1,value);
		hit = p.shoot(board,2,'H');		
		value = hit[0];		
		assertEquals(1,value);
		hit = p.shoot(board,3,'H');		
		value = hit[0];		
		assertEquals(1,value);
		hit = p.shoot(board,4,'H');		
		value = hit[0];		
		assertEquals(1,value);
		hit = p.shoot(board,2,'A');		
		value = hit[0];		
		assertEquals(1,value);
		hit = p.shoot(board,2,'B');		
		value = hit[0];		
		assertEquals(1,value);
		hit = p.shoot(board,2,'C');		
		value = hit[0];		
		assertEquals(1,value);
		hit = p.shoot(board,4,'E');		
		value = hit[0];		
		assertEquals(1,value);
		hit = p.shoot(board,5,'E');		
		value = hit[0];		
		assertEquals(1,value);
		hit = p.shoot(board,6,'E');		
		value = hit[0];		
		assertEquals(1,value);
		hit = p.shoot(board,7,'B');		
		value = hit[0];		
		assertEquals(1,value);
		hit = p.shoot(board,7,'C');		
		value = hit[0];		
		assertEquals(1,value);
		
		//Tests False for the shoot function with the same scene
		hit = p.shoot(board,1,'E');		
		value = hit[0];		
		assertEquals(0,value);
		hit = p.shoot(board,1,'F');		
		value = hit[0];		
		assertEquals(0,value);
		hit = p.shoot(board,2,'D');		
		value = hit[0];		
		assertEquals(0,value);
		hit = p.shoot(board,2,'G');		
		value = hit[0];		
		assertEquals(0,value);
		hit = p.shoot(board,3,'A');		
		value = hit[0];		
		assertEquals(0,value);
		hit = p.shoot(board,3,'C');		
		value = hit[0];		
		assertEquals(0,value);
		hit = p.shoot(board,3,'I');		
		value = hit[0];		
		assertEquals(0,value);
		hit = p.shoot(board,4,'F');		
		value = hit[0];		
		assertEquals(0,value);
		hit = p.shoot(board,4,'G');		
		value = hit[0];		
		assertEquals(0,value);
		hit = p.shoot(board,5,'G');		
		value = hit[0];		
		assertEquals(0,value);
		hit = p.shoot(board,5,'H');		
		value = hit[0];		
		assertEquals(0,value);
		hit = p.shoot(board,6,'B');		
		value = hit[0];		
		assertEquals(0,value);
		hit = p.shoot(board,6,'F');		
		value = hit[0];		
		assertEquals(0,value);
		hit = p.shoot(board,7,'A');		
		value = hit[0];		
		assertEquals(0,value);
		hit = p.shoot(board,7,'F');		
		value = hit[0];		
		assertEquals(0,value);
		hit = p.shoot(board,7,'I');		
		value = hit[0];		
		assertEquals(0,value);
		hit = p.shoot(board,8,'D');		
		value = hit[0];		
		assertEquals(0,value);
		hit = p.shoot(board,8,'G');		
		value = hit[0];		
		assertEquals(0,value);
		hit = p.shoot(board,8,'I');		
		value = hit[0];		
		assertEquals(0,value);
		hit = p.shoot(board,9,'A');		
		value = hit[0];		
		assertEquals(0,value);
		hit = p.shoot(board,9,'E');		
		value = hit[0];		
		assertEquals(0,value);
		hit = p.shoot(board,9,'H');		
		value = hit[0];		
		assertEquals(0,value);		
		}
	@Test
	public void shootCriteria()
	{
		Player p = new Player();
		int value = 0;
		char [][] board = new char[Board.max_dimension+1][Board.max_dimension+1];
		int [] hit =  new int [3];		
		//Board.setBorders(board);
		//Board.setBoardValues(board);
		//Placement of the Boats to test
		board[1][8] = Board.hit;
		board[2][8] = Board.hit;
		board[3][8] = Board.hit;
		board[4][8] = Board.hit;
		board[2][1] = Board.hit;
		board[2][2] = Board.hit;
		board[2][3] = Board.hit;
		board[4][5] = Board.hit;
		board[5][5] = Board.hit;
		board[6][5] = Board.hit;
		board[7][2] = Board.hit;
		board[7][3] = Board.hit;
		
		Boat.showMatrix(board);
		while(value <10)
		{
			hit = Player.shootCriteria(1,8,board);
			System.out.println("Hi im row and i'm " + hit[1] + "and i'm col and im " + hit[2] );
			value +=1;
		}
	}
}


