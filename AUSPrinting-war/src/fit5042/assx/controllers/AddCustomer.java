package fit5042.assx.controllers;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import fit5042.assx.mbean.CustomerManagedBean;

@ManagedBean(name="addCustomer")
@RequestScoped
public class AddCustomer 
{
	@ManagedProperty(value = "#{customerManagedBean}")
	CustomerManagedBean customerManagedBean;
	
	
	public AddCustomer()
	{
		
	}
	
	public void addCustomer(CustomerController customerController)
	{
		try {
			
			customerManagedBean.addCustomer(customerController);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}

}
