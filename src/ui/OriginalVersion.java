package ui;

import java.util.HashMap;
import java.util.Scanner;

public class OriginalVersion {

	private Scanner sc = new Scanner(System.in);

	public void inputData() {
		
		System.out.println("\n\n========== Original HashMap Version ==========\n");

		//		HashMap<Integer, String> magazine = new HashMap<>();
		//		HashMap<Integer, String> note = new HashMap<>();

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

		HashMap<Integer, String> magazine = createMap(m, magazineText);
		HashMap<Integer, String> note = createMap(n, noteText);

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

	private HashMap<Integer, String> createMap(int size, String line) {

		String[] words = line.split(" ");

		//		for(int i = 0; i < words.length; i++) {
		//			
		//			System.out.println(i + ") " + words[i]);
		//		}

		//		System.out.println(words.length == size);

		if(words.length == size) {

			HashMap<Integer, String> map = new HashMap<>();

			for(int i = 0; i < size; i++) {

				map.put(i + 1, words[i]);
			}

			//			System.out.println("Map: " + map);

			return map;
		}

		return null;
	}

	private boolean compare(HashMap<Integer, String> m, HashMap<Integer, String> n) {

		boolean contains = true;

		for(int i = 1; i <= n.size() && contains; i++) {

			//			boolean contains = false;
			//			System.out.println("Contains? " + n.get(i) + ": " + m.containsValue(n.get(i)));
			contains = m.containsValue(n.get(i));

			//			for(int j = 0; j < n.size() && !contains; j++) {
			//				 
			//				contains = m.containsValue(n.get(i));
			//			}
		}

		return contains;
	}
}