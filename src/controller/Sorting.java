package controller;
import model.LinkedNode;

public class Sorting {
	public void bubleSort(LinkedNode list) {
		controller controller = new controller();
		LinkedNode.Node current;
		LinkedNode.Node nextNode;
		LinkedNode.Node prevNode;
		LinkedNode.Node root = list.getRoot();
		boolean sorted = false;
		while (sorted == false) {
			//when the loop starts, set current to the root
			sorted = true;
			current = root;
			prevNode = null;
			while (current != null) {
				if (current.getNext()!= null) {
					if (current.getElement() > current.getNext().getElement()) {
						nextNode = current.getNext();
						swapNode(prevNode, current, nextNode);
						if (prevNode == null) {
							list.setRoot(nextNode);
						}
						current = nextNode;
						sorted = false;
					}
				}
				prevNode = current;
				current = current.getNext();
				controller.displayList(list);	
			}
		}
	}
	
	public static void swapNode (LinkedNode.Node prev, LinkedNode.Node current, LinkedNode.Node next)
	{
		
		if (current.getElement() > next.getElement()) {
			//swap current and nextNode
			//the lastNode must point to nextNode
			//the current point to nextNode.getNext
			//the nextNode point to current Node
				if (prev != null) {
					prev.setNext(next);
				}
				if (next.getNext() != null)
					current.setNext(next.getNext());
				else 
					current.setNext(null);
				next.setNext(current);
		}
	}
	
}
