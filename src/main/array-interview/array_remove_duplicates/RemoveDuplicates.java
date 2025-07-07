package array_remove_duplicates;

import java.util.Arrays;

public class RemoveDuplicates {

	public static int removeDuplicates(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int writer = 1;
		for (int reader = 1; reader < nums.length; reader++) {
			if (nums[reader] != nums[reader - 1]) {
				nums[writer] = nums[reader];
				writer++;
			}
		}
		return writer;
	}

	public static <T> int removeDuplicatesFromUnsortedArray(T[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int writer = 1;
		for (int reader = 1; reader < nums.length; reader++) {
			boolean isDuplicate = false;
			for (int i = 0; i < writer; i++) {
				if (nums[reader].equals(nums[i])) {
					isDuplicate = true;
					break;
				}
			}
			if (!isDuplicate) {
				nums[writer] = nums[reader];
				writer++;
			}
		}
		return writer;
	}

	public static void main(String[] args) {
		int[] nums1 = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
		System.out.println(Arrays.toString(nums1));
		int length = removeDuplicates(nums1);
		System.out.println("list after duplicates removal : " + Arrays.toString(Arrays.copyOfRange(nums1, 0, length)));

		System.out.println();

		Integer[] nums2 = { 1, 0, 1, 2, 1, 2, 2, 1, 3, 2 };
		System.out.println(Arrays.toString(nums2));
		length = removeDuplicatesFromUnsortedArray(nums2);
		System.out.println("list after duplicates removal : " + Arrays.toString(Arrays.copyOfRange(nums2, 0, length)));

		System.out.println();

		String[] nums3 = { "a", "b", "b", "a", "c", "b" };
		System.out.println(Arrays.toString(nums3));
		length = removeDuplicatesFromUnsortedArray(nums3);
		System.out.println("list after duplicates removal : " + Arrays.toString(Arrays.copyOfRange(nums3, 0, length)));
	}

}
