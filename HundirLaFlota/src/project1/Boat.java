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
	
	
	public List<Boat> createBoats() 
	{	
		List<Boat> boats = new ArrayList<Boat>();
		char aux;
		int i = 0;
		while(i<max_boats)
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
			System.out.println("Inser the row of the boat");
			row = sc.nextInt();	
			//Error control of the row argument
			while(row > Board.max_dimension || row <=0)
			{
				System.out.println("Error the value is incorrect");
				System.out.println("Inser the row of the boat");
				row = sc.nextInt();
			}			
			//Initialization of the col argument
			System.out.println("Inser the col of the boat");
			col = sc.next().charAt(0);	
			column = Board.letterToNumber(col);
			//Error control of the col argument
			while(column > Board.max_dimension || column <=0)
			{
				System.out.println("Error the value is incorrect");
				System.out.println("Inser the row of the boat");
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
			Boat b = new Boat(row,column,typeOfBoat,vertical,lenght);			
			boats.add(b);
			//Clear the argument in order to avoid problems
			vertical = false;					
			i+=1;
			System.out.println("You have now " + i + " boats placed");
		}
		return boats;	
	}
	public List<Boat> placeBoatsRandom()
	{
		//Generation of the boats done by the IA
		List<Boat> boatsIA = new ArrayList<Boat>();
		int aux = 0; 
		int row;
		int columna;
		boolean vert;
		int type;
		int large = 0;
		for(int i = 0; i<max_boats;i++)
		{	
			//Initialitzation of the arguments of a boat (done by the IA)
			row = ThreadLocalRandom.current().nextInt(1,11);
			columna = ThreadLocalRandom.current().nextInt(1,11);
			type = ThreadLocalRandom.current().nextInt(1,4);
			if(i%2 ==0)
			{
				vert = true;
			}
			else vert = false;
			switch (type)
			{
				case 1: large = 2;
						break;
				case 2: large = 3;
						break;
				case 3: large = 4;
						break;				
			}
			Boat b = new Boat(row,columna,type,vert,large);			
			boatsIA.add(b);
		}			
		return boatsIA;
		
	}
	
	
	
	
	
}
