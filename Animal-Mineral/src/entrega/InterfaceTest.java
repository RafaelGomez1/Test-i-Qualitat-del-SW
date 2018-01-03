package entrega;

import static org.junit.Assert.*;

import org.junit.Test;
	
	
public class InterfaceTest {
	
	private MockScanner mc;
	@Test
	public void isValidQuestionTest() {	
		//this functions performs a decision coverage on the isValidQuestion function	
		mc = new MockScanner();
		int isValid;		
		//Invalid question type (length > 50)
		String question = mc.getQuestionMaxLength();
		isValid = Interface.isValidQuestion(question);
		assertEquals(isValid,-1);
		//Invalid question type (length < 5)
		question = mc.getQuestionMinLength();
		isValid = Interface.isValidQuestion(question);
		assertEquals(isValid,-1);
		//Invalid question type (Question does't have ?)
		question = mc.getQuestionNotInterrogant();
		isValid = Interface.isValidQuestion(question);
		assertEquals(isValid,-1);
		//Invalid question type (First letters is not upper case)
		question = mc.getQuestionNotUpper();
		isValid = Interface.isValidQuestion(question);
		assertEquals(isValid,-1);
		//Valid question type
		question = mc.getValidQuestion();
		isValid = Interface.isValidQuestion(question);
		assertEquals(isValid,0);			
	}
	@Test 
	public void AskTest() {
		//This function performs a loop testing  on the Ask function
		mc = new MockScanner();
		int i = 0;
		Node node;
		//Node null test case
		Node nodeNull = null;
		String answer = Interface.ask(nodeNull,mc);
		assertEquals(answer," ");
		//Test case where we did find the animal
		node =  new Node(mc.getAnimalObject());
		answer = Interface.ask(node,mc);
		assertEquals(answer,"Yes");
		//Test case where we didn't find the animal
		node =  new Node(mc.getAnimalObject());
		answer = Interface.ask(node,mc);
		assertEquals(answer,"No");		
		//Test case where we did find the mineral
		node =  new Node(mc.getMineralObject());
		answer = Interface.ask(node,mc);
		assertEquals(answer,"Yes");
		//Test case where we didn't find the mineral
		node =  new Node(mc.getMineralObject());
		answer = Interface.ask(node,mc);
		assertEquals(answer,"No");	
		//Test case where we did find the vegetable
		node =  new Node(mc.getVegetableObject());
		answer = Interface.ask(node,mc);
		assertEquals(answer,"Yes");
		//Test case where we didn't find the vegetable
		node =  new Node(mc.getVegetableObject());
		answer = Interface.ask(node,mc);
		assertEquals(answer,"No");	
	}
	
	@Test
	public void nodeIsNullTest() {
		//This tests performs  a statement coverage at the nideIsNull function
		Node nodeNull = null;
		mc = new MockScanner();
		Node aux;		
		int i = 0;
		boolean isValid;
		//Null node test case
		isValid = Interface.nodeIsNull(nodeNull);
		assertEquals(isValid,true);
		//Filled Node loop test case		
		while(i<5000) {			
			aux = new Node(mc.getNewObject());
			isValid = Interface.nodeIsNull(aux);
			assertEquals(isValid,false);
			i+=1;
		}
	}
	
}
