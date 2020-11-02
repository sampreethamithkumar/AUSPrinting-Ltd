package fit5042.assx.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER")
@NamedQueries({
		@NamedQuery(name = Customer.GET_ALL_QUERY_NAME, query = "SELECT c FROM Customer c order by c.customerId") })
public class Customer implements Serializable {
	@Id
	@GeneratedValue
	private int customerId;
	private Staff staffId;
	private Industry industryId;
	private CustomerContactInformation contactInformation;
	private String customerFirstName;
	private String customerLastName;
	private Printer printer_id;
	private Date dateOfPurchase;
	public static final String GET_ALL_QUERY_NAME = "Customer.getAll";

	public Customer() {
		super();
	}

	public Customer(int customerId, Staff staffId, Industry industryId, CustomerContactInformation contactInformation,
			String customerFirstName, String customerLastName, Printer printer_id, Date dateOfPurchase) {
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

	public Date getDateOfPurchase() {
		return dateOfPurchase;
	}

	public void setDateOfPurchase(Date dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	public Staff getStaffId() {
		return staffId;
	}

	public void setStaffId(Staff staffId) {
		this.staffId = staffId;
	}

	@OneToOne
	public Industry getIndustryId() {
		return industryId;
	}

	public void setIndustryId(Industry industryId) {
		this.industryId = industryId;
	}

	@OneToOne(cascade = CascadeType.ALL)
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

	@OneToOne
	public Printer getPrinter_id() {
		return printer_id;
	}

	public void setPrinter_id(Printer printer_id) {
		this.printer_id = printer_id;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", staffId=" + staffId + ", industryId=" + industryId
				+ ", contactInformation=" + contactInformation + ", customerFirstName=" + customerFirstName
				+ ", customerLastName=" + customerLastName + ", printer_id=" + printer_id + ", dateOfPurchase="
				+ dateOfPurchase + "]";
	}
}
