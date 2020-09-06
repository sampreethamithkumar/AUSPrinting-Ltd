package fit5042.assx.mbean;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;

import fit5042.assx.repository.CustomerRepository;
import fit5042.assx.entities.*;

@ManagedBean
@ApplicationScoped
public class CustomerMangaedBean implements Serializable
{
	@EJB
	CustomerRepository customerRepository;

	public CustomerMangaedBean() {
		super();
	}
	
	public List<Customer> getCustomers()
	{
		return customerRepository.getCustomers();
		
//		try {
//			return customerRepository.getCustomers();
//        } catch (Exception ex) {
//        	//System.out.println("Error occured in fetching data from database");
//            Logger.getLogger(CustomerMangaedBean.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
	}
	
}
