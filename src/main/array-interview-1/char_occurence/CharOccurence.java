package char_occurence;

import java.util.Arrays;

public class CharOccurence {

	public static void charOccurence(String str) {
		if (str.isEmpty()) {
			return;
		}
		String unqiueStr = removeDuplicates(str);
		char[] ch1 = unqiueStr.toCharArray();
		char[] ch2 = str.toCharArray();
		for (int i = 0; i < ch1.length; i++) {
			int count = 0;
			for (int j = 0; j < ch2.length; j++) {
				if (ch1[i] == ch2[j]) {
					count++;
				}
			}
			System.out.println("char '" + ch1[i] + "' occur " + count + " times");
		}
	}

	public static void stringOccurence(String string) {
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

	public static String removeDuplicates(String str) {
		char[] ch = str.toLowerCase().toCharArray();
		int writer = 1;
		for (int reader = 0; reader < ch.length; reader++) {
			boolean isDuplicate = false;
			for (int i = 0; i < writer; i++) {
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
		return new String(ch, 0, writer);
	}

	public static void main(String[] args) {
		charOccurence("a");
		System.out.println();
		String string = "this is chair and this is table";
		stringOccurence(string);
	}
}
