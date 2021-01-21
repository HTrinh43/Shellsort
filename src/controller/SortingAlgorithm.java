package controller;
import model.LinkedNode;

public class SortingAlgorithm {
	public void bubleSort(LinkedNode list) {
		LinkedNode.Node current;
		LinkedNode.Node nextNode;
		LinkedNode.Node lastNode = null;		
		boolean sorted = false;
		
		while (sorted == false) {
			sorted = true;
			current = list.getRoot();
			System.out.println(current.getElement());
			while (current.getNext() != null) {
			
				nextNode = current.getNext();
				if (current.getElement() > nextNode.getElement()) {
				//swap current and nextNode
				//the lastNode must point to nextNode
				//the current point to nextNode.getNext
				//the nextNode point to current Node
					if (lastNode != null) {
						lastNode.setNext(nextNode);
					}
					if (nextNode.getNext() != null)
						current.setNext(nextNode.getNext());
					else 
						current.setNext(null);
					nextNode.setNext(current);
					lastNode = nextNode;
					sorted = false;
				}
				else {
					lastNode = current;
					current = current.getNext();
				}
			}
			if (sorted)
				break;
		}
	}
}
