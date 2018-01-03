package entrega;
import static org.junit.Assert.*;

import org.junit.Test;

public class TreeTest {
	private MockScanner mc;
	
	@Test
	public void checkTypeTest() {	
		//This function performs a path and decision coverage on the checkType function
		//Mock Object
		mc = new MockScanner();
		int isValid;
		String type;
		int i = -1;			
		while(i < 3) {
			//Gets the type of node from the mock object
			type = mc.getNodeType();
			isValid =Tree.checkType(type);
			assertEquals(isValid,i);
			i+=1;
		}				
	}
	
	@Test
	public void createFromTypeTest() {
		mc = new MockScanner();
		//This function performs a path and decision coverage on the createFromTypeTest
		Tree tr = new Tree(mc);
		
		Node validNode;
		Node nullQuest = null;
		Node animalQuest = new Node("Dog",null,null);
		Node mineralQuest = new Node("Steel",null,null);
		Node vegetableQuest = new Node("Cucumber",null,null);
		
		//create from animal type test case
		tr.animalroot = tr.createFromType(mc.getAnimalType(),animalQuest);		
		assertEquals(tr.animalroot,animalQuest);
		//create from mineral type test case
		tr.mineralroot = tr.createFromType(mc.getMineralType(), mineralQuest);
		assertEquals(tr.mineralroot,mineralQuest);
		//create from vegetable type test case
		tr.mineralroot = tr.createFromType(mc.getVegetableType(), vegetableQuest);
		assertEquals(tr.vegetableroot, vegetableQuest);
		//create from null type (bug) test case
		validNode = tr.createFromType(mc.getWrongType(), nullQuest);
		assertEquals(validNode,nullQuest);	
	}
	@Test 
	public void createTreeTest() {
		
		mc = new MockScanner();
		Tree tr = new Tree(mc);
		Node comp;		
		
		//Test case when the tree does already exists (node.left && node.right are both full)
		Node leftNode = new Node("leftNode");
		Node rightNode = new Node("rightNode");		
		Node node = new Node(mc.getNewObject(),leftNode,rightNode);
		comp = tr.createTree(node, mc.getAnimalType());
		assertEquals(comp,node);		
		//Test case when node.left is null and node.right is null		
		leftNode = null;
		rightNode = null;
		node = new Node(mc.getNewObject(),leftNode,rightNode);
		comp = tr.createTree(node, mc.getMineralType());
		assertEquals(comp,node);		
		//Test case when node.left is full and node.right is null		
		leftNode = new Node("leftNode");
		rightNode = null;
		node = new Node(mc.getNewObject(),leftNode,rightNode);
		comp = tr.createTree(node, mc.getVegetableType());
		assertEquals(comp,node);		
		//Test case when node.left is null and node.right is full		
		leftNode = null;
		rightNode = new Node("nodeRight");
		node = new Node(mc.getNewObject(),leftNode,rightNode);
		comp = tr.createTree(node, mc.getAnimalType());
		assertEquals(comp,node);		
	}
	/*
	@Test
	public void treeAskTest() {
		mc = new MockObject();
		Tree tr = new Tree();
		String type = mc.getAnimalType();
		Node aux = tr.treeAsk(type);
		assertEquals(tr.animalroot,aux);
		
		
	}*/
}
	

