package fit5042.assx.mbean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import fit5042.assx.repository.PrinterRepository;


@ManagedBean(name= "printerManagedBean")
public class PrinterManagedBean {
	
	@EJB
	PrinterRepository printerRepository;
	
	public List<Integer> allPrinterId()
	{
		return printerRepository.getPrinterId();
	}
}
