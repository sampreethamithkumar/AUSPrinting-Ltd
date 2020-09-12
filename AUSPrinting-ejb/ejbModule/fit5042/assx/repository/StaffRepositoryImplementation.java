package fit5042.assx.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
}
