package fit5042.assx.repository;

import java.util.List;

import fit5042.assx.entities.Customer;

public class MainClass {

	public static void main(String[] args) {
		CustomerRepository customer = new CustomerRepositoryImplementation();
		
		List<Customer> customerList = customer.getCustomers();
		
		for (Customer cust: customerList)
		{
			System.out.println(cust.getCustomerFirstName());
		}

	}

}
