package breadth_first_search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

	public List<Integer> BFS() {
		List<Integer> results = new ArrayList<>();
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node removedNode = queue.remove();
			results.add(removedNode.value);
			if (removedNode.left != null) {
				queue.add(removedNode.left);
			}
			if (removedNode.right != null) {
				queue.add(removedNode.right);
			}
		}
		return results;
	}

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.rInsert(21);
		bst.rInsert(76);
		bst.rInsert(18);
		bst.rInsert(27);
		bst.rInsert(52);
		bst.rInsert(47);
		bst.rInsert(82);
		System.out.println(bst.BFS());
	}

}
