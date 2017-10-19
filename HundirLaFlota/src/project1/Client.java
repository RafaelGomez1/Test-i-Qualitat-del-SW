package project1;
import project1.Player;
import java.util.Scanner;
public class Client {

	public static int menu(Scanner sc)
	{		
		System.out.println("Welcome to Sink the Float");
		System.out.println("-------------------------");
		System.out.println("Please select one of these options, if you dont know how to play we'd recommend you to see the instructions");
		System.out.println("1.Play");
		System.out.println("2.Instructions");
		System.out.println("3.Exit");
		System.out.flush();
		return sc.nextInt();
	}
	public static void checkResponse(int response,Scanner sc)
	{
		switch(response)
		{
			case 1: Play();
					break;
			case 2: ShowInstructions(sc);
					break;
			case 3: break;
		}
		
	}
	public static void ShowInstructions(Scanner sc)
	{
		char resp;
		int ret;
		System.out.println("Here's the basic instructions about the way to play this game");
		System.out.println("-------------------------------------------------------------");
		System.out.println("Ranges of values");
		System.out.println("   1.TypeOfBoat");
		System.out.println("      1. 1-> Boat of 2 slots");
		System.out.println("      2. 2-> Boat of 3 slots");
		System.out.println("      3. 3-> Boat of 4 slots");
		System.out.println("-------------------------------------------------------------");
		System.out.println("Ranges of values");
		System.out.println("   2.Row");
		System.out.println("      1.The value of this parameter has to be between 1 and 9 both included");
		System.out.println("-------------------------------------------------------------");
		System.out.println("Ranges of values");
		System.out.println("   3.Column");
		System.out.println("      1.The value of this parameter has to be between 1 and 9 both included");
		System.out.println("-------------------------------------------------------------");
		System.out.println("Ranges of values");
		System.out.println("   4.Vert");
		System.out.println("      1.The value of this parameter has to be either Y or N");
		System.out.println("-------------------------------------------------------------");
		System.out.println("Error Control");		
		System.out.println("   1.Any other value of the parameters listed above that's different from the ones we told you will be considered a mistake");
		System.out.println("-------------------------------------------------------------");
		System.out.println("Press B to go back to the starting menu");		
		resp = sc.next().charAt(0);
		if(resp == 'B')
		{
			ret = Client.menu(sc);
			if(ret == 1)
			{
				Client.Play();
			}
				
		}
	}
	public static void Play()
	{	 
		//Object of the class Scanner
		Scanner sc = new Scanner(System.in);
		//Objects and Methods/variables necessary for proper functionality of class Boat		
		Boat b = new Boat(0,0,3, false,0);//row,col,typeOfBoat
		
		//Matrixes and variables used to control the game
		char boardPlayer[][];
		boardPlayer = new char [Board.max_dimension][Board.max_dimension];
		boardPlayer = Player.initialitzacionBorder(boardPlayer);
		
		char boardIA[][];
		boardIA = new char [Board.max_dimension][Board.max_dimension];
		boardIA = Player.initialitzacionBorder(boardIA);	
		
		//Objects and Methods/variables necessary for proper functionality of class Player
		Player p1 = new Player();		
		int [] hit = new int [3];
		int [] hitIA = new int[3];
		int turn = 1;
		int numOfBoats = 0;
		int numOfBoatsIA = 0;
		int hitsPlayer = 0;
		int hitsIA = 0;
		int rowIA = 0;
		int colIA = 0;
		int rowPlayer = 0;
		char colPlayer = ' ';
		
		
		//Objects and Methods/variables necessary for proper functionality of class Board	
		Board bo = new Board('~','X');
		Board.printBoard(bo.board,boardPlayer);		
						
		//Initialization and placements of the boats by both sides the IA and the player
		boardPlayer = b.createBoats();
		boardIA = b.placeBoatsRandom();
		
		//We count the number of boats in the matrix in order to know when the game is over
		numOfBoats = Boat.countBoats(boardPlayer);
		numOfBoatsIA = Boat.countBoats(boardIA);
		
		//Main loop of the game
		while(true)
		{	
			//IA turn, shoots and checks if it hit or missed
			if(turn %2 == 0)
			{
				rowIA = Player.randomPosGenerator();
				colIA = Player.randomPosGenerator();
				hitIA = Player.shootIA(boardPlayer,rowIA,colIA);				
				turn+=1;
				//Case the IA hits one of our boats
				if(hitIA[0] == 1)
				{
					System.out.println("The enemy shot one your boat at row " + hitIA[1] + "col " + hitIA[2] );
					System.out.println("-------------------------------------------------------------------");
					boardPlayer[hitIA[1]][hitIA[2]] = Board.hit;
					hitsIA+=1;					
					Board.printBoard(Board.board,boardPlayer);
					//END of the GAME condition
					if(hitsIA == numOfBoats)
					{
						System.out.println("Your boats have been destroyed, YOU LOSE");
						break;
					}
				}
				else if(hitIA[0] == 0)
				{ 	
					boardPlayer[hitIA[1]][hitIA[2]] = Board.miss;
					System.out.println("The enemy missed his shoot  at row " + hitIA[1] + "col " + hitIA[2] );
					System.out.println("-------------------------------------------------------------------");
					Board.printBoard(Board.board,boardPlayer);
				}
				
				
			}			
			//Checks if it's the player's turn to shoot and if he hits an enemy boat or not			
			if(turn %2 != 0)
			{
				rowPlayer = p1.ask4Row(sc);
				colPlayer = p1.ask4Col(sc);							
				hit = p1.shoot(boardIA,rowPlayer,colPlayer);
				turn+=1;
				//The shoot was a hit
				if(hit[0] == 1)
				{
					Board.board[hit[1]][hit[2]] = Board.hit;
					hitsPlayer +=1;
					if(hitsPlayer == numOfBoatsIA)
					{
						Board.board[hit[1]][hit[2]] = Board.hit;
						System.out.println("You have the destroyed all the enemy's boats, YOU WON");
						break;						
					}
				}
				else if (hit[0] != 1)
				{
					Board.board[hit[1]][hit[2]] = Board.miss;
				}				
				Board.printBoard(Board.board,boardPlayer);						
			}			
		}
	}		
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		Scanner sc = new Scanner(System.in);
		int response;
		response = Client.menu(sc);
		Client.checkResponse(response,sc);
	}
}


