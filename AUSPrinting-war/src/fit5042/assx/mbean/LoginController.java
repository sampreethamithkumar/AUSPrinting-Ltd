package fit5042.assx.mbean;

import java.io.Serializable;
import java.security.Principal;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.security.enterprise.authentication.mechanism.http.RememberMe;

import fit5042.assx.entities.User;
import fit5042.assx.repository.UserService;


/**
 * 
 * @author sampreeth
 * Reference https://stackoverflow.com/questions/3841361/jsf-http-session-login
 */
@ManagedBean
@RequestScoped
public class LoginController implements Serializable{

	private User user;

    @EJB
    private UserService userService;

    public User getUser() {
    	if (user == null) {
            Principal principal = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
            if (principal != null) {
            	System.out.println(principal.getName());
                user = userService.find(principal.getName()); // Find User by j_username.
            }
        }
        return user;
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "../../";
    }

}
