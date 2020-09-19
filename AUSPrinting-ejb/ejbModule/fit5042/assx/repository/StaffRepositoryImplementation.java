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
		entityManager.persist(staff);
		
		User user = new User();
		UserGroup userGroup = new UserGroup();
		user.setUsername(staff.getStaffFname());
		userGroup.setUserName(staff.getStaffFname());
		userGroup.setGroupName("staff");
		
		try {
			user.setUserPassword(toHexString(getSHA(staff.getStaffFname())));
			entityManager.persist(user);
			entityManager.persist(userGroup);
		} catch (NoSuchAlgorithmException e) {

		
		}
		
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
	
	
	/**
	 * Reference: https://www.geeksforgeeks.org/sha-256-hash-in-java/
	 * 
	 * @param input
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static byte[] getSHA(String input) throws NoSuchAlgorithmException 
    {  
        // Static getInstance method is called with hashing SHA  
        MessageDigest md = MessageDigest.getInstance("SHA-256");  
  
        // digest() method called  
        // to calculate message digest of an input  
        // and return array of byte 
        return md.digest(input.getBytes(StandardCharsets.UTF_8));  
    } 
    
    public static String toHexString(byte[] hash) 
    { 
        // Convert byte array into signum representation  
        BigInteger number = new BigInteger(1, hash);  
  
        // Convert message digest into hex value  
        StringBuilder hexString = new StringBuilder(number.toString(16));  
  
        // Pad with leading zeros 
        while (hexString.length() < 32)  
        {  
            hexString.insert(0, '0');  
        }  
  
        return hexString.toString();  
    }
	

}
