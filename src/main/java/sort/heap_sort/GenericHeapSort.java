package sort.heap_sort;

import java.util.ArrayList;
import java.util.List;

public class GenericHeapSort<T extends Comparable<T>> {

	private List<T> heap;

	public GenericHeapSort() {
		heap = new ArrayList<>();
	}

	public List<T> getHeap() {
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
		T temp = heap.get(index2);
		heap.set(index2, heap.get(index1));
		heap.set(index1, temp);
	}

	public void insert(T value) {
		heap.add(value);
		int currentIndex = heap.size() - 1;
		while (heap.get(currentIndex).compareTo(heap.get(parent(currentIndex))) > 0) {
			swap(currentIndex, parent(currentIndex));
			currentIndex = parent(currentIndex);
		}
	}

	public T remove() {
		if (!heap.isEmpty()) {
			if (heap.size() == 1) {
				return heap.remove(0); // Single element, remove and return it
			}
			T removedElement = heap.get(0);
			T lastElement = heap.remove(heap.size() - 1);
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
			if (leftChildIndex < heap.size() && heap.get(maxIndex).compareTo(heap.get(leftChildIndex)) < 0) {
				maxIndex = leftChildIndex;
			}
			if (rightChildIndex < heap.size() && heap.get(maxIndex).compareTo(heap.get(rightChildIndex)) < 0) {
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

	public List<String> heapSort() {
		List<String> sortedList = new ArrayList<>();
		GenericHeapSort<String> tempHeap = new GenericHeapSort<>();
		// tempHeap.heap = new ArrayList<>(heap); // alternate can do this either
		tempHeap.insert("V");
		tempHeap.insert("Ba");
		tempHeap.insert("C");
		tempHeap.insert("W");
		tempHeap.insert("A");
		tempHeap.insert("Bb");
		tempHeap.insert("C");
		while (!tempHeap.heap.isEmpty()) {
			sortedList.add(tempHeap.remove());
		}
		return sortedList;
	}

	public static void main(String[] args) {
		GenericHeapSort<Integer> heap = new GenericHeapSort<>();
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
