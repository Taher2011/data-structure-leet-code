package heap;

import java.util.ArrayList;
import java.util.List;

public class Heap {

	private List<Integer> heap;

	public Heap() {
		heap = new ArrayList<>();
	}

	public List<Integer> getHeapList() {
		return new ArrayList<>(heap);
	}

	public int parent(int index) {
		return (index - 1) / 2;
	}

	public int leftChild(int index) {
		return (index * 2) + 1;
	}

	public int rightChild(int index) {
		return (index * 2) + 2;
	}

	public void swap(int currentIndex, int parentIndex) {
		int temp = heap.get(currentIndex);
		heap.set(currentIndex, heap.get(parentIndex));
		heap.set(parentIndex, temp);
	}

	public void insert(int value) {
		heap.add(value);
		int currentIndex = heap.size() - 1;
		while (currentIndex > 0 && heap.get(currentIndex) > heap.get(parent(currentIndex))) {
			int parentIndex = parent(currentIndex);
			swap(currentIndex, parentIndex);
			currentIndex = parentIndex;
		}
	}

	public Integer remove() {
		if (heap.isEmpty()) {
			return null;
		}
		Integer remove;
		if (heap.size() == 1) {
			remove = heap.remove(0);
			return remove;
		}
		remove = heap.get(0);
		heap.set(0, heap.remove(heap.size() - 1));
		sinkDown(0);
		return remove;
	}

	public void sinkDown(int index) {
		int maxIndex = index;
		while (true) {
			int leftChildIndx = leftChild(index);
			int rightChildIndx = rightChild(index);
			if (leftChildIndx < heap.size() && heap.get(index) < heap.get(leftChildIndx)) {
				maxIndex = leftChildIndx;
			}
			if (rightChildIndx < heap.size() && heap.get(maxIndex) < heap.get(rightChildIndx)) {
				maxIndex = rightChildIndx;
			}
			if (index != maxIndex) {
				swap(maxIndex, index);
				index = maxIndex;
			} else {
				break;
			}
		}
	}

	public void heapSort() {

		// Step 1: Repeatedly remove max and place at end
		List<Integer> sorted = new ArrayList<>();
		while (!heap.isEmpty()) {
			sorted.add(0, remove()); // Remove max and add to sorted list
		}
		// Update heap with sorted list
		heap = sorted;
	}

	public static void main(String[] args) {
		Heap heap = new Heap();
		heap.insert(97);
		heap.insert(59);
		heap.insert(86);
		heap.insert(45);
		heap.insert(44);
		heap.insert(85);
		heap.insert(58);
		System.out.println(heap.getHeapList());
		heap.heapSort();
		System.out.println("After sorting: " + heap.getHeapList());
	}
}
