package queue;

public class Queue {

	private Node first;
	private Node last;
	private int length;

	private class Node {
		private int value;
		private Node next;

		public Node(int value) {
			this.value = value;
		}
	}

	public void enqueue(int value) {
		Node node = new Node(value);
		if (first == null) {
			first = last = node;
			length++;
			display();
			return;
		}
		last.next = node;
		last = node;
		length++;
		display();
	}

	public Node dequeue() {
		if (first == null) {
			return null;
		}
		Node temp = first;
		if (length == 1) {
			first = last = null;
			length--;
			display();
			return temp;
		}
		first = first.next;
		temp.next = null;
		length--;
		display();
		return temp;
	}

	private void display() {
		print();
		length();
		getFirst();
		getLast();
		System.out.println("========================================================");
	}

	public void print() {
		if (first == null) {
			System.out.print("[ ]");
			return;
		}
		System.out.print("[");
		Node temp = first;
		while (temp.next != null) {
			System.out.print(temp.value + " ");
			temp = temp.next;
		}
		System.out.print(temp.value + "]");
	}

	public int length() {
		System.out.println(" || length is : " + length);
		return length;
	}

	public Node getFirst() {
		if (first == null) {
			System.out.println("first is pointing to : " + null);
			return null;
		}
		System.out.println("first is pointing to : " + first.value);
		return first;
	}

	public Node getLast() {
		if (first == null) {
			System.out.println("last is pointing to : " + null);
			return null;
		}
		System.out.println("last  is pointing to : " + last.value);
		return last;
	}

	public static void main(String[] args) {
		Queue q = new Queue();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.dequeue();
		q.dequeue();
		q.dequeue();
	}
}
