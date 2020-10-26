package fit5042.assx.repository;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.eclipse.persistence.internal.jaxb.json.schema.model.Property;

import fit5042.assx.entities.Customer;
import fit5042.assx.entities.CustomerContactInformation;
import fit5042.assx.entities.Staff;


@Stateless
public class CustomerRepositoryImplementation implements  CustomerRepository
{
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void addCustomer(Customer customer) throws Exception {
		List<Customer> customers = getCustomers();
		if (customers.size() >= 1)
		{
			int lastCustomerId = customers.get(customers.size() - 1).getCustomerId();
			customer.setCustomerId(lastCustomerId + 1);
		}
		else 
			customer.setCustomerId(1);
		
		List<CustomerContactInformation> customerContactInforamtion = entityManager.createNamedQuery(CustomerContactInformation.GET_ALL_CONTACT_INFORMATION).getResultList();
		int lastContactId =1;
		if (customerContactInforamtion.size() >= 1) {
			lastContactId = customerContactInforamtion.get(customerContactInforamtion.size() - 1).getCustomerContactId();
		}
		else
			lastContactId = 1;

		CustomerContactInformation newCustomerconatctInformation = customer.getContactInformation();
		newCustomerconatctInformation.setCustomerContactId(lastContactId);
		customer.setContactInformation(newCustomerconatctInformation);
		entityManager.persist(customer);
	}

	@Override
	public void removeCustomer(int customerId) {
		Customer customer = entityManager.find(Customer.class, customerId);
		CustomerContactInformation contactInfo = customer.getContactInformation();
		if (customer != null)
		{
			entityManager.remove(customer);
			entityManager.remove(contactInfo);
		}
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
	public Customer searchCustomerById(int customerId) {
		Customer customer = entityManager.find(Customer.class, customerId);
		return customer;
	}

	@Override
	public void addContactInformation(CustomerContactInformation contactInforamtion) 
	{
		List<CustomerContactInformation> customerContactInforamtion = entityManager.createNamedQuery(CustomerContactInformation.GET_ALL_CONTACT_INFORMATION).getResultList();
		if (customerContactInforamtion.size() >= 1) {
			int lastContactId = customerContactInforamtion.get(customerContactInforamtion.size() - 1).getCustomerContactId();
			contactInforamtion.setCustomerContactId(lastContactId + 1);
		}
		else
			contactInforamtion.setCustomerContactId(1);
		
		entityManager.persist(contactInforamtion);
	}

	@Override
	public void editCustomer(Customer customer) {
		entityManager.merge(customer);
		entityManager.merge(customer.getContactInformation());
	}
	
	@Override
	public List<Customer> getCustomersName(String customerFirstName) {
		List<Customer> customers = new ArrayList<>();
		
		for (Customer cust : getCustomers()) {
			if (cust.getCustomerFirstName().equals(customerFirstName))
				customers.add(cust);
		}
		return customers;
	}

	@Override
	public List<Customer> searchByPhoneNumber(long phoneNumber) {
		List<Customer> customers = new ArrayList<>();
		
		for (Customer cust: getCustomers()) {
			if (cust.getContactInformation().getCustomerPhoneNumber() == phoneNumber)
				customers.add(cust);
		}
		return customers;
	}
	
	
}
