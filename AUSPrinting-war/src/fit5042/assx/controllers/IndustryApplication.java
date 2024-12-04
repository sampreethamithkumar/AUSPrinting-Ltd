package fit5042.assx.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import fit5042.assx.entities.Customer;
import fit5042.assx.entities.Industry;
import fit5042.assx.mbean.IndustryManagedBean;

@ManagedBean(name="industryApplication")
@RequestScoped
public class IndustryApplication {
	
	@ManagedProperty(value = "#{industryManagedBean}")
	IndustryManagedBean industryManagedBean;
	
	private List<Industry> industries;
	
	public IndustryApplication() {
		industries = new ArrayList<Industry>();
	}
	
	public void updateIndustryList() {
		if (industries != null && industries.size() > 0) {

		} else {
			industries.clear();

			for (Industry industry : industryManagedBean.getAllIndustry())
				industries.add(industry);

			setIndustries(industries);
		}
	}

	public List<Industry> getIndustries() {
		return industries;
	}



	public void setIndustries(List<Industry> industries) {
		this.industries = industries;
	}

	public IndustryManagedBean getIndustryManagedBean() {
		return industryManagedBean;
	}

	public void setIndustryManagedBean(IndustryManagedBean industryManagedBean) {
		this.industryManagedBean = industryManagedBean;
	}	
	
	public void searchAllIndustry() {
		industries.clear();
		
		for (Industry indust : industryManagedBean.getAllIndustry())
			industries.add(indust);

		setIndustries(industries);
	}
	
	public void removeIndustry(int industryId) {
		industryManagedBean.removeIndustry(industryId);
	}
}
