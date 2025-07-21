package anagram;

public class Anagram2 {

	public static boolean isAnagram(String str1, String str2) {
		if (str1 == null || str2 == null) {
			return false;
		}
		if (str1.length() != str2.length()) {
			return false;
		}
		str1 = sort(str1.toLowerCase());
		str2 = sort(str2.toLowerCase());
		char[] ch1 = str1.toCharArray();
		char[] ch2 = str2.toCharArray();
		for (int i = 0; i < ch1.length; i++) {
			if (ch1[i] != ch2[i]) {
				return false;
			}
		}
		return true;
	}

	public static String sort(String str) {
		char[] ch = str.toCharArray();
		for (int i = ch.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (ch[j] > ch[j + 1]) {
					char temp = ch[j];
					ch[j] = ch[j + 1];
					ch[j + 1] = temp;
				}
			}
		}
		return new String(ch);
	}

	public static void main(String[] args) {
		String str1 = "rat!";
		String str2 = "tar!";

		if (isAnagram(str1, str2)) {
			System.out.println(str1 + " and " + str2 + " are anagram");
		} else {
			System.out.println(str1 + " and " + str2 + " are not anagram");
		}
	}

}
