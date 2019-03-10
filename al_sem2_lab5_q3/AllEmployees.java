package al_sem2_lab5_q3;

import java.util.LinkedList;
import java.util.Scanner;

public class AllEmployees {
	
	LinkedList<Employee> emp = new LinkedList<>();
	
	Scanner sc = new Scanner(System.in);
	
	public AllEmployees() {
	 	super();
		
	 	insertEmployees();

	 	hashEmployees();
		sc.close();
	}
	
	public void insertEmployees(){
		
		char choice;
		do {
			
			System.out.println("\nEntering a new employee");
			
			addEmployee();
			
			System.out.println("Continue? (y/n)");
			choice = sc.nextLine().charAt(0);
		
			System.out.println(choice);
			
		}while(choice != 'n');
		System.out.println("");
		
		System.out.println(emp);
		
		
	}

	public void hashEmployees() {
		
		System.out.println("How do you want to hash the employee data?"
				+ "\n1. Use Linear Probing"
				+ "\n2. Use Double Hashing"
				+ "\n3. Use Seperate Chaining"
				+ "\n4. Leave without doing anything 'cause you're a boss!");
		int choice = sc.nextInt();
		sc.nextLine();
		switch(choice) {
		case 1:
			LinearProbing lp = new LinearProbing(emp);
			break;
		case 2:
			DoubleHashing dh = new DoubleHashing(emp);
			break;
		case 3:
			
			break;
		case 4:
			return;
			
		}
		
	}

	public void addEmployee() {		
		
		System.out.print("\nEmployee ID: ");
		int id = sc.nextInt();
		
		sc.nextLine();
		
		System.out.print("\nName: ");
		String name = sc.nextLine();
		
		System.out.print("\nSalary: ");
		
		String sal = sc.nextLine();
		
		float salary = Float.parseFloat(sal);
		//sc.nextLine();
		Employee e = new Employee(id, name, salary);
		System.out.println("New employee inserted!");
		emp.add(e);
		
		System.out.println(emp);
		
		//print(emp);
		
		
		
	}
	
}
