package project1;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
		board = new char [max_dimension][max_dimension];
		
		//Inicialization of the borders of the board
				setBorders(board);
		//Inicialization of the matrix with the default values
		for(int i=1; i<max_dimension;i++) 
			for(int j=1; j<max_dimension;j++) 
				board[i][j]= unopenedBox;
		
			
	}
	
	public static boolean setBorders(char[][]board)
	{	
		//Sets the borders of the board
		boolean done = false;
		for(int i = 1; i<max_dimension;i++)
		{
			board[i][0] = (char) ((char) i+48);
		}
		for(int j=0;j<max_dimension;j++)
			board[0][j] = letters[j];	
		done = true;
		return done;
		
		
	}
	public static void printBoard(char [][] board) {
		
		//Prints the whole matrix to console
		for(int i=0; i<board.length;i++)
		{
			for(int j=0;j<board.length;j++)
			{
				System.out.print(board[i][j] + "\t");
			}
			System.out.println("\n");
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
