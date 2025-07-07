package enqueue_using_stack;

import java.util.Stack;

public class Queue {

	private Stack<Integer> stack1;
	private Stack<Integer> stack2;

	public Queue() {
		stack1 = new Stack<>();
		stack2 = new Stack<>();
	}

	public boolean isEmpty() {
		return stack1.isEmpty();
	}

	public void enqueue(int value) {
		while (!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		stack1.push(value);
		while (!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}
	}

	public Integer peek() {
		if (stack1.isEmpty()) {
			return null;
		}
		return stack1.peek();
	}

	public Integer dequeue() {
		if (stack1.isEmpty()) {
			return null;
		}
		return stack1.pop();
	}

	public int size() {
		return stack1.size();
	}

	public Stack<Integer> getStack1() {
		return stack1;
	}

	public static void main(String[] args) {
		Queue q = new Queue();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		System.out.println(q.getStack1());

		q.dequeue();
		System.out.println(q.getStack1());
		q.dequeue();
		System.out.println(q.getStack1());
		q.dequeue();
		System.out.println(q.getStack1());
		q.dequeue();
		System.out.println(q.getStack1());
		q.dequeue();
		System.out.println(q.getStack1());
		System.out.println(q.peek());
		q.dequeue();
		System.out.println(q.getStack1());
	}
}
