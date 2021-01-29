package controller;
import java.util.ArrayList;
import model.LinkedList;
import model.LinkedList.LinkedNode;

public class Sorting {
	public void bubleSort(LinkedList list) {
		/**
		 * Using bubble sort algorithm to sort the list
		 * @param list: the linkedlist
		 */
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
	
	private LinkedNode findAWayToMove(final LinkedList list, final int index, final LinkedNode startNode) {
		/**
		 * Return a destination node based on index
		 * 
		 */
		int startIndex = 0;
		LinkedNode destination = startNode;
		if (startNode != null) {
			startIndex = startNode.getIndex();
			destination = startNode;
		}
		
		if (index < 0)
			destination = null;
		else if (index == 0)
			destination = list.getRoot();
		else {
		if (startIndex > index) {
				while (startIndex < index) {
					destination = destination.getNext();
					startIndex++;
				}
			}
		else if (startIndex < index) {
			if (index > list.getMiddle().getIndex()) {
				destination = list.getMiddle();
				startIndex = destination.getIndex();
				while (startIndex < index) {
					destination = destination.getNext();
					startIndex++;
				}
			}
			else {
				destination = list.getRoot();
				startIndex = destination.getIndex();
				while (startIndex < index) {
					destination = destination.getNext();
					startIndex++;
				}
			}
		}}
		return destination;
	}
	
	private static void swapNode (LinkedNode prev, LinkedNode current, LinkedNode next)
	/**
	 * Helper method for bubble sort to swap 2 nodes
	 * @param prev: previous node of the current node
	 * @param current: current node
	 * @param next: the node will be swap with current node
	 */
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
				current.setIndex(current.getIndex() + 1);
				next.setIndex(next.getIndex() - 1);
		}
	}
	
	private static void swapNode(final LinkedNode prevA, final LinkedNode nodeA, final LinkedNode prevB, final LinkedNode nodeB) {
		/**
		 * Helper method for shell sort to swap 2 nodes
		 * @param prevA: previous node of node A
		 * @param nodeA: a node will be swap
		 * @param prevB: previous node of node B
		 * @param prevA: a node will be swap
		 */
		LinkedNode temp = nodeA.getNext();
		if (prevA != null) {
			prevA.setNext(nodeB);
		}
		if (nodeB.getNext() != null) {
			nodeA.setNext(nodeB.getNext());
		}
		else {
			nodeA.setNext(null);
		}
		nodeA.setIndex(nodeB.getIndex());
		nodeB.setIndex(temp.getIndex() - 1);
		prevB.setNext(nodeA);
		nodeB.setNext(temp);
	}

	public void shellSort(LinkedList list) {
		//
		int interval = 1;
		int size = list.getCount();
		while (interval < size/3) {
			interval = interval * 3 + 1;
		}
		StringBuilder stb = new StringBuilder();
		int pass = 0, cmp = 0;
		LinkedNode outer;
		LinkedNode inner, prevInner;

		LinkedNode startNode;
		LinkedNode valueNode, prevValue;
		LinkedNode temp;
		LinkedNode prevTemp;
		int outerIndex, innerIndex;
		ArrayList<String> resultList = new ArrayList<String>();
		controller controller = new controller();
//		boolean isRoot = false;
		while (interval > 0) {
			stb.append(interval);
			stb.append(" ");
			//setup nodeA and node
			startNode = list.getRoot();
			outer = findAWayToMove(list, interval, startNode);
			outerIndex = outer.getIndex();
			
			while (outer != null) {
				valueNode = list.newNode(outer.getElement());
//				prevValue = findAWayToMove(list, valueNode.getIndex() - 1, null);
				outerIndex = outer.getIndex();
				innerIndex = outerIndex;
//				inner = outer;
				temp = findAWayToMove(list, innerIndex - interval, null);
//				prevTemp = findAWayToMove(list, temp.getIndex() - 1, null);
//				isRoot = prevTemp == null;
				System.out.println("go in inner loop");
				while (innerIndex > interval -1 && temp.getElement() > valueNode.getElement()) {
					prevInner = findAWayToMove(list, innerIndex - 1, null);
					inner = prevInner.getNext();
					prevTemp = findAWayToMove(list, temp.getIndex()-1, null);
					// 2 nodes are next to each other
					if (interval == 1)
						swapNode(prevTemp, temp, inner);
					//2 nodes have gap > 1
					else {
						swapNode(prevTemp, temp, prevInner, inner);
					}
					//if exchange node is the root, set the other node to be the root
					if (prevTemp == null)
						list.setRoot(inner);
					
					innerIndex = innerIndex - interval;
					valueNode = findAWayToMove(list, innerIndex, null);
					temp = findAWayToMove(list, innerIndex - interval, null);
				}
				outer = findAWayToMove(list, outerIndex, null);
				outer = outer.getNext();
			}
			interval = interval == 2 ? 1 : (interval - 1)/3;
			resultList.add(controller.displayList(list));
		}
		System.out.println("list: "+ controller.displayList(list));
		System.out.println("index: "+ controller.displayIndex(list));
		controller.writeResult("shellSort", resultList);
	}
}
