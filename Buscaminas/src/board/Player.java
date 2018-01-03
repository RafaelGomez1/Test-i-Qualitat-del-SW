package board;
import java.util.Scanner;
public class Player {
	MyScanner sc = new MyScanner();
	
	Player(MyScanner scanner){
		sc = scanner;
	}
	
	
	@SuppressWarnings("unused")
	private int[] askForPosition() {
		boolean isValid = false;
		int [] position = new int[2];
		System.out.println("Insert the row of the position you want to open");
		int row = sc.getRow();
		System.out.println("Insert the col of the position you want to open");
		int col = sc.getCol();
		isValid = Board.isPositionInMatrix(row, col);
		if(Board.isSquareOpen(row, col)) {
			while(!isValid) {
				System.out.println("Insert the row of the position you want to open");
				row = sc.getRow();
				System.out.println("Insert the col of the position you want to open");
				col = sc.getCol();
				isValid = Board.isPositionInMatrix(row, col);
			}
		}
		position[0] = row;
		position[1] = col;
		return position;	
	}
	
	@SuppressWarnings("unused")
	protected void openSquare() {
		
		int [] position = askForPosition();		
		int row = position[0];
		int col = position[1];
		
		if(Board.board[row][col].hasBomb) {
			//Game ends
		}
		//Function that opens the matrix and shows the number of mines that are close
		
		
		
		
	}
	
	
}
