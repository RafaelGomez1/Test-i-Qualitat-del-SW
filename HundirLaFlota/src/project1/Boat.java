package project1;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;
import project1.Board;

public class Boat {
	private int typeOfBoat;//1 -> 2 slots boats, 2-> 3 slots boats, 3-> 4 boat slots	
	public int row;
	private boolean vertical = false;
	private int lenght;	
	private char col;
	public int column;
	final static int max_boats = 4;
	
	
	Boat(int row,int column,int typeOfBoat, boolean vertical,int lenght)
	{
		this.row = row;
		this.column = column;
		this.typeOfBoat = typeOfBoat;
		this.vertical = vertical;		
		this.lenght = lenght;
		
	}
	public static boolean isValidValue(int index)
	{
		//Checks if the values of both variables row and col are correct
		boolean valid = false;
		if(index < Board.max_dimension && index >= 1)
		{
			valid = true;
		}
		
		return valid;
	}
	public static boolean isValidVert(char vert)
	{
		//Checks if the value of vert is either of the two options we printed
		
		if(vert == 'Y' || vert == 'N')
		{
			return true;
		}
		return false;
	}
	public static boolean isValidType(int type)
	{
		//Checks if the value of type is correct
		
		if(type >=1 && type <=3)
		{
			return true;
		}
		return false;
	}
	public static int setLenght(int type)
	{
		//Sets the length of a boat according to his type
		boolean valid = false;
		int lenght = 0;
		valid =isValidType(type);
		if(valid)
		{
			switch (type)
			{
				case 1: lenght = 2;
						break;
				case 2: lenght = 3;
						break;
				case 3: lenght = 4;
						break;				
			}
			return lenght;
		}		
		return -1;
	}
	
