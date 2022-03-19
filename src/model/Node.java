package model;

public class Node <K, V> {

	private K key;
	private V value;
	private Node<K, V> next;
	private Node<K, V> prev;
	
	public Node(K key, V value, Node<K, V> next, Node<K, V> prev) {
		super();
		this.key = key;
		this.value = value;
		this.next = next;
		this.prev = prev;
	}
	
	public Node(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}

	public Node<K, V> getNext() {
		return next;
	}

	public Node<K, V> getPrev() {
		return prev;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public void setNext(Node<K, V> next) {
		this.next = next;
	}

	public void setPrev(Node<K, V> prev) {
		this.prev = prev;
	}
	
	@Override
	public String toString() {
		
		return key + "=" + value;
	}
	
	public String nextAndPrev() {

		return "Next: " + next + ", Prev: " + prev;
	}
}