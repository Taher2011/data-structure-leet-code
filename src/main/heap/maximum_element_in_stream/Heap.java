package maximum_element_in_stream;

import java.util.ArrayList;
import java.util.List;

public class Heap {

	private List<Integer> heap;

	public Heap() {
		heap = new ArrayList<>();
	}

	public List<Integer> getHeap() {
		return new ArrayList<>(heap);
	}

	public int leftChildIndex(int index) {
		return index * 2 + 1;
	}

	public int rightChildIndex(int index) {
		return index * 2 + 2;
	}

	public int parentIndex(int index) {
		return (index - 1) / 2;
	}

	public void swap(int currentIndex, int parentIndex) {
		int temp = heap.get(currentIndex);
		heap.set(currentIndex, heap.get(parentIndex));
		heap.set(parentIndex, temp);
	}

	public void insert(int value) {
		heap.add(value);
		int currentIndex = heap.size() - 1;
		while (currentIndex > 0 && heap.get(currentIndex) > heap.get(parentIndex(currentIndex))) {
			swap(currentIndex, parentIndex(currentIndex));
			currentIndex = parentIndex(currentIndex);
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
		sinkDown(0);
		return remove;
	}

	public void sinkDown(int index) {
		int maxIndex = index;
		while (true) {
			if (leftChildIndex(index) < heap.size() && heap.get(leftChildIndex(index)) > heap.get(maxIndex)) {
				maxIndex = leftChildIndex(index);
			}
			if (rightChildIndex(index) < heap.size() && heap.get(rightChildIndex(index)) > heap.get(maxIndex)) {
				maxIndex = rightChildIndex(index);
			}
			if (maxIndex != index) {
				swap(maxIndex, index);
				index = maxIndex;
			} else {
				return;
			}
		}
	}

	public static List<Integer> streamMax(int[] nums) {
		// Edge case
		if (nums == null || nums.length == 0) {
			return new ArrayList<>();
		}
		Heap heap = new Heap();
		List<Integer> list = new ArrayList<>();
		for (int num : nums) {
			heap.insert(num);
			list.add(heap.getHeap().get(0));
		}
		return list;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 5, 2, 3, 7, 1 };
		System.out.println("max element are " + streamMax(nums));
	}
}
