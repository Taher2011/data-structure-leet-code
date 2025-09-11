package sort.merge_sort;

import java.util.Arrays;

public class MergeSort {

	public static String[] merge(String a1[], String a2[]) {
		String[] a3 = new String[a1.length + a2.length];
		int index = 0;
		int i = 0;
		int j = 0;
		while (i < a1.length && j < a2.length) {
//			Negative (< 0) → a1[i] comes before a2[j] (dictionary/order wise chhota hai).
//			Zero (== 0) → a1[i] and a2[j] are equal.
//			Positive (> 0) → a1[i] comes after a2[j] (dictionary/order wise bada hai).

			if (a1[i].compareTo(a2[j]) < 0) { // In short: a1[i].compareTo(a2[j]) <= 0 ka matlab hai: "Agar a1[i] chhota
												// ya equal hai a2[j] se, to pehle a1[i] ko rakho."
				a3[index++] = a1[i];
				i++;
			} else {
				a3[index++] = a2[j];
				j++;
			}
		}
		while (i < a1.length) {
			a3[index++] = a1[i];
			i++;
		}
		while (j < a2.length) {
			a3[index++] = a2[j];
			j++;
		}
		return a3;
	}

	public static String[] mergeSort(String a[]) {
		if (a.length == 1) {
			return a;
		}
		int middle = a.length / 2;
		String[] left = mergeSort(Arrays.copyOfRange(a, 0, middle));
		String[] right = mergeSort(Arrays.copyOfRange(a, middle, a.length));
		return merge(left, right);
	}

	public static int[] merge(int a1[], int a2[]) {
		int[] a3 = new int[a1.length + a2.length];
		int index = 0;
		int i = 0;
		int j = 0;
		while (a1.length > i && a2.length > j) {
			if (a1[i] < a2[j]) {
				a3[index++] = a1[i];
				i++;
			} else {
				a3[index++] = a2[j];
				j++;
			}
		}
		while (a1.length > i) {
			a3[index++] = a1[i];
			i++;
		}
		while (a2.length > j) {
			a3[index++] = a2[j];
			j++;
		}
		return a3;
	}

	public static int[] mergeSort(int a[]) {
		if (a.length == 1) {
			return a;
		}
		int middle = a.length / 2;
		int[] left = mergeSort(Arrays.copyOfRange(a, 0, middle));
		int[] right = mergeSort(Arrays.copyOfRange(a, middle, a.length));
		return merge(left, right);
	}

	public static void main(String[] args) {
		int[] a1 = { 2, 4, 6, 8 };
		int[] a2 = { 3, 5, 7, 9 };
		int[] a3 = merge(a1, a2);
		System.out.println(Arrays.toString(a3));

		int[] a4 = { 3, 5, 7, 9, 2, 4, 6, 8 };
		System.out.println("before  sorting " + Arrays.toString(a4));
		a4 = mergeSort(a4);
		System.out.println("after   sorting " + Arrays.toString(a4));

		System.out.println("=======================================================");

		String[] s1 = { "apple", "mango", "orange" };
		String[] s2 = { "banana", "grape", "kiwi" };
		String[] s3 = merge(s1, s2);
		System.out.println(Arrays.toString(s3));

		String[] s4 = { "mango", "banana", "apple", "kiwi", "grape", "orange" };
		System.out.println("before  sorting " + Arrays.toString(s4));
		s4 = mergeSort(s4);
		System.out.println("after   sorting " + Arrays.toString(s4));
	}
}
