package entrega;


public class Interface {
	
	
	public static boolean nodeIsNull(Node node) {		
		if(node == null)		
			return true;
		else return false;
	}
	public static String ask(Node root,MyScanner sc) {
		String answer = " ";
		if(!nodeIsNull(root)) {
			int i = 2;			
			System.out.println("Are you thinking in a : "+root.name+"?");					
			answer = sc.getAnswer();			
			while(Tree.checkResponse(answer) == -1) {
				System.out.println("I don't know what is that");
				System.out.println("Say yes or no");
				System.out.println("--->");				
				answer = sc.getAnswer();				
			}
		}
		System.out.println(answer);
		return answer;
	}
	public static int isValidQuestion(String ask) {		
		
		int size = ask.length();
    	
    	if(size<5 || size>50) {
    		System.out.println("Bigger than 5 characters and less than 50");
    		return -1;
    	}
    	else if (!(Character.isUpperCase(ask.charAt(0)))) {
    		System.out.println("First word in uppercase, please");
    		return -1;
    	}
    	else if (ask.charAt(size-1)!='?'){
    		System.out.println("Last character have to be a question mark --> ?");
    		return -1;
    	}
    	return 0;
	}
	
	//Put the correct format on input user questions
	public static int inputQuestion(String ask){
		
			if(isValidQuestion(ask) < 0) {
				return -1;
			}
			else { StringBuilder sb = new StringBuilder();
    		boolean found = false;
    		for(char c : ask.toCharArray()){
    	        if(Character.isDigit(c)){
    	        	sb.append(c);
    	            found = true;
    	        } else if(found){
    	        	System.out.print("The question cannot have a number");
    	            break;                
    	        }
    	    }			
			return 1;
		}
	
	}
}
