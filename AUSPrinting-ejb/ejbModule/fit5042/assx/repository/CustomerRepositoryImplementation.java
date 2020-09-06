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


@Stateless
public class CustomerRepositoryImplementation implements  CustomerRepository
{
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void addCustomer(Customer customer) throws Exception {
		List<Customer> customers = getCustomers();
		int lastCustomerId = customers.get(customers.size() - 1).getCustomerId();
		List<CustomerContactInformation> customerContactInforamtion = entityManager.createNamedQuery(CustomerContactInformation.GET_ALL_CONTACT_INFORMATION).getResultList();
		int lastContactId = customerContactInforamtion.get(customerContactInforamtion.size() - 1).getCustomerContactId();
		//int lastCustomerContactId = customers.get(customers.size() - 1).getContactInformation().getCustomerContactId();
		customer.setCustomerId(lastCustomerId + 1);
		CustomerContactInformation newCustomerconatctInformation = customer.getContactInformation();
		newCustomerconatctInformation.setCustomerContactId(lastContactId);
		customer.setContactInformation(newCustomerconatctInformation);
		entityManager.persist(customer);
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

	@Override
	public void addContactInformation(CustomerContactInformation contactInforamtion) 
	{
		List<CustomerContactInformation> customerContactInforamtion = entityManager.createNamedQuery(CustomerContactInformation.GET_ALL_CONTACT_INFORMATION).getResultList();
		int lastContactId = customerContactInforamtion.get(customerContactInforamtion.size() - 1).getCustomerContactId();
		contactInforamtion.setCustomerContactId(lastContactId + 1);
		entityManager.persist(contactInforamtion);
	}

}
