package fit5042.assx.controllers;

import java.util.Date;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import fit5042.assx.entities.Customer;

@ManagedBean(name="customerEditController")
@RequestScoped
public class CustomerEditController 
{
	private int customerId;
	
	private Customer customer;
	
//	private Date customerDob;
	
	public CustomerEditController()
	{
		customerId = Integer.valueOf(FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap()
                .get("customerID"));
		
		customer = getCustomer();
		
//		customerDob = new java.util.Date(customer.getContactInformation().getCustomerDob().getTime());
		
	}

	
//	public Date getCustomerDob() {
//		return customerDob;
//	}
//
//
//	public void setCustomerDob(Date customerDob) {
//		this.customerDob = customerDob;
//	}


	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public Customer getCustomer() {
		if (customer == null) {
			ELContext context= FacesContext.getCurrentInstance().getELContext();
			
		CustomerApplication app= (CustomerApplication) FacesContext.getCurrentInstance()
                    .getApplication()
                    .getELResolver()
                    .getValue(context, null, "customerApplication");
				
			app.updateCustomerList();
			
			for(Customer cust: app.getCustomers())
				if (cust.getCustomerId() == customerId)
					return cust;
		}
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
}
