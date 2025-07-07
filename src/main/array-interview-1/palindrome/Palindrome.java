package palindrome;

public class Palindrome {

	public static boolean isPalindrome(String str) {
		for (int i = 0, j = str.toCharArray().length - 1; i < str.length() / 2; i++, j--) {
			if (str.charAt(i) != str.charAt(j)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String str = "mayayalam";
		if (isPalindrome(str)) {
			System.out.println(str + " is palindrome");
		} else {
			System.out.println(str + " is not palindrome");
		}
	}

}
