package arrayInterview1.char_occurence;

import java.util.Arrays;

public class CharOccurence {

	public static <T> int removeDupilcates(T[] str) {
		if (str.length != 0) {
			int writer = 1;
			for (int reader = 1; reader < str.length; reader++) {
				boolean isDuplicate = false;
				for (int i = 0; i < reader; i++) {
					if (str[reader].equals(str[i])) {
						isDuplicate = true;
					}
				}
				if (!isDuplicate) {
					str[writer++] = str[reader];
				}
			}
			return writer;
		}
		return 0;
	}

	// alternative approach for removing duplicates occurences
	public static String removeDupilcates1(String str) {
		char[] ch = str.toCharArray();
		StringBuilder sb = new StringBuilder();
		boolean[] seen = new boolean[256];
		for (int i = 0; i < ch.length; i++) {
			if (!seen[ch[i]]) {
				sb.append(ch[i]);
				seen[ch[i]] = true;
			}
		}
		return new String(sb);
	}

	public static void characterOccurrences(String str) {
		if (str != null && !str.isBlank()) {
			String[] strArray = str.split("");
			int newLength = removeDupilcates(strArray);
			String[] ch1 = Arrays.copyOfRange(strArray, 0, newLength);
			String[] ch2 = str.split("");
			for (int i = 0; i < ch1.length; i++) {
				int counter = 0;
				for (int j = 0; j < ch2.length; j++) {
					if (ch1[i].equals(ch2[j])) {
						counter++;
					}
				}
				System.out.println("char " + ch1[i] + " occurs " + counter + " times");
			}
		} else {
			System.out.println("string can not be null or empty");
		}
	}

	public static void stringOccurrence(String string) {
		if (string != null && !string.isBlank()) {
			String[] strings = string.split(" ");
			int newLength = removeDupilcates(strings);
			String[] uniqueWords = Arrays.copyOfRange(strings, 0, newLength);
			String[] duplcaiteWords = string.split(" ");
			for (int i = 0; i < uniqueWords.length; i++) {
				int counter = 0;
				for (int j = 0; j < duplcaiteWords.length; j++) {
					if (uniqueWords[i].equals(duplcaiteWords[j])) {
						counter++;
					}
				}
				System.out.println("word '" + uniqueWords[i] + "' occurs " + counter + " times");
			}
		}
	}

	public static void main(String[] args) {
		characterOccurrences("malayalam");
		System.out.println("===============================");
		String string = "this is and this is chair";
		stringOccurrence(string);
	}
}
