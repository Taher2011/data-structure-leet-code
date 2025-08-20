package test;

public class Stack<T> {

	private Node top;
	private int height;

	private class Node {
		private T value;
		private Node next;

		public Node(T value) {
			this.value = value;
		}
	}

	public void push(T value) {
		Node node = new Node(value);
		if (top == null) {
			top = node;
			height++;
			display();
			return;
		}
		node.next = top;
		top = node;
		height++;
		display();
	}

	public Node pop() {
		if (top != null) {
			Node temp = top;
			top = top.next;
			temp.next = null;
			height--;
			display();
			return temp;
		}
		return null;
	}

	public Node peek() {
		if (top != null) {
			return top;
		}
		return null;
	}

	public boolean isEmpty() {
		return height == 0;
	}

	private void display() {
		print();
		height();
		getTop();
		System.out.println("========================================================");
	}

	public void print() {
		if (top == null) {
			System.out.print("[ ]");
			return;
		}
		System.out.print("[");
		Node tempNode = top;
		while (tempNode.next != null) {
			System.out.print(tempNode.value + " ");
			tempNode = tempNode.next;
		}
		System.out.print(tempNode.value + "]");
	}

	public void height() {
		System.out.println(" || height is : " + height);
	}

	public Node getTop() {
		if (top == null) {
			System.out.println("top is pointing to : " + null);
			return null;
		}
		System.out.println("top is pointing to : " + top.value);
		return top;
	}

	public static boolean isBalancedParentheses(String str) {
		return false;
	}

	public static String reverseString(String string) {
		return null;
	}

	public static void sortStack(Stack<Integer> stack) {

	}

	public static void main(String[] args) {
		Stack<Integer> st = new Stack<>();
		st.push(1);
		st.push(2);
		st.push(3);
		System.out.println("value at top is " + st.peek().value);
		System.out.println("========================================================");
		st.pop();
		System.out.println("value at top is " + st.peek().value);
		System.out.println("========================================================");
	}
}
