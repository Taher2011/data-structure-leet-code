package binary_search;

import java.util.Arrays;

public class BinarySearch {

	public static int search(int[] nums, int firstIndex, int lastIndex, int elementToSearch) {
		if (firstIndex > lastIndex) {
			return -1;
		}
		int middle = firstIndex + (lastIndex - firstIndex) / 2;
		if (elementToSearch == nums[middle]) {
			return middle;
		}
		if (nums[middle] >= elementToSearch) {
			return search(nums, firstIndex, middle - 1, elementToSearch);
		} else if (nums[middle] < elementToSearch) {
			return search(nums, middle + 1, lastIndex, elementToSearch);
		} else {
			return 0;
		}
	}

	public static void main(String[] args) {
		int[] nums = { 10, 4, 7, 11, 17, 8, 21 };
		int elementToSearch = 21;
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
		int index = search(nums, 0, nums.length - 1, elementToSearch);
		System.out.println(index);
	}

}
