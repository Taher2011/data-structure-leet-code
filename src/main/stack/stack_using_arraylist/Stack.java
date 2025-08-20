package stack_using_arraylist;

import java.util.ArrayList;
import java.util.List;

public class Stack<T> {

	private List<T> list;

	public Stack() {
		this.list = new ArrayList<>();
	}

	private void getList() {
		System.out.print("[");
		for (int i = list.size() - 1; i >= 0; i--) {
			System.out.print(list.get(i));
			if (i != 0) {
				System.out.print(",");
			}
		}
		System.out.println("]");
	}

	public void push(T value) {
		list.add(value);
	}

	public T pop() {
		if (!isEmpty()) {
			return list.remove(list.size() - 1);
		}
		return null;
	}

	public T peek() {
		if (!isEmpty()) {
			return list.get(list.size() - 1);
		}
		return null;
	}

	public int size() {
		return list.size();
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
