package entrega;

import static org.junit.Assert.*;

import org.junit.Test;

public class ClientTest {
	private MockScanner m;
	@Test
	public void isValidInputMenu() {
		//This function performs a path coverage on the isValidInputMenu function
		
		//Mock Object
		m = new MockScanner();
		boolean isValid;
		String type;
		//Case the player wants to start playing
		type = m.getMode1();
		isValid =Client.isValidInputMenu(type);	
		assertTrue(isValid);
		//Case where the player wants to read the instructions
		type = m.getMode2();
		isValid =Client.isValidInputMenu(type);	
		assertTrue(isValid);
		//Case the player pressed the wrong button
		type = m.getWrongMode();
		isValid =Client.isValidInputMenu(type);	
		assertFalse(isValid);		
				

	}
	@Test 
	public void isValidBack() {
		//This function performs a path coverage on the isValidBack function
		Client c = new Client();
		//Mock Object
		m = new MockScanner();
		String letter;
		boolean isValid;
		int i = 0;
		while(i < 50000) {
			letter = m.getBack();			
			isValid = Client.isValidBack(letter);			
			if(letter.equalsIgnoreCase("b"))
				assertTrue(isValid);
			else assertFalse(isValid);			
			i+=1;
		}			
	}
}
