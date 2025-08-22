package test;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {

	private class Node {
	}

	public boolean rInsert(int value) {
		return true;
	}

	public boolean rInsert(Node node, int value) {
		return false;
	}

	public Node rDeleteNode(Node node, int value) {
		return null;
	}

	public void deleteNode(int value) {
	}

	public boolean rContains(int value) {
		return false;
	}

	public boolean rContains(Node node, int value) {
		return false;
	}

	public int minValue(Node node) {
		return 0;
	}

	public List<Integer> DFSInOrder() {
		List<Integer> results = new ArrayList<>();
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
