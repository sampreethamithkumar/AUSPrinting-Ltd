package fit5042.assx.mbean;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import fit5042.assx.controllers.StaffController;
import fit5042.assx.entities.Address;
import fit5042.assx.entities.Staff;
import fit5042.assx.repository.PrinterRepository;
import fit5042.assx.repository.StaffRepository;

@ManagedBean(name= "staffManagedBean")
public class StaffManagedBean {

	@EJB
	StaffRepository staffRepository;
	
	private boolean showRender =false;
	
	private String renderText;
	
	public StaffManagedBean() {
		super();
	}

	public List<Integer> allStaffId()
	{
		return staffRepository.getStaffId();
	}
	
	public List<Staff> getStaffs()
	{
		try {
			return staffRepository.getStaff();
		}
		catch (Exception ex)
		{
			Logger.getLogger(CustomerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}
	
	public void addStaff(StaffController staffController) {
		Staff staff = convertStaffToEntity(staffController);
		
		try {
			staffRepository.addStaff(staff);
			footerRender();
		}
		catch(Exception e) {
			
		}
	}
	
	public Staff convertStaffToEntity(StaffController staffController) {
		String streetNumber = staffController.getStreetNumber();
        String streetAddress = staffController.getStreetAddress();
        String suburb = staffController.getSuburb();
        String postcode = staffController.getPostcode();
        String state = staffController.getState();
        Address staffAddress = new Address(streetNumber, streetAddress, suburb, postcode, state);
		int staffId = staffController.getStaffId();
		String staffFname = staffController.getStaffFname();
		String staffLname = staffController.getStaffLname();
		String staffTFN = staffController.getStaffTFN();
		String staffEmail = staffController.getStaffEmail();
		long staffPhoneNumber = staffController.getStaffPhoneNumber();
		Staff staff = new Staff(staffId, staffFname, staffLname, staffTFN, staffAddress, staffEmail, staffPhoneNumber);
			
		return staff;
	}
	
	
	
	public StaffRepository getStaffRepository() {
		return staffRepository;
	}

	public void setStaffRepository(StaffRepository staffRepository) {
		this.staffRepository = staffRepository;
	}

	public boolean isShowRender() {
		return showRender;
	}

	public void setShowRender(boolean showRender) {
		this.showRender = showRender;
	}

	public String getRenderText() {
		return renderText;
	}

	public void setRenderText(String renderText) {
		this.renderText = renderText;
	}

	public void footerRender() {
		
		setRenderText("Staff Added Successfully!!");
	}
	
	public void editStaff(Staff staff) {
		staffRepository.editStaff(staff);
	}
	
	public void removeStaff(int staffId)
	{
		staffRepository.removeStaff(staffId);
	}
	
	public Staff searchStaffByID(int staffId)
	{
		return staffRepository.searchStaffById(staffId);
	}
}
