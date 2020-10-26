package fit5042.assx.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import fit5042.assx.entities.Customer;
import fit5042.assx.entities.CustomerContactInformation;
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
	
	@Override
   public List<Industry> getIndustry(){
    	CriteriaBuilder criteriaBuilder= entityManager.getCriteriaBuilder();
		CriteriaQuery<Industry> criteraiQuery = criteriaBuilder.createQuery(Industry.class);
		Root<Industry> rootEntry = criteraiQuery.from(Industry.class);
		CriteriaQuery<Industry> all = criteraiQuery.select(rootEntry);
		
		TypedQuery<Industry> allQuery = entityManager.createQuery(all);
		return allQuery.getResultList();
    }

	@Override
	public void addIndustry(Industry industry) {
		List<Industry> listOfIndusty = getIndustry();
		int lastIndustryId = listOfIndusty.get(listOfIndusty.size() -1).getIndustryId();
		industry.setIndustryId(lastIndustryId + 1);
		entityManager.persist(industry);		
	}

	@Override
	public void editIndustry(Industry industry) {
		entityManager.merge(industry);
	}

	@Override
	public void removeIndustry(int industryId) {
		Industry industry = entityManager.find(Industry.class, industryId);
		if (industry != null) {
			for (Customer cust: getCustomers()) {
				if (cust.getIndustryId().equals(industry)) {
					CustomerContactInformation custInfo = cust.getContactInformation();
					entityManager.remove(cust);
					entityManager.remove(custInfo);					
				}	
			}
			entityManager.remove(industry);		
		}
	}
		
	
	private List<Customer> getCustomers() 
	{
		CriteriaBuilder criteriaBuilder= entityManager.getCriteriaBuilder();
		CriteriaQuery<Customer> criteraiQuery = criteriaBuilder.createQuery(Customer.class);
		Root<Customer> rootEntry = criteraiQuery.from(Customer.class);
		CriteriaQuery<Customer> all = criteraiQuery.select(rootEntry);
		
		TypedQuery<Customer> allQuery = entityManager.createQuery(all);
		return allQuery.getResultList();
	}
}
