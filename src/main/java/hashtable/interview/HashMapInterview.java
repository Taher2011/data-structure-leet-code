package hashtable.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapInterview {

	public static boolean itemInCommon(int[] array1, int[] array2) {
		Map<Integer, Boolean> hashMap = new HashMap<>();
		for (int i = 0; i < array1.length; i++) {
			hashMap.put(array1[i], true);
		}
		for (int i = 0; i < array2.length; i++) {
			if (hashMap.get(array2[i]) != null && hashMap.get(array2[i])) {
				return true;
			}
		}
		return false;
	}

	public static List<Integer> findDuplicates(int[] nums) {
		List<Integer> duplicates = new ArrayList<>();
		Map<Integer, Integer> hashMap = new HashMap<>();
		for (int num : nums) {
			hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
		}
		hashMap.entrySet().forEach(m -> {
			if (m.getValue() > 1) {
				duplicates.add(m.getKey());
			}
		});
		return duplicates;
	}

	public static Character firstNonRepeatingChar(String input) {
		Map<Character, Integer> hashMap = new HashMap<>();
		char[] ch = input.toCharArray();
		for (char c : ch) {
			hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
		}
//		for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
//			if (entry.getValue() == 1) {
//				return entry.getKey();
//			}
//		}
		for (int i = 0; i < input.toCharArray().length; i++) {
			if (hashMap.get(input.charAt(i)) == 1) {
				return input.charAt(i);
			}
		}
		return null;
	}

	public static List<List<String>> groupAnagrams(String[] strings) {
		Map<String, List<String>> hashMap = new HashMap<>();
		for (String string : strings) {
			char[] ch = string.toCharArray();
			Arrays.sort(ch);
			String canonical = new String(ch);

//			if (hashMap.get(canonical) == null) {
//				List<String> anagrams = new ArrayList<>();
//				anagrams.add(string);
//				hashMap.put(canonical, anagrams);
//			} else {
//				hashMap.put(canonical, addToList(hashMap.get(canonical), string));
//			}

			if (hashMap.containsKey(canonical)) {
				hashMap.get(canonical).add(string);
			} else {
				List<String> anagrams = new ArrayList<>();
				anagrams.add(string);
				hashMap.put(canonical, anagrams);
			}
		}
		List<List<String>> anagrams = new ArrayList<>();
		hashMap.entrySet().forEach(m -> anagrams.add(m.getValue()));
		return anagrams;
	}

	// Second approach using computeIfAbsent
	public static List<List<String>> groupAnagrams1(String[] strings) {
		List<List<String>> list = new ArrayList<>();
		Map<String, List<String>> map = new HashMap<>();
		for (String string : strings) {
			char[] ch = string.toCharArray();
			Arrays.sort(ch);
			String canonical = new String(ch);

//	computeIfAbsent -->		If key present in map → use its value
//	computeIfAbsent -->		If key not present in map → create new value, put into map, then use its value

//			Equivalent old-style code
			/*
			 * if (!map.containsKey(canonical)) { map.put(canonical, new ArrayList<>()); }
			 * map.get(canonical).add(string);
			 */

			map.computeIfAbsent(canonical, l -> new ArrayList<>()).add(string);
		}
		for (Map.Entry<String, List<String>> entry : map.entrySet()) {
			list.add(entry.getValue());
		}
		return list;
	}

	private static List<String> addToList(List<String> list, String string) {
		list.add(string);
		return list;
	}

	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> hashMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			int complement = target - num; // The complement of the current number is calculated as (target - num). The
											// complement is the value that needs to be added to the current number to
											// get the target value.
			if (hashMap.containsKey(complement)) {
				return new int[] { hashMap.get(complement), i };
			} else {
				hashMap.put(num, i);
			}
		}
		return new int[] {};
	}

	public static int[] subarraySum(int[] nums, int target) {
		Map<Integer, Integer> hashMap = new HashMap<>();
		hashMap.put(0, -1);
		int currentSum = 0;
		for (int i = 0; i < nums.length; i++) {
			currentSum = currentSum + nums[i];
			int complement = currentSum - target;
			if (hashMap.containsKey(complement)) {
				return new int[] { hashMap.get(complement) + 1, i };
			} else {
				hashMap.put(nums[i], i);
			}
		}
		return new int[] {};
	}

	public static void main(String[] args) {
		int[] array1 = { 1, 2, 3 };
		int[] array2 = { 4, 5, 3 };
		System.out.println("items in common in between " + Arrays.toString(array1) + " and " + Arrays.toString(array2)
				+ " : " + itemInCommon(array1, array2));

		System.out.println("====================================================================");

		int[] nums1 = { 1, 2, 2, 3, 3, 4, 3 };
		System.out.println("duplicates : " + findDuplicates(nums1));

		System.out.println("====================================================================");

		String input = "alphabet";
		System.out.println("first non repeating char in " + input + " is : " + firstNonRepeatingChar(input));

		System.out.println("====================================================================");

		String[] input1 = { "eat", "tea", "tan", "ate", "nat", "bat" };
		System.out.println("grouped anagrams are : " + groupAnagrams(input1));

		System.out.println("====================================================================");

		int[] nums2 = { 2, 7, 11, 15 };
		int target = 9;
		System.out.println("sum of " + target + " is indices : " + Arrays.toString(twoSum(nums2, target)));

		System.out.println("====================================================================");

		int[] nums3 = { 1, 2, 3, 4, 5 };
		int sum = 9;
		System.out
				.println("sub-array sum of " + sum + " is from indices : " + Arrays.toString(subarraySum(nums3, sum)));

	}

}
