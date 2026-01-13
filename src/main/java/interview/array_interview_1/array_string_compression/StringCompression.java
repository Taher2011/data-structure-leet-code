package interview.array_interview_1.array_string_compression;

public class StringCompression {

	public static String stringCompression(String str) {
		StringBuilder builder = new StringBuilder();
		int counter = 1;
		for (int i = 1; i <= str.length(); i++) {
			if (i == str.length()) {
				builder.append(str.charAt(i - 1)).append(counter);
				break;
			}
			if (str.charAt(i - 1) == str.charAt(i)) {
				counter++;
			} else {
				builder.append(str.charAt(i - 1)).append(counter);
				counter = 1;
			}
		}
		return builder.toString();
	}

	public static void main(String[] args) {
		String s = "aabcccccaaaeeee";
		System.out.println(stringCompression(s));
	}

}
