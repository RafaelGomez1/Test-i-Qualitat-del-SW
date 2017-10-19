package project1;
import java.util.List;
import java.util.Scanner;
import project1.Board;
import java.util.concurrent.ThreadLocalRandom;

public class Player {
	
	public static char [][] placesShot;
	
	
	public int ask4Row(Scanner sc)
	{
		System.out.println("Row you want to shoot at");
		return sc.nextInt();
	}
	public char ask4Col(Scanner sc)
	{
		System.out.println("Col you want to shoot at");		 
		return sc.next().charAt(0);
	}
	public int[] shoot(char[][] boardIA,int row,char col)
	{	
		//Function used by the player in order to shoot down the enemy's boats
		boolean isBoat = false;
		int ret [] = new int [3];
		Scanner sc = new Scanner(System.in);
		int column=0;		
		int hit = 0;
		boolean isValid;
		placesShot = initialitzacionBorder(placesShot);
		boolean done = false;				
		isValid = Boat.isValidValue(row);		
		while(!isValid)
		{
			System.out.println("The value of row is incorrect");
			row = ask4Row(sc);
			isValid = Boat.isValidValue(row);
			
		}					
		column = Board.letterToNumber(col);
		isValid = Boat.isValidValue(column);	
		//Error control of the col argument
		while(!isValid)
		{
			System.out.println("Error the value is incorrect");
			row = ask4Col(sc);	
			column = Board.letterToNumber(col);
			isValid = Boat.isValidValue(column);
		}		
		isBoat = Board.collide(row,column,boardIA);
		
		if(isBoat)
		{
			System.out.println("NICE! That was a direct hit");
			System.out.println("----------------------------------------------------");
			placesShot[row][column] = Board.hit;
			hit = 1;			
		}	
		else  if(!isBoat)
			{
				System.out.println("You Missed");
				System.out.println("----------------------------------------------------");
				placesShot[row][column] = Board.miss;				
			}
		ret[0] = hit;
		ret[1] = row;
		ret[2] = column;
		return ret;
		
	}
	public static int randomPosGenerator()
	{
		int index = ThreadLocalRandom.current().nextInt(1,10);		
		return index;
	}
	public static int[] shootIA(char[][] boardPlayer,int row,int col)
	{	
		
		
				
		boolean isBoatIA= false;
		boolean valorHit = false;		
		int[] ret = new int [3];
		placesShot = new char [Board.max_dimension][Board.max_dimension];
		placesShot = initialitzacionBorder(placesShot);
		//Checks if we already hit something in order to hit the adjacents slots		
		ret = shootCriteria(row,col,placesShot);		
		//Random generation of the position the IA will shoot if we don't find a Hit
		if(ret[0] == 0)
		{
			row = ThreadLocalRandom.current().nextInt(1,10);
			col = ThreadLocalRandom.current().nextInt(1,10);				
		}
		row = ret[1];		
		col = ret[2];
		//Checking if there's a boat in the position and updating the list and the board.
		isBoatIA =Board.collide(row,col, boardPlayer);		
		if(isBoatIA)
		{
			placesShot[row][col]= Board.hit;			
			System.out.println("The enemy hit your boat at row " + row + "col " + col);
			System.out.println("----------------------------------------------------");
		}
		else placesShot[row][col] = Board.miss;
		
		return ret;
	}
	
	public static int[] shootCriteria(int row, int col, char [][] placesShot)
	{
		//Function that checks if the IA hit one of our boats in order to next hit the adjacents slots to that one
		
		boolean valorHit = false;
		int hit[] = new int[3];//hit(1) or miss (0)/row/col
		hit[0] = 0;
		for(int i=1;i<Board.max_dimension;i++)
		{
			for(int j=1; j<Board.max_dimension;j++)
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
						else if ((placesShot[i-2][j] == Board.border || placesShot[i-2][j] == Board.hit) && placesShot[i+1][j] != Board.hit && placesShot[i+1][j] !=Board.miss 
								&& placesShot[i+1][j] !=Board.border)
						{
							row = i+1;
							col = j;
							valorHit = true;
							break;
						}
						else if(placesShot[i+1][j] == Board.hit && (placesShot[i-1][j] ==Board.hit || placesShot[i-1][j] !=Board.border) && placesShot[i+2][j] !=Board.border)
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
						col = j-2;
						valorHit = true;
						break;
					}
					else if(placesShot[i][i-2] == Board.miss && placesShot[i][j+1] != Board.border && placesShot[i][j+1] != Board.hit && placesShot[i][j+1] != Board.miss)
					{
						row = i;
						col= j+1;
						valorHit = true;
						break;
					}
					else if(placesShot[i][j+1] == Board.hit && placesShot[i][j+2] != Board.border && placesShot[i][j+2]!= Board.hit && placesShot[i][j+2] != Board.miss)
					{
						row = i;
						col = j+2;
						valorHit = true;
						break;
					}
				}			
			}			
		}
		if(valorHit == true)
		{
			hit[0]= 1;
		}		
		hit[1] = row;
		hit[2] = col;
		return hit;
		
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




	

