package project1;
import org.junit.Test;

public class Board_test {

	
	
	
	
	@Test
	public void test() {
		
		Board b = new Board('~', 'X');		
		b.printBoard();		
		b.showBoat(0, 0);
		
	}

}
