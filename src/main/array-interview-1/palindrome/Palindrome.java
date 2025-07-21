package palindrome;

public class Palindrome {

	public static boolean isPalindrome(String str) {
		char[] ch = str.toCharArray();
		for (int i = 0, j = ch.length - 1; i < ch.length / 2; i++, j--) {
			if (ch[i] != ch[j]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String str = "malayalam";
		if (isPalindrome(str)) {
			System.out.println(str + " is palindrome");
		} else {
			System.out.println(str + " is not palindrome");
		}
	}

}
