package project1;
import java.util.List;
import java.util.Scanner;
import project1.Board;
import java.util.concurrent.ThreadLocalRandom;

public class Player {
	
	public static char [][] placesShot;
	
	
	
	public int[] shoot(char[][] boardIA)
	{	
		//Function used by the player in order to shoot down the enemy's boats
		boolean isBoat = false;
		int ret [] = new int [3];
		int row;
		int column=0;
		char col = ' ';
		int hit = 0;
		placesShot = initialitzacionBorder(placesShot);
		boolean done = false;
		Scanner sc = new Scanner(System.in);
		System.out.println("Row you want to shoot at");
		row = sc.nextInt();
		if(row> Board.max_dimension)
		{
			while(row > Board.max_dimension)
			{
				System.out.println("The value of row is incorrect");
				System.out.println("Row you want to shoot at");
				row = sc.nextInt();
			}
		}
		System.out.println("Col you want to shoot at");
		col = sc.next().charAt(0);	
		column = Board.letterToNumber(col);
		System.out.println("hi i'm column " + column);
		//Error control of the col argument
		while(column > Board.max_dimension || column <=0)
		{
			System.out.println("Error the value is incorrect");
			System.out.println("Inser the row of the boat");
			col = sc.next().charAt(0);	
			column = Board.letterToNumber(col);
		}		
		isBoat = Board.collide(row,column,boardIA);
		
		if(isBoat)
		{
			System.out.println("NICE! That was a direct hit");
			placesShot[row][column] = Board.hit;
			hit = 1;			
		}	
		else  if(!isBoat)
			{
				System.out.println("You Missed");
				placesShot[row][column] = Board.miss;				
			}
		ret[0] = hit;
		ret[1] = row;
		ret[2] = column;
		return ret;
		
	}
	public static int[] shootIA(char[][] boardPlayer)
	{	
		int row = 1;
		int col = 1;
		int i= 1;
		int j = 1;
		boolean isBoatIA= false;
		boolean valorHit = false;
		int hit = 0;
		int[] ret = new int [3];
		char [][]	placesShot = new char [Board.max_dimension][Board.max_dimension];
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
						//Posible error
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
			row = ThreadLocalRandom.current().nextInt(1,10);
			col = ThreadLocalRandom.current().nextInt(1,10);				
		}
		//Checking if there's a boat in the position and updating the list and the board.
		isBoatIA =Board.collide(row, col, boardPlayer);		
		if(isBoatIA)
		{
			placesShot[row][col]= Board.hit;			
			hit = 1;
		}		
		ret[0] = hit;
		ret[1] = row;
		ret[2] = col;
		return ret;
	}
	public static char[][] initialitzacionBorder(char [][] placesShot)
	{
		placesShot = new char[Board.max_dimension+1][Board.max_dimension+1];
		//Initialitzation of the borders of the list placeShot in order to dont count those positions when trying to find hits.
		for (int i = 0;i<Board.max_dimension+1;i++)
		{
			placesShot[i][0] = Board.border;
			placesShot[i][10] = Board.border;
			
		}
		for (int i = 0; i< Board.max_dimension+1;i++)
		{
			placesShot[0][i] = Board.border;
			placesShot[10][i] = Board.border;
		}	
		return placesShot;
	}
}




	

