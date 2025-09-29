package linear.stack.sort_stack;

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

	public static void sortStack(Stack<Integer> stack) {
		Stack<Integer> tempStack = new Stack<>();
		while (!stack.isEmpty()) {
			Integer pop = stack.pop();
			while (!tempStack.isEmpty() && tempStack.peek() > pop) {
				stack.push(tempStack.pop());
			}
			tempStack.push(pop);
		}
		while (!tempStack.isEmpty()) {
			stack.push(tempStack.pop());
		}
	}

	public static void main(String[] args) {
		Stack<Integer> st = new Stack<>();
		st.push(3);
		st.push(1);
		st.push(4);
		st.push(2);
		st.push(6);
		st.push(5);
		System.out.println("Before sorting:");
		st.print();
		sortStack(st);
		System.out.println();
		System.out.println("After sorting:");
		st.print();
	}

}
