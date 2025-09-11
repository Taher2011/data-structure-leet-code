package tree.test;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {

	private Node root;

	private class Node {
		private Node left;
		private Node right;
		private int value;

		public Node(int value) {
			this.value = value;
		}
	}

	public boolean rInsert(Node node, int value) {
		if (node.value == value) {
			return false;
		}
		if (value < node.value) {
			if (node.left == null) {
				node.left = new Node(value);
				return true;
			}
			return rInsert(node.left, value);
		} else {
			if (node.right == null) {
				node.right = new Node(value);
				return true;
			}
			return rInsert(node.right, value);
		}
	}

	public boolean rInsert(int value) {
		if (root == null) {
			root = new Node(value);
			return true;
		}
		return rInsert(root, value);
	}

	public Node rDeleteNode(Node node, int value) {
		if (node == null) {
			return null;
		}
		if (value < node.value) {
			node.left = rDeleteNode(node.left, value);
			return node;
		} else if (value > node.value) {
			node.right = rDeleteNode(node.right, value);
			return node;
		} else {
			if (node.left == null && node.right == null) {
				node = null;
				return node;
			} else if (node.right == null) {
				node.value = node.left.value;
				node.left = null;
				return node;
			} else if (node.left == null) {
				node.value = node.right.value;
				node.right = null;
				return node;
			} else {
				int minValue = minValue(node.right);
				node.value = minValue;
				node.right = rDeleteNode(node.right, minValue);
				return node;
			}
		}
	}

	public void deleteNode(int value) {
		rDeleteNode(root, value);
	}

	public boolean rContains(Node node, int value) {
		if (root == null) {
			return false;
		}
		if (node.value == value) {
			return true;
		}
		if (value < node.value) {
			if (node.left == null) {
				return false;
			}
			return rContains(node.left, value);
		} else {
			if (node.right == null) {
				return false;
			}
			return rContains(node.right, value);
		}
	}

	public boolean rContains(int value) {
		return rContains(root, value);
	}

	public int minValue(Node node) {
		Node temp = node;
		while (temp.left != null) {
			temp = temp.left;
		}
		return temp.value;
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

	public Node invertTree(Node node) {
		return null;
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
//		BinarySearchTree bst = new BinarySearchTree();
//		System.out.println(bst.rInsert(47));
//		System.out.println(bst.rInsert(27));
//		System.out.println(bst.rInsert(76));
////		System.out.println(bst.rInsert(25));
////		System.out.println(bst.rInsert(37));
////		System.out.println(bst.rInsert(33));
////		System.out.println(bst.rInsert(38));
//		System.out.println("============================");
//		System.out.println(bst.DFSInOrder());
//		System.out.println("Node 27 exist : " + bst.rContains(27));
//		bst.deleteNode(29);
//		System.out.println("============================");
//		System.out.println(bst.DFSInOrder());
//		System.out.println("Node 27 exist : " + bst.rContains(27));

		BinarySearchTree bst = new BinarySearchTree();
		int[] nums = { 1, 2, 3, 4, 5 };
		bst.root = bst.sortedArrayToBST(nums, 0, nums.length - 1);
		System.out.println(bst.DFSInOrder());
	}

}
