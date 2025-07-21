package reverse_string;

public class ReverseString {

	public static String reverseString(String string) {
		char[] ch = string.toCharArray();
		StringBuilder sb = new StringBuilder();
		for (int i = ch.length - 1; i >= 0; i--) {
			sb.append(ch[i]);
		}
		return new String(sb);
	}

	public static String reverseEachWordInString(String sentence) {
		String[] words = sentence.split(" ");
		StringBuilder sb = new StringBuilder();
		for (String word : words) {
			sb.append(reverseString(word) + " ");
		}
		return new String(sb).trim();
	}

	public static String reverseSentence(String sentence) {
		String[] words = sentence.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = words.length - 1; i >= 0; i--) {
			sb.append(words[i] + " ");
		}
		return new String(sb).trim();
	}

	public static void main(String[] args) {

		String string = "Indore";
		String reverseString = reverseString(string);
		System.out.println("reverse of string '" + string + "' is ---> '" + reverseString + "'");

		string = "Indore is the cleanest city";
		String reverseEachWordInString = reverseEachWordInString(string);
		System.out.println(
				"reverse of each words in the sentence '" + string + "' is ---> '" + reverseEachWordInString + "'");

		String reverseSentence = reverseSentence(string);
		System.out.println("reverse of sentence '" + string + "' is ---> '" + reverseSentence + "'");
	}

}
