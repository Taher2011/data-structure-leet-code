package hashtable.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class HashSetInterview {

	public static List<Integer> removeDuplicates(List<Integer> list) {
		Set<Integer> set = new LinkedHashSet<>(list);
		List<Integer> uniquelist = new ArrayList<Integer>(set);
		return uniquelist;
	}

	public static boolean hasUniqueChars(String string) {
		Set<Character> set = new LinkedHashSet<>();
		char[] ch = string.toCharArray();
		for (char c : ch) {
			if (set.contains(c)) {
				return false;
			}
			set.add(c);
		}
		return true;
	}

	public static List<int[]> findPairs(int[] nums1, int[] nums2, int target) {
		List<int[]> list = new ArrayList<>();
		Set<Integer> set = new LinkedHashSet<>();
		for (int num : nums1) {
			set.add(num);
		}
		for (int i = 0; i < nums2.length; i++) {
			int complement = target - nums2[i];
			if (set.contains(complement)) {
				int[] arr = { complement, nums2[i] };
				list.add(arr);
			}
		}
		return list;
	}

	private static String formatPairs(List<int[]> pairs) {
		List<String> formatted = new ArrayList<>();
		for (int[] pair : pairs) {
			formatted.add(Arrays.toString(pair));
		}
		return formatted.toString();
	}

	public static int longestConsecutiveSequence(int[] nums) {
		Set<Integer> numSet = new LinkedHashSet<>();
		for (int num : nums) {
			numSet.add(num);
		}
		int longestStreak = 0;
		for (Integer num : numSet) {
			if (!numSet.contains(num - 1)) {
				int currentNum = num;
				int currentStreak = 1;
				while (numSet.contains(currentNum + 1)) {
					currentNum++;
					currentStreak++;
				}
				longestStreak = Math.max(longestStreak, currentStreak);
			}
		}
		return longestStreak;
	}

	public static void main(String[] args) {
		List<Integer> list1 = Arrays.asList(1, 2, 2, 3, 3, 4);
		System.out.println("list after before duplicates : " + list1);
		System.out.println("list after remove duplicates : " + removeDuplicates(list1));

		System.out.println("====================================================================");

		String input = "hello";
		System.out.println("string '" + input + "' contains unique chars : " + hasUniqueChars(input));

		System.out.println("====================================================================");

		int[] arr1 = { 1, 2, 3 };
		int[] arr2 = { 4, 5, 6 };
		int target = 7;
		System.out.println("pairs for " + target + " are : " + formatPairs(findPairs(arr1, arr2, target)));

		System.out.println("====================================================================");

		int[] nums = { 5, 6, 7, 8, 9 };
		System.out.println("consecutive sequence : " + longestConsecutiveSequence(nums));

	}

}
