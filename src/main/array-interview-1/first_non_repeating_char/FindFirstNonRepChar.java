package first_non_repeating_char;

public class FindFirstNonRepChar {

	public static String findDuplicates(String str) {
		char[] ch = str.toCharArray();
		StringBuilder builder = new StringBuilder();
		boolean[] read = new boolean[256];
		boolean[] write = new boolean[256];
		for (int i = 0; i < ch.length; i++) {
			if (!read[ch[i]]) {
				read[ch[i]] = true;
			} else {
				if (!write[ch[i]]) {
					builder.append(ch[i]);
					write[ch[i]] = true;
				}
			}
		}
		return new String(builder);
	}

	public static String findFirstNonRepChar(String str) {
		String duplicates = findDuplicates(str);
		char[] ch1 = str.toCharArray();
		char[] ch2 = duplicates.toCharArray();
		for (int i = 0; i < ch1.length; i++) {
			int counter = 0;
			for (int j = 0; j < ch2.length; j++) {
				if (ch1[i] == ch2[j]) {
					counter++;
					break;
				}
			}
			if (counter < 1) {
				return new String(ch1[i] + "");
			}
		}
		return duplicates;
	}

	public static void main(String[] args) {
		String str = "malayalam";
		String firstNonRepChar = findFirstNonRepChar(str);
		System.out.println("'" + firstNonRepChar + "' is the first non repeating char in the " + str);
	}

}
