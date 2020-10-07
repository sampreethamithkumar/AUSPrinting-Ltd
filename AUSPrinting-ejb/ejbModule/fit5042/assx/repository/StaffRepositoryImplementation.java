package fit5042.assx.repository;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.validation.OverridesAttribute;

import fit5042.assx.entities.*;

@Stateless
public class StaffRepositoryImplementation implements StaffRepository {

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public List<Integer> getStaffId() {
		List<Integer> staffId = entityManager.createNamedQuery(Staff.GET_ID).getResultList();
		return staffId;
	}

	@Override
	public void addStaff(Staff staff) {
		List<Staff> staffs = getStaff();
		int lastStaffId = staffs.get(staffs.size() - 1).getStaffId();
		staff.setStaffId(lastStaffId + 1);
		
		List<User> users = getUser();
		long lastUserId = users.get(users.size() - 1).getId();
		String userFirstName = staff.getStaffFname();
		String userPassword = staff.getPassword();
		User user = new User(lastUserId, userFirstName, userPassword);
		
		List<UserGroup> userGroups = getUserGroup();
		long lastUserGroupId = userGroups.get(userGroups.size() - 1).getId();
		String userName = staff.getStaffFname();
		UserGroup userGroup = new UserGroup(lastUserGroupId, userName, "staff");
		entityManager.persist(staff);
		entityManager.persist(userGroup);
		entityManager.persist(user);
	}

	@Override
	public List<Staff> getStaff() {
		CriteriaBuilder criteriaBuilder= entityManager.getCriteriaBuilder();
		CriteriaQuery<Staff> criteraiQuery = criteriaBuilder.createQuery(Staff.class);
		Root<Staff> rootEntry = criteraiQuery.from(Staff.class);
		CriteriaQuery<Staff> all = criteraiQuery.select(rootEntry);
		
		TypedQuery<Staff> allQuery = entityManager.createQuery(all);
		return allQuery.getResultList();
	}

	@Override
	public void editStaff(Staff staff) {
		entityManager.merge(staff);
	}

	@Override
	public void removeStaff(int staffId) {
		Staff staff = entityManager.find(Staff.class, staffId);
		
		if(staff != null)
			entityManager.remove(staff);
		
	}
	
	@Override
	public Staff searchStaffById(int staffId) {
		Staff staff = entityManager.find(Staff.class, staffId);
		return staff;
	}
	
	@Override
	public List<User> getUser() {
		CriteriaBuilder criteriaBuilder= entityManager.getCriteriaBuilder();
		CriteriaQuery<User> criteraiQuery = criteriaBuilder.createQuery(User.class);
		Root<User> rootEntry = criteraiQuery.from(User.class);
		CriteriaQuery<User> all = criteraiQuery.select(rootEntry);
		
		TypedQuery<User> allQuery = entityManager.createQuery(all);
		return allQuery.getResultList();
	}
	
	@Override
	public List<UserGroup> getUserGroup(){
		CriteriaBuilder criteriaBuilder= entityManager.getCriteriaBuilder();
		CriteriaQuery<UserGroup> criteraiQuery = criteriaBuilder.createQuery(UserGroup.class);
		Root<UserGroup> rootEntry = criteraiQuery.from(UserGroup.class);
		CriteriaQuery<UserGroup> all = criteraiQuery.select(rootEntry);
		
		TypedQuery<UserGroup> allQuery = entityManager.createQuery(all);
		return allQuery.getResultList();
	}
	
}
