package model;

public class LinkedNode {
	Node root = null;
	int count = 0;
	
	public class Node{
		private int value;
		Node next= null;
		
		public Node(final int value) {
			this.value = value;
		}
		
		public Node() {
//			this.value = 0;
		}
		
		public void setNext(final Node node) {
			this.next = node;
		}
		
		public void setElement(final int element) {
			this.value = element;
		}
		
		public int getElement() {
			return this.value;
		}
		
		public Node getNext(){
			return this.next;
		}
	}
	
	public Node getRoot() {
		return this.root;
	}
	
	public Node newNode() {
		return new Node();
	}
		
	

}
