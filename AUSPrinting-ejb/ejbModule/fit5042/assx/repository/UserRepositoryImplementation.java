package fit5042.assx.repository;

import java.security.MessageDigest;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import fit5042.assx.entities.Staff;
import fit5042.assx.entities.Users;

@Stateless
public class UserRepositoryImplementation implements UserRepository{

	@PersistenceContext
	EntityManager entityManager;
	
	
	@Override
	public void addUser(Users user) {
		List<Users> users = getUser();
		long lastUserId = users.get(users.size() - 1).getId();
		user.setId((lastUserId + 1));
		user.setUserPassword(sha256(user.getUserPassword()));
		entityManager.persist(user);
	}
	
    private String sha256(String base) {
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
    
    public List<Users> getUser() {
    	CriteriaBuilder criteriaBuilder= entityManager.getCriteriaBuilder();
		CriteriaQuery<Users> criteraiQuery = criteriaBuilder.createQuery(Users.class);
		Root<Users> rootEntry = criteraiQuery.from(Users.class);
		CriteriaQuery<Users> all = criteraiQuery.select(rootEntry);
		
		TypedQuery<Users> allQuery = entityManager.createQuery(all);
		return allQuery.getResultList();
    }
    


	@Override
	public void editUser(Users user) {
		Users userFoundFromDb = entityManager.find(Users.class, user.getId());
		if (!userFoundFromDb.getUserPassword().equals(user.getUserPassword())) {
			user.setUserPassword(sha256(user.getUserPassword()));
			entityManager.merge(user);
		}
	}
}
