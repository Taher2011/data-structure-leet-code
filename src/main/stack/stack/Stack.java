package stack;

public class Stack {

	private Node top;
	private int height;

	class Node {
		private int value;
		private Node next;

		public Node(int value) {
			this.value = value;
		}
	}

	public void push(int value) {
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
		if (top == null) {
			return null;
		}
		Node temp = top;
		top = top.next;
		height--;
		display();
		return temp;
	}

	public Node peek() {
		if (top == null) {
			return null;
		}
		return top;
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

	public static void main(String[] args) {
		Stack st = new Stack();
		st.push(1);
		st.push(2);
		st.push(3);
		System.out.println(st.peek().value);
		st.pop();
		System.out.println(st.peek().value);
	}
}
