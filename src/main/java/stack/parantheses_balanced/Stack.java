package stack.parantheses_balanced;

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

	public static boolean isBalancedParentheses(String str) {
		Stack<Character> st = new Stack<>();
		char[] ch = str.toCharArray();
		for (char c : ch) {
			if (c == '(') {
				st.push(c);
			} else if (c == ')' && !st.isEmpty()) {
				st.pop();
			} else {
				return false;
			}
		}
		return st.isEmpty();
	}

	public static void main(String[] args) {
		testAndPrint("()", true);
		testAndPrint("()()", true);
		testAndPrint("(())", true);
		testAndPrint("()()()", true);
		testAndPrint("(()())", true);
		testAndPrint(")()(", false);
		testAndPrint(")(", false);
		testAndPrint("(()", false);
		testAndPrint("))", false);
		testAndPrint("(", false);
		testAndPrint(")", false);
	}

	public static void testAndPrint(String testStr, boolean expected) {
		// Run the test and store the result
		boolean result = isBalancedParentheses(testStr);

		// Print the test string, expected result, and actual result
		System.out.println("Test String: " + testStr);
		System.out.println("EXPECTED: " + expected);
		System.out.println("RESULT: " + result);

		// Check if the test passed or failed
		if (result == expected) {
			System.out.println("STATUS: PASS");
		} else {
			System.out.println("STATUS: FAIL");
		}

		// Print a separator for better readability
		System.out.println("--------------");
	}

}
