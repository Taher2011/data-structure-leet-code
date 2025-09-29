package binary.binary_tree.binary_tree_recursion;

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

	public boolean rInsert(int value) {
		if (root == null) {
			root = new Node(value);
			return true;
		}
		return rInsert(root, value);
	}

	public boolean rInsert(Node node, int value) {
		if (value < node.value) {
			if (node.left == null) {
				node.left = new Node(value);
				return true;
			}
			return rInsert(node.left, value);
		} else if (value > node.value) {
			if (node.right == null) {
				node.right = new Node(value);
				return true;
			}
			return rInsert(node.right, value);
		}
		return false;
	}

	public Node rDeleteNode(Node node, int value) {
		if (root == null) {
			return null;
		}
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
				node = node.left;
				return node;
			} else if (node.left == null) {
				node = node.right;
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

	public boolean rContains(int value) {
		if (root == null) {
			return false;
		}
		return rContains(root, value);
	}

	public boolean rContains(Node node, int value) {
		if (value == node.value) {
			return true;
		}
		if (value < node.value) {
			if (node.left == null) {
				return false;
			}
			return rContains(node.left, value);
		} else if (value > node.value) {
			if (node.right == null) {
				return false;
			}
			return rContains(node.right, value);
		}
		return false;
	}

	public int minValue(Node node) {
		Node temp = node;
		while (temp.left != null) {
			temp = temp.left;
		}
		return temp.value;
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

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		System.out.println(bst.rInsert(47));
		System.out.println(bst.rInsert(27));
		System.out.println(bst.rInsert(76));
		System.out.println(bst.rInsert(25));
		System.out.println(bst.rInsert(37));
		System.out.println(bst.rInsert(33));
		System.out.println(bst.rInsert(38));
		System.out.println("============================");
		System.out.println(bst.DFSInOrder());
		System.out.println("Node 27 exist : " + bst.rContains(27));
		bst.deleteNode(27);
		System.out.println("============================");
		System.out.println(bst.DFSInOrder());
		System.out.println("Node 27 exist : " + bst.rContains(27));
	}

}
