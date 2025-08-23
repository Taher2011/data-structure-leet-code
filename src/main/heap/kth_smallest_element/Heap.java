package kth_smallest_element;

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

	// Alternate approach
	public static int findKthSmallest1(int[] nums, int k) {
		Heap heap = new Heap();
		for (int num : nums) {
			heap.insert(num);
			if (heap.getHeap().size() > k) {
				heap.remove();
			}
		}
		int kthSmallest = heap.getHeap().get(0);
		return kthSmallest;
	}

	public static int findKthSmallest(int[] nums, int k) {
		// Edge cases
		if (nums == null || nums.length == 0 || k <= 0 || k > nums.length) {
			throw new IllegalArgumentException("Invalid input");
		}
		Heap heap = new Heap();
		for (int num : nums) {
			if (k != 0) {
				heap.insert(num);
				k--;
				continue;
			}
			if (num < heap.getHeap().get(0)) {
				heap.remove();
				heap.insert(num);
			}
		}
		return heap.getHeap().get(0);
	}

	public static void main(String[] args) {
		int[] nums = { 9, 2, 3 };
		int k = 3;
		System.out.println(k + "th smallest element is " + findKthSmallest(nums, k));
	}
}
