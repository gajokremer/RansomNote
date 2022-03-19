package ui;

import java.util.Scanner;
import model.MyHashtable;

public class MyVersion {

	private Scanner sc = new Scanner(System.in);

	public void inputData() {
		
		System.out.println("\n\n========== MyHashtable Version ==========\n");

		//		MyHashtable<Integer, String> magazine = new MyHashtable<>();
		//		MyHashtable<Integer, String> note = new MyHashtable<>();

		//		System.out.println("		(Magazine, Note)");
		System.out.print("Number of words: ");
		String numWords = sc.nextLine();

		String[] sizes = numWords.split(" ");

		int m = Integer.parseInt(sizes[0]);
		int n = Integer.parseInt(sizes[1]);

		//		System.out.println("-m: " + m);
		//		System.out.println("-n: " + n);

		System.out.print("Magazine: ");
		String magazineText = sc.nextLine();

		System.out.print("Note: ");
		String noteText = sc.nextLine();

		//		String magazineText = "attack on titan";
		//		String noteText = "attack on titan";

		//		System.out.println(magazineText);
		//		System.out.println(noteText);

		MyHashtable<Integer, String> magazine = create(m, magazineText);
		MyHashtable<Integer, String> note = create(n, noteText);

		if(magazine != null && note != null) {

			boolean possible = compare(magazine, note);

			if(possible == true) System.out.println("\n=Yes\n");

			if(possible == false) System.out.println("\n=No\n");
			
		} else {

			System.out.println("\n-Error: Line size didn't match number");
			System.out.println("Start over\n\n\n");
			inputData();
		}
	}

	private MyHashtable<Integer, String> create(int size, String line) {

		String[] words = line.split(" ");

		//		for(int i = 0; i < words.length; i++) {
		//			
		//			System.out.println(i + ") " + words[i]);
		//		}

		//		System.out.println(words.length == size);

		if(words.length == size) {

			MyHashtable<Integer, String> table = new MyHashtable<>();

			for(int i = 0; i < size; i++) {

				table.put(i + 1, words[i]);
			}

			//			System.out.println("Table: " + table);

			return table;
		}

		return null;
	}

	private boolean compare(MyHashtable<Integer, String> m, MyHashtable<Integer, String> n) {

		boolean contains = true;

		for(int i = 1; i <= n.size() && contains; i++) {

			//			boolean contains = false;
			contains = m.containsValue(n.get(i));
			System.out.println("Contains? " + n.get(i) + ": " + contains);

			//			for(int j = 0; j < n.size() && !contains; j++) {
			//				 
			//				contains = m.containsValue(n.get(i));
			//			}
		}

		return contains;
	}
}