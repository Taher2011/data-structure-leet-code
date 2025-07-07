package array_remove_element;

import java.util.Arrays;

public class RemoveElement {

	public static int removeElement(int[] nums, int val) {
		int writer = 0;
		for (int reader = 0; reader < nums.length; reader++) {
			if (val != nums[reader]) {
				nums[writer] = nums[reader];
				writer++;
			}
		}
		return writer;
	}

	public static void main(String[] args) {
		int[] nums1 = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int val = 1;
		System.out.println(Arrays.toString(nums1));
		int length = removeElement(nums1, val);
		System.out.println(
				"list after val" + val + " removal : " + Arrays.toString(Arrays.copyOfRange(nums1, 0, length)));
	}

}
