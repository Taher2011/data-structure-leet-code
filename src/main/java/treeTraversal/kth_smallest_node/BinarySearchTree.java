package treeTraversal.kth_smallest_node;

import java.util.ArrayList;
import java.util.Stack;

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

	public ArrayList<Integer> DFSInOrder() {
		ArrayList<Integer> results = new ArrayList<>();
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

	public Integer kthSmallest(int k) {
		Stack<Node> stack = new Stack<>();
		Node current = root;
		while (!stack.isEmpty() || current != null) {
			while (current != null) {
				stack.push(current);
				current = current.left;
			}
			Node poppedNode = stack.pop();
			k--;
			if (k == 0) {
				return poppedNode.value;
			}
			if (poppedNode.right != null) {
				current = poppedNode.right;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.rInsert(5);
		bst.rInsert(3);
		bst.rInsert(2);
		bst.rInsert(4);
		bst.rInsert(7);
		bst.rInsert(6);
		bst.rInsert(8);
		System.out.println(bst.DFSInOrder());
		System.out.println();
		int kth = 4;
		System.out.println(kth + "th smallest element is " + bst.kthSmallest(kth));
	}

}
