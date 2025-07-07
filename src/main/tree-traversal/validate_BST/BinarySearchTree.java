package validate_BST;

import java.util.ArrayList;

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

	public ArrayList<Integer> traverse(Node node, ArrayList<Integer> list) {
		if (node.left != null) {
			traverse(node.left, list);
		}
		list.add(node.value);
		if (node.right != null) {
			traverse(node.right, list);
		}
		return list;
	}

	public ArrayList<Integer> DFSInOrder() {
		ArrayList<Integer> list = new ArrayList<>();
		return traverse(root, list);
	}

	public boolean isValidBST() {
		ArrayList<Integer> list = DFSInOrder();
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i) < list.get(i - 1)) {
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
		bst.rInsert(52);
		bst.rInsert(82);
		System.out.println(bst.isValidBST());
	}

}
