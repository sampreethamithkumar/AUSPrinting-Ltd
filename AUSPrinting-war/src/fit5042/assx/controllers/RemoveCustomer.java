package fit5042.assx.controllers;

import java.util.List;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import fit5042.assx.entities.Customer;
@RequestScoped
@ManagedBean(name = "removeCustomer")
public class RemoveCustomer {

	CustomerApplication customerApplication;

	public RemoveCustomer() {
		ELContext context
        = FacesContext.getCurrentInstance().getELContext();

		customerApplication = (CustomerApplication) FacesContext.getCurrentInstance()
        .getApplication()
        .getELResolver()
        .getValue(context, null, "customerApplication");
		
		//customerApplication.updateCustomerList();
	}
	
	public List<Customer> getAllCustomers(){
		customerApplication.searchAllCustomer();
		
		return customerApplication.getCustomers();
	}
	
	
	public void removeCustomer(int customerId)
	{
		customerApplication.removeCustomer(customerId);
	}
}
