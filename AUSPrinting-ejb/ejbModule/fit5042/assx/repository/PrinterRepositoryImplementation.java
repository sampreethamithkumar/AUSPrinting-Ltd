package fit5042.assx.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fit5042.assx.entities.*;

@Stateless
public class PrinterRepositoryImplementation implements PrinterRepository{

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public List<Integer> getPrinterId() {
		List<Integer> printerId = entityManager.createNamedQuery(Printer.GET_ID).getResultList();
		return printerId;
	}
}
