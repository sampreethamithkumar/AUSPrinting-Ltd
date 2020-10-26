package fit5042.assx.mbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import com.sun.tools.xjc.reader.xmlschema.bindinfo.BIConversion.User;

import fit5042.assx.controllers.StaffController;
import fit5042.assx.entities.Address;
import fit5042.assx.entities.Staff;
import fit5042.assx.entities.UserGroup;
import fit5042.assx.entities.Users;
import fit5042.assx.repository.PrinterRepository;
import fit5042.assx.repository.StaffRepository;
import fit5042.assx.repository.UserGroupRepository;
import fit5042.assx.repository.UserRepository;

@ManagedBean(name= "staffManagedBean")
@SessionScoped
public class StaffManagedBean implements Serializable{

	@EJB
	StaffRepository staffRepository;
	
	@ManagedProperty(value = "#{userManagedBean}")
	UserManagedBean userManagedBean;
	
	@ManagedProperty(value = "#{userGroupManagedBean}")
	UserGroupManagedBean userGroupManagedBean;
	
	@ManagedProperty(value = "#{loginController}")
	LoginController loginController;
	
	private boolean showRender =false;
	
	private String renderText;
	
	public StaffManagedBean() {
		super();
	}

	public int getStaffIdByFname(String staffname) {
		List<Staff> staff = staffRepository.getStaffIdByFname(staffname);
		return staff.get(0).getStaffId();
	}
	
	public List<Integer> allStaffId()
	{
		return staffRepository.getStaffId();
	}
	
	public void addStaff(StaffController staffController) {
		Staff staff = convertStaffToEntity(staffController);
		
		try {
			staffRepository.addStaff(staff);
			userManagedBean.addUser(staffController);
			userGroupManagedBean.addUserGroup(staffController);
			footerRender();
		}
		catch(Exception e) {
			
		}
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
	
	public List<String> staffName(){
		List<Staff> staffs = getStaffs();
		List<String> staffNames = new ArrayList<>();
		for (Staff staff: staffs) {
			staffNames.add(staff.getStaffFname());
		}
		return staffNames;
	}
	
	public int getStaffByLogin() {
		String loginStaffName = loginController.getUser().getUsername();
		for (Staff staff: getStaffs()) {
			if (staff.getStaffFname().equals(loginStaffName))
				return staff.getStaffId();
		}
		return 1;
	}
	
	public List<Integer> staffIdByLogin(){
		List<Integer> staffId = new ArrayList<>();
		staffId.add(getStaffByLogin());
		return staffId;
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
	
	public UserManagedBean getUserManagedBean() {
		return userManagedBean;
	}

	public void setUserManagedBean(UserManagedBean userManagedBean) {
		this.userManagedBean = userManagedBean;
	}

	public UserGroupManagedBean getUserGroupManagedBean() {
		return userGroupManagedBean;
	}

	public void setUserGroupManagedBean(UserGroupManagedBean userGroupManagedBean) {
		this.userGroupManagedBean = userGroupManagedBean;
	}

	public LoginController getLoginController() {
		return loginController;
	}

	public void setLoginController(LoginController loginController) {
		this.loginController = loginController;
	}
}
