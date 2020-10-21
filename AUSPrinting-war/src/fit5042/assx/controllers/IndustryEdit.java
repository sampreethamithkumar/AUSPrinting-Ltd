package fit5042.assx.controllers;

import javax.el.ELContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import fit5042.assx.entities.Customer;
import fit5042.assx.entities.Industry;

@ManagedBean(name="industryEdit")
@RequestScoped
public class IndustryEdit {

	private int industryId;
	
	private Industry industry;
	
	
	public IndustryEdit() {
		industryId = Integer.valueOf(FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap()
                .get("industryID"));
		
		industry = getIndustry();
	}
	
	public Industry getIndustry() {
		if (industry == null) {
			ELContext context= FacesContext.getCurrentInstance().getELContext();
			
		IndustryApplication app= (IndustryApplication) FacesContext.getCurrentInstance()
                    .getApplication()
                    .getELResolver()
                    .getValue(context, null, "industryApplication");
				
			app.updateIndustryList();;
			
			for(Industry indust: app.getIndustries())
				if (indust.getIndustryId() == industryId)
					return indust;

		}
		return industry;
	}

	public int getIndustryId() {
		return industryId;
	}

	public void setIndustryId(int industryId) {
		this.industryId = industryId;
	}

	public void setIndustry(Industry industry) {
		this.industry = industry;
	}
}
