package interview.array_interview_1.array_remove_element;

import java.util.Arrays;

public class RemoveElement {

	public static int removeElement(int[] nums, int val) {
		if (nums.length != 0) {
			int writer = 0;
			for (int reader = 0; reader < nums.length; reader++) {
				if (val != nums[reader]) {
					nums[writer++] = nums[reader];
				}
			}
			return writer;
		}
		return 0;
	}

	public static void main(String[] args) {
		// Test case 1
		int[] nums1 = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out
				.println("Test case 1: Original array: " + Arrays.toString(Arrays.copyOfRange(nums1, 0, nums1.length)));
		System.out.println("remove 1");
		int val1 = 1;
		int newLength1 = removeElement(nums1, val1);
		System.out.println("Test case 1: Modified array: " + Arrays.toString(Arrays.copyOfRange(nums1, 0, newLength1))
				+ "\nNew length: " + newLength1);
		System.out.println("==================================================================");

		// Test case 2
		int[] nums2 = { 1, 2, 3, 4, 5, 6 };
		System.out
				.println("Test case 2: Original array: " + Arrays.toString(Arrays.copyOfRange(nums2, 0, nums2.length)));
		System.out.println("remove 6");
		int val2 = 6;
		int newLength2 = removeElement(nums2, val2);
		System.out.println("Test case 2: Modified array: " + Arrays.toString(Arrays.copyOfRange(nums2, 0, newLength2))
				+ "\nNew length: " + newLength2);
		System.out.println("==================================================================");

		// Test case 3
		int[] nums3 = { -1, -2, -3, -4, -5 };
		System.out
				.println("Test case 3: Original array: " + Arrays.toString(Arrays.copyOfRange(nums3, 0, nums3.length)));
		System.out.println("remove -1");
		int val3 = -1;
		int newLength3 = removeElement(nums3, val3);
		System.out.println("Test case 3: Modified array: " + Arrays.toString(Arrays.copyOfRange(nums3, 0, newLength3))
				+ "\nNew length: " + newLength3);
		System.out.println("==================================================================");

		// Test case 4
		int[] nums4 = {};
		System.out
				.println("Test case 4: Original array: " + Arrays.toString(Arrays.copyOfRange(nums4, 0, nums4.length)));
		System.out.println("remove 1");
		int val4 = 1;
		int newLength4 = removeElement(nums4, val4);
		System.out.println("Test case 4: Modified array: " + Arrays.toString(Arrays.copyOfRange(nums4, 0, newLength4))
				+ "\nNew length: " + newLength4);
		System.out.println("==================================================================");

		// Test case 5
		int[] nums5 = { 1, 1, 1, 1, 1 };
		System.out
				.println("Test case 5: Original array: " + Arrays.toString(Arrays.copyOfRange(nums5, 0, nums5.length)));
		System.out.println("remove 1");
		int val5 = 1;
		int newLength5 = removeElement(nums5, val5);
		System.out.println("Test case 5: Modified array: " + Arrays.toString(Arrays.copyOfRange(nums5, 0, newLength5))
				+ "\nNew length: " + newLength5);
		System.out.println("==================================================================");

	}

}
