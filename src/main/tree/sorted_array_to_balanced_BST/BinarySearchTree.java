package sorted_array_to_balanced_BST;

import java.util.ArrayList;
import java.util.List;

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

	public List<Integer> DFSInOrder() {
		List<Integer> results = new ArrayList<>();
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

	public Node sortedArrayToBST(int[] nums, int left, int right) {
		if (left > right) {
			return null;
		}
		int middle = left + (right - left) / 2;
		Node node = new Node(nums[middle]);
		node.left = sortedArrayToBST(nums, left, middle - 1);
		node.right = sortedArrayToBST(nums, middle + 1, right);
		return node;
	}

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		int[] nums = { 1, 2, 3, 4, 5 };
		bst.root = bst.sortedArrayToBST(nums, 0, nums.length - 1);
		System.out.println(bst.DFSInOrder());
	}
}
