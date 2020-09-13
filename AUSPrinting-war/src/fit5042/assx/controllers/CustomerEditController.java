package fit5042.assx.controllers;

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
	
	public CustomerEditController()
	{
		customerId = Integer.valueOf(FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap()
                .get("customerID"));
		
		customer = getCustomer();
		
	}

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
//			return app.getCustomers().get(--customerId);
		}
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
}
