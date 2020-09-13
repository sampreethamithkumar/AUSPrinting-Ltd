package fit5042.assx.controllers;

import javax.el.ELContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import fit5042.assx.entities.Staff;

@ManagedBean(name="staffEditController")
@RequestScoped
public class StaffEditController 
{
	
	private int staffId;
	
	private Staff staff;
	
	public StaffEditController()
	{
		staffId = Integer.valueOf(FacesContext.getCurrentInstance()
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
			ELContext context = FacesContext.getCurrentInstance().getELContext();
			
			StaffApplication staffApplication = (StaffApplication) FacesContext.getCurrentInstance()
					.getApplication()
					.getELResolver()
					.getValue(context, null, "staffApplication");
			
			staffApplication.updateStaffList();
			
			for(Staff staff: staffApplication.getStaffs())
				if (staff.getStaffId() == staffId)
					return staff;
		}
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	
	
}
