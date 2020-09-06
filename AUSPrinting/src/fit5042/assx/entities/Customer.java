package fit5042.assx.entities;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;


@Entity
//@NamedQueries({
//	@NamedQuery(name = Customer.GET_ALL_CUSTOMERS)
//})
public class Customer implements Serializable
{
	@Id @GeneratedValue
	private int customerId;
	private Staff staffId;
	private Industry industryId;
	private CustomerContactInformation contactInformation;
	private String customerFirstName;
	private String customerLastName;
	private Printer printer_id;
	private String dateOfPurchase;
	
	public Customer() 
	{
		super();
	}
	
	public Customer(int customerId, Staff staffId, Industry industryId,
			CustomerContactInformation contactInformation, String customerFirstName, String customerLastName,
			Printer printer_id, String dateOfPurchase) 
	{
		super();
		this.customerId = customerId;
		this.staffId = staffId;
		this.industryId = industryId;
		this.contactInformation = contactInformation;
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
		this.printer_id = printer_id;
		this.dateOfPurchase = dateOfPurchase;
	}

	public int getCustomerId() 
	{
		return customerId;
	}
	
	public void setCustomerId(int customerId) 
	{
		this.customerId = customerId;
	}
	
	@ManyToOne
	public Staff getStaffId() 
	{
		return staffId;
	}
	
	public void setStaffId(Staff staffId) 
	{
		this.staffId = staffId;
	}
	
	@OneToOne
	public Industry getIndustryId() 
	{
		return industryId;
	}
	
	public void setIndustryId(Industry industryId) 
	{
		this.industryId = industryId;
	}
	
	@OneToOne
	public CustomerContactInformation getContactInformation() 
	{
		return contactInformation;
	}

	public void setContactInformation(CustomerContactInformation contactInformation) 
	{
		this.contactInformation = contactInformation;
	}

	public String getCustomerFirstName() 
	{
		return customerFirstName;
	}
	
	public void setCustomerFirstName(String customerFirstName) 
	{
		this.customerFirstName = customerFirstName;
	}
	
	public String getCustomerLastName() 
	{
		return customerLastName;
	}
	
	public void setCustomerLastName(String customerLastName) 
	{
		this.customerLastName = customerLastName;
	}
	
	@OneToOne
	public Printer getPrinter_id() 
	{
		return printer_id;
	}
	
	public void setPrinter_id(Printer printer_id) 
	{
		this.printer_id = printer_id;
	}
	
	public String getDateOfPurchase() 
	{
		return dateOfPurchase;
	}
	
	public void setDateOfPurchase(String dateOfPurchase) 
	{
		this.dateOfPurchase = dateOfPurchase;
	}

	@Override
	public String toString() 
	{
		return "Customer [customerId=" + customerId + ", staffId=" + staffId + ", industryId=" + industryId
				+ ", contactInformation=" + contactInformation + ", customerFirstName=" + customerFirstName
				+ ", customerLastName=" + customerLastName + ", printer_id=" + printer_id + ", dateOfPurchase="
				+ dateOfPurchase + "]";
	}	
}