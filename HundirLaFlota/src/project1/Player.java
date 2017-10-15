package project1;
import java.util.List;
import java.util.Scanner;
import project1.Board;
import java.util.concurrent.ThreadLocalRandom;

public class Player {
	
	public static char [][] placesShot;
	
	
	
	public static void shoot(List <Boat> boatsIA)
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
	public static void ShootIA(List<Boat> boats)
	{	
		int row = 1;
		int col = 1;
		int i= 1;
		int j = 1;
		boolean isBoatIA= false;
		boolean valorHit = false;
		placesShot = initialitzacionBorder(placesShot);
		//Checking if we already hit something in order to hit the adjacents slots
		
		for(i=1;i<placesShot.length;i++)
		{
			for(j=1; j<placesShot.length;j++)
			{
				if(placesShot[i][j] == Board.hit)
				{
					//Everything inside this block, works to check if there's any hits up or down the hit we encountered
					if(placesShot[i-1][j] == Board.hit && placesShot[i-1][j] != Board.border)
					{
						if(placesShot[i-2][j] != Board.hit && placesShot[i-2][j] != Board.miss && placesShot[i-2][j] != Board.border)
						{
							row = i-2;
							col = j;
							valorHit = true;
							break;
						}
						else if (placesShot[i-2][j] == Board.border && placesShot[i+1][j] != Board.hit && placesShot[i+1][j] !=Board.miss)
						{
							row = i+1;
							col = j;
							valorHit = true;
							break;
						}
						else if(placesShot[i+1][j] == Board.hit)
						{
							row = i+2;
							col = j;
							valorHit = true;
							break;
						}
				
					}
					else if(placesShot[i-1][j]!= Board.hit && placesShot[i-1][j] != Board.miss && placesShot[i-1][j] != Board.border)
					{
						row = i-1;
						col = j;
						valorHit = true;
						break;
					}
					if(placesShot[i][j-1] != Board.hit && placesShot[i][j-1] != Board.miss && placesShot[i][j-1] != Board.border)
					{
						row = i;
						col = j-1;
						valorHit = true;
						break;
					
					}
					else if(placesShot[i][j-1] == Board.hit && placesShot[i][j-2] != Board.miss && placesShot[i][j-2] != Board.border && placesShot[i][j-2] != Board.hit)
					{
						row = i;
						j = j-2;
						valorHit = true;
						break;
					}
					else if(placesShot[i][i-2] == Board.miss && placesShot[i][j+1] != Board.border && placesShot[i][j+1] != Board.hit && placesShot[i][j+1] != Board.miss)
					{
						row = i;
						j= j+1;
						valorHit = true;
						break;
					}
					else if(placesShot[i][j+1] == Board.hit && placesShot[i][j+2] != Board.border && placesShot[i][j+2]!= Board.hit && placesShot[i][j+2] != Board.miss)
					{
						row = i;
						j = j+2;
						valorHit = true;
						break;
					}
				}			
			}			
		}
		
		//Random generation of the position the IA will shoot if we don't find a Hit
		if(!valorHit)
		{
			row = ThreadLocalRandom.current().nextInt(1,11);
			col = ThreadLocalRandom.current().nextInt(1,11);				
		}
		//Checking if there's a boat in the position and updating the list and the board.
		isBoatIA =Board.collideIA(row, col, boats);		
		if(isBoatIA)
		{
			placesShot[row][col]= Board.hit;
			Board.board[row][col] = Board.hit;
			
		}
	}
	public static char[][] initialitzacionBorder(char [][] placesShot)
	{
		//Initialitzation of the borders of the list placeShot in order to dont count those positions when trying to find hits.
		for (int i = 0;i<Board.max_dimension;i++)
		{
			placesShot[i][0] = Board.border;
		}
		for (int i = 0; i< Board.max_dimension;i++)
		{
			placesShot[0][i] = Board.border;
		}
		return placesShot;
	}
}




	

