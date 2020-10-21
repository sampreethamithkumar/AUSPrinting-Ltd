package fit5042.assx.mbean;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import fit5042.assx.entities.Industry;
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
	
	public List<Industry> getAllIndustry(){
		return industryRepository.getIndustry();
	}
	
	public void editIndustry(Industry industry) {
		industryRepository.editIndustry(industry);
	}
}
