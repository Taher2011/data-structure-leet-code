package array_list;

public class ArrayList<T> {

	private Object[] data;
	private int index;
	private int initialCapacity;

	public ArrayList() {
		initialCapacity = 10;
		data = new Object[initialCapacity];
	}

	public int size() {
		return index;
	}

	public boolean add(T value) { // adding at end
		if (size() == initialCapacity) {
			resize();
		}
		data[index++] = value;
		display();
		return true;
	}

	public void add(int index, int value) {
		if (size() == initialCapacity) {
			resize();
		}
		if (index == size()) { // adding at end
			data[index] = value;
			this.index++;
			return;
		}
		for (int i = size() - 1; i >= index; i--) {
			data[i + 1] = data[i];
		}
		System.out.println("reshifting array");
		data[index] = value;
		this.index++;
		display();
	}

	public Integer get(int index) {
		if (index < 0 || index >= size()) {
			System.out.println("index " + index + " not in range");
			return null;
		}
		return (int) data[index];
	}

	public Integer remove(int index) {
		if (index < 0 || index >= size()) {
			System.out.println("index " + index + " not in range");
			return null;
		}
		if (index == size() - 1) { // removing from end
			int removedElement = (int) data[index];
			data[index] = null;
			this.index--;
			display();
			return removedElement;
		}

		int removedElement = (int) data[index];
		for (int i = index; i < size(); i++) {
			data[i] = data[i + 1];
		}
		System.out.println("reshifting array");
		this.index--;
		display();
		return removedElement;
	}

	public void resize() {
		System.out.println("resized array");
		resizeArray();
		copyOldArrayToNewArray();
	}

	private void resizeArray() {
		int newCapacity = (initialCapacity * 3) / 2 + 1;
		initialCapacity = newCapacity;
	}

	private void copyOldArrayToNewArray() {
		Object[] newData = new Object[initialCapacity];
		for (int i = 0; i < data.length; i++) {
			newData[i] = data[i];
		}
		data = newData;

		// data = Arrays.copyOf(data, initialCapacity); alternate approach
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public void display() {
		System.out.print("[");
		for (int i = 0; i < size(); i++) {
			System.out.print(data[i]);
			if (i != size() - 1) {
				System.out.print(",");
			}
		}
		System.out.print("]");
		System.out.println("\nsize : " + size());
		System.out.println("==========================================");
	}

	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<>();
		al.add(1);
		al.add(3);
		al.add(4);
		al.add(5);
		al.add(6);
		al.add(7);
		al.add(8);
		al.add(9);
		al.add(1, 2);
		al.add(0, 0);
		al.add(10);
		al.add(11);
		al.add(12, 12);
		al.add(13, 13);
	}
}
