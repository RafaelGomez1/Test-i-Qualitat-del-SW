package project1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import project1.Boat;

import org.junit.Test;

public class PlayerTest {

	@Test
	public void test() {
		Boat b = new Boat(0,0,3,false,3);
		List <Boat>	ships = new ArrayList<Boat>();
		char boardIA[][];
		boardIA = new char [Board.max_dimension+1][Board.max_dimension+1];
		boardIA = Player.initialitzacionBorder(boardIA);
		for(int i=0; i<Board.max_dimension+1;i++)
		{
			for(int j=0; j<Board.max_dimension+1;j++)
			{
				System.out.print(boardIA[i][j]+ "\t");
			}
			System.out.println("\n");
		}
		
		Scanner sc = new Scanner(System.in);
		Player p = new Player();
		int turn = 1;
		int hit[] = new int [3];// [0] -> hit/miss, [1] -> row, [2] -> column
		char exit = ' ';
		//b.createBoats();
		boardIA = b.placeBoatsRandom();
		
		while(true)
		{	
			/*
			if(turn %2 == 0)
			{
				p.shootIA(ships);
				turn+=1;
			}
			
			if(turn %2 != 0)
			{*/
				hit = p.shoot(boardIA);
				if(hit[0] == 1)
				{
					Board.board[hit[1]][hit[2]] = Board.hit;	
				}
				else if (hit[0] != 1)
				{
					Board.board[hit[1]][hit[2]] = Board.miss;
				}
				Board.printBoard();
				//turn +=1;
				//System.out.println("Do you want to finish the game? Press 'e'");
				//exit = sc.next().charAt(0);
			//}
		}
		
	}

}
