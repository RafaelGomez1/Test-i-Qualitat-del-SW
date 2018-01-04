package snake;

import java.util.Random;

@SuppressWarnings("serial")
public class MockRandom extends Random {

	private int maxRow = 78;
	final int maxCol = 65;
	private int rowState = 2;
	private int colState = 2;
	private boolean pairCall = true;
		
	public int nextInt(int max) {
		
		return decider();
	}
	
	public int decider() {
		
		int temp = 0;	
		if (pairCall) {
			pairCall = false;
			return rowState;
			} else if (!pairCall) {				
				//faltan comprobaciones
				if(colState >= maxCol - 2) {
					temp = rowState;
					if(temp >= maxRow - 2) {
						return 0;
					} else {
						rowState++;
						colState = 1;
					}
				} else {
				pairCall = true;
				temp = colState;
				colState++;				
				return temp;				
			}		
		}
		System.out.println("Yolooo");
		System.out.println("The call of this function is pair? : " + pairCall);
		return 25;
	}
}
