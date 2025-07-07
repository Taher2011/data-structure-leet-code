package sorted_array_to_balanced_BST;

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

	public Node sortedArray(int[] nums) {
		return sortedArrayToBST(nums, 0, nums.length - 1);
	}

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		int[] nums = { 1, 2, 3, 4, 5 };
		bst.root = bst.sortedArray(nums);
	}
}
