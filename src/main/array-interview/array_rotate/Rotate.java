package array_rotate;

import java.util.Arrays;

public class Rotate {

	public static void rotate(int[] nums, int k) {
		k = 3 % nums.length;
		rotateArray(nums, 0, nums.length - 1);
		rotateArray(nums, 0, k - 1);
		rotateArray(nums, k, nums.length - 1);
	}

	public static void rotateArray(int[] nums, int start, int end) {
		while (start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}

	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 3, 4, 5, 6, 7 };
		System.out.println(Arrays.toString(nums1));
		int k = 3;
		rotate(nums1, k);
		System.out.println("Rotated array " + k + " times: " + Arrays.toString(nums1)); // prints "Rotated array: [5, 6,
																						// 7, 1, 2, 3, 4]"

	}

}
