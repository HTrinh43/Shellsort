package test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import model.LinkedNode;
import controller.*;

import org.junit.jupiter.api.BeforeAll;

public class controller_test {
	
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
		SortingAlgorithm sortingAlgo = new SortingAlgorithm();
		String filepath = System.getProperty("user.dir") + "/src/test/data.txt";
		controller controller = new controller();
		LinkedNode root = controller.readValue(filepath);
//		sortingAlgo.bubleSort(root);
//		controller.displayList(root);
	}
}
