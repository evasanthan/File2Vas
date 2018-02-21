/*

A Stack contains elements of same type arranged in 
sequential order. All operations takes place at a 
single end that is top of the stack and following 
operations can be performed:

isEmpty()
push()
peek()
pop()
contains()
size()
peekN()

 */
public class Stack {
	
	Node head = null;
	int size = 0;
	
	public boolean isEmpty() {
		return head == null;
	}

	public void push(Object o) {
		if(head == null) {
			head = new Node(o, null);
		} else {
			Node node = new Node(o, head);
			head = node;
		}
		size++;
	}
	
	public Object peek() {
		if(isEmpty()) {
			return null;
		} else {
			return head.value;
		}
	}
	
	public Object peek(int n) {
		if(isEmpty() || n > size - 1) {
			return null;
		} else {
			Node node = head;
			for(int i=0;i<n;i++) {
				node = node.next;
			}
			return node.value;
		}
	}
	
	public Object pop() {
		if(head == null) {
			return null;
		} else {
			size--;
			Object value = head.value;
			head = head.next;
			return value;
		}
	}
	
	private class Node{
		private Node(Object value, Node next) {
			this.value = value;
			this.next = next;
		}
		
		Object value;
		Node next;
	}

	public boolean contains(Object o) {
		Node node = head;
		while(node != null) {
			if(node.value.equals(o)) {
				return true;
			}
			node = node.next;
		}
		return false;
	}

	public int size() {
		return size;
	}
	
}
