package binary.binary_tree.test;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {

	private Node root;

	class Node {
		private Node left;
		private Node right;
		private int value;

		public Node(int value) {
			this.value = value;
		}
	}

	public boolean insert(Node node, int value) {
		if (node.value == value) {
			return false;
		}
		if (value < node.value) {
			if (node.left == null) {
				node.left = new Node(value);
				return true;
			}
			return insert(node.left, value);
		} else if (value > node.value) {
			if (node.right == null) {
				node.right = new Node(value);
				return true;
			}
			return insert(node.right, value);
		}
		return false;
	}

	public boolean rInsert(int value) {
		if (root == null) {
			root = new Node(value);
			return true;
		}
		return insert(root, value);
	}

	public boolean rContains(Node node, int value) {
		if (node == null) {
			return false;
		}
		if (node.value == value) {
			return true;
		}
		if (value < node.value) {
			return rContains(node.left, value);
		} else if (value > node.value) {
			return rContains(node.right, value);
		}
		return false;
	}

	public boolean rContains(int value) {
		if (root == null) {
			return false;
		}
		return rContains(root, value);
	}

	public Integer minValue(Node node) {
		Node temp = node;
		if (temp != null) {
			while (temp.left != null) {
				temp = temp.left;
			}
			return temp.value;
		}
		return null;
	}

	public Node deleteNode(Node node, int value) {
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
			} else if (node.right == null) {
				node = node.left;
				return node;
			} else if (node.left == null) {
				node = node.right;
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

	public List<Integer> inOrder(Node node) {
		List<Integer> list = new ArrayList<>();
		class Traverse {
			public Traverse(Node node) {
				if (node.left != null) {
					new Traverse(node.left);
				}
				list.add(node.value);
				if (node.right != null) {
					new Traverse(node.right);
				}
			}
		}
		new Traverse(root);
		return list;
	}

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		System.out.println(bst.rInsert(45));
		System.out.println(bst.rInsert(27));
		System.out.println(bst.rInsert(21));
		System.out.println(bst.rInsert(75));
		System.out.println(bst.rInsert(29));
		System.out.println(bst.rInsert(28));
		System.out.println(bst.rInsert(30));
		System.out.println(bst.inOrder(bst.root));
		System.out.println("================================");
		System.out.println(bst.rContains(27));
		bst.deleteNode(27);
		System.out.println(bst.rContains(27));
		System.out.println("================================");
		System.out.println(bst.inOrder(bst.root));

	}
}
