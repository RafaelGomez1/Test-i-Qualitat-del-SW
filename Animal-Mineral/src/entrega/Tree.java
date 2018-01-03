package entrega;
//import java.util.Scanner;
public class Tree {
	//Type of tree's
	public  Node animalroot;
	public  Node mineralroot;
	public  Node vegetableroot;
	public MyScanner sc;
	
	public Tree(MyScanner scanner) {
		//sc = new Scanner(System.in);
		sc = scanner;
		animalroot = new Node("Cat");
		mineralroot = new Node("Rock");
		vegetableroot = new Node("Cactus");
	}
	public static int checkType(String option) {
		
		if(option.equalsIgnoreCase("mineral")){
			return 0;
		}else if(option.equalsIgnoreCase("animal")) {
			return 1;
		}else if(option.equalsIgnoreCase("vegetable")) {
			return 2;
		}
		else return -1;
	}
	//Ask which category the player wants to play
	public Node treeAsk(String option) {
		//the returns in this function are only per test purposes
		//mineral tree
		if(checkType(option) == 0){
			createTree(mineralroot, option);
		//animal tree 
		}else if(checkType(option) == 1) {
			createTree(animalroot, option);
		//vegetable tree
		}else if(checkType(option) == 2) {
			createTree(vegetableroot, option);
		}
		return null;
	}
	//Roams the Node Tree for the new answer and node
	public void roam(Node root, String option) {
		
		System.out.println(root.name);		
		String roamAnswer;				
		if(root.nodeleft == null)
			roamAnswer = sc.getNo();
		else if(root.noderight == null)
			roamAnswer = sc.getYes();
		else
		roamAnswer = sc.getAnswer();		
		if(roamAnswer.equalsIgnoreCase("yes")) {
			root.nodeleft = createTree(root.nodeleft, option);
		}else if(roamAnswer.equalsIgnoreCase("no")) {
			root.noderight= createTree(root.noderight, option);
		}else {
			System.out.println("Please, say yes or no");
			root=createTree(root, option);
		}
		
	}
	public static int checkResponse(String response) {
		
		if(response.equalsIgnoreCase("yes")) {
			return 1;
		}
		else if(response.equalsIgnoreCase("no")){
			return 0;
		}
		else  return -1;
	}
	
	public Node createFromType(String type,Node question) {
		
		//These returns are only used for testing purposes
		 if(type.equalsIgnoreCase("animal")) {					 
			return animalroot=question;			
		 }else if(type.equalsIgnoreCase("vegetable")) {			
			 return vegetableroot=question;
		 }else if(type.equalsIgnoreCase("mineral")){			 
			return mineralroot=question;
		 }
		return null;
		
	}
	public Node createTree(Node root, String option) {
		
		String object="";
		String answer = null;
		Node objectNode = null;
		String inputQuestion="";
		String objectAnswer="";	
		//Mock mc = new MockObject();
		
		if(root.nodeleft==null && root.noderight==null) {
			answer = Interface.ask(root,sc);			
			if(checkResponse(answer) == 1) {				
				System.out.println("I won!");			 
			 }else if(checkResponse(answer)==0){
				 //New node created by the  player
				 System.out.println("What are you thinking of?");
				 //Mock Object input
				 //object = mc.getNewObject(option);
				 //User input
				 object = sc.getNewObject();
				 objectNode = new Node(object);
				 System.out.println("Now, tell me a question with yes or no with an answer\n"
				 		+ "this have to express the diference between "
				 		+ object+" and "+root.name);
				 int d = -1;
				 //Generate validation functions to enable proper testing
				 while(d == -1) {
					 //Mock Object question
					 //inputQuestion = mc.getQuestion(option);
					 //User question
					 inputQuestion = sc.getQuestion();
					 d = Interface.inputQuestion(inputQuestion);
					 System.out.println(inputQuestion);
				 }
				 System.out.println("Which answer is correct for "+object+"?");
				 //Mock Object answer 
				 //objectAnswer = mc.getAnswer();
				 //User objectAnswer
				 objectAnswer = sc.getAnswer();
				 System.out.println(objectAnswer);
				//Checks the response was not correct
				 while(checkResponse(objectAnswer) == -1) {
					 System.out.println("Say,yes or no");
					 //Mock Object answer
					 //objectAnswer = mc.getAnswer();
					 //User objectAnswer
					 objectAnswer = sc.getAnswer();
					 System.out.println(objectAnswer);
				 }
				 Node rootName = new Node(root.name);
				 //Expands the tree if we added another node
				 if(checkResponse(objectAnswer) == 1) {					 
					 Node question = new Node(inputQuestion, objectNode, rootName);
					 createFromType(option,question);
				 }
				 else if(checkResponse(objectAnswer) == 0) {
					 Node question = new Node(inputQuestion, rootName, objectNode);
					 createFromType(option,question);
				 }	
				 else if(checkResponse(objectAnswer) == -1) {
					 return root;
				 }				
			 }else{
				 System.out.println("Say, yes or no");
			 }
		}else {
			roam(root,option);
		} 
		
		return root;
	}
}

