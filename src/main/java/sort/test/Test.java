package sort.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

	public static void bubbleSort(int[] a) {
		for (int i = a.length - 1; i > 0; i--) {
			boolean noSwap = false;
			for (int j = 0; j < i; j++) {
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
					noSwap = true;
				}
			}
			if (!noSwap) {
				System.out.println("array is sorted now");
				break;
			}
		}
	}

	public static int[] mergeAndSort(int[] a1, int[] a2) {
		int[] a3 = new int[a1.length + a2.length];
		int index = 0;
		int i = 0;
		int j = 0;
		while (i < a1.length && j < a2.length) {
			if (a1[i] > a2[j]) {
				a3[index++] = a2[j++];
			} else {
				a3[index++] = a1[i++];
			}
		}
		while (i < a1.length) {
			a3[index++] = a1[i++];
		}
		while (j < a2.length) {
			a3[index++] = a2[j++];
		}
		return a3;
	}

	public static int[] mergeSort(int[] a) {
		if (a.length == 1) {
			return a;
		}
		int middle = a.length / 2;
		int[] left = mergeSort(Arrays.copyOfRange(a, 0, middle));
		int[] right = mergeSort(Arrays.copyOfRange(a, middle, a.length));
		return mergeAndSort(left, right);
	}

	private List<Integer> list = new ArrayList<>();

	public List<Integer> getList() {
		return new ArrayList<>(list);
	}

	public int leftIndex(int index) {
		return index * 2 + 1;
	}

	public int rightIndex(int index) {
		return index * 2 + 2;
	}

	public int parentIndex(int index) {
		return (index - 1) / 2;
	}

	public void swap(int index1, int index2) {
		int temp = list.get(index2);
		list.set(index2, list.get(index1));
		list.set(index1, temp);
	}

	public void insert(int value) {
		list.add(value);
		int currentIndex = list.size() - 1;
		while (currentIndex != 0 && list.get(currentIndex) < list.get(parentIndex(currentIndex))) {
			swap(currentIndex, parentIndex(currentIndex));
			currentIndex = parentIndex(currentIndex);
		}
	}

	public Integer remove() {
		if (list.isEmpty()) {
			return null;
		}
		if (list.size() == 1) {
			return list.remove(0);
		}
		Integer remove = list.get(0);
		list.set(0, list.remove(list.size() - 1));
		sinkDown(0);
		return remove;
	}

	public void sinkDown(int currentIndex) {
		int maxIndex = currentIndex;
		while (true) {
			int leftIndex = leftIndex(maxIndex);
			int rightIndex = rightIndex(maxIndex);
			if (leftIndex < list.size() && list.get(leftIndex) < list.get(maxIndex)) {
				maxIndex = leftIndex;
			}
			if (rightIndex < list.size() && list.get(rightIndex) < list.get(maxIndex)) {
				maxIndex = rightIndex;
			}
			if (maxIndex != currentIndex) {
				swap(maxIndex, currentIndex);
				currentIndex = maxIndex;
			} else {
				break;
			}
		}
	}

	public static int[] heapSort(int[] a3) {
		Test t = new Test();
		for (int i : a3) {
			t.insert(i);
		}
		List<Integer> ll = new ArrayList<>();
		while (!t.list.isEmpty()) {
			ll.add(0, t.remove());
		}
		a3 = ll.stream().mapToInt(Integer::intValue).toArray();
		return a3;
	}

	public void buildMaxheap(int[] a) {
		for (int i : a) {
			insert(i);
		}
	}

	public void buildMinheap(int[] a) {
		for (int i : a) {
			insert(i);
		}
	}

	public static void main(String[] args) {
		int[] a1 = { 5, 1, 7, 3, 6, 4, 8, 2 };
		System.out.println("before sorting        " + Arrays.toString(a1));
		bubbleSort(a1);
		System.out.println("after bubble sorting  " + Arrays.toString(a1));

		int[] a2 = { 5, 1, 7, 3, 6, 4, 8, 2 };
		System.out.println("\nbefore sorting        " + Arrays.toString(a2));
		System.out.println("after merge sorting   " + Arrays.toString(mergeSort(a2)));

		int[] a3 = { 5, 1, 7, 3, 6, 4, 8, 2 };
		System.out.println("\nbefore sorting        " + Arrays.toString(a3));

		Test t = new Test();
		t.buildMinheap(a3);
		System.out.println("actual maxHeap        " + t.getList());
		System.out.println("after merge sorting   " + Arrays.toString(heapSort(a3)));
		System.out.println("actual maxHeap        " + t.getList());

	}
}
