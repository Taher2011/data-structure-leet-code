package reverse_string;

public class ReverseString {

	public static String reverseString(String string) {
		char[] ch = string.toCharArray();
		StringBuilder reverseString = new StringBuilder();
		for (int i = ch.length - 1; i >= 0; i--) {
			reverseString.append(ch[i]);
		}
		return new String(reverseString);
	}

	public static String reverseEachWordInString(String sentence) {
		String[] words = sentence.split(" ");
		StringBuilder reverseString = new StringBuilder();
		for (String word : words) {
			char[] ch = word.toCharArray();
			for (int j = ch.length - 1; j >= 0; j--) {
				reverseString.append(ch[j]);
			}
			reverseString.append(" ");
		}
		return new String(reverseString).trim();
	}

	public static String reverseSentence(String sentence) {
		String[] words = sentence.split(" ");
		StringBuilder reverseString = new StringBuilder();
		for (int i = words.length - 1; i >= 0; i--) {
			reverseString.append(words[i] + " ");
		}
		return new String(reverseString).trim();
	}

	public static void main(String[] args) {

		String string = "Taher";
		String reverseString = reverseString(string);
		System.out.println("reverse of originalString '" + string + "' is '" + reverseString + "'");

		string = "Taher is good employee";
		reverseString = reverseString(string);
		System.out.println("reverse of originalString '" + string + "' is '" + reverseString + "'");

		String reverseEachWordInString = reverseEachWordInString(reverseString);
		System.out.println("reverse of originalString '" + reverseString + "' is '" + reverseEachWordInString + "'");

		String reverseSentence = reverseSentence(reverseEachWordInString);
		System.out.println("reverse of originalString '" + reverseEachWordInString + "' is '" + reverseSentence + "'");
	}

}
