package model;

public class MyHashtable <K, V> {
	
	private Node<K, V> first;
	
	public MyHashtable() {
		
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
			
			return findValueByKey(key, first);
		}
	}
	
	private V findValueByKey(K key, Node<K, V> current) {

		if(current.getKey() == key) {
			
			return current.getValue();
			
		} else {
			
			return findValueByKey(key, current.getNext());
		}
	}
	
	public boolean containsValue(V value) {
		
		System.out.println("First: " + first.getValue());
		System.out.println("Value: " + value);
		
		if(first.getValue().equals(value)) {
			
			return true;
			
		} else {
			
			return findIfValueExists(value, first.getNext());
		}
	}
	
	private boolean findIfValueExists(V value, Node<K, V> current) {
		
		if(current != null) {
			
			if(current.getValue().equals(value)) {

				return true;

			} else {

				return findIfValueExists(value, current.getNext());
			}
			
		} else {
			
			return false;
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