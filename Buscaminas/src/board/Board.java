package board;
import java.util.concurrent.ThreadLocalRandom;
public class Board {
	final static int MAX_LENGTH = 7;
	protected static Square [][] board = new Square[MAX_LENGTH][MAX_LENGTH];
	
	Board(){		
		for(int i = 0; i<  MAX_LENGTH;i++)
			for(int j = 0; j< MAX_LENGTH;j++) {
				board[i][j] = new Square(i,j);				
			}	
		board[0][0].nearBombs = " ";
	}
	
	protected void printBoard() {
		for(int i=0; i<MAX_LENGTH;i++) {		
			for(int j=0;j<MAX_LENGTH;j++)
			{	
				System.out.print(board[i][j].nearBombs + "\t");
			}
			System.out.println();
		}
	}
	protected void setBorders(){
		for(int i=1; i<MAX_LENGTH;i++) {
			board[i][0].nearBombs = String.valueOf(i);
			board[0][i].nearBombs = String.valueOf(i);	
		}
	}
	@SuppressWarnings("unused")
	protected void generateMines() {		
		//Generates random mines 
		int max_mines = ThreadLocalRandom.current().nextInt(10,17);
		int minesPlaced = 0;
		int randCol = 0;
		int randRow = 0;
		boolean isValid = false;
		while(minesPlaced<=max_mines) {
			if(isValid) {
				board[randCol][randRow].hasBomb = true;	
				minesPlaced+=1;
			}
			randCol = ThreadLocalRandom.current().nextInt(1,7);
			randRow = ThreadLocalRandom.current().nextInt(1,7);
			isValid = checkPositionAvailable(randRow,randCol);			
		}		
	}
	private boolean checkPositionAvailable(int row,int col) {
		//Checks if there's already a mine in the position created randomly
		if(isPositionInMatrix(row,col)) {
			if(!board[row][col].hasBomb)
				return true;
			else return false;
		}
		return false;
		
	}
	protected static boolean isPositionInMatrix(int row,int col) {
		//Checks if the position of the mine is inside the Matrix
		if((row <= 0 || row > MAX_LENGTH) || (col <= 0  || col > MAX_LENGTH))
			return false;
		else return true;
	}
	protected static boolean isSquareOpen(int row, int col) {
		
		if(board[row][col].isOpen)
			return true;
		else return false;
	}
	
	
	
}
