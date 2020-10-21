package fit5042.assx.controllers;

import java.util.List;

import javax.el.ELContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import fit5042.assx.entities.Industry;

@ManagedBean(name= "removeIndustry")
@RequestScoped
public class RemoveIndustry {

	IndustryApplication industryApplication;
	
	public RemoveIndustry() {
		ELContext context
        = FacesContext.getCurrentInstance().getELContext();

		industryApplication = (IndustryApplication) FacesContext.getCurrentInstance()
        .getApplication()
        .getELResolver()
        .getValue(context, null, "industryApplication");
	}
	
	public List<Industry> getAllIndustry(){
		industryApplication.searchAllIndustry();
		
		return industryApplication.getIndustries();
	}
	
	public void removeIndustry(int industryId) {
		industryApplication.removeIndustry(industryId);
	}
}
