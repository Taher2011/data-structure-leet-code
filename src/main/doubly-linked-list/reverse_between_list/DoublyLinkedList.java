package reverse_between_list;

public class DoublyLinkedList {

	private Node head;
	private Node tail;
	private int length;

	class Node {
		private int value;
		private Node next;
		private Node prev;

		public Node(int value) {
			super();
			this.value = value;
		}
	}

	public void prepend(int value) {
		Node node = new Node(value);
		if (head == null) {
			head = tail = node;
			length++;
			display();
			return;
		}
		node.next = head;
		head.prev = node;
		head = node;
		length++;
		display();
	}

	public void append(int value) {
		Node node = new Node(value);
		if (head == null) {
			head = tail = node;
			length++;
			display();
			return;
		}
		tail.next = node;
		node.prev = tail;
		tail = node;
		length++;
		display();
		return;
	}

	public Node removeFirst() {
		if (head == null) {
			return null;
		}
		Node temp = head;
		if (head == tail) {
			head = tail = null;
			length--;
			display();
			return temp;
		}
		head = head.next;
		head.prev = null;
		length--;
		display();
		return temp;
	}

	public Node removeLast() {
		if (head == null) {
			return null;
		}
		Node temp = tail;
		if (head == tail) {
			head = tail = null;
			length--;
			display();
			return temp;
		}
		tail = tail.prev;
		tail.next = null;
		length--;
		display();
		return temp;
	}

	public Node get(int index) {
		if (index < 0 || index >= length) {
			return null;
		}
		Node temp = head;
		for (int i = 0; i < index; i++) {
			temp = temp.next;
		}
		return temp;
	}

	public boolean set(int index, int value) {
		if (index < 0 || index >= length) {
			return false;
		}
		Node temp = head;
		for (int i = 0; i < index; i++) {
			temp = temp.next;
		}
		temp.value = value;
		display();
		return true;
	}

	public boolean insert(int index, int value) {
		if (index < 0 || index > length) {
			return false;
		}
		if (index == 0) {
			prepend(value);
			return true;
		}
		if (index == length) {
			append(value);
			return true;
		}
		Node newNode = new Node(value);
		Node previous = head;
		Node node = head;
		for (int i = 0; i < index; i++) {
			previous = node;
			node = node.next;
		}
		previous.next = newNode;
		newNode.prev = previous;
		newNode.next = node;
		node.prev = newNode;
		length++;
		display();
		return true;
	}

	public Node remove(int index) {
		if (index < 0 || index >= length) {
			return null;
		}
		if (index == 0) {
			return removeFirst();
		}
		if (index == length - 1) {
			return removeLast();
		}
		Node previous = head;
		Node node = head;
		for (int i = 0; i < index; i++) {
			previous = node;
			node = node.next;
		}
		Node temp = node;
		previous.next = node.next;
		node.next.prev = previous;
		length--;
		display();
		return temp;
	}

	private void display() {
		print();
		length();
		getHead();
		getTail();
		System.out.println("========================================================");
	}

	private void length() {
		System.out.println(" || length is : " + length);
	}

	private Node getHead() {
		if (head == null) {
			System.out.println("head is pointing to : " + null);
			return null;
		}
		System.out.println("head is pointing to : " + head.value);
		return head;
	}

	private Node getTail() {
		if (head == null) {
			System.out.println("tail is pointing to : " + null);
			return null;
		}
		System.out.println("tail is pointing to : " + tail.value);
		return tail;
	}

	private void print() {
		if (head == null) {
			System.out.print("[ ]");
			return;
		}
		System.out.print("[");
		Node tempNode = head;
		while (tempNode.next != null) {
			System.out.print(tempNode.value + " ");
			tempNode = tempNode.next;
		}
		System.out.print(tempNode.value + "]");
		tempNode = null;
	}

	public void reverseBetween(int startIndex, int endIndex) {
		if (head != null) {
			Node dummy = new Node(0);
			dummy.next = head;
			Node previous = dummy;
			for (int i = 0; i < startIndex; i++) {
				previous = previous.next;
			}
			Node current = previous.next;
			int iteration = endIndex - startIndex;
			for (int i = 0; i < iteration; i++) {
				Node nodeToMove = current.next;
				current.next = nodeToMove.next;
				if (nodeToMove.next != null) {
					nodeToMove.next.prev = current;
				}
				nodeToMove.next = previous.next;
				previous.next.prev = nodeToMove;
				previous.next = nodeToMove;
				nodeToMove.prev = previous;
			}
			head = dummy.next;
			head.prev = null;
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			tail = temp;
			display();
		}
	}

	public static void main(String[] args) {
		DoublyLinkedList ddl = new DoublyLinkedList();
		ddl.append(1);
		ddl.append(2);
		ddl.append(3);
		ddl.append(4);
		ddl.append(5);
		ddl.reverseBetween(0, 4);
	}

}
