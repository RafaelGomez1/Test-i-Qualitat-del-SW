package project1;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Board {
	final static int max_dimension = 10;
	final static char border = '/';
	final static char miss = 'M';
	final static char hit = 'H';
	public static char unopenedBox = '~'; //regular view of the box 
	public static char openBox = 'X'; // view that will show if you hit a boat
	static char [] letters = {' ','A','B','C','D','E','F','G','H','I'};
	public static char board[][];	
	
	Board(char unopenedBox, char openBox){
		
		
		Board.unopenedBox = unopenedBox;
		Board.openBox = openBox;
		board = new char [max_dimension][max_dimension];
		
		//Inicialization of the matrix with the default values
		for(int i=1; i<max_dimension;i++) 
			for(int j=1; j<max_dimension;j++) 
				board[i][j]= unopenedBox;
		//Inicialization of the first column with the numbers
		//for(int i=1; i<max_dimension;i++)
			board[1][0] = '1';
			board[2][0] = '2';
			board[3][0] = '3';
			board[4][0] = '4';
			board[5][0] = '5';
			board[6][0] = '6';
			board[7][0] = '7';
			board[8][0] = '8';
			board[9][0] = '9';
		//Inicialization of the first row with the letters
		for(int j=0;j<max_dimension;j++)
			board[0][j] = letters[j];		
	}
	
	
	public static void printBoard() {
		
		//Prints the whole matrix to console
		for(int i=0; i<max_dimension;i++)
		{
			for(int j=0;j<max_dimension;j++)
			{
				System.out.print(board[i][j] + "\t");
			}
			System.out.println("\n");
		}
		
	}
	
	public static int letterToNumber(char col)
	{	
		//Searches the letter inside of the dictionary and returns it's position
		int h = 0;
		for (int i = 0; i<letters.length;i++)
		{	//System.out.println(letters[i]);
			//System.out.println(col);
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
	public static void showBoat(int row, int col) {		
	
		board[row][col] = openBox;
		printBoard();
		
	}
	public static boolean collide(int row,int col,List<Boat> boatsIA)
	{	
		//Searchs in the list of boats of the IA if the position we're shooting is occupied
		//This function is used by the player
		boolean isBoat = false;
		for(int i=0;i<boatsIA.size();i++)
		{			
			if(boatsIA.get(i).row == row && boatsIA.get(i).column == col)
			{
				isBoat=true;
				return isBoat;
			}
		}
			
		return isBoat;
		
	}
	public static boolean collideIA(int row,int col,List<Boat> boats)
	{
		//Searchs in the list of boats of the player if there's any boat in the position.
		//Function used by the IA 
		boolean isBoatIA = false;
		for(int i=0;i<boats.size();i++)
		{			
			if(boats.get(i).row == row && boats.get(i).column == col)
			{
				isBoatIA=true;
				return isBoatIA;
			}
		}
			
		return isBoatIA;
	}
	
}
