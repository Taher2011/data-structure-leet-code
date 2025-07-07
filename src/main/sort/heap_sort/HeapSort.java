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

	public void swap(int currentIndex, int parentIndex) {
		int temp = heap.get(parentIndex);
		heap.set(parentIndex, heap.get(currentIndex));
		heap.set(currentIndex, temp);
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
		if (heap.isEmpty()) {
			return null;
		}
		if (heap.size() == 1) {
			return heap.remove(0);
		}
		int remove = heap.get(0);
		heap.set(0, heap.remove(heap.size() - 1));
		sinkDown(0, heap.size());
		return remove;
	}

	public void sinkDown(int index, int size) {
		int maxIndex = index;
		while (true) {
			int leftChildIndex = leftChild(index);
			int rightChildIndex = rightChild(index);
			if (leftChildIndex < size && heap.get(leftChildIndex) > heap.get(index)) {
				maxIndex = leftChildIndex;
			}
			if (rightChildIndex < size && heap.get(rightChildIndex) > heap.get(maxIndex)) {
				maxIndex = rightChildIndex;
			}
			if (maxIndex != index) {
				swap(maxIndex, index);
				index = maxIndex;
			} else {
				break;
			}
		}
	}

	public void heapSort() {
		for (int i = heap.size() - 1; i >= 0; i--) {
			swap(0, i);
			sinkDown(0, i);
		}
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
		System.out.println(heap.getHeap());
		heap.remove();
		System.out.println(heap.getHeap());
		heap.remove();
		System.out.println(heap.getHeap());
		heap.heapSort();
		System.out.println(heap.getHeap());
	}

}
