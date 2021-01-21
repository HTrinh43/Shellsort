package model;

public class LinkedNode {
	Node root = null;
	int count = 0;
	
	public LinkedNode() {
		root = new Node();
	}
	public class Node{
		private int value;
		Node next= null;
		
		public Node(final int value) {
			this.value = value;
		}
		
		public Node() {
		}
		
		public void setNext(final Node node) {
			this.next = node;
			LinkedNode.this.addCount();
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
	
	public Node newNode(int value) {
		return new Node(value);
	}
	private void addCount() {
		this.count++;
	}
	
	public void setRoot(Node newRoot) {
		this.root = newRoot;
	}
	
	public int getCount() {
		return this.count;
	}
		
	

}
