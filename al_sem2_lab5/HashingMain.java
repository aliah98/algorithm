package al_sem2_lab5;

import java.util.Scanner;

public class HashingMain {

	public static void main(String[] args) {


		Scanner sc = new Scanner(System.in);

		System.out.println("Welcome!");

		String choice;


		System.out.println("1. Hashing with linear probing");
		System.out.println("2. Hashing with double hashing");
		System.out.println("3. Say goodbye and leave!");
		System.out.print("Enter your choice: ");
		choice = sc.next();

		switch(choice) {
		case "1":
			LinearProbing h = new LinearProbing();				
			break;
		case "2":
			DoubleHashing d = new DoubleHashing();
			break;
		case "3":
			System.out.println("Good Bye");
			break;
		default:
			System.out.println("Choose one of the numbers 1, 2 or 3");
			break;
		}

		System.out.println("Bye my friend");
		sc.close();

	}

}
