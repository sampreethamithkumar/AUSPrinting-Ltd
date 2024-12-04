package fit5042.assx.restful;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import fit5042.assx.entities.Industry;
import fit5042.assx.repository.IndustryRepository;

@Path("generic")
public class IndustryService {
    @SuppressWarnings("unused")
    @Context
    private UriInfo context;

    @EJB
    IndustryRepository industryRepository;
    /**
     * Default constructor. 
     */
    public IndustryService() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Retrieves representation of an instance of IndustryService
     * @return an instance of String
     */
    @GET
    @Produces("text/html")
    public String getHtml() {
        return "<h1>Successfully created industry type.</h1>";
    }

    /**
     * PUT method for updating or creating an instance of IndustryService
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("text/html")
    public void putHtml(String content) {
    }
    
    @POST
    @Consumes("application/x-www-form-urlencoded")
    public void setPostName( @FormParam("industryType") String industryType) {
    	Industry industry = new Industry();
    	industry.setIndustryType(industryType);
    	try {
    		industryRepository.addIndustry(industry);
    	}
    	catch (Exception e) {
			// TODO: handle exception
		}
    	
    }

}