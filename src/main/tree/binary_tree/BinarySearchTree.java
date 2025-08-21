package binary_tree;

public class BinarySearchTree {

	private Node root;

	private class Node {
		private int value;
		private Node left;
		private Node right;

		public Node(int value) {
			this.value = value;
		}
	}

	public boolean insert(int value) {
		if (root == null) {
			root = new Node(value);
			return true;
		}
		Node temp = root;
		while (true) {
			if (value < temp.value) {
				if (temp.left == null) {
					temp.left = new Node(value);
					return true;
				}
				temp = temp.left;
			} else if (value > temp.value) {
				if (temp.right == null) {
					temp.right = new Node(value);
					return true;
				}
				temp = temp.right;
			} else {
				return false;
			}
		}
	}

	public boolean contains(int value) {
		if (root != null) {
			if (root.value == value) {
				return true;
			}
			Node temp = root;
			while (true) {
				if (value < temp.value) {
					if (temp.left == null) {
						return false;
					}
					temp = temp.left;
				} else if (value > temp.value) {
					if (temp.right == null) {
						return false;
					}
					temp = temp.right;
				} else {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		System.out.println(bst.insert(45));
		System.out.println(bst.insert(27));
		System.out.println(bst.insert(47));
		System.out.println(bst.insert(26));
		System.out.println(bst.insert(27));
		System.out.println(bst.insert(26));
		System.out.println(bst.insert(25));
		System.out.println(bst.insert(25));
		System.out.println(bst.insert(28));
		System.out.println("===========================================");
		System.out.println(bst.contains(55));
		System.out.println(bst.contains(27));
		System.out.println(bst.contains(47));
		System.out.println(bst.contains(26));
		System.out.println(bst.contains(38));
	}
}
