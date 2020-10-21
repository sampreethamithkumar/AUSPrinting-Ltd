package fit5042.assx.repository;

import java.util.List;

import javax.ejb.Remote;

import fit5042.assx.entities.Industry;

@Remote
public interface IndustryRepository 
{
	public List<Integer> getIndustryId();
	
	public List<Industry> getIndustry();
	
	public void addIndustry(Industry industry);
	
	public void editIndustry(Industry industry);
}
