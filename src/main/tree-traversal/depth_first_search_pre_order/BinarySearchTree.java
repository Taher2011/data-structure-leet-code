package depth_first_search_pre_order;

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

	public ArrayList<Integer> traverse(Node node, ArrayList<Integer> results) {
		results.add(node.value);
		if (node.left != null) {
			traverse(node.left, results);
		}
		if (node.right != null) {
			traverse(node.right, results);
		}
		return results;
	}

	public ArrayList<Integer> DFSPreOrder() {
		ArrayList<Integer> results = new ArrayList<>();
		results = traverse(root, results);
//		class Traverse {
//			public Traverse(Node node) {
//				results.add(node.value);
//				if (node.left != null) {
//					new Traverse(node.left);
//				}
//				if (node.right != null) {
//					new Traverse(node.right);
//				}
//			}
//		}
//		new Traverse(root);
		return results;
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
		System.out.println(bst.DFSPreOrder());
	}

}
