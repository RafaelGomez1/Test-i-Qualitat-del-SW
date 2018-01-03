package entrega;
import java.util.Scanner;

public class MyScanner {
	private Scanner sc; 
	
	MyScanner(){
		this.sc = new Scanner(System.in);
	}
	public String getYes() {
		return sc.nextLine();
	}	
	public String getNo() {
		return sc.nextLine();
	}
	public String getMode() {
		return sc.nextLine();
	}
	@SuppressWarnings("unused")
	public String getNodeType() {
		return sc.nextLine();		
	}
	
	@SuppressWarnings("unused")
	public String getAnswer() {
		return sc.nextLine();
	}
	
	@SuppressWarnings("unused")
	public String getQuestion() {
		return sc.nextLine();
	}
	
	@SuppressWarnings("unused")
	public String getNewObject() {
		return sc.nextLine();
	}

	public void close() {
		// TODO Auto-generated method stub
		sc.close();
	}
	
}
