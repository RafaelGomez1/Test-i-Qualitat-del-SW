package project1;
import static org.junit.Assert.*;

import org.junit.Test;

public class Board_test {

	
	
	
	
	@Test
	public void test() {
		
		Board b = new Board(10,'#', 'X');
		String s[] ={" ","A","B","C","D","E","F","G","H","I"};
		
		
		b.printBoard();		
		b.showBoat();
		
	}

}
