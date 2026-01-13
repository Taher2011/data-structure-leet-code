package interview.array_interview_2.palindrome;

import java.util.List;
import java.util.stream.IntStream;

public class Palindrome {

	public static boolean isPalindrome(String str) {
		char[] ch = str.toCharArray();
		for (int i = 0, j = ch.length - 1; i < ch.length / 2; i++, j--) {
			if (ch[i] != ch[j]) {
				return false;
			}
		}
		return true;
	}

	public static void isPalindrome(List<String> strings) {
		for (String string : strings) {
			IntStream index = IntStream.range(0, string.length() / 2);
			int length = string.length() - 1;
			if (index.allMatch(i -> string.charAt(i) == string.charAt(length - i))) {
				System.out.println(string + " is palindrome");
			} else {
				System.out.println(string + " is not palindrome");
			}
		}
	}

	public static void main(String[] args) {
		String[] strings = { "madam", "malayalam", "taher" };
		for (String string : strings) {
			if (isPalindrome(string)) {
				System.out.println(string + " is palindrome");
			} else {
				System.out.println(string + " is not palindrome");
			}
		}

	}

}
