package interview.array_interview_2.find_duplicate;

public class FindDuplicate {

	public static String findDuplicates(String str) {
		if (str != null && !str.isBlank()) {
			char[] ch = str.toCharArray();
			boolean[] read = new boolean[256];
			boolean[] write = new boolean[256];
			StringBuilder builder = new StringBuilder();
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

	public static void main(String[] args) {
		String str = "malayalam";
		String duplicates = findDuplicates(str);
		if (duplicates == null) {
			System.out.println("string cannot be null");
		} else if (!duplicates.isEmpty()) {
			System.out.println("'" + duplicates + "' are duplicates in string '" + str + "'");
		} else {
			System.out.println("No duplicates found in string '" + str + "'");
		}
	}

}
