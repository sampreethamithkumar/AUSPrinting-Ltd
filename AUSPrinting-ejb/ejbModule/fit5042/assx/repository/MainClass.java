package fit5042.assx.repository;

import java.util.ArrayList;
import java.util.List;

import fit5042.assx.entities.Customer;

public class MainClass {

	private static final int Interger = 0;

	public static void main(String[] args) {
//		CustomerRepository customer = new CustomerRepositoryImplementation();
//		
//		List<Customer> customerList = customer.getCustomers();
//		
//		for (Customer cust: customerList)
//		{
//			System.out.println(cust.getCustomerFirstName());
//		}
		
		
		List<Integer> list = new ArrayList<>();
		
		list.add(10);
		list.add(12);
		list.add(13);
		list.add(5);
		
		printEvenNumbers(list);
	}
	
	public static void printEvenNumbers(List<Integer> list)
	{
		for (Integer number: list)
			System.out.println(((number % 2) == 0) ? number : "");  
	}

}
