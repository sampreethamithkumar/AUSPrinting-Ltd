package fit5042.assx.controllers;

import java.util.List;

import javax.el.ELContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import fit5042.assx.entities.Staff;

@ManagedBean(name="removeStaff")
@RequestScoped
public class RemoveStaff 
{
	StaffApplication staffApplication;
	
	public RemoveStaff() {
		ELContext context = FacesContext.getCurrentInstance().getELContext();
		
		staffApplication = (StaffApplication) FacesContext.getCurrentInstance()
				.getApplication()
				.getELResolver()
				.getValue(context, null, "staffApplication");
		
	}
	
	public List<Staff> getAllStaffs()
	{
		staffApplication.searchAllStaff();
		
		return staffApplication.getStaffs();
	}
	
	public void removeStaff(int staffId) {
		staffApplication.removeStaff(staffId);
	}
	
	
}
