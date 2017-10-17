package project1;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import project1.Boat.*;
import project1.Player;

public class Client {

	private static final int max_boats = 4;
	private static final int max_dimension = 10;

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		//Instructions for the players 
		System.out.println("This information might help you, Type: 1-> 2 slots boat, 2-> 3 slots boat, 3-> 4 slots boat. Press 'e' to exit the game");
		//Objects and Methods/variables necessary for proper functionality of class Boat		
		Boat b = new Boat(0,0,3, false,0);//row,col,typeOfBoat
		//Matrixes and variables used to control the game
		char boardPlayer[][];
		boardPlayer = new char [Board.max_dimension][Board.max_dimension];
		boardPlayer = Player.initialitzacionBorder(boardPlayer);
		char boardIA[][];
		boardIA = new char [Board.max_dimension][Board.max_dimension];
		boardIA = Player.initialitzacionBorder(boardIA);
		
		//Objects and Methods/variables necessary for proper functionality of class Board
		Board bo = new Board('~','X');	
		bo.printBoard();

		//Objects and Methods/variables necessary for proper functionality of class Player
		Player p1 = new Player();
		Player pIA = new Player();
		List <Boat>	ships = new ArrayList<Boat>();
		int [] hit = new int [3];
		int [] hitIA = new int[3];
		int turn = 1;
		int numOfBoats = 0;
		int numOfBoatsIA = 0;
		int hitsPlayer = 0;
		int hitsIA = 0;
						
		//A way for the player to control if he wants to place them is yet to be implemented		
		boardPlayer = b.createBoats();
		boardIA = b.placeBoatsRandom();
		//We count the number of boats in the matrix in order to know when the game is over
		numOfBoats = Boat.countBoats(boardPlayer);
		numOfBoatsIA = Boat.countBoats(boardIA);	
		while(true)
		{	
			
			if(turn %2 == 0)
			{
				hitIA = pIA.shootIA(boardPlayer);				
				turn+=1;
				if(hitIA[0] == 1)
				{
					System.out.println("The enemy shot one your boat at row " + hitIA[1] + "col " + hitIA[2] );
					boardPlayer[hitIA[1]][hitIA[2]] = Board.hit;
					hitsIA+=1;
					if(hitsIA == numOfBoats)
					{
						System.out.println("Your boats have been destroyed, YOU LOSE");
						break;
					}
					System.out.println("This is the Boards of the player");
					for(int ti=0; ti<Board.max_dimension+1;ti++)
					{
						for(int j=0; j<Board.max_dimension+1;j++)
						{	
							
							System.out.print(boardPlayer[ti][j]+ "\t");
						}
						System.out.println("\n");
					}					
				}
				else System.out.println("The enemy missed his shoot  at row " + hitIA[1] + "col " + hitIA[2] );
				
			}
			
			//Checks if it's the player's turn to shoot and if he hits an enemy boat or not			
			if(turn %2 != 0)
			{
			
				hit = p1.shoot(boardIA);
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
				
				Board.printBoard();
				//turn +=1;
				//System.out.println("Do you want to finish the game? Press 'e'");
				//exit = sc.next().charAt(0);
				
			}
			
		}
	}		
}


