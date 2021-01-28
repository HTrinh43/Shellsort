package controller;
import java.util.ArrayList;
import java.util.Arrays;

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
	
	public void shellSort(LinkedList list) {
		//
		int interval = 1;
		int size = list.getCount();
		while (interval < size/3) {
			interval = interval * 3 + 1;
		}
//		LinkedNode prevInner;
		LinkedNode outer;
		LinkedNode inner;

		LinkedNode startNode;
		LinkedNode valueNode, prevValue;
		LinkedNode temp;
		LinkedNode prevTemp;
		int outerIndex, innerIndex;
		ArrayList<String> resultList = new ArrayList<String>();
		controller controller = new controller();
		boolean isRoot = false;
		while (interval > 0) {
			//setup nodeA and node
			startNode = list.getRoot();
			outer = findAWayToMove(list, interval, startNode);
			outerIndex = outer.getIndex();
			
			while (outer != null) {
				valueNode = list.newNode(outer.getElement());
//				prevValue = findAWayToMove(list, valueNode.getIndex() - 1, null);
				outerIndex = outer.getIndex();
				innerIndex = outerIndex;
				inner = outer;
				temp = findAWayToMove(list, innerIndex - interval, null);
				prevTemp = findAWayToMove(list, temp.getIndex() - 1, null);
				isRoot = prevTemp == null;
				System.out.println("new loop");
				while (innerIndex >= interval  && temp.getElement() >= valueNode.getElement()) {
					inner = findAWayToMove(list, innerIndex, null);
					LinkedNode newNode = list.newNode(temp.getElement());
					replaceNode(list, inner, newNode);
					System.out.println("Replace: " + inner.getElement() + " at index " + inner.getIndex() 
					+ " to " + newNode.getElement());
					newNode = null;
					innerIndex = innerIndex - interval;
					temp = findAWayToMove(list, innerIndex - interval, null);
//					if (interval == 1) {
//						swapNode(prevTemp,temp,valueNode);
//					}
//					else {
//						swapNode(prevTemp, temp, prevValue, valueNode);
//					}
//					if (prevTemp == null && temp.getElement() > valueNode.getElement()) {
//						list.setRoot(valueNode);
//					}
					

//					valueNode = temp;
//					inner = temp;
//					inner = findAWayToMove(list, inner.getIndex() - interval, null);
//					temp = inner;
//					prevTemp = findAWayToMove(list, temp.getIndex() - 1, temp);
					

					
//					System.out.println("Inner loop: ");
//					System.out.println("temp index: " + temp.getIndex() + " temp value: " + temp.getElement());
//					System.out.println("inner: " +inner.getIndex() + " inner value: " + inner.getElement());
//					System.out.println("value: " + valueNode.getIndex()+ " valueNode value: " + valueNode.getElement());
//					System.out.println("outer: " + outer.getIndex()+ " outer value: " + outer.getElement());
//					System.out.println("root: "+ list.getRoot().getElement() + " " + list.getRoot().getNext().getElement());
					System.out.println("list: "+ controller.displayList(list));
//					System.out.println("root: "+ list.getRoot().getElement());
//					System.out.println();
				}
			inner = findAWayToMove(list, innerIndex, null);
			replaceNode(list, inner, valueNode);
			if (isRoot) {
				list.setRoot(valueNode);
			}
			System.out.println("list: "+ controller.displayList(list));
			System.out.println();
			//				prevA = nodeA;
//			prevB = nodeB;
//			nodeA = nodeA.getNext();
//			nodeB = nodeB.getNext();
			outer = findAWayToMove(list, outerIndex, null);
			outer = outer.getNext();
			}
			interval = interval == 2 ? 1 : (interval - 1)/3;
			resultList.add(controller.displayList(list));
		}
		System.out.println("list: "+ controller.displayList(list));
		controller.writeResult("shellSort", resultList);
	}
	
	private void replaceNode(final LinkedList list, final LinkedNode current, final LinkedNode replacedNode) {
		LinkedNode prev = findAWayToMove(list, current.getIndex()-1, null);
		replacedNode.setNext(current.getNext());
		if (prev != null)
			prev.setNext(replacedNode);
		
		
		replacedNode.setIndex(current.getIndex());
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
	
	public void shellsortArray(int[] a) {
		int size = a.length;
		int increment = 1;
		while (increment < size/3) {
			increment = increment * 3 + 1;
		}
		 System.out.println(Arrays.toString(a));
		while (increment > 0) {
			for (int i = increment; i < a.length; i++) {
				int j = i;
				int temp = a[i];
				while (j >= increment && a[j - increment] > temp) {
					a[j] = a[j - increment];
					j = j - increment;
					System.out.println("j = "+ j);
				}
				a[j] = temp;
				System.out.println("i = " + i);
		        System.out.println(Arrays.toString(a));
		        System.out.println();
			}
			if (increment == 2) {
				increment = 1;
			} else {
				increment = (increment - 1)/3;
			}
		}
	}
}
