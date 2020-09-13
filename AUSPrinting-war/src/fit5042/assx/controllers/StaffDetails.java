package fit5042.assx.controllers;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import fit5042.assx.entities.Staff;

@ManagedBean(name="staffDetails")
@RequestScoped
public class StaffDetails 
{
	private int staffId;
	
	private Staff staff;
	
	public StaffDetails()
	{
		staffId = Integer.parseInt(FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap()
                .get("staffID"));
		
		staff = getStaff();
	}

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public Staff getStaff() {
		if (staff == null) {
			ELContext context= FacesContext.getCurrentInstance().getELContext();
			
		StaffApplication staffApplication= (StaffApplication) FacesContext.getCurrentInstance()
                    .getApplication()
                    .getELResolver()
                    .getValue(context, null, "staffApplication");
				
			staffApplication.searchAllStaff();
			return staffApplication.getStaffs().get(--staffId);
		}
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}
}
