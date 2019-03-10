package al_sem2_lab5_q3;

import java.util.ArrayList;
import java.util.LinkedList;

public class SeperateChaining {
	
	private int tableSize;
	//private  hashTable;
	private ArrayList<Employee> ae;
	public SeperateChaining(LinkedList<Employee> emp) {
		super();
		//this.ae = ae;
		
		this.tableSize = primeNumber(emp.size()+1);
		
		ae = new ArrayList<>();
		
		
		
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
