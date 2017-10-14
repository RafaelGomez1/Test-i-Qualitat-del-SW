package project1;
import java.util.List;
import java.util.Scanner;
import project1.Board;
import java.util.concurrent.ThreadLocalRandom;

public class Player {
	
	public char [][] placesShot;
	public char [][] placesToShoot;
	public int playerID;
	
	
	public void shoot(List <Boat> boatsIA)
	{	
		
		boolean isBoat = false;
		int row;
		int column=0;
		char col = ' ';
		boolean done = false;
		Scanner sc = new Scanner(System.in);
		System.out.println("Row you want to shoot at");
		row = sc.nextInt();
		while(row > Board.max_dimension)
		{
			System.out.println("The value of row is incorrect");
			System.out.println("Row you want to shoot at");
			row = sc.nextInt();
		}			
		while(!done)
		{
			System.out.println("Col you want to shoot at");
			col = sc.nextLine().charAt(0);	
			for(int i=0;i<Board.letters.length;i++)
			{
				if(Board.letters[i] == col)
				{
					column = Board.letterToNumber(col);
					done = true;
				}
				
			}
			System.out.println("The value of Col is incorrect");
		}
		isBoat = Board.collide(row,column,boatsIA);
		
		if(isBoat)
		{
			//placesShot[row][col] = Board.hit;
			Board.showBoat(row,col);
			System.out.println("Direct hit");
		}	
		System.out.println("You Missed");
		//else placesShot[row][col] = Board.miss;
	}
	public void ShootIA(List<Boat> boats)
	{	
		int row;
		int col;
		//Checking if we already hit something in order to hit the adjacents slots
		for(int i=0;i<placesShot.length;i++)
		{
			for(int j=0; j<placesShot.length;j++)
			{
				if(placesShot[i][j] == Board.hit)
				{
					if(placesShot[i-1][j] == Board.hit)
					{
						row = i-2;
						col = j;
						break;
					}
					else if(placesShot[i][j+1]== Board.hit)
					{
						row = i;
						col = j-2;
						break;
					}
				}				
			
			}
			
		}
		
		//Random generation of the position the IA will shoot
		boolean isBoatIA= false;
		row = ThreadLocalRandom.current().nextInt(1,11);
		col = ThreadLocalRandom.current().nextInt(1,11);		
		isBoatIA =Board.collideIA(row, col, boats);
		if(isBoatIA)
		{
			Board.board[row][col] = Board.hit;
			placesShot[row][col]= Board.hit;
		}
		
		
		
		 
		 

	}
}




	

