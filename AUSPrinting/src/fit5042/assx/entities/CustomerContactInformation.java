package fit5042.assx.entities;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({
		@NamedQuery(name = CustomerContactInformation.GET_ALL_CONTACT_INFORMATION, query = "SELECT c FROM CustomerContactInformation c order by c.customerContactId") })
public class CustomerContactInformation implements Serializable {
	public static final String GET_ALL_CONTACT_INFORMATION = "CustomerContactInformation.getAll";
	@Id
	@GeneratedValue
	private int customerContactId;
	private Address customerAddress;
	private long customerPhoneNumber;
	private String customerEmail;
	private Date customerDob;
	private String customerTFN;

	public CustomerContactInformation() {
		super();
	}

	public CustomerContactInformation(int customerContactId, Address customerAddress, long customerPhoneNumber,
			String customerEmail, Date customerDob, String customerTFN) {
		super();
		this.customerContactId = customerContactId;
		this.customerAddress = customerAddress;
		this.customerPhoneNumber = customerPhoneNumber;
		this.customerEmail = customerEmail;
		this.customerDob = customerDob;
		this.customerTFN = customerTFN;
	}

	public Date getCustomerDob() {
		return customerDob;
	}

	public void setCustomerDob(Date customerDob) {
		this.customerDob = customerDob;
	}

	public int getCustomerContactId() {
		return customerContactId;
	}

	public void setCustomerContactId(int customerContactId) {
		this.customerContactId = customerContactId;
	}

	@Embedded
	public Address getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(Address customerAddress) {
		this.customerAddress = customerAddress;
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

	@Override
	public String toString() {
		return "CustomerContactInformation [customerContactId=" + customerContactId + ", customerAddress="
				+ customerAddress + ", customerPhoneNumber=" + customerPhoneNumber + ", customerEmail=" + customerEmail
				+ ", customerDob=" + customerDob + ", customerTFN=" + customerTFN + "]";
	}

}
