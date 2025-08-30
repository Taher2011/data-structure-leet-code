package binary_tree;

import java.util.ArrayList;
import java.util.List;

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
		Node node = root;
		while (true) {
			if (value == node.value) {
				return false;
			}
			if (value < node.value) {
				if (node.left == null) {
					node.left = new Node(value);
					return true;
				}
				node = node.left;
			} else {
				if (value > node.value) {
					if (node.right == null) {
						node.right = new Node(value);
						return true;
					}
					node = node.right;
				}
			}
		}
	}

	public boolean contains(int value) {
		if (root == null) {
			return false;
		}
		Node node = root;
		while (true) {
			if (value == node.value) {
				return true;
			}
			if (value < node.value) {
				if (node.left == null) {
					return false;
				}
				node = node.left;
			} else {
				if (value > node.value) {
					if (node.right == null) {
						return false;
					}
					node = node.right;
				}
			}
		}
	}

	public List<Integer> DFSInOrder() {
		List<Integer> list = new ArrayList<>();
		class Traverse {
			public Traverse(Node node) {
				Node temp = node;
				if (temp.left != null) {
					new Traverse(temp.left);
				}
				list.add(temp.value);
				if (temp.right != null) {
					new Traverse(temp.right);
				}
			}
		}
		new Traverse(root);
		return list;
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
		System.out.println(bst.DFSInOrder());
		System.out.println("===========================================");
		System.out.println(bst.contains(55));
		System.out.println(bst.contains(27));
		System.out.println(bst.contains(47));
		System.out.println(bst.contains(26));
		System.out.println(bst.contains(38));
	}
}
