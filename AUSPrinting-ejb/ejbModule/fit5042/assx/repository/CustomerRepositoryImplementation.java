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


@Stateless
public class CustomerRepositoryImplementation implements  CustomerRepository
{
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void addCustomer(Customer customer) {
		
		
	}

	@Override
	public void removeCustomer(Customer customer) {
		
		
	}

	@Override
	public List<Customer> getCustomers() 
	{
		
		CriteriaBuilder criteriaBuilder= entityManager.getCriteriaBuilder();
		CriteriaQuery<Customer> criteraiQuery = criteriaBuilder.createQuery(Customer.class);
		Root<Customer> rootEntry = criteraiQuery.from(Customer.class);
		CriteriaQuery<Customer> all = criteraiQuery.select(rootEntry);
		
		TypedQuery<Customer> allQuery = entityManager.createQuery(all);
		return allQuery.getResultList();
	}

	@Override
	public void searchCustomerById(int customerId) {
		
		
	}

}
