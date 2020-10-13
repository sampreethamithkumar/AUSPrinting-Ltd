package fit5042.assx.mbean;

import java.io.Serializable;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
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
@SessionScoped
public class CustomerManagedBean implements Serializable
{
	@EJB
	CustomerRepository customerRepository;
	
	@ManagedProperty(value = "#{staffManagedBean}")
	StaffManagedBean staffManagedBean;
	
	private boolean showRender = false;
	
	private String renderText;

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
	

	
	public CustomerRepository getCustomerRepository() {
		return customerRepository;
	}

	public String getRenderText() {
		return renderText;
	}

	public void setRenderText(String renderText) {
		this.renderText = renderText;
	}

	public void setCustomerRepository(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public boolean isShowRender() {
		return showRender;
	}

	public void setShowRender(boolean showRender) {
		this.showRender = showRender;
	}

	public Customer searchCustomerById(int customerId)
	{
		return customerRepository.searchCustomerById(customerId);
	}

	public void addCustomer(CustomerController customerController) {
		addContactInformation(customerController);
		Customer customer = convertCustomerToEntity(customerController);
		
		try {
			customerRepository.addCustomer(customer);
			footerRender();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void editCustomer(Customer customer) {
		customerRepository.editCustomer(customer);
	}
	
	public void removeCustomer(int customerId) {
		customerRepository.removeCustomer(customerId);
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
        Date dob = new java.sql.Date(customerController.getCustomerDob().getTime());
        String tfn = customerController.getCustomerTFN();
        int contactId = customerController.getCustomerContactId();
        CustomerContactInformation contactInformation = new CustomerContactInformation(contactId, address, phoneNumber, email, dob, tfn);
        return contactInformation;
	}
	
	public Customer convertCustomerToEntity(CustomerController customerController)
	{
		Customer customer = new Customer();
		customer.setContactInformation(convertContactInformationToEntity(customerController));
		//int staffId = getStaffIdByStaffName(customerController.getStaffFname());
        int staffId = customerController.getStaffId();
		String staffFname = customerController.getStaffFname();
		String staffLname = customerController.getStaffLname();
		String staffTFN = customerController.getStaffTFN();
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


		customer.setDateOfPurchase(new java.sql.Date(customerController.getDateOfPurchase().getTime()));
		
		return customer;	
	}
	
	public List<Customer> getCustomerByName(String firstName){
		return customerRepository.getCustomersName(firstName);
	}
	

	public void footerRender() {
		
		setRenderText("Customer Added Successfully!!");
	}
	
	public int getStaffIdByStaffName(String staffname) {
		return staffManagedBean.getStaffIdByFname(staffname);
	}

	public StaffManagedBean getStaffManagedBean() {
		return staffManagedBean;
	}

	public void setStaffManagedBean(StaffManagedBean staffManagedBean) {
		this.staffManagedBean = staffManagedBean;
	}
}