	public char[][] createBoats() 
	{			
		char aux;
		char boardPlayer[][];
		boolean placed;
		boolean isValid = false;		
		boardPlayer = new char [Board.max_dimension+1][Board.max_dimension+1];
		boardPlayer= Player.initialitzacionBorder(boardPlayer);
		int i = 0;
		Scanner sc = new Scanner(System.in);
		for(i=1;i<max_boats+1;i++)
		{
			//Initialization of the type of the boat			
			System.out.println("Insert your type of boat");
			typeOfBoat = sc.nextInt();
			isValid = isValidType(typeOfBoat);
			
			//Initialitzation of the argument lenght depending from the typeOfBoat
			lenght = setLenght(typeOfBoat);
			
			while(!isValid)
			{
				System.out.println("Error the value is incorrect");
				System.out.println("Please, insert your type of boat again");
				typeOfBoat = sc.nextInt();
				isValid = isValidType(typeOfBoat);
				lenght = setLenght(typeOfBoat);
			}				
			//Initialization of the row of the boat
			System.out.println("Insert the row of the boat");
			row = sc.nextInt();	
			//Error control of the row argument
			isValid = isValidValue(row);
			while(!isValid)
			{
				System.out.println("Error the value is incorrect");
				System.out.println("Please, insert the row of the boat again");
				row = sc.nextInt();
				isValid = isValidValue(row);
			}					
			//Initialization of the col argument
			System.out.println("Insert the col of the boat");
			col = sc.next().charAt(0);	
			column = Board.letterToNumber(col);
			//Error control of the col argument			
			isValid = isValidValue(column);
			while(!isValid)
			{
				System.out.println("Error the value is incorrect");
				System.out.println("Please, insert the row of the boat again");
				col = sc.next().charAt(0);	
				column = Board.letterToNumber(col);
				isValid = isValidValue(column);
			}		
			//Initialitzacion of both the vertical and the horizontal arguments
			System.out.println("Do you want the boat to be placed vertically? Y/N");
			aux = sc.next().charAt(0);
			isValid=isValidVert(aux);
			while(!isValid)
			{
				System.out.println("The character was wrong");
				System.out.println("Do you want the boat to be placed vertically? Y/N");
				aux = sc.next().charAt(0);
				isValid=isValidVert(aux);
			}
			if(aux == 'Y')
			{
				vertical = true;
			}
			else vertical = false;		
			//Function that checks if the position is correct and puts the boats at the matrix
			placed = canPlaceBoats(row,column,typeOfBoat,vertical,boardPlayer);	
			System.out.println("The value of placed is " + placed);
			System.out.println("You have now " + i + " boats placed");		
			
			//Function that prints the board (Used to check)
			Board.printBoard(Board.board,boardPlayer);
			
		}
		return boardPlayer;
	}
	public char[][] placeBoatsRandom()
	{
		//Generation of the boats done by the IA		
		char boardIA[][];
		boardIA = new char [Board.max_dimension+1][Board.max_dimension+1];
		boardIA = Player.initialitzacionBorder(boardIA);
		int aux; 
		int row;
		int columna;
		boolean vert;
		boolean placed= false;
		boolean isValid;
		int type;
		int large;
		for(int i = 1; i<max_boats+1;i++)
		{	
			//Initialization of the arguments of a boat (done by the IA)				
			//Just in case we check the IA creates the right values of row
			row = ThreadLocalRandom.current().nextInt(1,10);
			isValid = isValidValue(row);
			while(!isValid)				
			{
				row = ThreadLocalRandom.current().nextInt(1,10);
				isValid = isValidValue(row);
			}
			//Just in case we check the IA creates the right values of columna
			columna = ThreadLocalRandom.current().nextInt(1,10);
			isValid = isValidValue(columna);
			while(!isValid)				
			{
				columna = ThreadLocalRandom.current().nextInt(1,10);
				isValid = isValidValue(columna);
			}
			//Just in case we check the IA creates the right values of type
			type = ThreadLocalRandom.current().nextInt(1,4);
			isValid = isValidType(type);			
			while(!isValid)				
			{
				type = ThreadLocalRandom.current().nextInt(1,4);
			}		
			//Initialization of the vert argument
			if(i%2 ==0)
			{
				vert = true;
			}
			else vert = false;			
			large = setLenght(type);				
			placed = canPlaceBoats(row,columna,type,vert,boardIA);	
			//Print the board (just to check)			
		}			
		return boardIA;
		
	}
	public static int countBoats(char [][] boats)		
	{	//Function that counts the number of boats at each board to later see if the game's over
		int boat = 0;
		
		for(int i=1;i<Board.max_dimension;i++)
		{
			for(int j =1; j<Board.max_dimension;j++)
			{
				if(boats[i][j] == Board.barquito)
				{
					boat+=1;
				}
			}
		}
		return boat;
	}
	public boolean canPlaceBoats(int row,int columna,int type,boolean vert,char[][] boats)
	{
		//Function that checks if you can position a boat at the point the user or the IA generated.
		
		boolean placed = false;		
		//Positioning of the boats in an alternative board that only contains their position to be checked when shoot
		if(type == 1)
		{
			//Check if the position randomly generated is already occupied
			if(boats[row][columna] != Board.barquito)
			{
				if(vert)
				{	
					
					//Checks if the positions over is free in order to put the second slot of the boat
					if(boats[row-1][columna] != Board.border && boats[row-1][columna] != Board.barquito)
					{
						boats[row][columna] = Board.barquito;
						boats[row-1][columna] = Board.barquito;
						placed = true;
					}
					//Checks if the position under is free in order to put the second slot of the boat
					else if(boats[row+1][columna] != Board.barquito && boats[row+1][columna] != Board.border)
						
					{
						boats[row][columna] = Board.barquito;
						boats[row+1][columna] = Board.barquito;
						placed = true;
					}
					//Checks if the slots above and below are locked and prints an error message
					else if ((boats[row-1][columna] == Board.barquito || (boats[row-1][columna] == Board.border) && (boats[row+1][columna] == Board.barquito || boats[row+1][columna] == Board.border)))
					{
						System.out.println("The col of this boat is incorrect, it collides with another boats");
					}
					
				}else if(!vert)
				{	
					//Checks if the position left and right are locked and sends an error message
					if((boats[row][columna-1] == Board.barquito || boats[row][columna-1] == Board.border) && (boats[row][columna+1] == Board.barquito || boats[row][columna+1] == Board.border))
					{
						System.out.println("The row of this boat is incorrect, it collides with another boats");
					}
					//Checks if the positions at the left of the boat is free to put the second slot of the boat
					else if(boats[row][columna-1] != Board.border && boats[row][columna-1] != Board.barquito)
					{
						boats[row][columna] = Board.barquito;
						boats[row][columna-1] = Board.barquito;
						placed = true;
					}
					//If the position at the left is blocked puts the remaining slot at the right
					else if((boats[row][columna-1] == Board.barquito || boats[row][columna-1] == Board.border) && (boats[row][columna+1] != Board.barquito && boats[row][columna+1] != Board.border))
					{
						boats[row][columna]= Board.barquito;
						boats[row][columna+1]= Board.barquito;
						placed = true;
					}
					//If the position at the right is blocked puts the remaining slot at the right
					else if((boats[row][columna+1] == Board.barquito || boats[row][columna+1] == Board.border) && (boats[row][columna-1] != Board.barquito && boats[row][columna-1] != Board.border))
					{
						boats[row][columna-1]= Board.barquito;
						boats[row][columna]= Board.barquito;
						placed = true;
					}						
				}	
			
			}else System.out.println("This position is already taken by another boat");
				
		}else if(type == 2)
		{
			
			if(boats[row][columna] != Board.barquito)
			{	
				//Checks if the positions over and under are free in order to put the second and third slots of the boat
				if(vert)
				{	
					//If the position under and over are locked, prints a message saying the value that's not correct
					if ((boats[row-1][columna] == Board.barquito || boats[row-1][columna] == Board.border) && (boats[row+1][columna] == Board.barquito || boats[row+1][columna] == Board.border) )
					{
						System.out.println("The col of this boat is incorrect, it collides with another boats");
					}
					//Checks if the positions over and under are free to put 1 slot over and 1 slot under the main one
					if(boats[row-1][columna] != Board.border && boats[row-1][columna] != Board.barquito && boats[row+1][columna] != Board.border && boats[row+1][columna] != Board.barquito)
					{	
						boats[row-1][columna] = Board.barquito;
						boats[row][columna] = Board.barquito;							
						boats[row+1][columna] = Board.barquito;
						placed = true;
					}
					//If the position over is locked, checks if the two positions under are free to place the 2 slots.
					if((boats[row-1][columna] == Board.border || boats[row-1][columna] == Board.barquito) && (boats[row+1][columna] != Board.barquito && boats[row+1][columna] != Board.border)
							&& (boats[row+2][columna] != Board.barquito && boats[row+2][columna] != Board.border))
					{
						boats[row][columna] = Board.barquito;
						boats[row+1][columna] = Board.barquito;
						boats[row+2][columna] = Board.barquito;
						placed = true;
					}
					//If the position under is locked, checks if the two positions over are free to place the 2 slots.
					else if((boats[row+1][columna] == Board.barquito || boats[row+1][columna] == Board.border ) && boats[row-1][columna] != Board.border && boats[row-1][columna] != Board.barquito 
							&& boats[row-2][columna] != Board.border && boats[row-2][columna] != Board.barquito)									
					{
						boats[row-2][columna] = Board.barquito;
						boats[row-1][columna] = Board.barquito;
						boats[row][columna] = Board.barquito;
						placed = true;
					}						
					
					
				}else if(!vert)
				{	
					//If both, the position at the left and the position at the right are locked, send an error message
					if((boats[row][columna-1] == Board.barquito ||  boats[row][columna-1] == Board.border) && boats[row][columna+1] == Board.barquito)
					{
						System.out.println("The value of the row is incorrect, the boat will collide with other boats");
					}		
					//Checks if one position at left and one at the right of the main slot are free and puts a slot at each position
					else if(boats[row][columna-1] != Board.border && boats[row][columna-1] != Board.barquito && boats[row][columna+1] != Board.border	&& boats[row][columna+1] != Board.barquito)
					{	
							boats[row][columna-1] = Board.barquito;
							boats[row][columna] = Board.barquito;
							boats[row][columna+1] = Board.barquito;	
							placed = true;
					}
					//Checks if the two positions at the left of the main one are free and puts a slot of the boat at each one
					else if((boats[row][columna-1] != Board.barquito && boats[row][columna-1] != Board.border) && (boats[row][columna+1]== Board.barquito) 
							&& (boats[row][columna-2] != Board.barquito && boats[row][col-2] != Board.border))
					{
						boats[row][columna-2] = Board.barquito;
						boats[row][columna-1] = Board.barquito;
						boats[row][columna] = Board.barquito;
						placed = true;
					}
					//If the position at the left is locked checks if the two position at the right of the main one are free to put a slot at each one
					else if((boats[row][columna-1] == Board.barquito || boats[row][columna-1] == Board.border) && (boats[row][columna+1] != Board.barquito && boats[row][columna+1] != Board.border) && (boats[row][columna+2] != Board.barquito 
							&& boats[row][columna+2] != Board.border ))
					{
						boats[row][columna] = Board.barquito;
						boats[row][columna+1] = Board.barquito;
						boats[row][columna+2] = Board.barquito;	
						placed = true;
					}
					//If the position at the right is locked, checks if the two positions at the left ae free to put one slot at each one
					else if((boats[row][columna+1] == Board.barquito || boats[row][columna+1] == Board.border) && (boats[row][columna-1] != Board.barquito && boats[row][columna-1] != Board.border) && (boats[row][columna-2] != Board.barquito 
							&& boats[row][columna-2] != Board.border ))
					{
						boats[row][columna-2] = Board.barquito;
						boats[row][columna-1] = Board.barquito;
						boats[row][columna] = Board.barquito;
						placed = true;
					}	
					
				}
				
			
			}else System.out.println("This position is already taken by another boat");
				
		}
		else if(type == 3)
		{
			if(boats[row][columna] != Board.barquito)
			{	
				
				//Checks if the two positions over and  one under are free in order to put the second,third and fourth slots of the boat
				if(vert)
				{	
					//If the position under and over are locked, prints a message saying the value that's not correct
					if ((boats[row-1][columna] == Board.barquito || boats[row-1][columna] == Board.border) && boats[row+1][columna] == Board.barquito )
					{
						System.out.println("The col of this boat is incorrect, it collides with another boats");
					}
					//Checks if the positions over and under are free to put 1 slot over and 1 slot under the main one
					else if((boats[row-1][columna] != Board.border && boats[row-1][columna] != Board.barquito) && (boats[row+1][columna] != Board.border && boats[row+1][columna] != Board.barquito) && 
							(boats[row-2][columna] != Board.border && boats[row-2][columna] != Board.barquito))
					{	
						boats[row-2][columna] = Board.barquito;
						boats[row-1][columna] = Board.barquito;
						boats[row][columna] = Board.barquito;							
						boats[row+1][columna] = Board.barquito;
						placed = true;
					}
					//If the position over is locked, checks if the three positions under are free to place the 3 slots.
					if((boats[row-1][columna] == Board.border || boats[row-1][columna] == Board.barquito)&&(boats[row+1][columna] != Board.barquito &&
							(boats[row+2][columna] != Board.barquito && boats[row+2][columna] != Board.border ) && (boats[row+3][columna] != Board.barquito && boats[row+3][columna] != Board.border)))					
					{						
							boats[row][columna] = Board.barquito;
							boats[row+1][columna] = Board.barquito;
							boats[row+2][columna] = Board.barquito;
							boats[row+3][columna] = Board.barquito;	
							placed = true;
					}
					//If the position under is locked, checks if the three positions over are free to place the 3 slots.
					else if((boats[row+1][columna] == Board.barquito || boats[row+1][columna] == Board.border) && (boats[row-1][columna] != Board.border && boats[row-1][columna] != Board.barquito)
							&& (boats[row-2][columna] != Board.border && boats[row-2][columna] != Board.barquito)&&(boats[row-3][columna] != Board.border && boats[row-3][columna] != Board.barquito))								
					{	
						boats[row-3][columna] = Board.barquito;
						boats[row-2][columna] = Board.barquito;
						boats[row-1][columna] = Board.barquito;
						boats[row][columna] = Board.barquito;
						placed = true;
					}			
					//Checks if two positions under and one over are free to put the 3 slots left
					else if((boats[row-1][columna] != Board.border && boats[row-1][columna] != Board.barquito) && (boats[row+1][columna] != Board.border && boats[row+1][columna] != Board.barquito) && 
							(boats[row+2][columna] != Board.border && boats[row+2][columna] != Board.barquito))
					{
						boats[row-1][columna] = Board.barquito;
						boats[row][columna] = Board.barquito;
						boats[row+1][columna] = Board.barquito;
						boats[row+2][columna] = Board.barquito;
						placed = true;
					}
					
				}else if(!vert)
				{	
					//If both, the position at the left and the position at the right are locked, send an error message
					if((boats[row][columna-1] == Board.barquito ||  boats[row][columna-1] == Board.border) && boats[row][columna+1] == Board.barquito)
					{
						System.out.println("The value of the row is incorrect, the boat will collide with other boats");
					}
					//Checks if two position at left and one at the right of the main slot are free and puts a slot at each position
					else if((boats[row][columna-1] != Board.border && boats[row][columna-1] != Board.barquito) 
							&& (boats[row][columna-2] != Board.border && boats[row][columna-2] != Board.barquito)&& boats[row][columna+1] != Board.border && boats[row][columna+1] != Board.barquito)
					{									
							boats[row][columna-2] = Board.barquito;
							boats[row][columna-1] = Board.barquito;
							boats[row][columna] = Board.barquito;
							boats[row][columna+1] = Board.barquito;	
							placed = true;
					}
					// if the right position is locked, checks if the three positions at the left of the main one are free and puts a slot of the boat at each one
					else if((boats[row][columna-1] != Board.barquito && boats[row][columna-1] != Board.border)&& ((boats[row][columna+1]== Board.barquito || boats[row][columna+1]== Board.border) 
							&& (boats[row][columna-2] != Board.barquito && boats[row][columna-2] != Board.border) && (boats[row][columna-3] != Board.barquito && boats[row][columna-3] != Board.border)))
					{							
							boats[row][columna-3] = Board.barquito;
							boats[row][columna-2] = Board.barquito;
							boats[row][columna-1] = Board.barquito;
							boats[row][columna] = Board.barquito;
							placed = true;
						
					}
					//If the position at the left is locked checks if the three position at the right of the main one are free to put a slot at each one
					else if((boats[row][columna-1] == Board.barquito || boats[row][columna-1] == Board.border)&& (boats[row][columna+1] != Board.barquito && boats[row][columna+1] != Board.border )
							&& (boats[row][columna+2] != Board.barquito && boats[row][columna+2] != Board.border) && (boats[row][columna+3] != Board.barquito && boats[row][columna+3] != Board.border))
					{							
							boats[row][columna] = Board.barquito;
							boats[row][columna+1] = Board.barquito;
							boats[row][columna+2] = Board.barquito;
							boats[row][columna+3] = Board.barquito;
							placed = true;
						
					}
					else if((boats[row][columna-1] != Board.barquito && boats[row][columna-1] != Board.border ) && (boats[row][columna-2] == Board.barquito || boats[row][columna-2] == Board.border) 
							&& (boats[row][columna+1] != Board.barquito && boats[row][columna+1] != Board.border ) && (boats[row][columna+2] != Board.barquito && boats[row][columna+2] != Board.border))
					{
						boats[row][columna-1] = Board.barquito;
						boats[row][columna] = Board.barquito;
						boats[row][columna+1] = Board.barquito;
						boats[row][columna+2] = Board.barquito;
						placed = true;
					}												
				}
				
			
			}else System.out.println("This position is already taken by another boat");				
		}		
		return placed;
	}

	public static void showMatrix(char[][] boats)
	{
	
		for(int i =0;i<Board.max_dimension+1;i++)
		{
			for(int j =0; j<Board.max_dimension+1;j++)
			{
				System.out.print(boats[i][j] + "\t");
			}
			System.out.println("\n");
		}	
		System.out.println("----------------------------------------------------------------------");
	}
	
}
