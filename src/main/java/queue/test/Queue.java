package queue.test;

public class Queue {

	private class Node {
	}

	public void enqueue(int value) {
	}

	public Node dequeue() {
		return null;
	}

//	private void display() {
//		print();
//		length();
//		getFirst();
//		getLast();
//		System.out.println("========================================================");
//	}
//
//	public void print() {
//		if (first == null) {
//			System.out.print("[ ]");
//			return;
//		}
//		System.out.print("[");
//		Node temp = first;
//		while (temp.next != null) {
//			System.out.print(temp.value + " ");
//			temp = temp.next;
//		}
//		System.out.print(temp.value + "]");
//	}
//
//	public int length() {
//		System.out.println(" || length is : " + length);
//		return length;
//	}
//
//	public Node getFirst() {
//		if (first == null) {
//			System.out.println("first is pointing to : " + null);
//			return null;
//		}
//		System.out.println("first is pointing to : " + first.value);
//		return first;
//	}
//
//	public Node getLast() {
//		if (first == null) {
//			System.out.println("last is pointing to : " + null);
//			return null;
//		}
//		System.out.println("last  is pointing to : " + last.value);
//		return last;
//	}

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
