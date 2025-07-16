package binary_tree_recursion;

import java.util.ArrayList;

public class BinarySearchTree {

	private Node root;

	class Node {
		private int value;
		private Node left;
		private Node right;

		public Node(int value) {
			this.value = value;
		}
	}

	public boolean rInsert(Node node, int value) {
		if (root == null) {
			Node newNode = new Node(value);
			root = newNode;
			return true;
		}
		if (value < node.value) {
			if (node.left == null) {
				Node newNode = new Node(value);
				node.left = newNode;
				return true;
			}
			return rInsert(node.left, value);
		} else if (value > node.value) {
			if (node.right == null) {
				Node newNode = new Node(value);
				node.right = newNode;
				return true;
			}
			return rInsert(node.right, value);
		} else {
			return false;
		}
	}

	public boolean rInsert(int value) {
		return rInsert(root, value);
	}

	public boolean rContains(Node node, int value) {
		if (root == null) {
			return false;
		}
		if (value == node.value) {
			return true;
		}
		if (value < node.value) {
			if (node.left == null) {
				return false;
			}
			return rContains(node.left, value);
		} else if (value > node.value) {
			if (node.right == null) {
				return false;
			}
			return rContains(node.right, value);
		}
		return false;
	}

	public boolean rContains(int value) {
		return rContains(root, value);
	}

	public Node deleteNode(Node node, int value) {
		if (root == null) {
			return null;
		}
		if (node == null) {
			return null;
		}
		if (value < node.value) {
			node.left = deleteNode(node.left, value);
			return node;
		} else if (value > node.value) {
			node.right = deleteNode(node.right, value);
			return node;
		} else {
			if (node.left == null && node.right == null) {
				return null;
			} else if (node.left == null) {
				node = node.right;
				return node;
			} else if (node.right == null) {
				node = node.left;
				return node;
			} else {
				int minValue = minValue(node.right);
				node.value = minValue;
				node.right = deleteNode(node.right, minValue);
				return node;
			}
		}
	}

	public void deleteNode(int value) {
		deleteNode(root, value);
	}

	public int minValue(Node node) {
		while (node.left != null) {
			node = node.left;
		}
		return node.value;
	}

	public ArrayList<Integer> DFSInOrder() {
		ArrayList<Integer> results = new ArrayList<>();
		class Traverse {
			private Traverse(Node node) {
				if (node.left != null) {
					new Traverse(node.left);
				}
				results.add(node.value);
				if (node.right != null) {
					new Traverse(node.right);
				}
			}
		}
		new Traverse(root);
		return results;
	}

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		System.out.println(bst.rInsert(47));
		System.out.println(bst.rInsert(27));
		System.out.println(bst.rInsert(76));
		System.out.println(bst.rInsert(25));
		System.out.println(bst.rInsert(37));
		System.out.println(bst.rInsert(33));
		System.out.println(bst.rInsert(38));
		System.out.println("============================");
		System.out.println(bst.DFSInOrder());
		System.out.println("============================");
		System.out.println(bst.rContains(27));
		bst.deleteNode(27);
		System.out.println(bst.rContains(27));
		System.out.println("============================");
		System.out.println(bst.DFSInOrder());

	}
}
