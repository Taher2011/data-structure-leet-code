package merge_two_sorted_list;

import java.util.NoSuchElementException;

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

	public void addFirst(int value) {
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
			addFirst(value);
			return;
		}
		tail.next = node;
		tail = node;
		length++;
		display();
	}

	public void add(int index, int value) {
		if (index < 0 || index > length) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + length);
		}
		if (index == 0) {
			addFirst(value);
			return;
		}
		if (index == length) {
			append(value);
			return;
		}
		Node node = new Node(value);
		Node prev = head;
		Node current = head;
		for (int i = 0; i < index; i++) {
			prev = current;
			current = current.next;
		}
		prev.next = node;
		node.next = current;
		length++;
		display();
	}

	public void get(int index) {
		if (index < 0 || index >= length) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + length);
		}
		Node temp = head;
		for (int i = 0; i < index; i++) {
			temp = temp.next;
		}
		System.out.println("value at index " + index + " is : " + temp.value);
		System.out.println("========================================================");
	}

	public void set(int index, int value) {
		if (index < 0 || index >= length) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + length);
		}
		Node temp = head;
		for (int i = 0; i < index; i++) {
			temp = temp.next;
		}
		System.out.println("value " + temp.value + " at index " + index + " is updated with value : " + value);
		temp.value = value;
		display();
	}

	public void removeFirst() {
		if (length == 0) {
			throw new NoSuchElementException();
		}
		Node temp = head;
		int deletedValue = temp.value;
		System.out.println("deleted value from index 0 is : " + deletedValue);
		head = head.next;
		length--;
		temp.next = null;
		temp = null;
		display();
	}

	public void removeLast() {
		if (length == 0) {
			throw new NoSuchElementException();
		}
		Node prev = head;
		Node runner = head;
		while (runner.next != null) {
			prev = runner;
			runner = runner.next;
		}
		int deletedValue = runner.value;
		System.out.println("deleted value from last index is : " + deletedValue);
		runner = null;
		prev.next = null;
		tail = prev;
		length--;
		display();
	}

	public void remove(int index) {
		if (index < 0 || index >= length) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + length);
		}
		if (index == 0) {
			removeFirst();
			return;
		}
		if (index == length - 1) {
			removeLast();
			return;
		}
		Node prev = head;
		Node runner = head;
		for (int i = 0; i < index; i++) {
			prev = runner;
			runner = runner.next;
		}
		int deletedValue = prev.next.value;
		System.out.println("deleted index " + index + " with value : " + deletedValue);
		prev.next = runner.next;
		length--;
		runner.next = null;
		runner = null;
		display();
	}

	private void display() {
		print();
		size();
		getHead();
		getTail();
		System.out.println("========================================================");
	}

	private int size() {
		System.out.println(" || size is : " + length);
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
			Node otherHead = otherList.getHead();
			Node dummy = new Node(0);
			Node temp = dummy;
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
			head = dummy.next;
			tail = temp;
			display();
		}
	}

	public static void main(String[] args) {

		LinkedList l1 = new LinkedList();
		l1.append(3);
		l1.append(5);
		l1.append(7);
		l1.append(10);

		LinkedList l2 = new LinkedList();
		l2.append(4);
		l2.append(6);
		l2.append(8);
		l2.append(9);
		l2.append(11);

		l1.merge(l2);
	}

}
