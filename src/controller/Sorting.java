package controller;
import java.util.ArrayList;

import model.LinkedList;
import model.LinkedList.LinkedNode;

public class Sorting {
	public void bubleSort(LinkedList list) {
		controller controller = new controller();
		LinkedNode current;
		LinkedNode nextNode;
		LinkedNode prevNode;
		ArrayList<String> resultList = new ArrayList<String>();
		
		boolean sorted = false;
		while (sorted == false) {
			//when the loop starts, set current to the root
			//set sorted = true, if the list is sorted, sorted will be true at the end of the loop
			sorted = true;
			current = list.getRoot();
			prevNode = null;
			while (current != null) {
				if (current.getNext()!= null && current.getElement() > current.getNext().getElement()) {
						nextNode = current.getNext();
//						resultList.add(Integer.toString(current.getElement()));
						swapNode(prevNode, current, nextNode);

						if (prevNode == null && nextNode.getElement() < list.getRoot().getElement()) {
							list.setRoot(nextNode);
						}
						current = nextNode;
						sorted = false;
						resultList.add(controller.displayList(list));
				}
//				resultList.add(controller.displayList(list));
				prevNode = current;
				current = current.getNext();
			}
		}
		//write the sorting process to a file
		controller.writeResult("bubleSort", resultList);
	}
	
	public void shellSort(LinkedList list) {
		int interval = 1;
		int size = list.getCount();
		while (interval < size) {
			interval = interval * 3 + 1;
		}
		while (interval > 0) {
			for (int outer = interval; outer < size; outer++) {
				
			}
		}
		
	}
	
	public static void swapNode (LinkedNode prev, LinkedNode current, LinkedNode next)
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
