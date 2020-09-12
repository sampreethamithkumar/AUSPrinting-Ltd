package fit5042.assx.controllers;


import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.event.ActionEvent;

import fit5042.assx.entities.Customer;
import fit5042.assx.mbean.CustomerManagedBean;

@ManagedBean(name = "customerApplication")
@ApplicationScoped
public class CustomerApplication {

	@ManagedProperty(value = "#{customerManagedBean}")
	CustomerManagedBean customerManagedBean;

	private List<Customer> customers;
	
	private boolean showTable = false;

	public CustomerApplication() {
		customers = new ArrayList<Customer>();

		// updateCustomerList();
	}

	public List<Customer> getCustomers() {
		setShowTable(true);
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public CustomerManagedBean getCustomerManagedBean() {
		return customerManagedBean;
	}

	public void setCustomerManagedBean(CustomerManagedBean customerManagedBean) {
		this.customerManagedBean = customerManagedBean;
	}

	public void searchCustomerById(int customerId) {
		customers.clear();
		
		setShowTable(true);
		customers.add(customerManagedBean.searchCustomerById(customerId));
	}

	public void updateCustomerList() {
		if (customers != null && customers.size() > 0) {

		} else {
			customers.clear();

			for (Customer cust : customerManagedBean.getCustomers())
				customers.add(cust);

			setCustomers(customers);
		}
	}

	public boolean isShowTable() {
		return showTable;
	}

	public void setShowTable(boolean showTable) {
		this.showTable = showTable;
	}
	
	public void searchAllCustomer() {
		customers.clear();
		
		for (Customer cust : customerManagedBean.getCustomers())
			customers.add(cust);

		setCustomers(customers);
	}
	
	public void removeCustomer(int customerId)
	{
		customerManagedBean.removeCustomer(customerId);
	}

//	public void searchCustomerByName(String firstName) {
//		customers.clear();
//		
//		setShowTable(true);
//		for (Customer customer : customerManagedBean.getCustomerByName(firstName))
//			customers.add(customer);
//		
//		setCustomers(customers);
//	}
	
	public void customerByName(String customerFirstName) {
		customers.clear();
		
		setShowTable(true);
		for (Customer cust: customerManagedBean.getCustomerByName(customerFirstName))
			customers.add(cust);
		
		setCustomers(customers);
	}
}
