package hashtable.map;

import java.util.ArrayList;
import java.util.List;

public class GenericHashTable<K, V> {

	private int size = 10;
	private Node<K, V>[] map;

	class Node<K, V> {
		K key;
		V value;
		Node<K, V> next;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}

	public GenericHashTable() {
		this.map = new Node[size];
	}

	public void print() {
		for (int i = 0; i < map.length; i++) {
			System.out.print("index : " + i + " ");
			Node<K, V> node = map[i];
			while (node != null) {
				System.out.print("--> {key : " + node.key + " and value : " + node.value + "} ");
				node = node.next;
			}
			System.out.println();
		}
	}

	public int hash(K key) {
		return Math.abs(key.hashCode()) % size;
	}

	public void put(K key, V value) {
		int index = hash(key);
		Node<K, V> node = new Node<>(key, value);
		Node<K, V> temp = map[index];
		if (temp == null) {
			map[index] = node;
		} else {
			while (temp != null) {
				if (temp.key.equals(key)) {
					temp.value = value;
					return;
				}
				if (temp.next == null) {
					temp.next = node;
					return;
				}
				temp = temp.next;
			}
		}
	}

	public V get(K key) {
		int index = hash(key);
		Node<K, V> temp = map[index];
		while (temp != null) {
			if (temp.key.equals(key)) {
				return temp.value;
			}
			temp = temp.next;
		}
		return null;
	}

	public List<K> getKeys() {
		List<K> keys = new ArrayList<>();
		for (int i = 0; i < map.length; i++) {
			if (map[i] != null) {
				Node<K, V> temp = map[i];
				while (temp != null) {
					keys.add(temp.key);
					temp = temp.next;
				}
			}
		}
		return keys;
	}

	public static void main(String[] args) {
		GenericHashTable<String, Integer> hashTable = new GenericHashTable<>();
		hashTable.put("nails", 100);
		hashTable.put("tile", 50);
		hashTable.put("lumber", 80);

		hashTable.put("bolts", 200);
		hashTable.put("screws", 140);

		hashTable.put("nails", 200);
		hashTable.put("lumber", 800);
		hashTable.put("tile", 500);
		hashTable.print();

		System.out.println("===============================================");
		System.out.println("keys : " + hashTable.getKeys());

		System.out.println("===============================================");
		GenericHashTable<Integer, String> hashTable1 = new GenericHashTable<>();
		hashTable1.put(12345, "nails");
		hashTable1.put(43215, "screws");
		hashTable1.put(12345, "nails-1");
		hashTable1.print();

		System.out.println("keys : " + hashTable1.getKeys());
	}

}
