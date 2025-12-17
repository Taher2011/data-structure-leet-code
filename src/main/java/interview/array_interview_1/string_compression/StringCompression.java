package interview.array_interview_1.string_compression;

public class StringCompression {

	// input --> aabcccccaaa
	// output --> a2b1c5a3

	public static String compress(String s) {
		StringBuilder sb = new StringBuilder();
		char[] ch = s.toCharArray();
		int counter = 1;
		for (int i = 1; i < ch.length; i++) {
			if (ch[i - 1] == ch[i]) {
				counter++;
			} else {
				sb.append(ch[i - 1]).append(counter);
				counter = 1;
			}
			if (i == ch.length - 1) {
				sb.append(ch[i - 1]).append(counter);
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String s = "aabcccccaaaeeee";
		System.out.println(compress(s));
	}

}
