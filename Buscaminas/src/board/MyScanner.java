package board;

import java.util.Scanner;
public class MyScanner {

private Scanner sc; 
	
	MyScanner(){
		this.sc = new Scanner(System.in);
	}
	protected int getRow() {
		return sc.nextInt();
	}	
	protected int getCol() {
		return sc.nextInt();
	}
	protected String getMode() {
		return sc.nextLine();
	}
	@SuppressWarnings("unused")
	protected String getNodeType() {
		return sc.nextLine();		
	}
	
	@SuppressWarnings("unused")
	protected String getAnswer() {
		return sc.nextLine();
	}
	
	@SuppressWarnings("unused")
	protected String getQuestion() {
		return sc.nextLine();
	}
	
	@SuppressWarnings("unused")
	protected String getNewObject() {
		return sc.nextLine();
	}

	protected void close() {
		// TODO Auto-generated method stub
		sc.close();
	}
}
