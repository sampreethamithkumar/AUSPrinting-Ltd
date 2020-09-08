package fit5042.assx.controllers;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import fit5042.assx.entities.Customer;
import fit5042.assx.mbean.CustomerManagedBean;

@ManagedBean(name= "searchCustomer")
@RequestScoped
public class SearchCustomer {

	CustomerApplication customerApplication;
	
	private int searchById;
	private String searchByFirstName;
	
	
	public String getSearchByFirstName() {
		return searchByFirstName;
	}

	public void setSearchByFirstName(String searchByFirstName) {
		this.searchByFirstName = searchByFirstName;
	}

	public SearchCustomer(){
		
	}
	
	public CustomerApplication getCustomerApplication() {
		return customerApplication;
	}

	public void setCustomerApplication(CustomerApplication customerApplication) {
		this.customerApplication = customerApplication;
	}
	
	public int getSearchById() {
		return searchById;
	}

	public void setSearchById(int searchById) {
		this.searchById = searchById;
	}
	
	public void searchCustomerById(int customerId)
	{
		customerApplication.searchCustomerById(customerId);
	}
	
	public void searchCustomerByName(String customerFirstName)
	{
		
	}
}
