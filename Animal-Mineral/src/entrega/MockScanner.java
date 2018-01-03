package entrega;

import java.util.Random;

public class MockScanner extends MyScanner {
	int answerCounter =2;
	int nodeCounter = 0;
	int objectCounter = 0;
	int modeCounter = 0;
	
	
	public String getMode1() {
		return "1";
	}
	public String getMode2() {
		return "2";
	}
	public String getWrongMode() {
		return "3";
	}
	
	@SuppressWarnings("unused")
	//override method of the MyScanner class
	public String getNodeType() {
		//change the return function in order to get a different answer
		if(nodeCounter == 0)
		{
			nodeCounter = 1;
			return getWrongType();
		} else if(nodeCounter == 1) {
			nodeCounter = 2;
			return getMineralType();
		}
		else if(nodeCounter ==2) {
			nodeCounter = 3;
			return getAnimalType();
		}
		else if(nodeCounter == 3) {
			nodeCounter = 0;
			return getVegetableType();
		}
		return null;		
	}
	@SuppressWarnings("unused")
	public String getAnimalType() {
		return "Animal";		
	}
	@SuppressWarnings("unused")
	public String getMineralType() {
		return "Mineral";
	}
	@SuppressWarnings("unused")
	public String getVegetableType() {
		return "Vegetable";
	}
	@SuppressWarnings("unused")
	public String getWrongType() {
		return "Gahh";
	}	
	@SuppressWarnings("unused")
	//override method of the MyScanner class
	public String getAnswer() {
		//change the return function in order to get a different answer	
		
		if(answerCounter == 0)
		{
			answerCounter = 1;
			return getYes();
		} else if(answerCounter == 1) {
			answerCounter = 2;
			return getNo();
		}
		else if(answerCounter ==2) {
			answerCounter = 0;
			return getBah();
		}
		else return null;		
	}
	public String getYes() {
		return "Yes";
	}
	@SuppressWarnings("unused")
	public String getNo() {
		return "No";
	}
	@SuppressWarnings("unused")
	private String getBah() {
		return "Bah";
	}
	
	@SuppressWarnings("unused")
	//override method of the MyScanner class 
	public String getQuestion() {
		//change the return function in order to get a different answer
		return getValidQuestion();
	}
	@SuppressWarnings("unused")
	public String getQuestionMaxLength() {
		return "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
	}
	@SuppressWarnings("unused")
	public String getQuestionMinLength() {
		return "aaa";		
	}
	@SuppressWarnings("unused")
	public String getQuestionNotUpper() {
		return "does the animal bark?";
	}
	@SuppressWarnings("unused")
	public String getQuestionNotInterrogant() {
		return "Does the animal bark";
	}
	@SuppressWarnings("unused")
	public String getValidQuestion() {
		return "Does the animal bark?";
	}
	@SuppressWarnings("unused")
	//Override method of the MyScanner class length
	public String getNewObject() {
		//change the return function in order to get a different answer
		if(objectCounter == 0)
		{
			objectCounter = 1;
			return getAnimalObject();
		} else if(objectCounter == 1) {
			objectCounter = 2;
			return getMineralObject();
		}
		else if(objectCounter ==2) {
			objectCounter = 0;
			return getVegetableObject();
		}
		else return null;
		
	}
	@SuppressWarnings("unused")
	public String getAnimalObject() {
		return "Dog";
	}
	@SuppressWarnings("unused")
	public String getMineralObject() {
		return "Steel";
	}
	@SuppressWarnings("unused")
	public String getVegetableObject() {
		return "Cucumber";
	}
	public String getBack() {		
		Random randomGenerator = new Random();
		int x =randomGenerator.nextInt(28);
		char value = (char) ((char) x + 48);
		return String.valueOf(value);
	}
	
}
