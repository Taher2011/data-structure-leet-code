package find_duplicate;

public class FindDuplicate {

	public static String findDuplicates(String str) {
		boolean[] seen = new boolean[256];
		boolean[] added = new boolean[256];
		char[] ch = str.toCharArray();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < ch.length; i++) {
			if (seen[ch[i]]) {
				if (!added[ch[i]]) {
					sb.append(ch[i]);
					added[ch[i]] = true;
				}
			} else {
				seen[ch[i]] = true;
			}
		}
		return new String(sb);
	}

	public static void main(String[] args) {
		String str = "cool";
		String duplicates = findDuplicates(str);
		System.out.println("'" + duplicates + "' are duplicates in string " + str);
	}

}
