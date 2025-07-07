package first_non_repeating_char;

public class FindFirstNonRepChar {

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

	public static String findFirstNonRepChar(String str) {
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
			if (count < 2) {
				return "'" + String.valueOf(ch1[i]) + "' is the first non repeating char in the " + str;
			}
		}

		return "no non repeating char are present";
	}

	public static void main(String[] args) {
		String str = "malayalam";
		String firstNonRepChar = findFirstNonRepChar(str);
		System.out.println(firstNonRepChar);
	}

}
