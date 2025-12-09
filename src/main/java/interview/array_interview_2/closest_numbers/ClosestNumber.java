package interview.array_interview_2.closest_numbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClosestNumber {

	public static List<Integer> closestNumbers(List<Integer> arr) {
		Collections.sort(arr);
		System.out.println(arr);
		int minDiff = Integer.MAX_VALUE;
		List<Integer> result = new ArrayList<>();

		// STEP 1: Find minimum difference
		for (int i = 0; i < arr.size() - 1; i++) {
			int diff = arr.get(i + 1) - arr.get(i);
			minDiff = Math.min(minDiff, diff);
		}

		// STEP 2: Collect all pairs having minimum difference
		for (int i = 0; i < arr.size() - 1; i++) {
			int diff = arr.get(i + 1) - arr.get(i);
			if (diff == minDiff) {
				result.add(arr.get(i));
				result.add(arr.get(i + 1));
			}
		}
		return result;
	}

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();
		list.add(15);
		list.add(4);
		list.add(3);
		list.add(32);
		List<Integer> closestNumbers = closestNumbers(list);
		System.out.println(closestNumbers);
	}

}
