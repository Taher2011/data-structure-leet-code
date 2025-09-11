package linkedlist.merge_lists;

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
			// display();
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
		// display();
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

	public void merge(LinkedList otherList) {
		if (head != null) {
			Node dummy = new Node(0);
			Node temp = dummy;

			Node otherHead = otherList.getHead();

			while (head != null && otherHead != null) {
				if (head.value < otherHead.value) {
					temp.next = head;
					head = head.next;
				} else {
					temp.next = otherHead;
					otherHead = otherHead.next;
					length++;
				}
				temp = temp.next;
			}

			while (head != null) {
				temp.next = head;
				head = head.next;
				temp = temp.next;
			}

			while (otherHead != null) {
				temp.next = otherHead;
				otherHead = otherHead.next;
				temp = temp.next;
				length++;
			}

			tail = temp;
			head = dummy.next;
			display();
		}
	}

	public static void main(String[] args) {

		LinkedList l1 = new LinkedList();
		l1.append(3);
		l1.append(5);
		l1.append(7);
		l1.append(9);

		LinkedList l2 = new LinkedList();
		l2.append(4);
		l2.append(6);
		l2.append(8);
		l2.append(10);

		l1.merge(l2);
	}

}
