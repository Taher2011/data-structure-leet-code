package stack_using_arraylist;

import java.util.ArrayList;
import java.util.List;

public class Stack<T> {

	private ArrayList<T> stackList;

	public Stack() {
		this.stackList = new ArrayList<>();
	}

	public void push(T value) {
		stackList.add(value);
	}

	public T pop() {
		if (stackList.isEmpty()) {
			return null;
		}
		return stackList.remove(size() - 1);
	}

	public List<T> getStackList() {
		List<T> list = new ArrayList<>();
		for (int i = size() - 1; i >= 0; i--) {
			list.add(stackList.get(i));
		}
		return new ArrayList<>(list);
	}

	public int size() {
		return stackList.size();
	}

	public T peek() {
		if (!stackList.isEmpty()) {
			return stackList.get(size() - 1);
		}
		return null;
	}

	public boolean isEmpty() {
		return stackList.isEmpty();
	}

	public static void main(String[] args) {
		Stack<Integer> st = new Stack<>();
		st.push(1);
		st.push(2);
		st.push(3);
		System.out.println(st.getStackList());
		System.out.println(st.peek());
		System.out.println(st.pop());
		System.out.println(st.getStackList());
	}
}
