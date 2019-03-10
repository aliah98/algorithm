package al_sem2_lab5;

import java.util.Arrays;
import java.util.Scanner;

/* 
 * https://www.sanfoundry.com/java-program-implement-hash-tables/
 */

/*
 * https://stackoverflow.com/questions/409784/whats-the-simplest-way-to-print-a-java-array
 */
public class LinearProbing {

	private int tableSize;
	private char[] hashTable;	

	public LinearProbing() {
		super();

		//entering the string to be hashed
		System.out.println("Enter the string to hash:");
		Scanner sc = new Scanner(System.in);
		String stringToHash = sc.nextLine();


		System.out.println(stringToHash.length());

		int[] intValue = new int[stringToHash.length()];
		for(int i = 0; i<stringToHash.length(); i++) {
			int valOfString = 0;
			if(Character.isLowerCase(stringToHash.charAt(i))) {
				valOfString = stringToHash.charAt(i)-96;
			}
			else if(Character.isUpperCase(stringToHash.charAt(i))) {
				valOfString = stringToHash.charAt(i)-64;
			}
			intValue[i] = valOfString;
		}

		System.out.println("Array of values corresponding to the characters(in lower case)");
		System.out.println(Arrays.toString(intValue));
		//set the table size
		tableSize = primeNumber(stringToHash.length()+1);
		hashTable = new char[tableSize];
		System.out.println("Table size " + tableSize);

		//print an array
		System.out.println("Hash table");
		System.out.println(Arrays.toString(hashTable));

		//inserting the characters into the hashTable
		for(int i = 0; i<stringToHash.length(); i++) {			
			hashInsertLP(intValue[i]);
		}

		System.out.println("isover");
		System.out.println("Hash table, after insert");
		System.out.println(Arrays.toString(hashTable));
		
		
		
		System.out.println("Is there any character you want to search?(y/n)");
		String choice = sc.next();
		while(choice.equals("y")) {
			
			System.out.print("Enter the character: ");
			char c = sc.next().charAt(0);
			System.out.println(hashSearch(c));
			System.out.println("Search another?(y/n)");
			choice = sc.next();
		}
		System.out.println("You are leaving!");
		sc.close();
	}

	//function to hash chars
	public int hash(int k, int tableSize) {
		return (k%tableSize);
	}

	//function to hash strings
	public int hash(int key[], int keysize, int tableSize) {
		int h = key[0];
		for(int j=1; j<keysize; j++) {
			h=((h*32+key[j])%tableSize);			
		}
		return h;
	}

	//function to return a prime number
	public int primeNumber(int num) {
		if (num % 2 == 0)
			num++;
		for (; !isPrime(num); num += 2);

		return num; 
	}

	private static boolean isPrime(int n)
	{
		if (n == 2 || n == 3)
			return true;
		if (n == 1 || n % 2 == 0)
			return false;
		for (int i = 3; i * i <= n; i += 2)
			if (n % i == 0)
				return false;
		return true;
	}

	//function to insert into the hashTable
	public int hashInsertLP(int value) {

		int hash = hash(value, tableSize);
		System.out.println(hash);
		//while this position in the hashTable is not empty
		while(hashTable[hash] != '\u0000') {
			System.out.println("not empty "+hash);
			hash=(hash+1)%tableSize;

		}
		
		//where the character will be inserted in the hash table, inserting it
		System.out.println("new ins "+hash);
		hashTable[hash] = (char) (value+96);
		return hash;
	}


	//function to search the table
	public int hashSearch(char value) {
		int val=value-96;
		int hash = hash(val, tableSize);

		//while this position in the hashTable is not empty
		while(hashTable[hash] != '\u0000' && hashTable[hash] != value) {
			System.out.println("searching"+hash);
			hash = (hash+1)%tableSize;
		}

		//if the value has been found, return its position
		if(hashTable[hash] == value) {
			System.out.println("Found "+value+ "at position: "+hash);
			return hash;
		}
		//if not found, return -1
		else {
			System.out.println("Not found");
			return -1;
		}
	}

}
