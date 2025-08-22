package test_using_arraylist;

public class Stack<T> {

	public Stack() {

	}

	private void getList() {
	}

	public void push(T value) {
	}

	public T pop() {

		return null;
	}

	public T peek() {

		return null;
	}

	public int size() {
		return 0;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public static void main(String[] args) {
		Stack<Integer> st = new Stack<>();
		st.push(1);
		st.push(2);
		st.push(3);
		st.getList();
		System.out.println(st.pop());
		st.getList();
	}
}
