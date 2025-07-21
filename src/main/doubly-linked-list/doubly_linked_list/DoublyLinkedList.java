package doubly_linked_list;

public class DoublyLinkedList {

	private Node head;
	private Node tail;
	private int length;

	class Node {
		private int value;
		private Node next;
		private Node prev;

		public Node(int value) {
			this.value = value;
		}
	}

	public void prepend(int value) {
		Node node = new Node(value);
		if (head == null) {
			head = tail = node;
			length++;
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
			prepend(value);
			return;
		}
		tail.next = node;
		node.prev = tail;
		tail = node;
		length++;
		display();
	}

	public Node removeFirst() {
		if (length == 0) {
			return null;
		}
		if (length == 1) {
			Node temp = head;
			head = tail = null;
			length--;
			display();
			return temp;
		}
		Node temp = head;
		head = head.next;
		head.prev = null;
		temp.next = null;
		length--;
		display();
		return temp;
	}

	public Node removeLast() {
		if (length == 0) {
			return null;
		}
		if (length == 1) {
			Node temp = head;
			head = tail = null;
			length--;
			display();
			return temp;
		}
		Node temp = tail;
		tail = tail.prev;
		tail.next = null;
		temp.prev = null;
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
		Node prev = head;
		Node node = new Node(value);
		Node current = head;
		for (int i = 0; i < index; i++) {
			prev = current;
			current = current.next;
		}
		prev.next = node;
		node.prev = prev;
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
		Node temp = null;
		if (index == 0) {
			temp = removeFirst();
			return temp;
		}
		if (index == length - 1) {
			temp = removeLast();
			return temp;
		}
		Node prev = head;
		Node current = head;
		for (int i = 0; i < index; i++) {
			prev = current;
			current = current.next;
		}
		temp = current;
		prev.next = current.next;
		current.next.prev = prev;
		temp.next = null;
		temp.prev = null;
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

	public static void main(String[] args) {
		DoublyLinkedList dll = new DoublyLinkedList();
		dll.append(0);
		dll.append(1);
		dll.append(2);
		dll.append(3);
		dll.append(4);
	}
}
