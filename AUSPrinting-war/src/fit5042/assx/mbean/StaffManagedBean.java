package fit5042.assx.mbean;

import java.security.MessageDigest;
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
		String staffPassword = sha256(staffController.getPassword());
		Staff staff = new Staff(staffId, staffFname, staffLname, staffTFN, staffAddress, staffEmail, staffPhoneNumber,staffPassword);
			
		return staff;
	}
	
	/**
	 * reference: https://stackoverflow.com/questions/5531455/how-to-hash-some-string-with-sha256-in-java
	 * @param base
	 * @return String
	 */
    public  String sha256(String base) {
        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(base.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
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
