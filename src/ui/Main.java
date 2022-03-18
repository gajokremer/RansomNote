package ui;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
	
	private Scanner sc =  new Scanner(System.in);
	
	public Main() {

		sc = new Scanner(System.in);
	}	
	
	public static void main(String[] args) {
		
		Main main = new Main();
		
//		Scanner sc =  new Scanner(System.in);
		
		main.inputData();
	}

	private void inputData() {
		
//		HashMap<Integer, String> magazine = new HashMap<>();
//		HashMap<Integer, String> note = new HashMap<>();
		
		System.out.print("Number or words: ");
		String numWords = sc.nextLine();
		
		String[] sizes = numWords.split(" ");
		
		int m = Integer.parseInt(sizes[0]);
		int n = Integer.parseInt(sizes[1]);
		
		System.out.println("-m: " + m);
		System.out.println("-n: " + n);
		
//		System.out.print("Magazine: ");
//		String magazineText = sc.nextLine();
		String magazineText = "Attack on titan";
		
//		System.out.print("Note: ");
//		String noteText = sc.nextLine();
		String noteText = "attack on titan";
		
		System.out.println(magazineText);
		System.out.println(noteText);
		
		HashMap<Integer, String> magazine = createMap(m, magazineText);
		HashMap<Integer, String> note = createMap(n, noteText);
	}
	
	private HashMap<Integer, String> createMap(int size, String line) {
		
		String[] words = line.split(" ");
		
//		for(int i = 0; i < words.length; i++) {
//			
//			System.out.println(i + ") " + words[i]);
//		}
		
		System.out.println(words.length == size);
		
		if(words.length == size) {
			
			HashMap<Integer, String> map = new HashMap<>();
			
			for(int i = 0; i < size; i++) {
				
				map.put(i + 1, words[i]);
			}
			
			System.out.println("Map: " + map);
			
			return map;
		}
		
		return null;
	}
}