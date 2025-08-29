package heap_sort;

import java.util.ArrayList;
import java.util.List;

public class HeapSort {

	private List<Integer> heap;

	public HeapSort() {
		heap = new ArrayList<>();
	}

	public List<Integer> getHeap() {
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

	public void swap(int index1, int index2) {
		int temp = heap.get(index2);
		heap.set(index2, heap.get(index1));
		heap.set(index1, temp);
	}

	public void insert(int value) {
		heap.add(value);
		int currentIndex = heap.size() - 1;
		while (heap.get(currentIndex) > heap.get(parent(currentIndex))) {
			swap(currentIndex, parent(currentIndex));
			currentIndex = parent(currentIndex);
		}
	}

	public Integer remove() {
		if (!heap.isEmpty()) {
			if (heap.size() == 1) {
				return heap.remove(0); // Single element, remove and return it
			}
			int removedElement = heap.get(0);
			int lastElement = heap.remove(heap.size() - 1);
			heap.set(0, lastElement);
			sinkDown(0);
			return removedElement;
		}
		return null;
	}

	public void sinkDown(int index) {
		int maxIndex = index;
		while (true) {
			int leftChildIndex = leftChild(maxIndex);
			int rightChildIndex = rightChild(maxIndex);
			if (leftChildIndex < heap.size() && heap.get(maxIndex) < heap.get(leftChildIndex)) {
				maxIndex = leftChildIndex;
			}
			if (rightChildIndex < heap.size() && heap.get(maxIndex) < heap.get(rightChildIndex)) {
				maxIndex = rightChildIndex;
			}
			if (index != maxIndex) {
				swap(index, maxIndex);
				index = maxIndex;
			} else {
				break;
			}
		}
	}

	public List<Integer> heapSort() {
		List<Integer> sortedList = new ArrayList<>();
		HeapSort tempHeap = new HeapSort();
		// tempHeap.heap = new ArrayList<>(heap); // alternate can do this either
		tempHeap.insert(1);
		tempHeap.insert(10);
		tempHeap.insert(2);
		tempHeap.insert(11);
		tempHeap.insert(4);
		tempHeap.insert(5);
		tempHeap.insert(3);
		while (!tempHeap.heap.isEmpty()) {
			sortedList.add(tempHeap.remove());
		}
		return sortedList;
	}

	public static void main(String[] args) {
		HeapSort heap = new HeapSort();
		heap.insert(1);
		heap.insert(10);
		heap.insert(2);
		heap.insert(11);
		heap.insert(4);
		heap.insert(5);
		heap.insert(3);
		System.out.println("Original Heap: " + heap.getHeap());

		System.out.println("==============================");
		System.out.println("Sorted List: " + heap.heapSort());

		System.out.println("==============================");
		System.out.println("Original Heap after sorting: " + heap.getHeap());

		System.out.println("==============================");
		heap.remove();
		System.out.println("Heap after removing one element: " + heap.getHeap());
	}

}
