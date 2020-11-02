package fit5042.assx.controllers;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import fit5042.assx.entities.Address;
import fit5042.assx.entities.CustomerContactInformation;
import fit5042.assx.entities.Industry;
import fit5042.assx.entities.Printer;
import fit5042.assx.entities.Staff;
import fit5042.assx.entities.*;

@ManagedBean(name = "customer")
@RequestScoped
public class CustomerController implements Serializable {
	private int customerId;
	private Staff staff;
	private Industry industry;
	private CustomerContactInformation contactInformation;
	private String customerFirstName;
	private String customerLastName;
	private Printer printer;
	private java.util.Date dateOfPurchase;

	/**
	 * Address
	 */
	private String streetNumber;
	private String streetAddress;
	private String suburb;
	private String postcode;
	private String state;

	private int customerContactId;
	private long customerPhoneNumber;
	private String customerEmail;
	private java.util.Date customerDob;
	private String customerTFN;

	/**
	 * Staff
	 */
	private int staffId;
	private String staffFname;
	private String staffLname;
	private String staffTFN;
	private Address staffAddress;
	private String staffEmail;
	private long staffPhoneNumber;

	/**
	 * printer
	 */
	private int printerId;
	private String printerType;

	/**
	 * Industry
	 */
	private int industryId;
	private String industryType;

	public CustomerController() {
		super();
	}
	
	

	public CustomerController(int customerId, Staff staff, Industry industry,
			CustomerContactInformation contactInformation, String customerFirstName, String customerLastName,
			Printer printer, java.util.Date dateOfPurchase, String streetNumber, String streetAddress, String suburb,
			String postcode, String state, int customerContactId, long customerPhoneNumber, String customerEmail,
			java.util.Date customerDob, String customerTFN, int staffId, String staffFname, String staffLname,
			String staffTFN, Address staffAddress, String staffEmail, long staffPhoneNumber, int printerId,
			String printerType, int industryId, String industryType) {
		super();
		this.customerId = customerId;
		this.staff = staff;
		this.industry = industry;
		this.contactInformation = contactInformation;
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
		this.printer = printer;
		this.dateOfPurchase = dateOfPurchase;
		this.streetNumber = streetNumber;
		this.streetAddress = streetAddress;
		this.suburb = suburb;
		this.postcode = postcode;
		this.state = state;
		this.customerContactId = customerContactId;
		this.customerPhoneNumber = customerPhoneNumber;
		this.customerEmail = customerEmail;
		this.customerDob = customerDob;
		this.customerTFN = customerTFN;
		this.staffId = staffId;
		this.staffFname = staffFname;
		this.staffLname = staffLname;
		this.staffTFN = staffTFN;
		this.staffAddress = staffAddress;
		this.staffEmail = staffEmail;
		this.staffPhoneNumber = staffPhoneNumber;
		this.printerId = printerId;
		this.printerType = printerType;
		this.industryId = industryId;
		this.industryType = industryType;
	}

	public java.util.Date getCustomerDob() {
		return customerDob;
	}

	public void setCustomerDob(java.util.Date customerDob) {
		this.customerDob = customerDob;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public Industry getIndustry() {
		return industry;
	}

	public void setIndustry(Industry industry) {
		this.industry = industry;
	}

	public Printer getPrinter() {
		return printer;
	}

	public void setPrinter(Printer printer) {
		this.printer = printer;
	}

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public String getStaffFname() {
		return staffFname;
	}

	public void setStaffFname(String staffFname) {
		this.staffFname = staffFname;
	}

	public String getStaffLname() {
		return staffLname;
	}

	public void setStaffLname(String staffLname) {
		this.staffLname = staffLname;
	}

	public String getStaffTFN() {
		return staffTFN;
	}

	public void setStaffTFN(String staffTFN) {
		this.staffTFN = staffTFN;
	}

	public Address getStaffAddress() {
		return staffAddress;
	}

	public void setStaffAddress(Address staffAddress) {
		this.staffAddress = staffAddress;
	}

	public String getStaffEmail() {
		return staffEmail;
	}

	public void setStaffEmail(String staffEmail) {
		this.staffEmail = staffEmail;
	}

	public long getStaffPhoneNumber() {
		return staffPhoneNumber;
	}

	public void setStaffPhoneNumber(long staffPhoneNumber) {
		this.staffPhoneNumber = staffPhoneNumber;
	}

	public int getPrinterId() {
		return printerId;
	}

	public void setPrinterId(int printerId) {
		this.printerId = printerId;
	}

	public String getPrinterType() {
		return printerType;
	}

	public void setPrinterType(String printerType) {
		this.printerType = printerType;
	}

	public int getIndustryId() {
		return industryId;
	}

	public void setIndustryId(int industryId) {
		this.industryId = industryId;
	}

	public String getIndustryType() {
		return industryType;
	}

	public void setIndustryType(String industryType) {
		this.industryType = industryType;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public CustomerContactInformation getContactInformation() {
		return contactInformation;
	}

	public void setContactInformation(CustomerContactInformation contactInformation) {
		this.contactInformation = contactInformation;
	}

	public String getCustomerFirstName() {
		return customerFirstName;
	}

	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	public String getCustomerLastName() {
		return customerLastName;
	}

	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	public java.util.Date getDateOfPurchase() {
		return dateOfPurchase;
	}

	public void setDateOfPurchase(java.util.Date dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getSuburb() {
		return suburb;
	}

	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getCustomerContactId() {
		return customerContactId;
	}

	public void setCustomerContactId(int customerContactId) {
		this.customerContactId = customerContactId;
	}

	public long getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}

	public void setCustomerPhoneNumber(long customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerTFN() {
		return customerTFN;
	}

	public void setCustomerTFN(String customerTFN) {
		this.customerTFN = customerTFN;
	}
	
	public void validateTFN(FacesContext context, UIComponent component,Object value) throws ValidatorException{
		if (value == null) 
			return;
		
		String data = value.toString();
		
		if (!data.matches("[0-9]*[A-Z]*")) {
			FacesMessage message =  new FacesMessage("TFN should have start with number and can contain uppercase letters.");
			
			throw new ValidatorException(message);
		}
	}

	@Override
	public String toString() {
		return "CustomerController [customerId=" + customerId + ", staff=" + staff + ", industry=" + industry
				+ ", contactInformation=" + contactInformation + ", customerFirstName=" + customerFirstName
				+ ", customerLastName=" + customerLastName + ", printer=" + printer + ", dateOfPurchase="
				+ dateOfPurchase + ", streetNumber=" + streetNumber + ", streetAddress=" + streetAddress + ", suburb="
				+ suburb + ", postcode=" + postcode + ", state=" + state + ", customerContactId=" + customerContactId
				+ ", customerPhoneNumber=" + customerPhoneNumber + ", customerEmail=" + customerEmail + ", customerDob="
				+ customerDob + ", customerTFN=" + customerTFN + ", staffId=" + staffId + ", staffFname=" + staffFname
				+ ", staffLname=" + staffLname + ", staffTFN=" + staffTFN + ", staffAddress=" + staffAddress
				+ ", staffEmail=" + staffEmail + ", staffPhoneNumber=" + staffPhoneNumber + ", printerId=" + printerId
				+ ", printerType=" + printerType + ", industryId=" + industryId + ", industryType=" + industryType
				+ "]";
	}

}
