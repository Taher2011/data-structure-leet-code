package sort.test;

import java.util.Arrays;
import java.util.List;

public class Test {

	public static void bubbleSort(int[] nums) {
	}

	public static int[] merge(int[] a1, int[] a2) {
		return null;
	}

	public static int[] mergeSort(int[] a4) {
		return null;
	}

	public static List<Integer> heapSort(int[] nums) {
		return null;
	}

	public static void main(String[] args) {
		int[] nums = { 4, 2, 6, 5, 1, 3 };
		System.out.println("before  sorting " + Arrays.toString(nums));
		bubbleSort(nums);
		System.out.println("after   sorting " + Arrays.toString(nums));

		System.out.println("================================================");

		int[] a1 = { 2, 4, 6, 8 };
		int[] a2 = { 3, 5, 7, 9 };
		int[] a3 = merge(a1, a2);
		System.out.println(Arrays.toString(a3));
		System.out.println("================================================");

		int[] a4 = { 3, 5, 7, 9, 2, 4, 6, 8 };
		System.out.println("before  sorting " + Arrays.toString(a4));
		a4 = mergeSort(a4);
		System.out.println("after   sorting " + Arrays.toString(a4));

		System.out.println("================================================");

		System.out.println("==============================");
		System.out.println("Original Heap after sorting: " + heapSort(nums));
	}

}
