package fit5042.assx.mbean;

import java.io.Serializable;
import java.security.Principal;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import fit5042.assx.entities.User;
import fit5042.assx.repository.UserService;



@ManagedBean
@ViewScoped
public class LoginController implements Serializable{

	private User user;

    @EJB
    private UserService userService;

//    public String login() {
//        User user = userService.find(username, password);
//        FacesContext context = FacesContext.getCurrentInstance();
//
//        if (user == null) {
//            context.addMessage(null, new FacesMessage("Unknown login, try again"));
//            username = null;
//            password = null;
//            return null;
//        } else {
//            context.getExternalContext().getSessionMap().put("user", user);
//            return "index";
////            return "userhome?faces-redirect=true";
//        }
//    }
    
    public User getUser() {
    	if (user == null) {
            Principal principal = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
            if (principal != null) {
                user = userService.find(principal.getName()); // Find User by j_username.
            }
        }
        return user;
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index?faces-redirect=true";
    }

}
