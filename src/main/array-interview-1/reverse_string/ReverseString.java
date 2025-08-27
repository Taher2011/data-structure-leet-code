package reverse_string;

public class ReverseString {

	public static String reverseString(String string) {
		StringBuilder builder = new StringBuilder();
		for (int i = string.length() - 1; i >= 0; i--) {
			builder.append(string.charAt(i));
		}
		return builder.toString();
	}

	public static String reverseEachWordInString(String sentence) {
		StringBuilder builder = new StringBuilder();
		String[] words = sentence.split(" ");
		for (String word : words) {
			builder.append(reverseString(word) + " ");
		}
		return builder.toString().trim();
	}

	public static String reverseSentence(String sentence) {
		StringBuilder builder = new StringBuilder();
		String[] words = sentence.split(" ");
		for (int i = words.length - 1; i >= 0; i--) {
			builder.append(words[i] + " ");
		}
		return builder.toString().trim();
	}

	public static void main(String[] args) {

		String string = "Indore";
		String reverseString = reverseString(string);
		System.out.println("reverse of string '" + string + "' :: ---> '" + reverseString + "'");
		System.out.println(
				"========================================================================================================");

		string = "Indore is the cleanest city";
		String reverseEachWordInString = reverseEachWordInString(string);
		System.out.println(
				"reverse of each words in the sentence '" + string + "' :: ---> '" + reverseEachWordInString + "'");
		System.out.println(
				"========================================================================================================");

		String reverseSentence = reverseSentence(string);
		System.out.println("reverse of sentence '" + string + "' :: ---> '" + reverseSentence + "'");
		System.out.println(
				"========================================================================================================");
	}

}
