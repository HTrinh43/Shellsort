package model;

public class LinkedList {
	LinkedNode root;
	LinkedNode middle;
	LinkedNode last;
	int count = 0;
	
	public class LinkedNode {
		private int value;
		private int index;
		LinkedNode next = null;
		
		public LinkedNode(final int value) {
			this.value = value;
		}
		
		public int getElement() {
			return this.value;
		}
		
		public void setElement(final int value) {
			this.value = value;
		}
		
		public LinkedNode getNext() {
			return this.next;
		}
		
		public void setNext(final LinkedNode newNode) {
			this.next = newNode;
		}
		
		public void setIndex(final int index) {
			this.index = index;
		}
		
		public int getIndex() {
			return this.index;
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
		newNode.index = count;
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
	
	public LinkedNode newNode (final int value) {
		return new LinkedNode(value);
	}
}
