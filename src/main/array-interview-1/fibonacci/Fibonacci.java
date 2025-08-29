package fibonacci;

public class Fibonacci {

	public static void fibonacci(int count) {
		if (count != 0) {
			int n1 = 0;
			int n2 = 1;
			System.out.print(n1 + "," + n2);
			while (count > 2) {
				int n3 = n1 + n2;
				System.out.print("," + n3);
				n1 = n2;
				n2 = n3;
				count--;
			}
			return;
		}
		System.out.print(count);
	}

	public static void main(String[] args) {
		fibonacci(2);
	}

}
