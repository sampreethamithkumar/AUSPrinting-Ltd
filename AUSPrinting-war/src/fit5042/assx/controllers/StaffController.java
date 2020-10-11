package fit5042.assx.controllers;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import fit5042.assx.entities.Address;
import fit5042.assx.entities.Customer;

@ManagedBean(name="staffController")
public class StaffController {

	private int staffId;
	private String staffFname;
	private String staffLname;
	private String staffTFN;
	private Address staffAddress;
	private String staffEmail;
	private long staffPhoneNumber;
	private List<Customer> customer;
	private String staffPassword;
	
	private String streetNumber;
    private String streetAddress;
    private String suburb;
    private String postcode;
    private String state;
    
	public StaffController() {
		super();
	}

	public StaffController(int staffId, String staffFname, String staffLname, String staffTFN, Address staffAddress,
			String staffEmail, long staffPhoneNumber, List<Customer> customer, String streetNumber,
			String streetAddress, String suburb, String postcode, String state) {
		super();
		this.staffId = staffId;
		this.staffFname = staffFname;
		this.staffLname = staffLname;
		this.staffTFN = staffTFN;
		this.staffAddress = staffAddress;
		this.staffEmail = staffEmail;
		this.staffPhoneNumber = staffPhoneNumber;
		this.customer = customer;
		this.streetNumber = streetNumber;
		this.streetAddress = streetAddress;
		this.suburb = suburb;
		this.postcode = postcode;
		this.state = state;
	}

	public String getStaffPassword() {
		return staffPassword;
	}

	public void setStaffPassword(String staffPassword) {
		this.staffPassword = staffPassword;
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

	public List<Customer> getCustomer() {
		return customer;
	}

	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
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

	@Override
	public String toString() {
		return "StaffController [staffId=" + staffId + ", staffFname=" + staffFname + ", staffLname=" + staffLname
				+ ", staffTFN=" + staffTFN + ", staffAddress=" + staffAddress + ", staffEmail=" + staffEmail
				+ ", staffPhoneNumber=" + staffPhoneNumber + ", customer=" + customer + ", streetNumber=" + streetNumber
				+ ", streetAddress=" + streetAddress + ", suburb=" + suburb + ", postcode=" + postcode + ", state="
				+ state + "]";
	}
}
