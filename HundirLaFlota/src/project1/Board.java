package project1;

import java.util.concurrent.ThreadLocalRandom;

public class Board {
	final static int max_dimension = 10;
	final static char border = '/';
	final static char miss = 'M';
	final static char hit = 'H';
	final static char barquito = 'B';
	public static char unopenedBox = '~'; //regular view of the box 
	public static char openBox = 'X'; // view that will show if you hit a boat
	static char [] letters = {' ','A','B','C','D','E','F','G','H','I'};
	public static char board[][];	
	
	Board(char unopenedBox, char openBox){
		
		
		Board.unopenedBox = unopenedBox;
		Board.openBox = openBox;
		board = new char [max_dimension+1][max_dimension+1];
		
		//Inicialization of the borders of the board
				setBorders(board);
		//Inicialization of the matrix with the default values
				setBoardValues(board);
		
			
	}
	public static void setBoardValues(char[][] board)
	{
		//Fills the boards with the value of unOpenedBox
		for(int i=1; i<max_dimension;i++) 
			for(int j=1; j<max_dimension;j++) 
				board[i][j]= unopenedBox;
	}
	public static void setBorders(char[][]board)
	{	
		//Sets the borders of the board		
		for(int i = 1; i<max_dimension;i++)
		{
			board[i][0] = (char) ((char) i+48);
		}
		for(int j=0;j<max_dimension;j++)
			board[0][j] = letters[j];				
	}
	public static void printBoard(char [][] board, char [][] boardPlayer) {
		
		//Prints the whole matrix to console
		for(int i=0; i<board.length;i++)
		{	
			
			for(int j=0;j<board.length;j++)
			{	
				System.out.print(board[i][j] + "\t");
			}			
			for(int j=0;j<boardPlayer.length;j++)
			{	
				System.out.print(boardPlayer[i][j] + "\t");
			}
			System.out.println("\n");
		}
		
	}
	public static int randomFill(char [][] board)
	{
		//Function used to test other functions
		int count = 0;		
		int row = ThreadLocalRandom.current().nextInt(1,10);
		int col = ThreadLocalRandom.current().nextInt(1,10);
		int numberOfBoats= ThreadLocalRandom.current().nextInt(8,17);
		while(count < numberOfBoats)
		{
			if(board[row][col] == Board.barquito)
			{
				row = ThreadLocalRandom.current().nextInt(1,10);
				col = ThreadLocalRandom.current().nextInt(1,10);
			}
			else if (board[row][col] != Board.barquito)
			{
				board[row][col] = Board.barquito;
				row = ThreadLocalRandom.current().nextInt(1,10);
				col = ThreadLocalRandom.current().nextInt(1,10);
				count+=1;
			}			
		}
		return numberOfBoats;
	}
	public static void flushMatrix(char[][] board)
	{
		//Empties all the values that are in a matrix (used to test other functions)
		for(int i = 1; i<Board.max_dimension;i++)
		{
			for(int j =1; j<Board.max_dimension;j++)
			{
				board[i][j] = ' ';
			}
		}
	}
	
	public static int letterToNumber(char col)
	{	
		//Searches the letter inside of the list and returns it's position
		int h = 0;
		for (int i = 0; i<letters.length;i++)
		{	
			if(letters[i] == col)
			{					
				h=i;
				return i;
			}
			else if(i == letters.length)
			{
				System.out.println("The value of your column is incorrect");
				return 0;
			}				
		}
		return h;
	}		
	
	public static boolean collide(int row,int col,char[][] boardIA)
	{	
		//Searchs in the list of boats of the IA if the position we're shooting is occupied
		//This function is used by the player
		boolean isBoat = false;
		
		if(boardIA[row][col] == barquito)
		{
			isBoat = true;			
		}		
			
		return isBoat;		
	}
		
}
