package fit5042.assx.repository;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface IndustryRepository 
{
	public List<Integer> getIndustryId();
}
