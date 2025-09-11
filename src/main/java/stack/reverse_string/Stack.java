package stack.reverse_string;

public class Stack<T> {

	private Node top;
	private int height;

	class Node {
		private T value;
		private Node next;

		public Node(T value) {
			this.value = value;
		}
	}

	public void push(T value) {
		Node node = new Node(value);
		node.next = top;
		top = node;
		height++;
		// display();
	}

	public T pop() {
		if (top != null) {
			Node temp = top;
			top = top.next;
			temp.next = null;
			height--;
			// display();
			return temp.value;
		}
		return null;
	}

	public T peek() {
		if (top != null) {
			return top.value;
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

	public static String reverseString(String string) {
		StringBuilder reverseString = new StringBuilder();
		Stack<Character> st = new Stack<>();
		char[] ch = string.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			st.push(ch[i]);
		}
		while (!st.isEmpty()) {
			reverseString.append(st.pop());
		}
		return reverseString.toString();
	}

	public static void main(String[] args) {
		Stack<String> st = new Stack<>();
		System.out.println(st.reverseString("taher"));
	}

}
