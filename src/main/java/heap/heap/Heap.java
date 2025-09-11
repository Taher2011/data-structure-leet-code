package heap.heap;

import java.util.ArrayList;
import java.util.List;

public class Heap {

	private List<Integer> heap;

	public Heap() {
		this.heap = new ArrayList<>();
	}

	public List<Integer> getHeap() {
		return new ArrayList<>(heap);
	}

	public int leftChild(int index) {
		return (index * 2) + 1;
	}

	public int rightChild(int index) {
		return (index * 2) + 2;
	}

	public int parent(int index) {
		int parentIndex = (index - 1) / 2;
		return parentIndex;
	}

	public void swap(int index1, int index2) {
		int temp = heap.get(index2);
		heap.set(index2, heap.get(index1));
		heap.set(index1, temp);
	}

	public void insert(int value) {
		if (heap.isEmpty()) {
			heap.add(value);
			return;
		}
		heap.add(value);
		int currentIndex = heap.size() - 1;
		while (currentIndex != 0 && heap.get(currentIndex) > heap.get(parent(currentIndex))) {
			swap(currentIndex, parent(currentIndex));
			currentIndex = parent(currentIndex);
		}
	}

	public Integer remove() {
		if (!heap.isEmpty()) {
			if (heap.size() == 1) {
				return heap.remove(0);
			}
			int removedValue = heap.get(0);
			int lastValue = heap.remove(heap.size() - 1);
			heap.set(0, lastValue);
			sinkDown(0);
			return removedValue;
		}
		return null;
	}

	public void sinkDown(int index) {
		int maxIndex = index;
		while (true) {
			int leftChild = leftChild(maxIndex);
			int rightChild = rightChild(maxIndex);
			if (leftChild < heap.size() && heap.get(maxIndex) < heap.get(leftChild)) {
				maxIndex = leftChild;
			}
			if (rightChild < heap.size() && heap.get(maxIndex) < heap.get(rightChild)) {
				maxIndex = rightChild;
			}
			if (index != maxIndex) {
				swap(maxIndex, index);
				index = maxIndex;
			} else {
				break;
			}
		}
	}

	public static void main(String[] args) {
		Heap heap = new Heap();
		heap.insert(80);
		heap.insert(100);
		heap.insert(101);
		heap.insert(70);
		heap.insert(54);
		heap.insert(95);
		heap.insert(64);
		System.out.println(heap.getHeap());

		System.out.println("==============================");
		heap.remove();
		System.out.println(heap.getHeap());

		System.out.println("==============================");
		heap.remove();
		System.out.println(heap.getHeap());

		System.out.println("==============================");

	}

}
