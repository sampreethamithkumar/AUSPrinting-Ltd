package fit5042.assx.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fit5042.assx.entities.Industry;

@Stateless
public class IndustryRepsitoryImplementation implements IndustryRepository 
{	
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public List<Integer> getIndustryId() {
		List<Integer> industryId = entityManager.createNamedQuery(Industry.GET_ID).getResultList();
		return industryId;
	}

}
