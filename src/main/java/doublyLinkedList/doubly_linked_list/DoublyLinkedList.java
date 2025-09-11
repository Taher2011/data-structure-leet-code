package doublyLinkedList.doubly_linked_list;

public class DoublyLinkedList {

	private Node head;
	private Node tail;
	private int length;

	private class Node {
		private int value;
		private Node next;
		private Node prev;

		public Node(int value) {
			this.value = value;
		}
	}

	public void append(int value) {
		Node node = new Node(value);
		if (head == null) {
			prepend(value);
			return;
		}
		tail.next = node;
		node.prev = tail;
		tail = node;
		length++;
		display();
	}

	public void prepend(int value) {
		Node node = new Node(value);
		if (head == null) {
			head = tail = node;
			length++;
			display();
			return;
		}
		head.prev = node;
		node.next = head;
		head = node;
		length++;
		display();
	}

	public Node removeLast() {
		Node temp = head;
		if (length == 0) {
			return null;
		}
		if (length == 1) {
			removeFirst();
			return temp;
		}
		Node previous = temp;
		Node current = temp;
		while (current.next != null) {
			previous = current;
			current = current.next;
		}
		previous.next = null;
		current.prev = null;
		tail = previous;
		length--;
		display();
		return current;
	}

	public Node removeFirst() {
		Node temp = head;
		if (length == 0) {
			return null;
		}
		if (length == 1) {
			head = tail = null;
			length--;
			display();
			return temp;
		}
		head = head.next;
		temp.next = null;
		head.prev = null;
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
		Node previous = head;
		Node current = head;
		Node node = new Node(value);
		for (int i = 0; i < index; i++) {
			previous = current;
			current = current.next;
		}
		previous.next = node;
		node.prev = previous;

		node.next = current;
		current.prev = node;

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
		Node current = head;
		for (int i = 0; i < index; i++) {
			previous = current;
			current = current.next;
		}
		previous.next = current.next;
		current.next.prev = previous;

		current.next = null;
		current.prev = null;

		length--;
		display();
		return current;
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

	public static void main(String[] args) {
		DoublyLinkedList dll = new DoublyLinkedList();
		dll.append(0);
		dll.append(1);
		dll.append(2);
		dll.append(3);
		dll.append(4);
		dll.append(5);
	}
}
