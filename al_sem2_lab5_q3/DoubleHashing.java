package al_sem2_lab5_q3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class DoubleHashing {

	private int tableSize;
	private int[] hashTable;

	private LinkedList<Employee> emp = new LinkedList<>();

	public DoubleHashing(LinkedList<Employee> emp) {
		super();
		this.emp = emp;
		this.tableSize = primeNumber(emp.size()+1);

		hashTable = new int[tableSize];

		//calls function to enter the employees in the hashTable
		System.out.println("Table size of the hashTable :"+tableSize);
		hashEmployees();

		System.out.println("Linked List of employees");
		System.out.println(emp);

		System.out.println("HashTable");
		System.out.println(Arrays.toString(hashTable));

		searchEmployee();
	}

	//search for an employee
	public void searchEmployee() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Is there any employee you want to search?(y/n)");
		String choice = sc.next();
		while(!choice.equals("n")) {

			System.out.print("Enter the employee ID: ");
			int c = sc.nextInt();
			System.out.println(hashSearch(c));
			System.out.println("Search another?(y/n)");
			choice = sc.next();
		}
		System.out.println("You are leaving!");
		sc.close();

		return;

	}

	//insert all employee from the hash table
	public void hashEmployees() {

		for(int i = 0; i<emp.size(); i++) {
			System.out.println("Emp id: "+emp.get(i).getId());
			hashInsertLP(emp.get(i).getId());
			System.out.println("Emp inserted!");
		}

	}

	//function to hash 
	public int hash(int k, int tableSize) {
		return (k%tableSize);
	}

	//2nd function to hash chars
	public int hash2(int k, int tableSize) {
		int tbsize =(int) Math.floor(tableSize/2);
		return ((k%tbsize)+1);
	}

	//function to insert into the hashTable
	public int hashInsertLP(int value) {

		int hash = hash(value, tableSize);
		int hash2 = hash2(value, tableSize);
		System.out.println("Hash Value: " +hash);
		//while this position in the hashTable is not empty
		while(hashTable[hash] != 0) {
			System.out.println("not empty: "+hash);
			hash=(hash+hash2)%tableSize;

		}

		//where the character will be inserted in the hash table, inserting it
		System.out.println("new insert: "+hash);
		hashTable[hash] = value;
		return hash;
	}

	//function to search the table
	public int hashSearch(int value) {

		System.out.println(tableSize);
		int hash = hash(value, tableSize);
		int hash2 = hash2(value, tableSize);
		System.out.println(value);

		//while this position in the hashTable is not empty
		while(hashTable[hash] != 0 && hashTable[hash] != value) {
			System.out.println("searching: "+hash);
			hash = (hash+hash2)%tableSize;
			System.out.println(value);
		}

		//if the value has been found, return its position
		if(hashTable[hash] == value) {
			System.out.println("Found "+value+ "at position: "+hash);
			return hash;
		}
		//if not found, return -1
		else {
			System.out.println("Not found! "+value);
			return -1;
		}
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

}
