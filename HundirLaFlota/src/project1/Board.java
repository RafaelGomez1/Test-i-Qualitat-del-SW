package project1;
import java.util.Scanner;

public class Board {
	private int max_dimension = 10;
	char unopenedBox = '#'; //regular view of the box 
	char openBox = 'X'; // view that will show if you hit a boat
	char [] letters = {' ','A','B','C','D','E','F','G','H','I'};
	char board[][];	
	
	Board(int max_dimension,char unopenedBox, char openBox){
		
		this.max_dimension = max_dimension;
		this.unopenedBox = unopenedBox;
		this.openBox = openBox;
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
	
	
	public void printBoard() {
		
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
	
	public int letterToNumber(char col)
	{
		int h = 0;
		for (int i = 0; i<letters.length;i++)
		{	System.out.println(letters[i]);
			System.out.println(col);
			if(letters[i] == col)
			{	
				
				h=i+1;
				return i+1;
			}
			else if(i == letters.length)
			{
				System.out.println("The value of your column is incorrect");
				return 0;
			}
				
				
		}
		return h;
	}
	public void showBoat() {
		
		int row;
		char col;
		int column;
		//Code that asks for a row to shoot a boat
		Scanner fila = new Scanner(System.in);
		System.out.println("Row to shoot");
		row = fila.nextInt();
		if(row > max_dimension)
		{
			System.out.println("The value of your row is incorrect");
		}
		System.out.println("Name Accepted" + row);	
		//Asks for a col to shoot a boat
		Scanner columna = new Scanner(System.in);
		System.out.println("Col to shoot");
		//col = columna.next();
		col = columna.next().charAt(0);		
		System.out.println("Name Accepted" + col);		
		column =letterToNumber(col);
		System.out.print( "Hi i'm column" + column);
		board[row][column] = openBox;
		printBoard();
		
	}
	
	
}
