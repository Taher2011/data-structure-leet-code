package heap;

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
		return index * 2 + 1;
	}

	public int rightChild(int index) {
		return index * 2 + 2;
	}

	public int parent(int index) {
		return (index - 1) / 2;
	}

	public void swap(int currentIndex, int parentIndex) {
		int temp = heap.get(currentIndex);
		heap.set(currentIndex, heap.get(parent(currentIndex)));
		heap.set(parentIndex, temp);
	}

	public void insert(int value) {
		heap.add(value);
		int currentIndex = heap.size() - 1;
		while (currentIndex > 0 && heap.get(currentIndex) > heap.get(parent(currentIndex))) {
			swap(currentIndex, parent(currentIndex));
			currentIndex = parent(currentIndex);
		}
	}

	public Integer remove() {
		if (heap.isEmpty()) {
			return null;
		}
		if (heap.size() == 1) {
			return heap.remove(0);
		}
		int removed = heap.get(0);
		int last = heap.remove(heap.size() - 1);
		heap.set(0, last);
		sinkDown(0);
		return removed;
	}

	public void sinkDown(int index) {
		int maxIndex = index;
		while (true) {
			int leftChildIndex = leftChild(maxIndex);
			int rightChildIndex = rightChild(maxIndex);

			if (leftChildIndex < heap.size() && heap.get(leftChildIndex) > heap.get(maxIndex)) {
				maxIndex = leftChildIndex;
			}

			if (rightChildIndex < heap.size() && heap.get(rightChildIndex) > heap.get(maxIndex)) {
				maxIndex = rightChildIndex;
			}
			if (index != maxIndex) {
				swap(maxIndex, index);
				index = maxIndex;
			} else {
				break;
			}
		}
	}

	public List<Integer> heapSort() {
		List<Integer> heap1 = new ArrayList<>(heap);
		int size = heap1.size();
		while (size > 0) {
			int removed = heap1.get(0);
			int last = heap1.get(size - 1);
			heap1.set(0, last);
			heap1.set(size - 1, removed);
			sinkDown(0, size - 1, heap1);
			size--;
		}
		return heap1;

//		// Step 1: Repeatedly remove max and place at end
//				List<Integer> sorted = new ArrayList<>();
//				while (!heap.isEmpty()) {
//					sorted.add(0, remove()); // Remove max and add to sorted list
//				}
//				// Update heap with sorted list
//				heap = sorted;
	}

	public void swap(int currentIndex, int parentIndex, List<Integer> heap) {
		int temp = heap.get(currentIndex);
		heap.set(currentIndex, heap.get(parent(currentIndex)));
		heap.set(parentIndex, temp);
	}

	public void sinkDown(int index, int size, List<Integer> heap) {
		int maxIndex = index;
		while (true) {
			int leftChildIndex = leftChild(maxIndex);
			int rightChildIndex = rightChild(maxIndex);

			if (leftChildIndex < size && heap.get(leftChildIndex) > heap.get(maxIndex)) {
				maxIndex = leftChildIndex;
			}

			if (rightChildIndex < size && heap.get(rightChildIndex) > heap.get(maxIndex)) {
				maxIndex = rightChildIndex;
			}
			if (index != maxIndex) {
				swap(maxIndex, index, heap);
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
		heap.remove();
		System.out.println(heap.getHeap());
		List<Integer> heapSort = heap.heapSort();
		System.out.println(heapSort);
		heap.remove();
		System.out.println(heap.getHeap());
		heapSort = heap.heapSort();
		System.out.println(heapSort);
	}
}
