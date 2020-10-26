package fit5042.assx.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
	@NamedQuery(name= Staff.GET_ID, query = "SELECT s.staffId FROM Staff s order by s.staffId ")
})
public class Staff implements Serializable
{
	public static final String GET_ID = "Staff.getId";
	@Id @GeneratedValue
	private int staffId;
	private String staffFname;
	private String staffLname;
	private String staffTFN;
	private Address staffAddress;
	private String staffEmail;
	private long staffPhoneNumber;
	private List<Customer> customer;

	
	public Staff() 
	{
		super();
	}

	public Staff(int staffId, String staffFname, String staffLname, String staffTFN, Address staffAddress,
			String staffEmail, long staffPhoneNumber) 
	{
		super();
		this.staffId = staffId;
		this.staffFname = staffFname;
		this.staffLname = staffLname;
		this.staffTFN = staffTFN;
		this.staffAddress = staffAddress;
		this.staffEmail = staffEmail;
		this.staffPhoneNumber = staffPhoneNumber;
	}
	

	public int getStaffId() 
	{
		return staffId;
	}

	public void setStaffId(int staffId) 
	{
		this.staffId = staffId;
	}

	public String getStaffFname() 
	{
		return staffFname;
	}

	public void setStaffFname(String staffFname) 
	{
		this.staffFname = staffFname;
	}

	public String getStaffLname() 
	{
		return staffLname;
	}

	public void setStaffLname(String staffLname) 
	{
		this.staffLname = staffLname;
	}

	public String getStaffTFN() 
	{
		return staffTFN;
	}

	public void setStaffTFN(String staffTFN) 
	{
		this.staffTFN = staffTFN;
	}
	
	@Embedded
	public Address getStaffAddress() 
	{
		return staffAddress;
	}

	public void setStaffAddress(Address staffAddress) 
	{
		this.staffAddress = staffAddress;
	}

	public String getStaffEmail() 
	{
		return staffEmail;
	}

	public void setStaffEmail(String staffEmail) 
	{
		this.staffEmail = staffEmail;
	}

	public long getStaffPhoneNumber() 
	{
		return staffPhoneNumber;
	}

	public void setStaffPhoneNumber(long staffPhoneNumber) 
	{
		this.staffPhoneNumber = staffPhoneNumber;
	}
	
	@OneToMany(mappedBy = "staff",cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	public List<Customer> getCustomer() 
	{
		return customer;
	}

	public void setCustomer(List<Customer> customer) 
	{
		this.customer = customer;
	}

	@Override
	public String toString() 
	{
		return "Staff [staffId=" + staffId + ", staffFname=" + staffFname + ", staffLname=" + staffLname + ", staffTFN="
				+ staffTFN + ", staffAddress=" + staffAddress + ", staffEmail=" + staffEmail + ", staffPhoneNumber="
				+ staffPhoneNumber + "]";
	}
}
