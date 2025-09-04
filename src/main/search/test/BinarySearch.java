package test;

import java.util.Arrays;

public class BinarySearch {

	public static int binarySearch(int[] nums, int firstIndex, int lastIndex, int elementToSearch) {

		return -1;
	}

	public static void main(String[] args) {
		int[] nums = { 32, 54, 9, 5, 43, 87, 12 };
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
		int elementSearch = 433;
		int index = binarySearch(nums, 0, nums.length - 1, elementSearch);
		System.out.println("index of elemnet " + elementSearch + " is " + index);
	}
}
