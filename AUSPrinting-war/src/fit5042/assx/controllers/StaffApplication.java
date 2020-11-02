package fit5042.assx.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import javax.faces.bean.ManagedBean;
import fit5042.assx.entities.Customer;
import fit5042.assx.entities.Staff;
import fit5042.assx.mbean.StaffManagedBean;

@ManagedBean(name="staffApplication")
@ApplicationScoped
public class StaffApplication 
{
	@javax.faces.bean.ManagedProperty(value = "#{staffManagedBean}")
	StaffManagedBean staffManagedBean;
	
	private List<Staff> staffs;
	
	private boolean showTable = false;
	
	public StaffApplication() {
		staffs = new ArrayList<Staff>();
	}

	public StaffManagedBean getStaffManagedBean() {
		return staffManagedBean;
	}

	public void setStaffManagedBean(StaffManagedBean staffManagedBean) {
		this.staffManagedBean = staffManagedBean;
	}

	public List<Staff> getStaffs() {
		setShowTable(true);
		return staffs;
	}

	public void setStaffs(List<Staff> staffs) {
		this.staffs = staffs;
	}

	public boolean isShowTable() {
		return showTable;
	}

	public void setShowTable(boolean showTable) {
		this.showTable = showTable;
	}
	
	public void searchStaffById(int staffId) {
		staffs.clear();
		
		setShowTable(true);
		
		staffs.add(staffManagedBean.searchStaffByID(staffId));
	}
	
	public void searchStaffByFirstAndLastName(String firstName,String lastName) {
		staffs.clear();
		
		setShowTable(true);
		
		for (Staff staff: staffManagedBean.getStaffs()) {
			if (staff.getStaffFname().equals(firstName) && staff.getStaffLname().equals(lastName))
				staffs.add(staff);
		}
			
		
		setStaffs(staffs);
	}
	
	public void updateStaffList() {
		if (staffs != null && staffs.size() > 0) {

		} else {
			staffs.clear();

			for (Staff staff : staffManagedBean.getStaffs())
				staffs.add(staff);

			setStaffs(staffs);
		}
	}
	
	public void searchAllStaff()
	{
		staffs.clear();
		
		for (Staff staff: staffManagedBean.getStaffs())
			staffs.add(staff);
		
		setStaffs(staffs);
	}
	
	public void removeStaff(int staffId)
	{
		staffManagedBean.removeStaff(staffId);
	}
}
