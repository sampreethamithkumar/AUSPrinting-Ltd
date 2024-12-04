package fit5042.assx.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.security.auth.spi.LoginModule;

import fit5042.assx.entities.Customer;
import fit5042.assx.entities.Users;

@Stateless
public class UserServiceImplementation implements UserService {

	@PersistenceContext
	EntityManager entityManager;
	
	
	@Override
	public Users find(String username) {
		
		CriteriaBuilder criteriaBuilder= entityManager.getCriteriaBuilder();
		CriteriaQuery<Users> criteraiQuery = criteriaBuilder.createQuery(Users.class);
		Root<Users> rootEntry = criteraiQuery.from(Users.class);
		criteraiQuery.select(rootEntry).where(criteriaBuilder.equal(rootEntry.get("username"), username));
		
		TypedQuery<Users> allQuery = entityManager.createQuery(criteraiQuery);
		return allQuery.getSingleResult();
		
	}

}
