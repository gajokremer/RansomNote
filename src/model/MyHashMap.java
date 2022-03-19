package model;

public class MyHashMap <K, V> {
	
	private Node<K, V> first;
	
	public MyHashMap() {
		
		first = null;
	}

	public Node<K, V> getFirst() {
		return first;
	}

	public void setFirst(Node<K, V> first) {
		this.first = first;
	}
	
	public void put(K key, V value) {

		Node<K, V> newNode = new Node<K, V>(key, value);
		
//		System.out.println("\nNew Node: " + newNode);
		
		if(first == null) {
			
//			System.out.println("first = null");
			
			first = newNode;
			
		} else {
			
//			System.out.println("else");
			
			assignPosition(newNode, first);
		}
	}
	
	private void assignPosition(Node<K, V> newNode, Node<K, V> current) {
		
//		System.out.println("Assign position");

		if(current.getNext() == null) {
			
//			System.out.println("next = null");
			
			current.setNext(newNode);
			current.getNext().setPrev(current);;

//			System.out.println(newNode + " -> " + newNode.nextAndPrev());
//			System.out.println(current + " -> " + current.nextAndPrev());
			
		} else {
			
			assignPosition(newNode, current.getNext());
		}
	}
	
	public V get(K key) {
		
		if(first.getKey() == key) {
			
			return first.getValue();
			
		} else {
			
			return findValue(key, first);
		}
	}
	
	private V findValue(K key, Node<K, V> current) {

		if(current.getKey() == key) {
			
			return current.getValue();
			
		} else {
			
			return findValue(key, current.getNext());
		}
	}
	
	public boolean containsValue(V value) {
		
		if(first.getValue() == value) {
			
			return true;
			
		} else {
			
			return findIfValueExists(value, first);
		}
	}
	
	private boolean findIfValueExists(V value, Node<K, V> current) {
		
		System.out.println("Current: " + current);
		
		if(current.getValue() == value) {
			
			System.out.println(1);
			
			return true;
			
		} else if(current.getValue() != value && current.getNext() == null) {

			System.out.println(2);
			
			return false;
			
		} else {
			
			System.out.println(3);

			return findIfValueExists(value, current.getNext());
		}
	}

	public int size() {
		
		int count = 0;
		count = count(first, 0);
		
		return count;
	}
	
	private int count(Node<K, V> current, int count) {

		if(current != null) {
			
			return count(current.getNext(), count+1);
		} 
		
		return count;
	}
	
	@Override
	public String toString() {
		
		String line = "{";
		
		Node<K, V> current = first;
		
		while(current != null) {
			
			line += current.toString();
			
			if(current.getNext() != null) {
				
				 line += ", ";
			}
			
			current = current.getNext();
		}
		
		line += "}";
		
		return line;
	}
}