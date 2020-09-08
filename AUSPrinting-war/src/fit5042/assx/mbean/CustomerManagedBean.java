package fit5042.assx.mbean;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;

import fit5042.assx.controllers.CustomerController;
import fit5042.assx.entities.Address;
import fit5042.assx.entities.Customer;
import fit5042.assx.entities.CustomerContactInformation;
import fit5042.assx.entities.Industry;
import fit5042.assx.entities.Printer;
import fit5042.assx.entities.Staff;
import fit5042.assx.repository.CustomerRepository;

@ManagedBean(name = "customerManagedBean")
@ApplicationScoped
public class CustomerManagedBean implements Serializable
{
	@EJB
	CustomerRepository customerRepository;

	public CustomerManagedBean() {
		super();
	}
	
	public List<Customer> getCustomers()
	{
		try {
			return customerRepository.getCustomers();
		}
		catch (Exception ex)
		{
			Logger.getLogger(CustomerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}
	
	

//	public void addCustomer(Customer customer) {
//		try {
//			customerRepository.addCustomer(customer);
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
	
	public Customer searchCustomerById(int customerId)
	{
		return customerRepository.searchCustomerById(customerId);
	}

	public String addCustomer(CustomerController customerController) {
		addContactInformation(customerController);
		Customer customer = convertCustomerToEntity(customerController);
		
		try {
			customerRepository.addCustomer(customer);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		return "index";
		
	}
	
	public void addContactInformation(CustomerController customerController) {
		
        CustomerContactInformation contactInforamtion = convertContactInformationToEntity(customerController);
        try {
        	
        	customerRepository.addContactInformation(contactInforamtion);
        }
        catch (Exception e) {
			
		}
	}
	
	public CustomerContactInformation convertContactInformationToEntity(CustomerController customerController)
	{
		String streetNumber = customerController.getStreetNumber();
        String streetAddress = customerController.getStreetAddress();
        String suburb = customerController.getSuburb();
        String postcode = customerController.getPostcode();
        String state = customerController.getState();
        Address address = new Address(streetNumber, streetAddress, suburb, postcode, state);
        long phoneNumber = customerController.getCustomerPhoneNumber();
        String email = customerController.getCustomerEmail();
        String dob = customerController.getCustomerDob();
        String tfn = customerController.getCustomerTFN();
        int contactId = customerController.getCustomerContactId();
        CustomerContactInformation contactInformation = new CustomerContactInformation(contactId, address, phoneNumber, email, dob, tfn);
        return contactInformation;
	}
	
	public Customer convertCustomerToEntity(CustomerController customerController)
	{
		Customer customer = new Customer();
//		String streetNumber = customerController.getStreetNumber();
//        String streetAddress = customerController.getStreetAddress();
//        String suburb = customerController.getSuburb();
//        String postcode = customerController.getPostcode();
//        String state = customerController.getState();
//        Address address = new Address(streetNumber, streetAddress, suburb, postcode, state);
//        long phoneNumber = customerController.getCustomerPhoneNumber();
//        String email = customerController.getCustomerEmail();
//        String dob = customerController.getCustomerDob();
//        String tfn = customerController.getCustomerTFN();
//        int contactId = customerController.getCustomerContactId();
//        CustomerContactInformation contactInformation = new CustomerContactInformation(contactId, address, phoneNumber, email, dob, tfn);
		customer.setContactInformation(convertContactInformationToEntity(customerController));
        int staffId = customerController.getStaffId();
		String staffFname = customerController.getStaffFname();
		String staffLname = customerController.getStaffLname();
		String staffTFN = customerController.getCustomerTFN();
		Address staffAddress = customerController.getStaffAddress();
		String staffEmail = customerController.getStaffEmail();
		long staffPhoneNumber = customerController.getStaffPhoneNumber();
		Staff staff = new Staff(staffId, staffFname, staffLname, staffTFN, staffAddress, staffEmail, staffPhoneNumber);
		customer.setStaffId(staff);
		int printerId = customerController.getPrinterId();
		String printerType = customerController.getPrinterType();
		Printer printer = new Printer(printerId, printerType);
		customer.setPrinter_id(printer);
		int industryId = customerController.getIndustryId();
		String industryType = customerController.getIndustryType();
		Industry industry = new Industry(industryId, industryType);
		customer.setIndustryId(industry);
		customer.setCustomerId(customerController.getCustomerId());
		customer.setCustomerFirstName(customerController.getCustomerFirstName());
		customer.setCustomerLastName(customerController.getCustomerLastName());
		customer.setDateOfPurchase(customerController.getDateOfPurchase());
		
		return customer;	
	}
}
