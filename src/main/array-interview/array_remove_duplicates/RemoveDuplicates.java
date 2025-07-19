package array_remove_duplicates;

import java.util.Arrays;

public class RemoveDuplicates {

	public static int removeDuplicatesFromSortedArray(int[] nums) {
		if (nums.length != 0) {
			int writer = 1;
			for (int reader = 1; reader < nums.length; reader++) {
				if (nums[reader] != nums[reader - 1]) {
					nums[writer] = nums[reader];
					writer++;
				}
			}
			return writer;
		}
		return 0;
	}

	public static <T> int removeDuplicatesFromUnsortedArray(T[] nums) {
		if (nums.length != 0) {
			int writer = 1;
			for (int reader = 1; reader < nums.length; reader++) {
				boolean isDuplicate = false;
				for (int i = 0; i < reader; i++) {
					if (nums[i] == nums[reader]) {
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
		return 0;
	}

	public static void main(String[] args) {
		Integer[] nums1 = { 5, 1, 4, 7, 5, 1, 4, 0, 2, 2, 7, 5, 4 };
		System.out.println(Arrays.toString(Arrays.copyOfRange(nums1, 0, nums1.length)));
		int newLength1 = removeDuplicatesFromUnsortedArray(nums1);
		System.out.println(Arrays.toString(Arrays.copyOfRange(nums1, 0, newLength1)));
		System.out.println("=====================================================");

		int[] nums2 = { 1, 1, 2, 2, 2, 3 };
		System.out.println(Arrays.toString(Arrays.copyOfRange(nums2, 0, nums2.length)));
		int newLength2 = removeDuplicatesFromSortedArray(nums2);
		System.out.println(Arrays.toString(Arrays.copyOfRange(nums2, 0, newLength2)));
		System.out.println("=====================================================");

		int[] nums3 = { -1, 0, 0, 0, 3, 3 };
		System.out.println(Arrays.toString(Arrays.copyOfRange(nums3, 0, nums3.length)));
		int newLength3 = removeDuplicatesFromSortedArray(nums3);
		System.out.println(Arrays.toString(Arrays.copyOfRange(nums3, 0, newLength3)));
		System.out.println("=====================================================");

		int[] nums4 = {};
		System.out.println(Arrays.toString(Arrays.copyOfRange(nums4, 0, nums4.length)));
		int newLength4 = removeDuplicatesFromSortedArray(nums4);
		System.out.println(Arrays.toString(Arrays.copyOfRange(nums4, 0, newLength4)));
		System.out.println("=====================================================");

		int[] nums5 = { 1, 1, 1, 1, 1 };
		System.out.println(Arrays.toString(Arrays.copyOfRange(nums5, 0, nums5.length)));
		int newLength5 = removeDuplicatesFromSortedArray(nums5);
		System.out.println(Arrays.toString(Arrays.copyOfRange(nums5, 0, newLength5)));
		System.out.println("=====================================================");

		Integer[] nums6 = { 1, 0, 1, 2, 1, 2, 2, 1, 3, 2 };
		System.out.println(Arrays.toString(nums6));
		int length = removeDuplicatesFromUnsortedArray(nums6);
		System.out.println(Arrays.toString(Arrays.copyOfRange(nums6, 0, length)));

		System.out.println("=====================================================");

		String[] nums7 = { "a", "b", "b", "a", "c", "b" };
		System.out.println(Arrays.toString(nums7));
		int length1 = removeDuplicatesFromUnsortedArray(nums7);
		System.out.println(Arrays.toString(Arrays.copyOfRange(nums7, 0, length1)));
	}

}
