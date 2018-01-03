package board;

public class Client {
	private static MyScanner scanner = new MyScanner();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		Player p1 = new Player(scanner);
		p1.openSquare();
		*/
		Board board = new Board();
		board.setBorders();
		board.generateMines();
		board.printBoard();
	}

}
