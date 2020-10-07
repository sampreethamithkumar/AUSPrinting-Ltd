package fit5042.assx.repository;

import java.util.List;

import javax.ejb.Remote;

import fit5042.assx.entities.Staff;
import fit5042.assx.entities.User;
import fit5042.assx.entities.UserGroup;

@Remote
public interface StaffRepository {
	
	public List<Integer> getStaffId();
	
	public void addStaff(Staff staff);

	public List<Staff> getStaff();
	
	public void editStaff(Staff staff);
	
	public void removeStaff(int staffId);

	public Staff searchStaffById(int staffId);

	List<UserGroup> getUserGroup();

	List<User> getUser();
	
}
