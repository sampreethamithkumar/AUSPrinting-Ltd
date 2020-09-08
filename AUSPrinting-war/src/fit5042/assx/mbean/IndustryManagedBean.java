package fit5042.assx.mbean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import fit5042.assx.repository.IndustryRepository;


@ManagedBean(name= "industryManagedBean")
public class IndustryManagedBean 
{
	@EJB
	IndustryRepository industryRepository;
	
	public List<Integer> allIndustryId()
	{
		return industryRepository.getIndustryId();
	}
}
