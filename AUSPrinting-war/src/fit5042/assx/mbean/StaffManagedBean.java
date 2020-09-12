package fit5042.assx.mbean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import fit5042.assx.repository.PrinterRepository;
import fit5042.assx.repository.StaffRepository;

@ManagedBean(name= "staffManagedBean")
public class StaffManagedBean {

	@EJB
	StaffRepository staffRepository;
	
	public List<Integer> allStaffId()
	{
		return staffRepository.getStaffId();
	}
}
