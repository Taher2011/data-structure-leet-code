package merge_sort;

import java.util.Arrays;

public class MergeSort {

	public static int[] merge(int[] a1, int[] a2) {
		int a3[] = new int[a1.length + a2.length];
		int index = 0;
		int i = 0;
		int j = 0;
		while (i < a1.length && j < a2.length) {
			if (a1[i] < a2[j]) {
				a3[index] = a1[i];
				i++;
			} else {
				a3[index] = a2[j];
				j++;
			}
			index++;
		}
		while (i < a1.length) {
			a3[index] = a1[i];
			i++;
			index++;
		}
		while (j < a2.length) {
			a3[index] = a2[j];
			j++;
			index++;
		}
		return a3;
	}

	public static int[] merge(int[] a) {
		if (a.length == 1) {
			return a;
		}
		int middle = a.length / 2;
		int[] left = merge(Arrays.copyOfRange(a, 0, middle));
		int[] right = merge(Arrays.copyOfRange(a, middle, a.length));
		return merge(left, right);
	}

	public static void main(String[] args) {
//		int[] a1 = { 1, 3, 7, 8 };
//		int[] a2 = { 2, 4, 5, 6 };
//		int[] a3 = merge(a1, a2);
//		System.out.println(Arrays.toString(a3));

		int[] a1 = { 3, 2, 5, 8, 6, 4 };
		System.out.println("before  sorting " + Arrays.toString(a1));
		int[] a2 = merge(a1);
		System.out.println("before  sorting " + Arrays.toString(a2));
	}

}
