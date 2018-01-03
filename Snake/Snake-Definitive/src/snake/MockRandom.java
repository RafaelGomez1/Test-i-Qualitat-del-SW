package snake;

import java.util.Random;

public class MockRandom extends Random {

	int maxRow = 79;
	int maxCol = 66;
	int rowState = 1;
	int colState = 1;
	boolean pairCall = true;
	boolean oddCall = false;
		
	public int nextInt(int max) {
		
		return max/2;
	}
	
	public int decider() {
		
		
		
	
		return 0;
	}
}
