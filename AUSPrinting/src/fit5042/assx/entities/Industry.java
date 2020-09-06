package fit5042.assx.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Industry implements Serializable
{
	@Id @GeneratedValue
	private int industryId;
	private String industryType;

	public Industry() 
	{
		super();
	}

	public Industry(int industryId, String industryType) 
	{
		super();
		this.industryId = industryId;
		this.industryType = industryType;
	}

	public int getIndustryId() 
	{
		return industryId;
	}

	public void setIndustryId(int industryId) 
	{
		this.industryId = industryId;
	}


	public String getIndustryType() {
		return industryType;
	}

	public void setIndustryType(String industryType) 
	{
		this.industryType = industryType;
	}

	@Override
	public String toString() 
	{
		return "Industry [industryId=" + industryId + ", industryType=" + industryType + "]";
	}
}
