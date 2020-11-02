package fit5042.assx.controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="searchStaff")
@RequestScoped
public class SearchStaff 
{
	StaffApplication staffApplication;
	
	private String StaffFName;
	private String StaffLName;
	
	private int searchById;
	
	public SearchStaff() {
		
	}
	
	
	public SearchStaff(StaffApplication staffApplication, int searchById) {
		super();
		this.staffApplication = staffApplication;
		this.searchById = searchById;
	}


	public StaffApplication getStaffApplication() {
		return staffApplication;
	}

	public void setStaffApplication(StaffApplication staffApplication) {
		this.staffApplication = staffApplication;
	}

	public int getSearchById() {
		return searchById;
	}

	public void setSearchById(int searchById) {
		this.searchById = searchById;
	}


	public String getStaffFName() {
		return StaffFName;
	}


	public void setStaffFName(String staffFName) {
		StaffFName = staffFName;
	}


	public String getStaffLName() {
		return StaffLName;
	}


	public void setStaffLName(String staffLName) {
		StaffLName = staffLName;
	}
}
