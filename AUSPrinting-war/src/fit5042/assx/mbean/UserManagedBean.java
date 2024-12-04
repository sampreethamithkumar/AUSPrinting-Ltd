package fit5042.assx.mbean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import fit5042.assx.controllers.StaffController;
import fit5042.assx.entities.Staff;
import fit5042.assx.entities.Users;
import fit5042.assx.repository.UserRepository;

@ManagedBean(name = "userManagedBean")
@SessionScoped
public class UserManagedBean implements Serializable
{

	@EJB
	UserRepository userRepository;
	
	@ManagedProperty(value = "#{loginController}")
	LoginController loginController;
	
	private String passwordSavedRenderText;
	
	private boolean showRender = false;
	
	
	public void addUser(StaffController staff) {
		Users user = convertUserToEntity(staff);
		
		try {
			userRepository.addUser(user);
		}
		catch (Exception e) {
			
		}
	}
	
	private Users convertUserToEntity(StaffController staff) {
		Long userId = (long) staff.getStaffId();
		String userName = staff.getStaffFname();
		String userPassword = staff.getStaffPassword();
		
		return new Users(userId, userName, userPassword);
		
	}
	
	public void editUser(Users user) {
		userRepository.editUser(user);
		RenderSaveText();
	}
	
	
	private void RenderSaveText() {
		setPasswordSavedRenderText("Password changed!!");
	}

	public String getPasswordSavedRenderText() {
		return passwordSavedRenderText;
	}

	public void setPasswordSavedRenderText(String passwordSavedRenderText) {
		this.passwordSavedRenderText = passwordSavedRenderText;
	}

	public boolean isShowRender() {
		return showRender;
	}

	public void setShowRender(boolean showRender) {
		this.showRender = showRender;
	}


	public LoginController getLoginController() {
		return loginController;
	}

	public void setLoginController(LoginController loginController) {
		this.loginController = loginController;
	}
}
