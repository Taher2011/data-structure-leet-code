package anagram;

public class Anagram {

	public static void sort(char[] a) {
		for (int i = a.length - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				if (a[j] > a[j + 1]) {
					char temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
	}

	public static boolean isAnagram(String s1, String s2) {
		if (s1 == null || s2 == null) {
			return false;
		}
		if (s1.length() != s2.length()) {
			return false;
		}
		char[] ch1 = s1.toCharArray();
		char[] ch2 = s2.toCharArray();

		sort(ch1);
		sort(ch2);

		for (int i = 0; i < ch1.length; i++) {
			if (ch1[i] != ch2[i]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String str1 = "listen";
		String str2 = "silent";
		if (isAnagram(str1, str2)) {
			System.out.println(str1 + " and " + str2 + " are anagram");
		} else {
			System.out.println(str1 + " and " + str2 + " are not anagram");
		}
	}

}
