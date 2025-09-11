package arrayInterview1.first_non_repeating_char;

public class FindFirstNonRepChar {

	public static String findDuplicates(String str) {
		if (str != null && !str.isBlank()) {
			boolean[] write = new boolean[256];
			boolean[] read = new boolean[256];
			StringBuilder builder = new StringBuilder();
			char[] ch = str.toCharArray();
			for (char c : ch) {
				if (read[c]) {
					if (!write[c]) {
						builder.append(c);
						write[c] = true;
					}
				} else {
					read[c] = true;
				}
			}
			return builder.toString();
		}
		return null;
	}

	public static String removeDuplicates(String str) {
		if (str != null && !str.isBlank()) {
			boolean[] seen = new boolean[256];
			StringBuilder builder = new StringBuilder();
			char[] ch = str.toCharArray();
			for (char c : ch) {
				if (!seen[c]) {
					builder.append(c);
					seen[c] = true;
				}
			}
			return builder.toString();
		}
		return null;
	}

	public static String findFirstNonRepChar(String str) {
		if (str != null && !str.trim().isBlank()) {
			String duplicates = findDuplicates(str);
			String nonDuplicates = removeDuplicates(str);
			char[] ch1 = nonDuplicates.toCharArray();
			char[] ch2 = duplicates.toCharArray();
			for (int i = 0; i < ch1.length; i++) {
				boolean nonReapting = false;
				for (int j = 0; j < ch2.length; j++) {
					if (ch1[i] == ch2[j]) {
						nonReapting = true;
						break;
					}
				}
				if (!nonReapting) {
					return "" + ch1[i];
				}
			}
		}
		return null;
	}

	public static void main(String[] args) {
		String str = "malayalam";
		String firstNonRepChar = findFirstNonRepChar(str);
		if (firstNonRepChar != null) {
			System.out.println("'" + firstNonRepChar + "' is the first non repeating char in the " + str);
		} else {
			System.out.println("string cannot be null or empty");
		}
	}

}
