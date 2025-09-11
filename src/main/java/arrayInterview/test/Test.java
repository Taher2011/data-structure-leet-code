package arrayInterview.test;

import java.util.Arrays;

public class Test {

	public static void rotate(int[] nums, int k) {

	}

	public static int removeElement(int[] nums, int val) {
		return 0;
	}

	public static int removeDuplicates(int[] nums) {
		return 0;
	}

	public static <T> int removeDuplicatesFromUnsortedArray(T[] nums) {
		return 0;
	}

	public static int maxSubarray(int[] nums) {
		return 0;
	}

	public static int maxProfit(int[] prices) {
		return 0;
	}

	public static String findLongestString(String[] strings) {
		return "";
	}

	public static int[] findMaxMin(int[] nums) {
		return new int[] { 0, 0 };
	}

	public static void main(String[] args) {
		// Test case 1
		int[] nums1 = { 1, 2, 3, 4, 5 };
		int k = 3;
		rotate(nums1, k);
		System.out.println("Test case 1: Rotated array: " + Arrays.toString(nums1)); // prints "Rotated array:
																						// [3,4,5,1,2 ]"
		System.out.println("==================================================================");

		// Test case 2
		int[] nums2 = { 1, 2, 3, 4, 5, 6 };
		System.out
				.println("Test case 2: Original array: " + Arrays.toString(Arrays.copyOfRange(nums2, 0, nums2.length)));
		System.out.println("remove 6");
		int val = 6;
		int newLength2 = removeElement(nums2, val);
		System.out.println("Test case 2: Modified array: " + Arrays.toString(Arrays.copyOfRange(nums2, 0, newLength2))
				+ "\nNew length: " + newLength2);
		System.out.println("==================================================================");

		// Test case 3
		Integer[] nums3 = { 5, 1, 4, 7, 5, 1, 4, 0, 2, 2, 7, 5, 4 };
		System.out.println(Arrays.toString(Arrays.copyOfRange(nums3, 0, nums3.length)));
		int newLength3 = removeDuplicatesFromUnsortedArray(nums3);
		System.out.println(Arrays.toString(Arrays.copyOfRange(nums3, 0, newLength3)));
		System.out.println("==================================================================");

		// Test case 4
		int[] nums4 = { 1, 1, 2, 2, 2, 3 };
		System.out.println(Arrays.toString(Arrays.copyOfRange(nums4, 0, nums4.length)));
		int newLength4 = removeDuplicates(nums4);
		System.out.println(Arrays.toString(Arrays.copyOfRange(nums4, 0, newLength4)));
		System.out.println("=====================================================");

		// Test case 5
		int[] inputCase1 = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println("Example 1: Input: " + Arrays.toString(inputCase1));
		int result1 = maxSubarray(inputCase1);
		System.out.println("Expected output : 6");
		System.out.println("Example 1: Input: " + Arrays.toString(inputCase1) + "\nActual   result : " + result1);
		System.out.println("=============================================");

		// Test case 6
		int[] prices1 = { 7, 1, 5, 3, 6, 4 };
		int profit1 = maxProfit(prices1);
		System.out.println("Test case 6: Maximum profit: " + profit1); // prints "Maximum profit: 5"
		System.out.println("=============================================");

		// Test case 7
		String[] stringList1 = { "apple", "banana", "kiwi", "pear" };
		String longest1 = findLongestString(stringList1);
		System.out.println("Test case 7: Longest string: " + longest1); // prints "banana"
		System.out.println("=============================================");

		// Test case 8
		int[] myList1 = { 5, 3, 8, 1, 6, 9 };
		int[] result = findMaxMin(myList1);
		System.out.println("Test case 8: MaxMin: " + Arrays.toString(result)); // prints "[9, 1]"
		System.out.println("=============================================");
	}

}
