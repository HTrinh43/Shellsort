package test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import model.LinkedNode;
import controller.*;

import org.junit.jupiter.api.BeforeAll;

public class Tester {
	
	@BeforeAll
	static void setUpBeforeClass() {
	}
	
	@Test
	void testReadValue() {
		String filepath = System.getProperty("user.dir") + "/src/test/data.txt";
		controller controller = new controller();
		LinkedNode list = controller.readValue(filepath);

	}
	
	@Test 
	void testDisplayList() {

	}
	
	@Test
	void testBubleSort() {
		Sorting sortingAlgo = new Sorting();
		String filepath = System.getProperty("user.dir") + "/src/test/data.txt";
		controller controller = new controller();
		LinkedNode root = controller.readValue(filepath);
		controller.displayList(root);
		sortingAlgo.bubleSort(root);
//		controller.displayList(root);

	}
	
	@Test
	void testSwapNode() {
		Sorting sortingAlgo = new Sorting();
		controller controller = new controller();
		LinkedNode list = new LinkedNode();
		LinkedNode.Node root = list.getRoot();
		root.setElement(3);
		LinkedNode.Node node1 = list.newNode(1);
		LinkedNode.Node node2 = list.newNode(8);
		root.setNext(node1);
		node1.setNext(node2);
		LinkedNode.Node current = root;
		LinkedNode.Node nextNode = current.getNext();
		controller.displayList(list);
		sortingAlgo.swapNode(null, current, nextNode);
		list.setRoot(node1);
		controller.displayList(list);
		
		
		
	}
}
