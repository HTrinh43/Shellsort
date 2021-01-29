package controller;
import java.util.ArrayList;
import model.LinkedList;
import model.LinkedList.LinkedNode;

public class Sorting {
	public void bubbleSort(LinkedList list) {
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
		int gap = 1;
		int size = list.getCount();
		while (gap < size/3) {
			gap = gap * 3 + 1;
		}
		int pass = 0, cmp = 0, exch = 0;
		int totalPass = 0, totalCmp = 0, totalExch = 0, k = gap;
		int totalGapCmp = 0, totalGapExch = 0;
		LinkedNode boudary, tracking, prevInner, startNode, valueNode, temp, prevTemp;
		int boundaryIndex, trackingIndex;
		ArrayList<String> resultList = new ArrayList<String>();
		controller controller = new controller();
		addToOutput(resultList, "k \tpass \tcmp \texch");

		while (gap > 0) {
//			if(k != gap)
//			addToOutput(resultList, (k) + "\t" + pass + "\t" + cmp + "\t" + exch);
//			totalPass += pass;
			
			pass = 0;
			exch = 0;
			cmp = 0;

			startNode = list.getRoot();
			boudary = findAWayToMove(list, gap, startNode);
			boundaryIndex = boudary.getIndex();
			
			while (boudary != null) {
				pass++;
				valueNode = list.newNode(boudary.getElement());
				boundaryIndex = boudary.getIndex();
				trackingIndex = boundaryIndex;
				temp = findAWayToMove(list, trackingIndex - gap, null);
				
				while (trackingIndex > gap -1) {
					cmp++;
					if (temp.getElement() > valueNode.getElement())
						exch++;
					else
						break;
					
					prevInner = findAWayToMove(list, trackingIndex - 1, null);
					tracking = prevInner.getNext();
					prevTemp = findAWayToMove(list, temp.getIndex()-1, null);
					// 2 nodes are next to each other
					if (gap == 1)
						swapNode(prevTemp, temp, tracking);
					//2 nodes have gap > 1
					else {
						swapNode(prevTemp, temp, prevInner, tracking);
					}
					//if exchange node is the root, set the other node to be the root
					if (prevTemp == null)
						list.setRoot(tracking);
					trackingIndex = trackingIndex - gap;
					valueNode = findAWayToMove(list, trackingIndex, null);
					temp = findAWayToMove(list, trackingIndex - gap, null);
				}
				boudary = findAWayToMove(list, boundaryIndex, null);
				boudary = boudary.getNext();
				
			}

			totalCmp += cmp;
			totalExch += exch;
			totalPass += pass;
			k = gap;
			gap = (gap - 1)/3;
			addToOutput(resultList, (k) + "\t" + pass + "\t" + cmp + "\t" + exch);
		}
		addToOutput(resultList, "Total \t" + totalPass + "\t" + totalCmp + "\t" + totalExch);
		printOutput(resultList);
//		controller.writeResult("shellSort", resultList);
	}
	
	private static void addToOutput(ArrayList<String> arr, String context) {
		arr.add(context);
	}
	
	private static void printOutput(ArrayList<String> arr) {
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
		}
	}
}
