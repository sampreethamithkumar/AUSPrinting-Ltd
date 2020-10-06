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
import fit5042.assx.entities.User;

@Stateless
public class UserServiceImplementation implements UserService {

	@PersistenceContext
	EntityManager entityManager;
	
	
	@Override
	public User find(String username) {
		
		
		CriteriaBuilder criteriaBuilder= entityManager.getCriteriaBuilder();
		CriteriaQuery<User> criteraiQuery = criteriaBuilder.createQuery(User.class);
		Root<User> rootEntry = criteraiQuery.from(User.class);
		criteraiQuery.select(rootEntry).where(criteriaBuilder.equal(rootEntry.get("username"), username));
		
		TypedQuery<User> allQuery = entityManager.createQuery(criteraiQuery);
		return allQuery.getSingleResult();
		
	}

}
