package char_occurence;

import java.util.Arrays;

public class CharOccurence {

	public static String removeDupilcates(String str) {
		char[] ch = str.toCharArray();
		int writer = 1;
		for (int reader = 1; reader < ch.length; reader++) {
			boolean isDuplicate = false;
			for (int i = 0; i < reader; i++) {
				if (ch[i] == ch[reader]) {
					isDuplicate = true;
					break;
				}
			}
			if (!isDuplicate) {
				ch[writer] = ch[reader];
				writer++;
			}
		}
		return new String(Arrays.copyOfRange(ch, 0, writer));
	}

	// alternative approach for removing duplicates occurences
	public static String removeDupilcates1(String str) {
		char[] ch = str.toCharArray();
		StringBuilder sb = new StringBuilder();
		boolean[] seen = new boolean[256];
		for (int i = 0; i < ch.length; i++) {
			if (!seen[ch[i]]) {
				seen[ch[i]] = true;
				sb.append(ch[i]);
			}
		}
		return new String(sb);
	}

	public static void characterOccurrences(String str) {
		if (str == null || str.isBlank()) {
			System.out.println("string can not be null or empty");
			return;
		}
		String unique = removeDupilcates1(str);
		char[] ch1 = unique.toCharArray();
		char[] ch2 = str.toCharArray();
		for (int i = 0; i < ch1.length; i++) {
			int counter = 0;
			for (int j = 0; j < ch2.length; j++) {
				if (ch1[i] == ch2[j]) {
					counter++;
				}
			}
			System.out.println("char " + ch1[i] + " occured " + counter + " time");
		}
	}

	public static void stringOccurrence(String string) {
		String[] words = string.split(" ");
		int writer = 1;
		for (int reader = 1; reader < words.length; reader++) {
			boolean isDuplicate = false;
			for (int i = 0; i < writer; i++) {
				if (words[i].equals(words[reader])) {
					isDuplicate = true;
					break;
				}
			}
			if (!isDuplicate) {
				words[writer] = words[reader];
				writer++;
			}
		}
		String[] unique = Arrays.copyOfRange(words, 0, writer);
		words = string.split(" ");
		for (int i = 0; i < unique.length; i++) {
			int count = 0;
			for (int j = 0; j < words.length; j++) {
				if (unique[i].equals(words[j])) {
					count++;
				}
			}
			System.out.println("word '" + unique[i] + "' occur " + count + " times");
		}
	}

	public static void main(String[] args) {
		characterOccurrences(null);
		System.out.println("=============================");
		String string = "this is chair and this is table";
		stringOccurrence(string);
	}
}
