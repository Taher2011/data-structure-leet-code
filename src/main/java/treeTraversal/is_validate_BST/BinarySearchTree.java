package treeTraversal.is_validate_BST;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {

	private Node root;

	class Node {
		private int value;
		private Node left;
		private Node right;

		public Node(int value) {
			super();
			this.value = value;
		}
	}

	public boolean rInsert(Node node, int value) {
		if (root == null) {
			root = new Node(value);
			return true;
		}
		Node temp = node;
		if (value < temp.value) {
			if (temp.left == null) {
				temp.left = new Node(value);
				return true;
			}
			return rInsert(temp.left, value);
		} else if (value > temp.value) {
			if (temp.right == null) {
				temp.right = new Node(value);
				return true;
			}
			return rInsert(temp.right, value);
		} else {
			return false;
		}
	}

	public boolean rInsert(int value) {
		return rInsert(root, value);
	}

	public List<Integer> DFSInOrder() {
		List<Integer> results = new ArrayList<>();
		class Traverse {
			public Traverse(Node node) {
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

	public boolean isValidBST() {
		List<Integer> results = DFSInOrder();
		for (int i = 1; i < results.size(); i++) {
			if (results.get(i) < results.get(i - 1)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.rInsert(47);
		bst.rInsert(21);
		bst.rInsert(76);
		bst.rInsert(18);
		bst.rInsert(27);
		bst.rInsert(82);
		bst.rInsert(52);
		System.out.print(bst.DFSInOrder());
		System.out.print(" is valid BST -> " + bst.isValidBST());
	}

}
