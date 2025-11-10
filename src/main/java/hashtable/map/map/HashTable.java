package hashtable.map;

import java.util.ArrayList;
import java.util.List;

public class HashTable {

	private int size = 7;
	private Node[] map;

	class Node {
		String key;
		int value;
		Node next;

		public Node(String key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	public HashTable() {
		this.map = new Node[size];
	}

	public void print() {
		for (int i = 0; i < map.length; i++) {
			System.out.print("index : " + i + " ");
			Node node = map[i];
			while (node != null) {
				System.out.print("--> {key : " + node.key + " and value : " + node.value + "} ");
				node = node.next;
			}
			System.out.println();
		}
	}

	public int hash(String key) {
		int hash = 0;
		char[] ch = key.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			int asciiValue = ch[i];
			hash = (hash + asciiValue * 23) % map.length;
		}
		return hash;
	}

	public void put(String key, int value) {
		int index = hash(key);
		Node node = new Node(key, value);
		if (map[index] == null) {
			map[index] = node;
		} else {
			Node temp = map[index];
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = node;
		}
	}

	public int get(String key) {
		int index = hash(key);
		Node temp = map[index];
		while (temp != null) {
			if (temp.key.equals(key)) {
				return temp.value;
			}
			temp = temp.next;
		}
		return 0;
	}

	public List<String> getKeys() {
		List<String> keys = new ArrayList<>();
		for (int i = 0; i < map.length; i++) {
			if (map[i] != null) {
				Node temp = map[i];
				while (temp != null) {
					keys.add(temp.key);
					temp = temp.next;
				}
			}
		}
		return keys;
	}

	public static void main(String[] args) {
		HashTable hashTable = new HashTable();
		hashTable.put("nails", 100);
		hashTable.put("tile", 50);
		hashTable.put("lumber", 80);

		hashTable.put("bolts", 200);
		hashTable.put("screws", 140);

		hashTable.print();

		System.out.println("keys : " + hashTable.getKeys());
	}

}
