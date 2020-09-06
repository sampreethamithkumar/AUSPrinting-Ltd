package fit5042.assx.repository;

import java.util.List;

import javax.ejb.Remote;
import javax.inject.Named;

import fit5042.assx.entities.Customer;
import fit5042.assx.entities.CustomerContactInformation;

@Remote
public interface CustomerRepository 
{
	public void addCustomer(Customer customer) throws Exception;
	
	public void removeCustomer(Customer customer);
	
	public List<Customer> getCustomers();
	
	public void searchCustomerById(int customerId);
	
	public void addContactInformation(CustomerContactInformation contactInforamtion);
	
}