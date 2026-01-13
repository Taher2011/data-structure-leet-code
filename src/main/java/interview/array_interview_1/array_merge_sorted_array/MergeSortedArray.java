package interview.array_interview_1.array_merge_sorted_array;

import java.util.Arrays;

public class MergeSortedArray {

	public static void mergeSortedArray(int[] nums1, int[] nums2, int k) {
		int i = k - 1;
		int j = nums2.length - 1;
		int l = nums1.length - 1;

		while (i >= 0 && j >= 0) {
			if (nums1[i] > nums2[j]) {
				nums1[l--] = nums1[i--];
			} else {
				nums1[l--] = nums2[j--];
			}
		}
		while (j >= 0) {
			nums1[l--] = nums2[j--];
		}

	}

	public static void main(String[] args) {
		int[] nums1 = { 14, 15, 16, 0, 0, 0 };
		int[] nums2 = { 2, 4, 8 };
		int k = 3;
		mergeSortedArray(nums1, nums2, k);
		System.out.println(Arrays.toString(nums1));
	}

}
