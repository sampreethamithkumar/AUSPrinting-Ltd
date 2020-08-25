package fit5042.assx.repository;

import javax.ejb.Remote;
import javax.inject.Named;

import fit5042.assx.entities.Customer;

@Remote
public interface CustomerRepository 
{
	public void addCustomer(Customer customer);
	
	public void removeCustomer(Customer customer);
	
	public void getCustomers(Customer customer);
	
	public void searchCustomerById(int customerId);
	
}
