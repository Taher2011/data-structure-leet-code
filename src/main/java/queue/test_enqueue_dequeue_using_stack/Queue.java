package queue.test_push_pop_using_stack;

public class Queue {

	public Queue() {
	}

	public void enqueue(int value) {
	}

	public Integer dequeue() {
		return null;
	}

	public Integer peek() {
		return null;
	}

	public void getQueue() {
//		Stack<Integer> stack1 = (Stack<Integer>) stack.clone(); // deep copy
//		System.out.print("[");
//		while (!stack1.isEmpty()) {
//			System.out.print(stack1.pop());
//			if (!stack1.isEmpty()) { // last element ke baad comma mat lagao
//				System.out.print(",");
//			}
//		}
//		System.out.println("]");
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
