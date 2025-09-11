package arrayInterview1.permutation;

public class Permutation {

//	Example 1: String = "GOD" (No duplicates)
//	 		Formula: n! / (r1! × r2! × r3!)
//			Step 1: Identify n and frequencies
//			Total characters (n) = 3 (G, O, D)
//			Frequencies:
//			G, O, D each repeat 1 time (r1 = 1, r2 = 1, r3 = 1)
//			Step 2: Apply formula
//			Formula: n! / (r1! × r2! × r3!)
//			n! = 3! = 6
//			r1! = r2! = r3! = 1! = 1
//			Permutations = 6 / (1 × 1 × 1) = 6
//			Step 3: Verify permutations
//			Possible unique permutations of "GOD":
//			GOD
//			GDO
//			OGD
//			ODG
//			DGO
//			DOG
//			Total = 6, which matches.

//	Example 2: String = "AAB" (Duplicate characters)
//			Formula: n! / (r1! × r2!)		
//			Step 1: Identify n and frequencies
//			Total characters (n) = 3 (A, A, B)
//			Frequencies:
//			A repeats 2 times (r1 = 2)
//			B repeats 1 time (r2 = 1)
//			Step 2: Apply formula
//			Formula: n! / (r1! × r2!)
//			n! = 3! = 3 × 2 × 1 = 6
//			r1! = 2! = 2 × 1 = 2 (for A)
//			r2! = 1! = 1 (for B)
//			Permutations = 6 / (2 × 1) = 6 / 2 = 3
//			Step 3: Verify permutations
//			Possible unique permutations of "AAB":
//			AAB
//			ABA
//			BAA
//			Total = 3, which matches the formula.

	public static void permute(char[] a, int index) {
		if (index == a.length) {
			System.out.println(a);
			return;
		}
		for (int i = index; i < a.length; i++) {
			// Skip if current character is same as previous character to avoid duplicates
			if (i > index && a[i] == a[i - 1]) {
				continue;
			}
			swap(a, i, index);
			permute(a, index + 1);
			swap(a, i, index); // Backtrack
		}
	}

	public static void swap(char[] a, int i, int j) {
		char temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		String str = "GODYI";
		System.out.println("Permutations of " + str + ":");

		permute(str.toCharArray(), 0);
		System.out.println("===============================");

		str = "AAB";
		System.out.println("Permutations of " + str + ":");
		permute(str.toCharArray(), 0);
	}

}
