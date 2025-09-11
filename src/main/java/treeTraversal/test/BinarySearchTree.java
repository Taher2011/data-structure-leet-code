package treeTraversal.test;

import java.util.List;

public class BinarySearchTree {

	class Node {
	}

	public boolean rInsert(Node node, int value) {
		return false;
	}

	public boolean rInsert(int value) {
		return rInsert(null, value);
	}

	public List<Integer> BFS() {
		return null;
	}

	public List<Integer> DFSInOrder() {
		return null;
	}

	public List<Integer> DFSPreOrder() {
		return null;
	}

	public List<Integer> DFSPostOrder() {
		return null;
	}

	public Integer kthSmallest(int k) {
		return null;
	}

	public boolean isValidBST() {
		return false;
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
		System.out.println(bst.BFS());
	}
}
