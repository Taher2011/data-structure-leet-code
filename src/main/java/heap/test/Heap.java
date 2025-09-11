package heap.test;

import java.util.List;

public class Heap {

	private List<Integer> heap;

	public Heap() {
	}

	public List<Integer> getHeap() {
		return null;
	}

	public int leftChild(int index) {
		return 0;
	}

	public int rightChild(int index) {
		return 0;
	}

	public int parent(int index) {
		return 0;
	}

	public void swap(int index1, int index2) {

	}

	public void insert(int value) {
	}

	public Integer remove() {
		return null;
	}

	public static int findKthSmallest(int[] nums, int k) {
		return 0;
	}

	public static List<Integer> streamMax(int[] nums) {
		return null;
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

		int[] nums = { 1, 5, 2, 3, 7, 1 };
		System.out.println("max element are " + streamMax(nums));

		int k = 3;
		System.out.println(k + "th smallest element is " + findKthSmallest(nums, k));

	}

}
