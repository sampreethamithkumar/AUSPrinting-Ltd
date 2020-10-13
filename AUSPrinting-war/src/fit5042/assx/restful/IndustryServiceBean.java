package fit5042.assx.restful;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import fit5042.assx.client.IndustryServiceClient;

@ManagedBean(name="industryServiceBean")
@SessionScoped
public class IndustryServiceBean implements Serializable{

	private String industryType;
	private IndustryServiceClient industryServiceClient;
	
	public IndustryServiceBean() {
		
	}

	public String getIndustryType() {
		return industryType;
	}

	public void setIndustryType(String industryType) {
		this.industryType = industryType;
	}

	public void setIndustryServiceClient() {
		industryServiceClient = new IndustryServiceClient();
		industryServiceClient.setPostIndustryParams(getIndustryType());
	}
	
	
}
