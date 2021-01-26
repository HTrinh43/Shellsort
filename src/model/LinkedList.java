package model;

public class LinkedList {
	LinkedNode root;
	LinkedNode middle;
	LinkedNode last;
	int count = 0;
	
	public class LinkedNode {
		private int value;
		LinkedNode next = null;
		
		public LinkedNode(final int value) {
			this.value = value;
		}
		
		public int getElement() {
			return this.value;
		}
		
		public LinkedNode getNext() {
			return this.next;
		}
		
		public void setNext(final LinkedNode newNode) {
			this.next = newNode;
		}
	}
	
	public LinkedNode getRoot() {
		return this.root;
	}
	
	public void setRoot(final LinkedNode thisNode) {
		this.root = thisNode;
	}

	
	public LinkedNode getMiddle() {
		return this.middle;
	}
	
	public int getCount() {
		return this.count;
	}
	
	public void add(final int value) {
		LinkedNode newNode = new LinkedNode(value);
		if (this.root == null) {
			this.root = newNode;
			this.middle = root;
			this.last = root;
			this.count++;
		}
		else {
			this.last.next = newNode;
			this.last = last.next;
			this.count++;
			if (this.count % 2 == 1)
				this.middle = middle.next;	
		}
	}
}
