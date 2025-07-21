package find_duplicate;

public class FindDuplicate {

	public static String findDuplicates(String str) {
		char[] ch = str.toCharArray();

		boolean[] read = new boolean[256];
		boolean[] write = new boolean[256];

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < ch.length; i++) {
			if (!read[ch[i]]) {
				read[ch[i]] = true;
			} else {
				if (!write[ch[i]]) {
					sb.append(ch[i]);
					write[ch[i]] = true;
				}
			}
		}
		return new String(sb);
	}

	public static void main(String[] args) {
		String str = "malayalam";
		String duplicates = findDuplicates(str);
		if (duplicates.isEmpty()) {
			System.out.println("No duplicates found in string '" + str + "'");
		} else {
			System.out.println("'" + duplicates + "' are duplicates in string '" + str + "'");
		}
	}

}
