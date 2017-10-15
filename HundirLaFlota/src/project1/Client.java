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
		System.out.println("This information might help you, Type: 1-> 2 slots boat, 2-> 3 slots boat, 3-> 4 slots boat. Press 'e' to exit the game");
		Scanner sc = new Scanner(System.in);
		char exit = ' ';
		Board bo = new Board('~','X');	
		Boat b = new Boat(0,0,3, false,0);//row,col,typeOfBoat
		Player p1 = new Player();
		Player pIA = new Player();
		List <Boat>	ships = new ArrayList<Boat>();
		List<Boat> shipsIA = new ArrayList<Boat>();
		bo.printBoard();				
		//A way for the player to control if he wants to place them is yet to be implemented		
		ships = b.createBoats();
		shipsIA = b.placeBoatsRandom();
		while(exit != 'e')
		{
			Player.shoot(shipsIA);
			Player.ShootIA(ships);
			
			System.out.println("Do you want to exit the game? Press 'e'");
			exit = sc.next().charAt(0);
		}
		
		
	}

}
