package middle_node;

public class LinkedList {

	private Node head;
	private Node tail;
	private int length;

	class Node {
		private int value;
		private Node next;

		public Node(int value) {
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
		tail = node;
		length++;
		display();
	}

	public Node removeLast() {
		if (head == null) {
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
		Node prev = temp;
		Node current = temp;
		while (current.next != null) {
			prev = current;
			current = current.next;
		}
		prev.next = null;
		tail = prev;
		length--;
		display();
		return current;
	}

	public Node removeFirst() {
		if (head == null) {
			return null;
		}
		Node temp = head;
		if (length == 1) {
			head = tail = null;
			length--;
			display();
			return temp;
		}
		head = head.next;
		temp.next = null;
		length--;
		display();
		return temp;
	}

	public Node get(int index) {
		if (index >= length || index < 0) {
			return null;
		}
		Node temp = head;
		for (int i = 0; i < index; i++) {
			temp = temp.next;
		}
		return temp;
	}

	public boolean set(int index, int value) {
		if (index >= length || index < 0) {
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
		if (index > length || index < 0) {
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
		Node node = new Node(value);
		Node temp = head;
		Node prev = temp;
		Node current = temp;
		for (int i = 0; i < index; i++) {
			prev = current;
			current = current.next;
		}
		prev.next = node;
		node.next = current;
		length++;
		display();
		return true;
	}

	public Node remove(int index) {
		if (index >= length || index < 0) {
			return null;
		}
		if (index == 0) {
			return removeFirst();
		}
		if (index == length - 1) {
			return removeLast();
		}
		Node temp = head;
		Node prev = temp;
		Node current = temp;
		for (int i = 0; i < index; i++) {
			prev = current;
			current = current.next;
		}
		prev.next = current.next;
		length--;
		display();
		return current;
	}

	public void reverse() {
		if (head != null) {
			Node temp = head;
			head = tail;
			tail = temp;
			Node before = null;
			Node after = null;
			while (temp != null) {
				after = temp.next;
				temp.next = before;
				before = temp;
				temp = after;
			}
			display();
		}
	}

	private void display() {
		print();
		getLength();
		getHead();
		getTail();
		System.out.println("========================================================");
	}

	private int getLength() {
		System.out.println(" || length is : " + length);
		return length;
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

	public Node findMiddleNode() {
		if (head != null) {
			Node slow = head;
			Node fast = head;
			while (fast != null && fast.next != null) {
				slow = slow.next;
				fast = fast.next.next;
			}
			return slow;
		}
		return null;
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.append(1);
		ll.append(2);
		ll.append(3);
		ll.append(4);
		ll.append(5);
		Node middleNode = ll.findMiddleNode();
		if (middleNode != null) {
			System.out.println("middleNode is " + middleNode.value);
		}
	}

}
