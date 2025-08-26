package array_max_sub_array;

import java.util.Arrays;

public class MaxSubArray {

	public static int maxSubarray1(int[] nums) {
		if (nums.length != 0) {
			int currentSum = nums[0];
			int maxSum = nums[0];
			for (int i = 1; i < nums.length; i++) {
				int totalSubArraySum = nums[i] + currentSum;
				if (nums[i] > totalSubArraySum) {
					currentSum = nums[i];
				} else {
					currentSum = totalSubArraySum;
				}
				if (currentSum > maxSum) {
					maxSum = currentSum;
				}
			}
			return maxSum;
		}
		return 0;
	}

	// alternate approach
	public static int maxSubarray(int[] nums) {
		if (nums.length != 0) {
			int currentSum = nums[0];
			int maxSum = nums[0];
			for (int i = 1; i < nums.length; i++) {
				int totalSubArraySum = nums[i] + currentSum;
				currentSum = Math.max(nums[i], totalSubArraySum);
				maxSum = Math.max(maxSum, currentSum);
			}
			return maxSum;
		}
		return 0;
	}

	public static void main(String[] args) {
		// Example 1: Simple case with positive and negative numbers
		int[] inputCase1 = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println("Example 1: Input: " + Arrays.toString(inputCase1));
		int result1 = maxSubarray(inputCase1);
		System.out.println("Expected output : 6");
		System.out.println("Example 1: Input: " + Arrays.toString(inputCase1) + "\nActual   result : " + result1);
		System.out.println("=============================================");

		// Example 2: Case with a negative number in the middle
		int[] inputCase2 = { 1, 2, 3, -4, 5, 6 };
		System.out.println("Example 2: Input: " + Arrays.toString(inputCase2));
		int result2 = maxSubarray(inputCase2);
		System.out.println("Expected output : 13");
		System.out.println("Example 2: Input: " + Arrays.toString(inputCase2) + "\nActual   result : " + result2);
		System.out.println("=============================================");

		// Example 3: Case with all negative numbers
		int[] inputCase3 = { -1, -2, -3, -4, -5 };
		int result3 = maxSubarray(inputCase3);
		System.out.println("Expected output : -1");
		System.out.println("Example 3: Input: " + Arrays.toString(inputCase3) + "\nActual   result : " + result3);
		System.out.println("=============================================");

		// Example 4: Case with all positive numbers
		int[] inputCase4 = { 1, 2, 3, 4, 5 };
		int result4 = maxSubarray(inputCase4);
		System.out.println("Expected output : 15");
		System.out.println("Example 4: Input: " + Arrays.toString(inputCase4) + "\nActual   result : " + result4);
		System.out.println("=============================================");

		// Example 5: Case with alternating positive and negative numbers
		int[] inputCase5 = { 1, -1, 1, -1, 1 };
		int result5 = maxSubarray(inputCase5);
		System.out.println("Expected output : 1");
		System.out.println("Example 5: Input: " + Arrays.toString(inputCase5) + "\nActual   result : " + result5);
		System.out.println("=============================================");
	}

}
