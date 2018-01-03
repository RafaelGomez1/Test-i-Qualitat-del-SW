package board;

public class Square {

	protected boolean hasBomb;
	protected String nearBombs;
	protected int x;
	protected int y;
	protected boolean isOpen;
	
	
	Square(int row, int col){
		this.hasBomb = false;
		this.nearBombs = "[]";	
		this.x = row;
		this.y = col;
		this.isOpen = false;		
	}
	
	
	
}
