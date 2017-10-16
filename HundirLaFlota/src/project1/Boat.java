package project1;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.List;
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
	
	
	public char[][] createBoats() 
	{	
		List<Boat> boats = new ArrayList<Boat>();
		char aux;
		char boardPlayer[][];
		boardPlayer = new char [Board.max_dimension+1][Board.max_dimension+1];
		boardPlayer= Player.initialitzacionBorder(boardPlayer);
		int i = 0;
		for(i=0;i<max_boats;i++)
		{
			//Initialization of the type of the boat
			Scanner sc = new Scanner(System.in);
			System.out.println("Insert your type of boat");
			typeOfBoat = sc.nextInt();
			
			while(typeOfBoat < 1 || typeOfBoat >3)
			{
				System.out.println("Error the value is incorrect");
				System.out.println("Insert your type of boat");
				typeOfBoat = sc.nextInt();
				
			}
			//Initialitzation of the argument lenght depending from the typeOfBoat
			switch (typeOfBoat)
			{
				case 1: lenght = 2;
						break;
				case 2: lenght = 3;
						break;
				case 3: lenght = 4;
						break;
			}
			//Initialization of the row of the boat
			System.out.println("Insert the row of the boat");
			row = sc.nextInt();	
			//Error control of the row argument
			while(row > Board.max_dimension || row <=0)
			{
				System.out.println("Error the value is incorrect");
				System.out.println("Insert the row of the boat");
				row = sc.nextInt();
			}			
			//Initialization of the col argument
			System.out.println("Insert the col of the boat");
			col = sc.next().charAt(0);	
			column = Board.letterToNumber(col);
			//Error control of the col argument
			while(column > Board.max_dimension || column <=0)
			{
				System.out.println("Error the value is incorrect");
				System.out.println("Insert the row of the boat");
				col = sc.next().charAt(0);	
				column = Board.letterToNumber(col);
			}		
			
			//Initialitzacion of both the vertical and the horizontal arguments
			System.out.println("Do you want the boat to be placed vertically? Y/N");
			aux = sc.next().charAt(0);
			if(aux == 'Y')
			{
				vertical = true;
			}
			else vertical = false;		
			
			//Positioning of the boats in an alternative board that only contains their position to be checked when shoot
			if(typeOfBoat == 1)
			{
				//Check if the position randomly generated is already occupied
				if(boardPlayer[row][column] != Board.barquito)
				{
					if(vertical)
					{	
						//Checks if the slots above and below are locked and prints an error message
						if ((boardPlayer[row-1][column] == Board.barquito || (boardPlayer[row-1][column] == Board.border) && (boardPlayer[row+1][column] == Board.barquito || boardPlayer[row+1][column] == Board.border)))
						{
							System.out.println("The col of this boat is incorrect, it collides with another boats");
						}
						//Checks if the positions over is free in order to put the second slot of the boat
						else if(boardPlayer[row-1][column] != Board.border && boardPlayer[row-1][column] != Board.barquito)
						{
							boardPlayer[row][column] = Board.barquito;
							boardPlayer[row-1][column] = Board.barquito;
						}
						//Checks if the position under is free in order to put the second slot of the boat
						else if(boardPlayer[row+1][column] != Board.barquito && boardPlayer[row+1][column] != Board.border)
							
						{
							boardPlayer[row][column] = Board.barquito;
							boardPlayer[row+1][column] = Board.barquito;
						}
						
					}else if(!vertical)
					{	
						//Checks if the position left and right are locked and sends an error message
						if((boardPlayer[row][column-1] == Board.barquito || boardPlayer[row][column-1] == Board.border) && (boardPlayer[row][column+1] == Board.barquito || boardPlayer[row][column+1] == Board.border))
						{
							System.out.println("The row of this boat is incorrect, it collides with another boats");
						}
						//Checks if the positions at the left of the boat is free to put the second slot of the boat
						else if(boardPlayer[row][column-1] != Board.border && boardPlayer[row][column-1] != Board.barquito)
						{
							boardPlayer[row][column] = Board.barquito;
							boardPlayer[row][column-1] = Board.barquito;
						}
						//If the position at the left is blocked puts the remaining slot at the right
						else if((boardPlayer[row][column-1] == Board.barquito || boardPlayer[row][column-1] == Board.border) && (boardPlayer[row][column+1] != Board.barquito && boardPlayer[row][column+1] != Board.border))
						{
							boardPlayer[row][column]= Board.barquito;
							boardPlayer[row][column+1]= Board.barquito;
							System.out.println("The row of this boat is incorrect, it collides with another boats");
						}
						//If the position at the right is blocked puts the remaining slot at the right
						else if((boardPlayer[row][column+1] == Board.barquito || boardPlayer[row][column+1] == Board.border) && (boardPlayer[row][column-1] != Board.barquito && boardPlayer[row][column-1] != Board.border))
						{
							boardPlayer[row][column-1]= Board.barquito;
							boardPlayer[row][column]= Board.barquito;
							System.out.println("The row of this boat is incorrect, it collides with another boats");
						}						
					}	
				
				}else System.out.println("This position is already taken by another boat");
					
			}else if(typeOfBoat == 2)
			{
				
				if(boardPlayer[row][column] != Board.barquito)
				{	
					//Checks if the positions over and under are free in order to put the second and third slots of the boat
					if(vertical)
					{	
						//If the position under and over are locked, prints a message saying the value that's not correct
						if ((boardPlayer[row-1][column] == Board.barquito || boardPlayer[row-1][column] == Board.border) && (boardPlayer[row+1][column] == Board.barquito || boardPlayer[row+1][column] == Board.border) )
						{
							System.out.println("The col of this boat is incorrect, it collides with another boats");
						}
						//Checks if the positions over and under are free to put 1 slot over and 1 slot under the main one
						if(boardPlayer[row-1][column] != Board.border && boardPlayer[row-1][column] != Board.barquito && boardPlayer[row+1][column] != Board.border && boardPlayer[row+1][column] != Board.barquito)
						{	
							boardPlayer[row-1][column] = Board.barquito;
							boardPlayer[row][column] = Board.barquito;							
							boardPlayer[row+1][column] = Board.barquito;
						}
						//If the position over is locked, checks if the two positions under are free to place the 2 slots.
						if((boardPlayer[row-1][column] == Board.border || boardPlayer[row-1][column] == Board.barquito) && (boardPlayer[row+1][column] != Board.barquito && boardPlayer[row+1][column] != Board.border)
								&& (boardPlayer[row+2][column] != Board.barquito && boardPlayer[row+2][column] != Board.border))
						{
							boardPlayer[row][column] = Board.barquito;
							boardPlayer[row+1][column] = Board.barquito;
							boardPlayer[row+2][column] = Board.barquito;
						}
						//If the position under is locked, checks if the two positions over are free to place the 2 slots.
						else if((boardPlayer[row+1][column] == Board.barquito || boardPlayer[row+1][column] == Board.border ) && boardPlayer[row-1][column] != Board.border && boardPlayer[row-1][column] != Board.barquito 
								&& boardPlayer[row-2][column] != Board.border && boardPlayer[row-2][column] != Board.barquito)									
						{
							boardPlayer[row-2][column] = Board.barquito;
							boardPlayer[row-1][column] = Board.barquito;
							boardPlayer[row][column] = Board.barquito;
						}						
						
						
					}else if(!vertical)
					{	
						//If both, the position at the left and the position at the right are locked, send an error message
						if((boardPlayer[row][column-1] == Board.barquito ||  boardPlayer[row][column-1] == Board.border) && boardPlayer[row][column+1] == Board.barquito)
						{
							System.out.println("The value of the row is incorrect, the boat will collide with other boats");
						}		
						//Checks if one position at left and one at the right of the main slot are free and puts a slot at each position
						else if(boardPlayer[row][column-1] != Board.border && boardPlayer[row][column-1] != Board.barquito && boardPlayer[row][column+1] != Board.border	&& boardPlayer[row][column+1] != Board.barquito)
						{	
								boardPlayer[row][column-1] = Board.barquito;
								boardPlayer[row][column] = Board.barquito;
								boardPlayer[row][column+1] = Board.barquito;							
						}
						//Checks if the two positions at the left of the main one are free and puts a slot of the boat at each one
						else if((boardPlayer[row][column-1] != Board.barquito && boardPlayer[row][column-1] != Board.border) && (boardPlayer[row][column+1]== Board.barquito) 
								&& (boardPlayer[row][column-2] != Board.barquito && boardPlayer[row][col-2] != Board.border))
						{
							boardPlayer[row][column-2] = Board.barquito;
							boardPlayer[row][column-1] = Board.barquito;
							boardPlayer[row][column] = Board.barquito;
						}
						//If the position at the left is locked checks if the two position at the right of the main one are free to put a slot at each one
						else if((boardPlayer[row][column-1] == Board.barquito || boardPlayer[row][column-1] == Board.border) && (boardPlayer[row][column+1] != Board.barquito && boardPlayer[row][column+1] != Board.border) && (boardPlayer[row][column+2] != Board.barquito 
								&& boardPlayer[row][column+2] != Board.border ))
						{
							boardPlayer[row][column] = Board.barquito;
							boardPlayer[row][column+1] = Board.barquito;
							boardPlayer[row][column+2] = Board.barquito;							
						}
						//If the position at the right is locked, checks if the two positions at the left ae free to put one slot at each one
						else if((boardPlayer[row][column+1] == Board.barquito || boardPlayer[row][column+1] == Board.border) && (boardPlayer[row][column-1] != Board.barquito && boardPlayer[row][column-1] != Board.border) && (boardPlayer[row][column-2] != Board.barquito 
								&& boardPlayer[row][column-2] != Board.border ))
						{
							boardPlayer[row][column-2] = Board.barquito;
							boardPlayer[row][column-1] = Board.barquito;
							boardPlayer[row][column] = Board.barquito;							
						}	
						
					}
					
				
				}else System.out.println("This position is already taken by another boat");
					
			}
			else if(typeOfBoat == 3)
			{
				if(boardPlayer[row][column] != Board.barquito)
				{	
					
					//Checks if the two positions over and  one under are free in order to put the second,third and fourth slots of the boat
					if(vertical)
					{	
						//If the position under and over are locked, prints a message saying the value that's not correct
						if ((boardPlayer[row-1][column] == Board.barquito || boardPlayer[row-1][column] == Board.border) && boardPlayer[row+1][column] == Board.barquito )
						{
							System.out.println("The col of this boat is incorrect, it collides with another boats");
						}
						//Checks if the positions over and under are free to put 1 slot over and 1 slot under the main one
						else if((boardPlayer[row-1][column] != Board.border && boardPlayer[row-1][column] != Board.barquito) && (boardPlayer[row+1][column] != Board.border && boardPlayer[row+1][column] != Board.barquito) && 
								(boardPlayer[row-2][column] != Board.border && boardPlayer[row-2][column] != Board.barquito))
						{	
							boardPlayer[row-2][column] = Board.barquito;
							boardPlayer[row-1][column] = Board.barquito;
							boardPlayer[row][column] = Board.barquito;							
							boardPlayer[row+1][column] = Board.barquito;
						}
						//If the position over is locked, checks if the three positions under are free to place the 3 slots.
						if((boardPlayer[row-1][column] == Board.border || boardPlayer[row-1][column] == Board.barquito)&&(boardPlayer[row+1][column] != Board.barquito &&
								boardPlayer[row+2][column] != Board.barquito && boardPlayer[row+3][column] != Board.barquito))					
						{						
								boardPlayer[row][column] = Board.barquito;
								boardPlayer[row+1][column] = Board.barquito;
								boardPlayer[row+2][column] = Board.barquito;
								boardPlayer[row+3][column] = Board.barquito;							
						}
						//If the position under is locked, checks if the three positions over are free to place the 3 slots.
						else if((boardPlayer[row+1][column] == Board.barquito) && (boardPlayer[row-1][column] != Board.border && boardPlayer[row-1][column] != Board.barquito)
								&& (boardPlayer[row-2][column] != Board.border && boardPlayer[row-2][column] != Board.barquito)&&(boardPlayer[row-3][column] != Board.border && boardPlayer[row-3][column] != Board.barquito))								
						{	
							boardPlayer[row-3][column] = Board.barquito;
							boardPlayer[row-2][column] = Board.barquito;
							boardPlayer[row-1][column] = Board.barquito;
							boardPlayer[row][column] = Board.barquito;
						}			
						//Checks if two positions under and one over are free to put the 3 slots left
						else if((boardPlayer[row-1][column] != Board.border && boardPlayer[row-1][column] != Board.barquito) && (boardPlayer[row+1][column] != Board.border && boardPlayer[row+1][column] != Board.barquito) && 
								(boardPlayer[row+2][column] != Board.border && boardPlayer[row+2][column] != Board.barquito))
						{
							boardPlayer[row-1][column] = Board.barquito;
							boardPlayer[row][column] = Board.barquito;
							boardPlayer[row+1][column] = Board.barquito;
							boardPlayer[row+2][column] = Board.barquito;
						}
						
					}else if(!vertical)
					{	
						//If both, the position at the left and the position at the right are locked, send an error message
						if((boardPlayer[row][column-1] == Board.barquito ||  boardPlayer[row][column-1] == Board.border) && boardPlayer[row][column+1] == Board.barquito)
						{
							System.out.println("The value of the row is incorrect, the boat will collide with other boats");
						}
						//Checks if two position at left and one at the right of the main slot are free and puts a slot at each position
						else if((boardPlayer[row][column-1] != Board.border && boardPlayer[row][column-1] != Board.barquito) 
								&& (boardPlayer[row][column-2] != Board.border && boardPlayer[row][column-2] != Board.barquito)&& boardPlayer[row][column+1] != Board.border && boardPlayer[row][column+1] != Board.barquito)
						{									
								boardPlayer[row][column-2] = Board.barquito;
								boardPlayer[row][column-1] = Board.barquito;
								boardPlayer[row][column] = Board.barquito;
								boardPlayer[row][column+1] = Board.barquito;							
						}
						// if the right position is locked, checks if the three positions at the left of the main one are free and puts a slot of the boat at each one
						else if((boardPlayer[row][column-1] != Board.barquito && boardPlayer[row][column-1] != Board.border)&& ((boardPlayer[row][column+1]== Board.barquito) 
								&& (boardPlayer[row][column-2] != Board.barquito && boardPlayer[row][column-2] != Board.border) && (boardPlayer[row][column-3] != Board.barquito && boardPlayer[row][column-3] != Board.border)))
						{							
								boardPlayer[row][column-3] = Board.barquito;
								boardPlayer[row][column-2] = Board.barquito;
								boardPlayer[row][column-1] = Board.barquito;
								boardPlayer[row][column] = Board.barquito;
							
						}
						//If the position at the left is locked checks if the three position at the right of the main one are free to put a slot at each one
						else if((boardPlayer[row][column-1] == Board.barquito || boardPlayer[row][column-1] == Board.border)&& (boardPlayer[row][column+1] != Board.barquito && boardPlayer[row][column+1] != Board.border )
								&& (boardPlayer[row][column+2] != Board.barquito && boardPlayer[row][column+2] != Board.border) && (boardPlayer[row][column+3] != Board.barquito && boardPlayer[row][column+3] != Board.border))
						{							
								boardPlayer[row][column] = Board.barquito;
								boardPlayer[row][column+1] = Board.barquito;
								boardPlayer[row][column+2] = Board.barquito;
								boardPlayer[row][column+3] = Board.barquito;
							
						}
						else if((boardPlayer[row][column-1] != Board.barquito || boardPlayer[row][column-1] != Board.border ) && (boardPlayer[row][column-2] == Board.barquito || boardPlayer[row][column-2] == Board.border) 
								&& boardPlayer[row][column+1] != Board.barquito && boardPlayer[row][column+2] != Board.barquito)
						{
							boardPlayer[row][column-1] = Board.barquito;
							boardPlayer[row][column] = Board.barquito;
							boardPlayer[row][column+1] = Board.barquito;
							boardPlayer[row][column+2] = Board.barquito;
						}												
						}	
					}
			}
			//Boat b = new Boat(row,column,typeOfBoat,vertical,lenght);			
			//boats.add(b);
			//Clear the argument in order to avoid problems			
			System.out.println("You have now " + i + " boats placed");
			for(int ti=0; ti<Board.max_dimension+1;ti++)
			{
				for(int j=0; j<Board.max_dimension+1;j++)
				{
					System.out.print(boardPlayer[ti][j]+ "\t");
				}
				System.out.println("\n");
			}
			
		}
		return boardPlayer;
	}
	public char[][] placeBoatsRandom()
	{
		//Generation of the boats done by the IA
		List<Boat> boatsIA = new ArrayList<Boat>();
		char boardIA[][];
		boardIA = new char [Board.max_dimension+1][Board.max_dimension+1];
		boardIA = Player.initialitzacionBorder(boardIA);
		int aux = 0; 
		int row;
		int columna;
		boolean vert;
		int type;
		int large = 0;
		for(int i = 0; i<max_boats;i++)
		{	
			//Initialitzation of the arguments of a boat (done by the IA)
			row = ThreadLocalRandom.current().nextInt(1,10);
			columna = ThreadLocalRandom.current().nextInt(1,10);
			type = ThreadLocalRandom.current().nextInt(1,4);
			System.out.println("Hi my row is " + row);
			System.out.println("Hi my col is " + columna);
			System.out.println("Hi my type is " + type);
			
			if(i%2 ==0)
			{
				vert = true;
			}
			else vert = false;
			System.out.println("Hi my vert is " + vert);
			switch (type)
			{
				case 1: large = 2;
						break;
				case 2: large = 3;
						break;
				case 3: large = 4;
						break;				
			}
			//Positioning of the boats in an alternative board that only contains their position to be checked when shoot
			if(type == 1)
			{
				//Check if the position randomly generated is already occupied
				if(boardIA[row][columna] != Board.barquito)
				{
					if(vert)
					{	
						//Checks if the slots above and below are locked and prints an error message
						if ((boardIA[row-1][columna] == Board.barquito || (boardIA[row-1][columna] == Board.border) && (boardIA[row+1][columna] == Board.barquito || boardIA[row+1][columna] == Board.border)))
						{
							System.out.println("The col of this boat is incorrect, it collides with another boats");
						}
						//Checks if the positions over is free in order to put the second slot of the boat
						else if(boardIA[row-1][columna] != Board.border && boardIA[row-1][columna] != Board.barquito)
						{
							boardIA[row][columna] = Board.barquito;
							boardIA[row-1][columna] = Board.barquito;
						}
						//Checks if the position under is free in order to put the second slot of the boat
						else if(boardIA[row+1][columna] != Board.barquito && boardIA[row+1][columna] != Board.border)
							
						{
							boardIA[row][columna] = Board.barquito;
							boardIA[row+1][columna] = Board.barquito;
						}
						
					}else if(!vert)
					{	
						//Checks if the position left and right are locked and sends an error message
						if((boardIA[row][columna-1] == Board.barquito || boardIA[row][columna-1] == Board.border) && (boardIA[row][columna+1] == Board.barquito || boardIA[row][columna+1] == Board.border))
						{
							System.out.println("The row of this boat is incorrect, it collides with another boats");
						}
						//Checks if the positions at the left of the boat is free to put the second slot of the boat
						else if(boardIA[row][columna-1] != Board.border && boardIA[row][columna-1] != Board.barquito)
						{
							boardIA[row][columna] = Board.barquito;
							boardIA[row][columna-1] = Board.barquito;
						}
						//If the position at the left is blocked puts the remaining slot at the right
						else if((boardIA[row][columna-1] == Board.barquito || boardIA[row][columna-1] == Board.border) && (boardIA[row][columna+1] != Board.barquito && boardIA[row][columna+1] != Board.border))
						{
							boardIA[row][columna]= Board.barquito;
							boardIA[row][columna+1]= Board.barquito;
							System.out.println("The row of this boat is incorrect, it collides with another boats");
						}
						//If the position at the right is blocked puts the remaining slot at the right
						else if((boardIA[row][columna+1] == Board.barquito || boardIA[row][columna+1] == Board.border) && (boardIA[row][columna-1] != Board.barquito && boardIA[row][columna-1] != Board.border))
						{
							boardIA[row][columna-1]= Board.barquito;
							boardIA[row][columna]= Board.barquito;
							System.out.println("The row of this boat is incorrect, it collides with another boats");
						}						
					}	
				
				}else System.out.println("This position is already taken by another boat");
					
			}else if(type == 2)
			{
				
				if(boardIA[row][columna] != Board.barquito)
				{	
					//Checks if the positions over and under are free in order to put the second and third slots of the boat
					if(vert)
					{	
						//If the position under and over are locked, prints a message saying the value that's not correct
						if ((boardIA[row-1][columna] == Board.barquito || boardIA[row-1][columna] == Board.border) && (boardIA[row+1][columna] == Board.barquito || boardIA[row+1][columna] == Board.border) )
						{
							System.out.println("The col of this boat is incorrect, it collides with another boats");
						}
						//Checks if the positions over and under are free to put 1 slot over and 1 slot under the main one
						if(boardIA[row-1][columna] != Board.border && boardIA[row-1][columna] != Board.barquito && boardIA[row+1][columna] != Board.border && boardIA[row+1][columna] != Board.barquito)
						{	
							boardIA[row-1][columna] = Board.barquito;
							boardIA[row][columna] = Board.barquito;							
							boardIA[row+1][columna] = Board.barquito;
						}
						//If the position over is locked, checks if the two positions under are free to place the 2 slots.
						if((boardIA[row-1][columna] == Board.border || boardIA[row-1][columna] == Board.barquito) && (boardIA[row+1][columna] != Board.barquito && boardIA[row+1][columna] != Board.border)
								&& (boardIA[row+2][columna] != Board.barquito && boardIA[row+2][columna] != Board.border))
						{
							boardIA[row][columna] = Board.barquito;
							boardIA[row+1][columna] = Board.barquito;
							boardIA[row+2][columna] = Board.barquito;
						}
						//If the position under is locked, checks if the two positions over are free to place the 2 slots.
						else if((boardIA[row+1][columna] == Board.barquito || boardIA[row+1][columna] == Board.border ) && boardIA[row-1][columna] != Board.border && boardIA[row-1][columna] != Board.barquito 
								&& boardIA[row-2][columna] != Board.border && boardIA[row-2][columna] != Board.barquito)									
						{
							boardIA[row-2][columna] = Board.barquito;
							boardIA[row-1][columna] = Board.barquito;
							boardIA[row][columna] = Board.barquito;
						}						
						
						
					}else if(!vert)
					{	
						//If both, the position at the left and the position at the right are locked, send an error message
						if((boardIA[row][columna-1] == Board.barquito ||  boardIA[row][columna-1] == Board.border) && boardIA[row][columna+1] == Board.barquito)
						{
							System.out.println("The value of the row is incorrect, the boat will collide with other boats");
						}		
						//Checks if one position at left and one at the right of the main slot are free and puts a slot at each position
						else if(boardIA[row][columna-1] != Board.border && boardIA[row][columna-1] != Board.barquito && boardIA[row][columna+1] != Board.border	&& boardIA[row][columna+1] != Board.barquito)
						{	
								boardIA[row][columna-1] = Board.barquito;
								boardIA[row][columna] = Board.barquito;
								boardIA[row][columna+1] = Board.barquito;							
						}
						//Checks if the two positions at the left of the main one are free and puts a slot of the boat at each one
						else if((boardIA[row][columna-1] != Board.barquito && boardIA[row][columna-1] != Board.border) && (boardIA[row][columna+1]== Board.barquito) 
								&& (boardIA[row][columna-2] != Board.barquito && boardIA[row][col-2] != Board.border))
						{
							boardIA[row][columna-2] = Board.barquito;
							boardIA[row][columna-1] = Board.barquito;
							boardIA[row][columna] = Board.barquito;
						}
						//If the position at the left is locked checks if the two position at the right of the main one are free to put a slot at each one
						else if((boardIA[row][columna-1] == Board.barquito || boardIA[row][columna-1] == Board.border) && (boardIA[row][columna+1] != Board.barquito && boardIA[row][columna+1] != Board.border) && (boardIA[row][columna+2] != Board.barquito 
								&& boardIA[row][columna+2] != Board.border ))
						{
							boardIA[row][columna] = Board.barquito;
							boardIA[row][columna+1] = Board.barquito;
							boardIA[row][columna+2] = Board.barquito;							
						}
						//If the position at the right is locked, checks if the two positions at the left ae free to put one slot at each one
						else if((boardIA[row][columna+1] == Board.barquito || boardIA[row][columna+1] == Board.border) && (boardIA[row][columna-1] != Board.barquito && boardIA[row][columna-1] != Board.border) && (boardIA[row][columna-2] != Board.barquito 
								&& boardIA[row][columna-2] != Board.border ))
						{
							boardIA[row][columna-2] = Board.barquito;
							boardIA[row][columna-1] = Board.barquito;
							boardIA[row][columna] = Board.barquito;							
						}	
						
					}
					
				
				}else System.out.println("This position is already taken by another boat");
					
			}
			else if(type == 3)
			{
				if(boardIA[row][columna] != Board.barquito)
				{	
					
					//Checks if the two positions over and  one under are free in order to put the second,third and fourth slots of the boat
					if(vert)
					{	
						//If the position under and over are locked, prints a message saying the value that's not correct
						if ((boardIA[row-1][columna] == Board.barquito || boardIA[row-1][columna] == Board.border) && boardIA[row+1][columna] == Board.barquito )
						{
							System.out.println("The col of this boat is incorrect, it collides with another boats");
						}
						//Checks if the positions over and under are free to put 1 slot over and 1 slot under the main one
						else if((boardIA[row-1][columna] != Board.border && boardIA[row-1][columna] != Board.barquito) && (boardIA[row+1][columna] != Board.border && boardIA[row+1][columna] != Board.barquito) && 
								(boardIA[row-2][columna] != Board.border && boardIA[row-2][columna] != Board.barquito))
						{	
							boardIA[row-2][columna] = Board.barquito;
							boardIA[row-1][columna] = Board.barquito;
							boardIA[row][columna] = Board.barquito;							
							boardIA[row+1][columna] = Board.barquito;
						}
						//If the position over is locked, checks if the three positions under are free to place the 3 slots.
						if((boardIA[row-1][columna] == Board.border || boardIA[row-1][columna] == Board.barquito)&&(boardIA[row+1][columna] != Board.barquito &&
								boardIA[row+2][columna] != Board.barquito && boardIA[row+3][columna] != Board.barquito))					
						{						
								boardIA[row][columna] = Board.barquito;
								boardIA[row+1][columna] = Board.barquito;
								boardIA[row+2][columna] = Board.barquito;
								boardIA[row+3][columna] = Board.barquito;							
						}
						//If the position under is locked, checks if the three positions over are free to place the 3 slots.
						else if((boardIA[row+1][columna] == Board.barquito) && (boardIA[row-1][columna] != Board.border && boardIA[row-1][columna] != Board.barquito)
								&& (boardIA[row-2][columna] != Board.border && boardIA[row-2][columna] != Board.barquito)&&(boardIA[row-3][columna] != Board.border && boardIA[row-3][columna] != Board.barquito))								
						{	
							boardIA[row-3][columna] = Board.barquito;
							boardIA[row-2][columna] = Board.barquito;
							boardIA[row-1][columna] = Board.barquito;
							boardIA[row][columna] = Board.barquito;
						}			
						//Checks if two positions under and one over are free to put the 3 slots left
						else if((boardIA[row-1][columna] != Board.border && boardIA[row-1][columna] != Board.barquito) && (boardIA[row+1][columna] != Board.border && boardIA[row+1][columna] != Board.barquito) && 
								(boardIA[row+2][columna] != Board.border && boardIA[row+2][columna] != Board.barquito))
						{
							boardIA[row-1][columna] = Board.barquito;
							boardIA[row][columna] = Board.barquito;
							boardIA[row+1][columna] = Board.barquito;
							boardIA[row+2][columna] = Board.barquito;
						}
						
					}else if(!vert)
					{	
						//If both, the position at the left and the position at the right are locked, send an error message
						if((boardIA[row][columna-1] == Board.barquito ||  boardIA[row][columna-1] == Board.border) && boardIA[row][columna+1] == Board.barquito)
						{
							System.out.println("The value of the row is incorrect, the boat will collide with other boats");
						}
						//Checks if two position at left and one at the right of the main slot are free and puts a slot at each position
						else if((boardIA[row][columna-1] != Board.border && boardIA[row][columna-1] != Board.barquito) 
								&& (boardIA[row][columna-2] != Board.border && boardIA[row][columna-2] != Board.barquito)&& boardIA[row][columna+1] != Board.border && boardIA[row][columna+1] != Board.barquito)
						{									
								boardIA[row][columna-2] = Board.barquito;
								boardIA[row][columna-1] = Board.barquito;
								boardIA[row][columna] = Board.barquito;
								boardIA[row][columna+1] = Board.barquito;							
						}
						// if the right position is locked, checks if the three positions at the left of the main one are free and puts a slot of the boat at each one
						else if((boardIA[row][columna-1] != Board.barquito && boardIA[row][columna-1] != Board.border)&& ((boardIA[row][columna+1]== Board.barquito) 
								&& (boardIA[row][columna-2] != Board.barquito && boardIA[row][columna-2] != Board.border) && (boardIA[row][columna-3] != Board.barquito && boardIA[row][columna-3] != Board.border)))
						{							
								boardIA[row][columna-3] = Board.barquito;
								boardIA[row][columna-2] = Board.barquito;
								boardIA[row][columna-1] = Board.barquito;
								boardIA[row][columna] = Board.barquito;
							
						}
						//If the position at the left is locked checks if the three position at the right of the main one are free to put a slot at each one
						else if((boardIA[row][columna-1] == Board.barquito || boardIA[row][columna-1] == Board.border)&& (boardIA[row][columna+1] != Board.barquito && boardIA[row][columna+1] != Board.border )
								&& (boardIA[row][columna+2] != Board.barquito && boardIA[row][columna+2] != Board.border) && (boardIA[row][columna+3] != Board.barquito && boardIA[row][columna+3] != Board.border))
						{							
								boardIA[row][columna] = Board.barquito;
								boardIA[row][columna+1] = Board.barquito;
								boardIA[row][columna+2] = Board.barquito;
								boardIA[row][columna+3] = Board.barquito;
							
						}
						else if((boardIA[row][columna-1] != Board.barquito || boardIA[row][columna-1] != Board.border ) && (boardIA[row][columna-2] == Board.barquito || boardIA[row][columna-2] == Board.border) 
								&& boardIA[row][columna+1] != Board.barquito && boardIA[row][columna+2] != Board.barquito)
						{
							boardIA[row][columna-1] = Board.barquito;
							boardIA[row][columna] = Board.barquito;
							boardIA[row][columna+1] = Board.barquito;
							boardIA[row][columna+2] = Board.barquito;
						}												
					}
					
				
				}else System.out.println("This position is already taken by another boat");				
			}			
			/*			
			Boat b = new Boat(row,columna,type,vert,large);		
			System.out.println("Hi i'm the IA and my boat is at row" + row + "and col" + columna);
			boatsIA.add(b);
			*/
			
			for(int ti=0; ti<Board.max_dimension+1;ti++)
			{
				for(int j=0; j<Board.max_dimension+1;j++)
				{
					System.out.print(boardIA[ti][j]+ "\t");
				}
				System.out.println("\n");
			}
		}			
		return boardIA;
		
	}
	
	
	
	
	
}
