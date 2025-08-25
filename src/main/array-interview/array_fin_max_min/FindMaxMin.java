package array_fin_max_min;

import java.util.Arrays;

public class FindMaxMin {

	public static int[] findMaxMin(int[] nums) {
		if (nums.length != 0) {
			int max = nums[0];
			int min = nums[0];
			for (int num : nums) {
				min = Math.min(num, min);
				max = Math.max(num, max);
			}
			return new int[] { max, min };
		}
		return new int[] { 0, 0 };
	}

	// alternate approach
	public static int[] findMaxMin1(int[] nums) {
		if (nums.length != 0) {
			int max = nums[0];
			int min = nums[0];
			for (int num : nums) {
				if (num < min) {
					min = num;
				} else if (num > max) {
					max = num;
				}
			}
			return new int[] { max, min };
		}
		return new int[] { 0, 0 };
	}

	public static void main(String[] args) {
		int[] myList1 = { 5, 3, 8, 1, 6, 9 };
		int[] result1 = findMaxMin(myList1);
		System.out.println("Test case 1: MaxMin: " + Arrays.toString(result1)); // prints "[9, 1]"

		int[] myList2 = { -5, -3, -8, -1, -6, -9 };
		int[] result2 = findMaxMin(myList2);
		System.out.println("Test case 2: MaxMin: " + Arrays.toString(result2)); // prints "[-1, -9]"

		int[] myList3 = { 0, 0, 0, 0, 0 };
		int[] result3 = findMaxMin(myList3);
		System.out.println("Test case 3: MaxMin: " + Arrays.toString(result3)); // prints "[0, 0]"

		int[] myList4 = { 100, 200, 300, 400, 500 };
		int[] result4 = findMaxMin(myList4);
		System.out.println("Test case 4: MaxMin: " + Arrays.toString(result4)); // prints "[500, 100]"
	}

}
