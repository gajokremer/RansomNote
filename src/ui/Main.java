package ui;

import java.util.Scanner;

public class Main {
	
	private Scanner sc =  new Scanner(System.in);
	private OriginalVersion ov;
	private MyVersion mv;
	
	public Main() {

		sc = new Scanner(System.in);
		ov = new OriginalVersion();
		mv = new MyVersion();
	}	
	
	public static void main(String[] args) {
		
		Main main = new Main();

		main.menu();
		
//		Scanner sc =  new Scanner(System.in);
		
//		main.inputData();
	}

	private void menu() {

		System.out.println("========== MENU ==========" + 
				"\n(1) for Original Hashtable Version" + 
				"\n(2) for MyHashtable Version" + 
				"\n(0) to exit");
		
		int option = sc.nextInt();
		
		switch (option) {
		
		default:
			menu();
			break;
			
		case 1:
			ov.inputData();
			menu();
			break;
			
		case 2:
			mv.inputData();
			menu();
			break;
			
		case 0:
			System.out.println("\n-Exit");
			break;
		}
	}
}