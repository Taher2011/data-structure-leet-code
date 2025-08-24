package merge_sort;

import java.util.Arrays;

public class MergeSort {

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
		int a1[] = { 2, 4, 6, 8 };
		int a2[] = { 3, 5, 7, 9 };
		int a3[] = merge(a1, a2);
		System.out.println(Arrays.toString(a3));
		System.out.println("========================");

		int a4[] = { 3, 5, 7, 9, 2, 4, 6, 8 };
		System.out.println("before  sorting " + Arrays.toString(a4));
		a4 = mergeSort(a4);
		System.out.println("after   sorting " + Arrays.toString(a4));
	}
}
