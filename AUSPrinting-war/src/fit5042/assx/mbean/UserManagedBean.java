package fit5042.assx.mbean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

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
		String userPassword = staff.getStaffFname();
		
		return new Users(userId, userName, userPassword);
		
	}
}
