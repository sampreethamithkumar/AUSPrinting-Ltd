package fit5042.assx.mbean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import fit5042.assx.controllers.StaffController;
import fit5042.assx.entities.UserGroup;
import fit5042.assx.repository.UserGroupRepository;

@ManagedBean(name="userGroupManagedBean")
@SessionScoped
public class UserGroupManagedBean implements Serializable{

	@EJB
	UserGroupRepository userGroupRepository;
	
	public void addUserGroup(StaffController staff) {
		UserGroup userGroup = convertUserGroupToEntity(staff);

//		userGroupRepository.addUser(userGroup);
		try {
			userGroupRepository.addUser(userGroup);
		}
		catch (Exception e) {
			
		}
	}
	
	private UserGroup convertUserGroupToEntity(StaffController staff) {
		Long userId = (long) staff.getStaffId();
		String userName = staff.getStaffFname();
		String userGroup = "staff";
		
		return new UserGroup(userId,userName,userGroup);
	}
}
