package interview.array_interview_2.anagram;

public class Anagram {

	public static void sort(char[] ch) {
		for (int i = ch.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (ch[j] > ch[j + 1]) {
					char temp = ch[j];
					ch[j] = ch[j + 1];
					ch[j + 1] = temp;
				}
			}
		}
	}

	public static boolean isAnagram(String s1, String s2) {
		if ((s1 != null && s2 != null) && (s1.length() == s2.length())) {

			char[] ch1 = s1.toCharArray();
			char[] ch2 = s2.toCharArray();

			sort(ch1);
			sort(ch2);

			for (int i = 0, j = 0; i < ch1.length; i++, j++) {
				if (ch1[i] != ch2[j]) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		String str1 = "listen";
		String str2 = "silent";
		if (isAnagram(str1, str2)) {
			System.out.println(str1 + " and " + str2 + " are anagram");
		} else {
			System.out.println(str1 + " and " + str2 + " are not anagram");
		}

		System.out.println("================================================");

		String str3 = "lasten";
		String str4 = "silent";
		if (isAnagram(str3, str4)) {
			System.out.println(str3 + " and " + str4 + " are anagram");
		} else {
			System.out.println(str3 + " and " + str4 + " are not anagram");
		}
	}

}
