package project1;
import java.util.Scanner;
import project1.Board;

public class Player {

	public void shoot(Board board)
	{
		int positions[];
		positions= ask(board);
		
	}
	public int[] ask( Board board)
	{	
		int max_dimension = 10;
		int row;
		int column;
		char col;		
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
		column = board.letterToNumber(col);		
		return new int[] {row,column};
	}
}
