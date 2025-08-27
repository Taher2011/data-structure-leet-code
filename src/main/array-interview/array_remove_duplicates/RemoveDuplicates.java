package array_remove_duplicates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveDuplicates {

	public static int removeDuplicates(int[] nums) {
		if (nums.length != 0) {
			int writer = 1;
			for (int reader = 0; reader < nums.length - 1; reader++) {
				if (nums[reader] != nums[reader + 1]) {
					nums[writer] = nums[reader + 1];
					writer++;
				}
			}
			return writer;
		}
		return 0;
	}

	// alternative approach using boolean array this works for both sorted and
	// unsorted array
	public static int[] removeDuplicates1(int[] nums) {
		if (nums.length != 0) {
			boolean[] seen = new boolean[256];
			List<Integer> list = new ArrayList<>();
			for (int num : nums) {
				if (!seen[num]) {
					list.add(num);
					seen[num] = true;
				}
			}
			return list.stream().mapToInt(Integer::intValue).toArray();
		}
		return nums;
	}

	public static <T> int removeDuplicatesFromUnsortedArray(T[] nums) {
		if (nums.length != 0) {
			int writer = 1;
			for (int reader = 1; reader < nums.length; reader++) {
				boolean isDuplicate = false;
				for (int i = 0; i < reader; i++) {
					if (nums[reader] == nums[i]) {
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
		int newLength2 = removeDuplicates(nums2);
		System.out.println(Arrays.toString(Arrays.copyOfRange(nums2, 0, newLength2)));
		System.out.println("=====================================================");

		int[] nums3 = { -1, 0, 0, 0, 3, 3 };
		System.out.println(Arrays.toString(Arrays.copyOfRange(nums3, 0, nums3.length)));
		int newLength3 = removeDuplicates(nums3);
		System.out.println(Arrays.toString(Arrays.copyOfRange(nums3, 0, newLength3)));
		System.out.println("=====================================================");

		int[] nums4 = {};
		System.out.println(Arrays.toString(Arrays.copyOfRange(nums4, 0, nums4.length)));
		int newLength4 = removeDuplicates(nums4);
		System.out.println(Arrays.toString(Arrays.copyOfRange(nums4, 0, newLength4)));
		System.out.println("=====================================================");

		int[] nums5 = { 1, 1, 1, 1, 1 };
		System.out.println(Arrays.toString(Arrays.copyOfRange(nums5, 0, nums5.length)));
		int newLength5 = removeDuplicates(nums5);
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

		System.out.println("=====================================================");

		int[] nums8 = { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(Arrays.copyOfRange(nums8, 0, nums8.length)));
		int newLength8 = removeDuplicates(nums8);
		System.out.println(Arrays.toString(Arrays.copyOfRange(nums8, 0, newLength8)));
		System.out.println("=====================================================");

	}

}
