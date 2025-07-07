package invert_binary_tree;

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

	public boolean rInsert(Node node, int value) {
		if (root == null) {
			root = new Node(value);
			return true;
		}
		Node currentNode = node;
		if (value < currentNode.value) {
			if (currentNode.left == null) {
				currentNode.left = new Node(value);
				return true;
			}
			return rInsert(currentNode.left, value);
		} else if (value > currentNode.value) {
			if (currentNode.right == null) {
				currentNode.right = new Node(value);
				return true;
			}
			return rInsert(currentNode.right, value);
		} else {
			return false;
		}
	}

	public boolean rInsert(int value) {
		return rInsert(root, value);
	}

	public Node invertTree(Node node) {
		if (root != null) {
			if (node == null) {
				return null;
			}
			Node temp = node.left;
			node.left = invertTree(node.right);
			node.right = invertTree(temp);
			return node;
		}
		return null;
	}

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		System.out.println(bst.rInsert(47));
		System.out.println(bst.rInsert(21));
		System.out.println(bst.rInsert(76));
		System.out.println(bst.rInsert(18));
		System.out.println(bst.rInsert(27));
		System.out.println(bst.rInsert(52));
		System.out.println(bst.rInsert(82));
		bst.invertTree(bst.root);
		System.out.println();
	}
}
