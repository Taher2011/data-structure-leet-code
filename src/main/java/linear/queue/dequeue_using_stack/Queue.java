package linear.queue.dequeue_using_stack;

import java.util.Stack;

public class Queue {

	private Stack<Integer> stack;

	public Queue() {
		stack = new Stack<>();
	}

	public void enqueue(int value) {
		Stack<Integer> tempStack = new Stack<>();
		while (!stack.isEmpty()) {
			tempStack.push(stack.pop());
		}
		stack.push(value);
		while (!tempStack.isEmpty()) {
			stack.push(tempStack.pop());
		}
	}

	public Integer dequeue() {
		if (!stack.isEmpty()) {
			return stack.pop();
		}
		return null;
	}

	public Integer peek() {
		if (!stack.isEmpty()) {
			return stack.peek();
		}
		return null;
	}

	public void getQueue() {
		Stack<Integer> stack1 = (Stack<Integer>) stack.clone(); // deep copy
		System.out.print("[");
		while (!stack1.isEmpty()) {
			System.out.print(stack1.pop());
			if (!stack1.isEmpty()) { // last element ke baad comma mat lagao
				System.out.print(",");
			}
		}
		System.out.println("]");
	}

	public static void main(String[] args) {
		Queue q = new Queue();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);

		q.getQueue();

		q.dequeue();

		q.getQueue();
	}

}
