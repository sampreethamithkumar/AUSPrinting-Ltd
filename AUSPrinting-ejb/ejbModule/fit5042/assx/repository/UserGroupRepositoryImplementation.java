package fit5042.assx.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import fit5042.assx.entities.Users;
import fit5042.assx.entities.UserGroup;

@Stateless
public class UserGroupRepositoryImplementation implements UserGroupRepository{

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public void addUser(UserGroup userGroup) {
		List<UserGroup> userGroups = getUserGroups();
		long lastUserId = userGroups.get(userGroups.size() - 1).getId();
		userGroup.setId((lastUserId + 1));
		entityManager.persist(userGroups);
	}
	
	public List<UserGroup> getUserGroups() {
		CriteriaBuilder criteriaBuilder= entityManager.getCriteriaBuilder();
		CriteriaQuery<UserGroup> criteraiQuery = criteriaBuilder.createQuery(UserGroup.class);
		Root<UserGroup> rootEntry = criteraiQuery.from(UserGroup.class);
		CriteriaQuery<UserGroup> all = criteraiQuery.select(rootEntry);
		
		TypedQuery<UserGroup> allQuery = entityManager.createQuery(all);
		return allQuery.getResultList();
	}

}
