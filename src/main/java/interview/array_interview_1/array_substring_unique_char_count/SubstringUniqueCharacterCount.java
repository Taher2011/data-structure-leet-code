package interview.array_interview_1.array_substring_unique_char_count;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*Input String: ABA
Output: 8
Explanation:
Substrings> A, B, A, AB, BA, ABA
A - 1
B - 1
A - 1
AB - 2
BA - 2
ABA - 1 (since A is repeated, A is ignored and only B is considered here)
 
1+1+1+2+2+1 = 8 (final output)    */

public class SubstringUniqueCharacterCount {

	private static void substringUniqueCharCount(String str) {
		List<String> subStrings = new ArrayList<>();
		for (int i = 0; i < str.length(); i++) {
			int k = i + 1;
			while (k <= str.length()) {
				subStrings.add(str.substring(i, k));
				k++;
			}
		}
		System.out.println("possible substrings : " + subStrings);

		int totalSum = 0;
		for (String string : subStrings) {
			Map<Character, Long> freqMap = string.chars().mapToObj(c -> (char) c)
					.collect(Collectors.groupingBy(c -> c, Collectors.counting()));

			for (Long value : freqMap.values()) {
				if (value == 1) {
					totalSum += value;
				}
			}
		}
		System.out.println(totalSum);
	}

	public static void main(String[] args) {
		String str = "ABA";
		substringUniqueCharCount(str);
	}

}
