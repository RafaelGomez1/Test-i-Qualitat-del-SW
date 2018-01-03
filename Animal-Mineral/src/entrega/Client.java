package entrega;
public class Client {
	
	private static MyScanner sc = new MyScanner();
	public static void menu() {	
		
		System.out.println("Welcome to Animal, Vegetable and Mineral");
		System.out.println("My mission is to guess a word you think about this 3 categories");
		System.out.println("Animal,Mineral,Vegetal");
		System.out.println("--> Press 1 to start playing");
		System.out.println("--> Press 2 to go to the Instruction menu");	
		String s;
		
		s = sc.getMode();
		if(isValidInputMenu(s)) {
			if(s.equals("1")) {						
				game();
			}
			else if(s.equals("2")) {
				instructions();
			}
		}		
		else 
		System.out.println("Please enter the proper value (1 or 2)");		
		sc.close();
	}
	public static boolean isValidInputMenu(String s) {
		
		if(s.equals("1") || s.equals("2")) {
			return true;			
		}	
		else return false;
		
	}
	public static boolean isValidBack(String s) {
		if(s.equalsIgnoreCase("b")) {
			return true;
		}
		return false;
		
	}
	public static void instructions() {
		System.out.println("These are the basic intructions to play our game");
		System.out.println("1.The possible types of trees are Animal,Mineral,Vegetal ");
		System.out.println("2.Whenever you write the question into the system you have to follow these rules");
		System.out.println("	2.1 The question has to start with an upper case letter.");
		System.out.println("	2.2 The question's lenght has to be between 5 and 50 caracters (both included)");
		System.out.println("	2.3 The question has to end with a ?");
		System.out.println("--> Now press B to go back to the main menu");		
		String s = sc.getMode();
		if(isValidBack(s)) {
			menu();
		}
		else System.out.println("You have to press B in order to go back");
	}
	public static String askCategory() {
		//Mock mc = new MockObject();		
		String category = "";
		System.out.println("Which category are you thinking?");
		//User input
		category = sc.getNodeType() ;
		//Mock Object input 
		//category = mc.getType();
		while(Tree.checkType(category) == -1) {	
			System.out.println("I don't know what is that");
			System.out.println("Type one category");
			//Mock Object input
			//category = mc.getType();
			//User input
			category = sc.getNodeType();
		}
		System.out.println(category);
		return category;		
	}
	public static String answerYesorNot() {
		//Mock mc = new MockObject();
		String answer = "";
		//Mock Object Answer
		//answer = mc.getAnswer();
		//User Answer
		answer = sc.getAnswer();		
		System.out.println(answer);
		return answer;		
	}
	public static void game() {
		
		boolean game = true;
		String category = "";				
		String yesono="";
		Tree tree = new Tree(sc);
		do {			
			category = askCategory();
			tree.treeAsk(category);			
			System.out.println("You wanna play again?");				
			yesono = answerYesorNot();			
			while(Tree.checkResponse(yesono) == -1){					
				System.out.println("I'm sorry the response was incorrect please type yes or no");
				yesono=answerYesorNot();				
			}
			if(Tree.checkResponse(yesono)==0) {
				game=false;
				break;
			}			
		}while(game);
		sc.close();
	}
	public static void main(String[] args) {
		
		menu();		
	}
		
}
