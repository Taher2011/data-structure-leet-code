package linear.doublyLinkedList.partition_list;

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

	public void partitionList(int x) {
		if (head != null) {
			Node dummy1 = new Node(0);
			Node dummy2 = new Node(0);

			Node partition1 = dummy1;
			Node partition2 = dummy2;

			Node temp = head;

			while (temp != null) {
				Node node = new Node(temp.value);
				if (temp.value < x) {
					partition1.next = node;
					node.prev = partition1;
					partition1 = partition1.next;
				} else {
					partition2.next = node;
					node.prev = partition2;
					partition2 = partition2.next;
				}
				temp = temp.next;
			}

			partition1.next = dummy2.next;
			if (dummy2.next != null) {
				dummy2.next.prev = partition1;
			}

			if (partition2.value != 0) {
				tail = partition2;
			}

			head = dummy1.next;
			head.prev = null;
			display();
		}
	}

	public static void main(String[] args) {
		DoublyLinkedList ddl = new DoublyLinkedList();
		ddl.append(3);
		ddl.append(8);
		ddl.append(5);
		ddl.append(10);
		ddl.append(2);
		ddl.append(1);
		ddl.partitionList(5);

//		DoublyLinkedList ddl1 = new DoublyLinkedList();
//		ddl1.append(1);
//		ddl1.append(2);
//		ddl1.append(3);
//		ddl1.partitionList(5);

//		DoublyLinkedList ddl2 = new DoublyLinkedList();
//		ddl2.append(6);
//		ddl2.append(7);
//		ddl2.append(8);
//		ddl2.partitionList(5);
	}

}
